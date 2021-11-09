public class InvalidTransactions {

//  Runtime: 7 ms, faster than 98.07% of Java online submissions for Invalid Transactions.
//  Memory Usage: 39.9 MB, less than 62.05% of Java online submissions for Invalid Transactions.
    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        public Transaction (String info){
            String[] infos = info.split(",");
            this.name = infos[0];
            this.time = Integer.parseInt(infos[1]);
            this.amount = Integer.parseInt(infos[2]);
            this.city = infos[3];
        }
    }
    
    public List<String> invalidTransactions(String[] transactions) {
        // k: name, v: transactions 
        // sorted transactions based on time, check same/different city and then time overlap
        
        List<String> result = new ArrayList<>();
        Map<String, List<Transaction>> nameTransactions = new HashMap<>();
        
        // create map with key= name and value = list of transactions made by 
        // that person
        for (int i = 0; i < transactions.length; i++){
            Transaction t = new Transaction(transactions[i]);
            // update the map
            nameTransactions.putIfAbsent(t.name, new ArrayList<>());
            nameTransactions.get(t.name).add(t);
        }
        
        // iterate through each person's list of transactions and detect
        // invalid ones
        for (int i = 0; i < transactions.length; i++){
            Transaction t = new Transaction(transactions[i]);
            if (!isValid(t, nameTransactions.get(t.name))){
                result.add(transactions[i]);
            }
        }
        
        return result;
    }
    
    private boolean isValid (Transaction t, List<Transaction> list){
        if (t.amount > 1000){
            return false;
        }
        
        for (Transaction other: list){
            // if time difference is less than 60 and in different cities
            if (Math.abs(t.time - other.time) <= 60 && !t.city.equals(other.city)){
                return false;
            }
        }
        
        return true;
    }
    
}

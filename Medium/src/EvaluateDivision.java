import java.util.*;

public class EvaluateDivision {
    class Edge{
        String val;
        double weight;
        public Edge (String val, double weight){
            this.val = val;
            this.weight = weight;
        }
    }
    private Map<String, List<Edge>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // if there is an equation between a and b, put into map
        map = new HashMap<>();
        int index = 0;
        
        // build the map
        for (List<String> e: equations){
            String dividend = e.get(0), divisor = e.get(1);
            double quotient = values[index++];
            map.putIfAbsent(dividend, new ArrayList<>());
            map.putIfAbsent(divisor, new ArrayList<>());
            map.get(dividend).add(new Edge(divisor, quotient));
            map.get(divisor).add(new Edge(dividend, 1/quotient));
        }
        
        // do all queries
        double[] res = new double[queries.size()];
        index = 0;
        for (List<String> q: queries){
            String dividend = q.get(0), divisor = q.get(1);
            double temp = findPath(dividend, divisor, new HashSet<>());
            if (temp != -1.0){
                res[index++] = temp;
            } else {
                res[index++] = -1.0;
            }
        }
        
        return res;
    }
    
    private double findPath (String curr, String goal, Set<String> visited){
        visited.add(curr);

        if (!map.containsKey(curr) || !map.containsKey(goal)){
            return -1.0;
        } else if (curr.equals(goal)){
            return 1.0;
        }
        
        // dfs
        for (Edge e: map.get(curr)){
            if (!visited.contains(e.val)){
                double ret = findPath (e.val, goal, visited);
                // if find a path
                if (ret != -1.0){
                    return ret*e.weight;
                }
            }
        }
        
        // cannot find a path
        return -1.0;
    
}
}

import java.util.*;
class DesignUndergoundSystem {
    // discuss:
        // maintain data in permanent medium - database
        // concurrency when thousands of checkins-checkouts per second
        // store the sum and count all the time instead of re-iterating list whenever called
        // remove old data to free up memory
        // save total vs avg time
        
        private HashMap<Integer, Pair<String, Integer>> checkInMap;
        private HashMap<String, Pair<Integer, Integer>> travelTime;
        
        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            travelTime = new HashMap<>();
        }
        
        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }
        
        public void checkOut(int id, String stationName, int t) {
            int diff = t - checkInMap.get(id).getValue();
            String startStation = checkInMap.get(id).getKey();
            String stations = stationsKey(startStation, stationName);
            Pair<Integer, Integer> newCheck = travelTime.getOrDefault(stations, new Pair<>(0, 0));
            
            travelTime.put(stations, new Pair<>(newCheck.getKey()+diff, newCheck.getValue()+1));
        }
        
        public double getAverageTime(String startStation, String endStation) {
            String stations = stationsKey(startStation, endStation);
            Pair<Integer, Integer> stats = travelTime.get(stations);
            return (double) stats.getKey()/stats.getValue();
        }
        
        private String stationsKey(String start, String end){
            return start + "->" + end;
        }
    }
    
    /**
     * Your UndergroundSystem object will be instantiated and called as such:
     * UndergroundSystem obj = new UndergroundSystem();
     * obj.checkIn(id,stationName,t);
     * obj.checkOut(id,stationName,t);
     * double param_3 = obj.getAverageTime(startStation,endStation);
     */
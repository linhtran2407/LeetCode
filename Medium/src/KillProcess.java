public class KillProcess {
    // Runtime: 23 ms, faster than 70.17% of Java online submissions for Kill Process.
    // Memory Usage: 47.7 MB, less than 69.14% of Java online submissions for Kill Process.
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {        
        // build the graph: for each node, put a list of children
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < ppid.size(); i++){
            int val = ppid.get(i);
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(pid.get(i));
        }

        // do a dfs tree traversal from the killed node
        List<Integer> killedNodes = new ArrayList<>();
        killedNodes.add(kill);
        findKilledNodes(killedNodes, kill, map);
        return killedNodes;
    }
    
    private void findKilledNodes(List<Integer> killedNodes, int kill, Map<Integer, List<Integer>> map){
        // base
        if (!map.containsKey(kill)){
            return;
        }
        
        for (int child: map.get(kill)){
            killedNodes.add(child);
            findKilledNodes(killedNodes, child, map);
        }
    }
    
}

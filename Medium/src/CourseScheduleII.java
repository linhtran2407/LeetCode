public class CourseScheduleII {
    /*
    @author: Linh Tran
    @version: Jun 29, 2021

    Runtime and usage info of the solution:
    Runtime: 5 ms, faster than 69.17% of Java online submissions for Course Schedule II.
    Memory Usage: 40.1 MB, less than 65.17% of Java online submissions for Course Schedule II.
*/

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> set = new LinkedList<>();
        int[] result = new int[numCourses];
        int order = 0;
        int removedEdge = 0;

        // build the map and indegree array
        for (int[] relation: prerequisites){
            // pre[1] --> pre[0]
            var depList = map.getOrDefault(relation[1], new ArrayList<Integer>());
            depList.add(relation[0]);
            map.put(relation[1], depList);
            indegree[relation[0]]++;
        }

        // create a set of 0-indegree nodes
        for(int course=0; course<numCourses; course++){
            if (indegree[course]==0){
                set.add(course);
            }
        }

        // apply topological sort
        while(!set.isEmpty()){
            int currCourse = set.poll();
            result[order++] = currCourse;

            // traverse through its dependency list
            if (map.containsKey(currCourse)){
                for (int dep: map.get(currCourse)){
                    indegree[dep]--;
                    removedEdge++;
                    if (indegree[dep] == 0){
                        set.add(dep);
                    }
                }
            }
        }

        return removedEdge==prerequisites.length? result:new int[0];
    }
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
    @author: Linh Tran
    @version: Jun 28, 2021

    Runtime and usage info:
    Runtime: 6 ms, faster than 41.69% of Java online submissions for Course Schedule.
    Memory Usage: 39.7 MB, less than 48.24% of Java online submissions for Course Schedule.
*/

class NodeInfo {
    public int indegrees = 0;
    public LinkedList<Integer> dependencies = new LinkedList<>();
}

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites.length ==0){
            return true;
        }

        // form a map with key being each course and value being an object
        // holding indegree and dependencies of each course
        HashMap<Integer, NodeInfo> map = new HashMap<>();

        for (int[] relation: prerequisites){
            // relation[1] --> relation[0]
            NodeInfo prereqCourse = this.getCreateNode(map, relation[1]);
            NodeInfo dependentCourse = this.getCreateNode(map, relation[0]);

            prereqCourse.dependencies.add(relation[0]);
            dependentCourse.indegrees++;
        }

        // create a list of 0-indegree nodes and remove them
        LinkedList<Integer> indepCourse = new LinkedList<>();
        for (Map.Entry<Integer, NodeInfo> entry: map.entrySet()){
            NodeInfo currNode = entry.getValue();
            if (currNode.indegrees == 0){
                indepCourse.add(entry.getKey());
            }
        }

        // for each node being removed, traverse through its dependencies,
        // decrease each dependency's indegree and increase the removed edges
        int removedEdges = 0;
        int totalEdges = prerequisites.length;
        while(!indepCourse.isEmpty()){
            Integer currCourse = indepCourse.removeFirst();
            NodeInfo currNode = map.get(currCourse);
            LinkedList<Integer> currDeps = currNode.dependencies;

            for (int nextDep: currDeps){
                NodeInfo depInfo = map.get(nextDep);
                depInfo.indegrees--;
                removedEdges++;

                if (depInfo.indegrees == 0){
                    indepCourse.add(nextDep);
                }
            }
        }
        return removedEdges!=totalEdges? false:true;
    }

    private NodeInfo getCreateNode(HashMap<Integer, NodeInfo> map, int course){
        NodeInfo node = null;

        if (map.get(course) != null){
            node = map.get(course);
        } else {
            node = new NodeInfo();
            map.put(course, node);
        }
        return node;
    }
}
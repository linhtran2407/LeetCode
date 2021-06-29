import java.util.*;

/*
    @author: Linh Tran
    @version: Jun 28, 2021

    Runtime and usage info of the first solution:
    Runtime: 4 ms, faster than 69.53% of Java online submissions for Course Schedule.
    Memory Usage: 39.5 MB, less than 72.28% of Java online submissions for Course Schedule.

    Runtime: 6 ms, faster than 41.69% of Java online submissions for Course Schedule.
    Memory Usage: 39.7 MB, less than 48.24% of Java online submissions for Course Schedule.
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /** algo topological sort:
         build a graph: O(|E|)
         indegree - the number of incoming egdes of each node
         set of 0-indegree nodes

         while(set is not empty){ // O(|E|+|V|)
             remove the 0-indegree node N
             traverse through N's list of dependencies
             for each of dependency, decrement its incoming edge by 1
             if a dependency's indegree is 0, add it to the set
         }

         if (number of edges removed is not equal to the prereq.length)--> cycle
         otherwise no cycle --> return true
         */

        // key: course -> val: list of dependencies
        HashMap<Integer, ArrayList<Integer>> courseDict = new HashMap<>();
        // track node's indegree
        int[] indegrees = new int[numCourses];
        // set containing 0-indegree nodes, use LL bc of its O(1) for inserting and removing element
        Queue<Integer> set = new LinkedList<>();

        // build the graph
        for (int[] relation: prerequisites){
            // relation[1] --> relation[0]
            var depList = courseDict.getOrDefault(relation[1], new ArrayList<Integer>());
            depList.add(relation[0]);
            courseDict.put(relation[1], depList);
            indegrees[relation[0]]++;
        }

        // use topological sort
        // create a set of 0-indegree nodes
        for (int course=0; course<numCourses; course++){
            if (indegrees[course] == 0){
                set.add(course);
            }
        }

        int totalEdge = prerequisites.length;
        int removedEdge = 0;
        while(!set.isEmpty()){
            int currCourse = set.poll();
            // traverse through the course's dependency list
            if (courseDict.containsKey(currCourse)){
                for (int dep: courseDict.get(currCourse)){
                    indegrees[dep]--;
                    removedEdge++;
                    if (indegrees[dep] ==0){
                        set.add(dep);
                    }
                }
            }
        }

        return removedEdge == totalEdge;
    }
}

/**
 * LeetCode solution:
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
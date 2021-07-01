import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {

        /*
    @author: Linh Tran
    @version: July 01, 2021

    Runtime and usage info of the solution:
    Runtime: 4 ms, faster than 98.26% of Java online submissions for Employee Importance.
    Memory Usage: 40.6 MB, less than 35.96% of Java online submissions for Employee Importance.
    */

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    class Solution {
        public int getImportance_BFS(List<Employee> employees, int id) {
            // BFS: traverse through the root's children
            // find all nodes' importance scores and sum up
            // SC: O(N) with N being the number of employees
            // TC: O(N)
            int sum = 0;

            // key: id, val: Employee
            HashMap<Integer, Employee> map = new HashMap<>();

            // build the map
            for (Employee emp: employees){
                map.put(emp.id, emp);
            }

            Deque<Employee> dq = new ArrayDeque<>();
            dq.add(map.get(id));

            while(!dq.isEmpty()){
                Employee currEmp = dq.poll();
                sum+=currEmp.importance;

                for (int subId: currEmp.subordinates){
                    dq.add(map.get(subId));
                }
            }

            return sum;
        }
    }

    public int getImportance_DFS(List<Employee> employees, int id) {
        // DFS:
        // SC: O(M) with M being the number of total employee
        // TC: O(N+1) with N being the number of the employee's subordinates

        // key: id, val: Employee
        HashMap<Integer, Employee> map = new HashMap<>();
        // build the map
        for (Employee emp: employees){
            map.put(emp.id, emp);
        }

        return calcImportance(map, id);
    }

    private int calcImportance(HashMap<Integer, Employee> map, int id){
        for (int subId: map.get(id).subordinates){
            map.get(id).importance += calcImportance(map, subId);
        }

        // base case: return directly
        return map.get(id).importance;
    }
}

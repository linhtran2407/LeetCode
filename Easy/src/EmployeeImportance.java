import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
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
}

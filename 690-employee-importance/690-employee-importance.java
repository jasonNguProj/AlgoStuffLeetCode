/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/*
to solve this question we are just given a list of employees
but then we have to find a way to connect the id with the employee
and well use a map to that 
then we add our current i and then traverse it neighbors getting all importance
we'll traverse via BFS

*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int importance = 0;
        while(!queue.isEmpty()){
            
          
            Employee e = queue.poll();
            importance += e.importance;
            
            for(Integer subordinate : e.subordinates){
                queue.offer(map.get(subordinate));
            }
            
        }
        return importance;
    }
}
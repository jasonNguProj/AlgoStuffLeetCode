/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/*
we need to understand that from the given imput
this is an n- arry tree or graph so to speak
since the date is given in a list we will use a hashmap to 
easily search by employee due to its quick lookup
then as we poll the value we add its importance with that
of its subordinates or neighbors

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
            
            for(Integer subordinate :  e.subordinates){
                queue.offer(map.get(subordinate));
            }
        }
        return importance;
    }
}
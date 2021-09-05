/*
to solve this problem we will use three sets and then traverse
via the set and then add the numbers in a list and then return that list

*/

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        
        Set<Integer> setTwo =new HashSet<>();
        for(int j : arr2){
            if(set.contains(j)){
                setTwo.add(j);
            }
        }
         Set<Integer> setThree =new HashSet<>();
        for(int k : arr3){
            if(setTwo.contains(k)){
                setThree.add(k);
            }
        }
        
        LinkedList<Integer> result = new LinkedList<>();
        
        for(Integer num : setThree){
            result.add(num);
        }
        
        Collections.sort(result);
        return result;
    }
}
/*
so to solve this question they hve asked us to return array of users whose UAM equals j
so we nee a hasmap for unique users and we are told they have unique minutes as well
so we first traverse the 2d array and add users and then we add userse into the hashset in the map
and then we travers via every key get the size and increment the user and store the info in a the result array



*/


class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] log : logs){
            int id = log[0];
            int time = log[1];
            map.putIfAbsent(id, new HashSet<>());
            map.get(id).add(time);
        }
        
        int[] result = new int[k];
        for(int user : map.keySet()){
            int uam = map.get(user).size();
            result[uam - 1]++;
        }
        
        return result;
    }
}
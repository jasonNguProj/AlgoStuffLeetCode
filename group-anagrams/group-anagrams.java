/*

to solve this question we need to understand what an anagram is , which a word formed by rearraging xtres
so this means that from our input if we sort a string and map it to other strings that can be formed from that 
string it means we will get our answer via String = {string a, String b, sting c}
so we use a map to chek if not present if present we just add the values to the list of refored strings

*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
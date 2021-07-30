// class Solution {
//     public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
//     }
// }

class Solution {
    public int maxFreq(String s, int maxLetters, int minsize, int maxSize) {
        if(maxLetters!=0 && maxSize!=0){
            Set<Character> set = new HashSet<>();
            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<=s.length()-minsize; i++){
                String sub = s.substring(i, i+minsize);
                if(sub.chars().distinct().count() <= maxLetters){
                    map.put(sub, map.getOrDefault(sub, 0)+1);
                }
            }
            if(map.size()!=0)
            return Collections.max(map.values());
        }
        return 0;
        
    }
}
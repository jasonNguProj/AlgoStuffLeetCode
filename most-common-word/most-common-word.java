class Solution {
    // O(M + N ) Space Time complexity
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedWord = new HashSet<>();
            for(String b: banned){
                bannedWord.add(b);
            }
        String[] paraSplit = normalizedStr.split("\\s+");
        for(String word : paraSplit){
            if(!bannedWord.contains(word))
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
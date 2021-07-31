/*
to solve this qxn optimaly we will need a hashmap to trackof unique tweetss
and inside the mad we need unique time intervala againg count of tweets in that interval
then we add into our list then traverse the list 
the values in the list will be our tweet count 
*/

class TweetCounts {

    Map<String, TreeMap<Integer, Integer>> map;
    public TweetCounts() {
        map = new HashMap<String, TreeMap<Integer, Integer>>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if(!map.containsKey(tweetName)) {
            map.put(tweetName, new TreeMap<>());
        }
        
        TreeMap<Integer, Integer> temp = map.get(tweetName);
        temp.put(time, temp.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        
        List<Integer> result = new ArrayList<>();
        if(!map.containsKey(tweetName)) return result;
        int interval = 0;
        if(freq.equals("minute")){
            interval = 60;
        }else if (freq.equals("hour")){
            interval = 3600;
        } else if (freq.equals("day")){
            interval = 86400;
        }
        int firstIndex = ((endTime - startTime)/interval) + 1 ;
        int[] bucket = new int[firstIndex];
        
        TreeMap<Integer, Integer> vals = map.get(tweetName);
        
        for(Map.Entry<Integer,Integer> entry : vals.subMap(startTime, endTime + 1).entrySet()){
            int secIndex = (entry.getKey() - startTime)/ interval;
            bucket[secIndex] += entry.getValue();
        }
        
        for(int i : bucket){
            result.add(i);
        }
      return result;
        
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
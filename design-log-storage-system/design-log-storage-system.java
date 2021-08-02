/*
to solve this qxn we will use a hashmap to put elements into a map
then to retrieve between start and end given granularity say maybe day oe min we will
just traverse via the string and check conditions that pattern to granularity given
then in the end we traverse via keys in the hashmap and get the timestamp
that is within the range if btw the start and end range we just add into our array and then we return our array
this will be O(N) time | O(n) space
using a treeMap will give O(logn) time for search/ traversal in the hasmap

*/

class LogSystem {
  TreeMap<Integer, String> map ;
   
    public LogSystem() {
        map = new TreeMap<Integer, String>();
    }
    
    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        int x = 0;
        
        if(granularity.equals("Year")){
            x = 4;
        } else if (granularity.equals("Month")){
            x = 7;
        }else if (granularity.equals("Day")){
            x = 10;
        }else if (granularity.equals("Hour")){
            x = 13;
        }else if (granularity.equals("Minute")){
            x = 16;
        }else if (granularity.equals("Second")){
            x = 19;
        }      
        // switch(granularity){
        //     case  "Year":
        //         x = 4;
        //         break;
        //     case  "Month":
        //         x = 7;
        //         break;
        //     case  "Day":
        //         x = 10;
        //         break;
        //     case  "Hour":
        //         x = 13;
        //         break;
        //     case  "Minute":
        //         x = 16;
        //         break;
        //     case  "Second":
        //         x = 19;
        //         break;
        // }
        start = start.substring(0, x);
         end = end.substring(0, x);
        List<Integer> result = new ArrayList<>();
        for(Integer entry : map.keySet()){
            String getTimeStamp = map.get(entry).substring(0, x);
            if(getTimeStamp.compareTo(end) <=0 && getTimeStamp.compareTo(start) >= 0)
                result.add(entry);
        }
        return result;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
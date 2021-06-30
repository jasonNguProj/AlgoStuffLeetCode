class Solution {
    // O(N) time | O(1) space because the extra array of 4 directions will always be 4
    // regardless if a string is of length 17, 18, 20 
    public boolean isRobotBounded(String instructions) {
        
        int dir[][] = {{0,1}, {-1,0}, {0, -1}, {1, 0}};
        int b = 0;
        int x = 0; 
        int y = 0;
        
        for(int i =0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'L'){
                b = (b + 1) % 4;
            } else if(instructions.charAt(i) == 'R'){
                  b = (b + 3) % 4;
            } else {
                x = x + dir[b][0];
                y = y + dir[b][1];
            }
        }
        return x == 0 && y == 0 || b > 0; 
    }
}
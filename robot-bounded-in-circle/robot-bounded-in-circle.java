/*
to solve this problem we have to take note of the fact that L and R 
are just directions and then G is the direction
at the end if the robot comes back to the origin that is (0,0) hence it never leaves the cirle
so there are couple of ways the bot move 

       
                        
                        
                        
                        |up(0, 1)  -left (-1, 0), down(0, -1), right(1, 0)
                        we create a varible i that indicates hw we move
                        and to avoid index out od bound exception and our arr is 4 directions we do (i + 1)
                        1 rep the pos of left or right

*/


class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1,0}};
        
        int a = 0 , x =0, y =0;
        
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'L'){
                a = (a + 1) % 4;
            } else if(instructions.charAt(i) == 'R'){
                a = (a + 3) % 4;
            } else {
                x += dir[a][0];
                y += dir[a][1];
            }
        }
        
        return x == 0 && y == 0 || a > 0;
    }
}
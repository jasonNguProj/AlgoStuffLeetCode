/*
to solve this question we need to understand that we are give left, right and straight to move
from the example we can infer that our robot would move up, left, down, right to come back to the origin 
or to make a circle,

the time complexity is O(N) because we would traverse the directions array to get our movements
the space is O(1) because regardless of our directions string we wold always move 4 times that is up, left, down and right,

Algoroithm
we need to initialize our movements array that would help us
when our robot is given l, r or straight and to avoid idx out of bounds 
we'll mod our movments i by 4
then in a case where we have no rotation where i is zero means there 
is no rotation and also take care of a case where i is greater that zero



*/



class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int i =0, x = 0, y = 0;
        
        int[][] moves = {{0,1}, {-1, 0}, {0, -1}, {1, 0}};
        
        for(int k = 0; k < instructions.length(); k++){
            
            if(instructions.charAt(k) == 'L'){
                i = (i + 1) % 4;
            } else if(instructions.charAt(k) == 'R'){
                i = (i + 3) % 4;
            } else {
                x = x + moves[i][0]; 
                 y = y + moves[i][1]; 
            }
        }
        return x == 0 && y == 0 || i != 0;
        
    }
}
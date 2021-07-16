/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//so to solve this question given the knows api
// we'll set a celeb varible to 0, and traverse via the people 
// if knows(celeb, i) , i is the celeb
// also we need to check when it will be false 
// check if the dnt know themselselves, check if celeb a knos i , but i does not know celeb,
//we return -1 theres no celeb
//at the end return celeb

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        
        for(int i = 1; i < n; i++){
            if(knows(celeb, i)){
                celeb = i;
            }
        }
        
        for(int i = 0; i < n ; i++){
            if(celeb != i && knows(celeb, i) || !knows(i, celeb)){
                return -1;
            }
        }
        return celeb;
    }
}
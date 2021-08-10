/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/*
to solve this question we are given a know api 
that telss us if i knows j 
then j is the celeb 
and we are told to reduce calls to the API so we can find our celeb
and then check if celeb is really our celeb
*/

public class Solution extends Relation {
    int numOfPeople;
    public int findCelebrity(int n) {
        
        numOfPeople = n ;
        int celeb = 0;
        for(int i = 0; i < n; i++){
            if (knows(celeb, i))
                celeb = i;
        }
         if(celebCheck(celeb)){
                return celeb;
            }
        return -1;
    }
    
    
    public boolean celebCheck(int i){
        for(int j = 0; j < numOfPeople; j++){
            if( i == j) continue; // because we dont want to be doing a check with it self we are checking the other people // in a 
            
            if(knows(i, j) || !knows(j, i)){
                return false;
            }
        }
        return true;
    }
}
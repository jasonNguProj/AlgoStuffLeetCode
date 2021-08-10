class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for(int i = 0; i < columnTitle.length(); i++){
            result *= 26; // cus there are 26 lett in the alphabeth
                result +=(columnTitle.charAt(i)- 'A' + 1); // plus 1 cus A is one in the question
        }
        return result;
    }
}
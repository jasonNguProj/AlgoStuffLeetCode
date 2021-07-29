/*
so to build a try we need an array of children which are of 26 letters
then a boolean isend which tell us we are at the end
for each fxn we traverse via the word given 
and for the insert fxn if it trie is null we create a new trie
then set the current to start from the ne root aftre the creation
and do thesame thing with search and starts with 
O(N) time because we traverse for all the fxn | O(N)space for the trienode array

*/

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    TrieNode(){
        children = new TrieNode[26];
            isEnd = false;
    }
}

class Trie {

     TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public Trie() {
       
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children[c - 'a'] == null){
                current.children[c - 'a'] =  new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
          TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children[c - 'a'] == null){
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         TrieNode current = root;
        for(char c: prefix.toCharArray()){
            if(current.children[c - 'a'] == null){
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
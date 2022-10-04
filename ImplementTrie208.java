class Trie {

    private Node root; 
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.putString(word, 0);
    }
    
    public boolean search(String word) {
        Node node = root;
        for (char c: word.toCharArray()) {
            int letter = c - 'a';
            if (node.s[letter] == null) {        
                return false;
            } else {
                node = node.s[letter];
            }
        }
        
        return node.isCompleted;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c: prefix.toCharArray()) {
            int letter = c - 'a';
            if (node.s[letter] == null) {
                return false;
            } else {
                node = node.s[letter];
            }
        }
        
        return true;
    }
}

class Node {
    public Node[] s = new Node[26];
    public boolean isLeaf = true;
    public boolean isCompleted = false;
    
    public void putString(String sin, int i) {
        if (i >= sin.length()) {
            isCompleted = true;
            return;
        }
        int first = sin.charAt(i) - 'a';
        isLeaf = false;
        s[first] = s[first] == null ? new Node() : s[first]; 
        s[first].putString(sin, i+1);
    } 
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

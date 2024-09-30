class TrieNode {
    TrieNode[] links;
    boolean flag;

    TrieNode() {
        links = new TrieNode[26];
        flag = false;
    }
    boolean containsKey(char c) {
        return links[c-'a'] != null;
    }
    void putKey(char c, TrieNode trieNode) {
        links[c-'a'] = trieNode;
    }
    TrieNode getKey(char c) {
        return links[c-'a'];
    }
    void setEnd() {
        flag = true;
    }
    boolean isEnd() {
        return flag;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            if(node.containsKey(word.charAt(i)) == false) {
                node.putKey(word.charAt(i), new TrieNode());
            }
            node = node.getKey(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            if(node.containsKey(word.charAt(i)) == false) {
                return false;
            }
            node = node.getKey(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            if(node.containsKey(prefix.charAt(i)) == false) {
                return false;
            }
            node = node.getKey(prefix.charAt(i));
        }
        return true;
    }
}

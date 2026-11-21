// Trie: each node has children by character and an end-of-word flag. Ops are O(word length).
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord;
}
TrieNode root = new TrieNode();

void insert(String w) {
    TrieNode n = root;
    for (char c : w.toCharArray()) {
        if (n.next[c - 'a'] == null) n.next[c - 'a'] = new TrieNode();
        n = n.next[c - 'a'];
    }
    n.isWord = true;
}
TrieNode walk(String prefix) {               // null if the prefix is absent
    TrieNode n = root;
    for (char c : prefix.toCharArray()) { n = n.next[c - 'a']; if (n == null) return null; }
    return n;
}
// search(w): walk(w) != null && walk(w).isWord.  startsWith(p): walk(p) != null.
// Autocomplete: DFS from walk(prefix) in a..z order, stop after 3 words.

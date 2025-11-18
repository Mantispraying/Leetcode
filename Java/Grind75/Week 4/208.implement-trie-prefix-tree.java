import java.util.*;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {

    Trie[] trie;
    Boolean flag;

    public Trie() {
        trie = new Trie[26];
        flag = false;
    }

    public void insert(String word) {
        if (word.length() == 0) {
            flag = true;
            return;
        }
        char ch = word.charAt(0);
        if (trie[ch - 'a'] == null) {
            trie[ch - 'a'] = new Trie();
        }
        trie[ch - 'a'].insert(word.substring(1));
    }

    public boolean search(String word) {
        if (word.length() == 0) {
            return flag;
        }
        char ch = word.charAt(0);
        if (trie[ch - 'a'] == null) {
            return false;
        }
        return trie[ch - 'a'].search(word.substring(1));
    }

    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }
        char ch = prefix.charAt(0);
        if (trie[ch - 'a'] == null) {
            return false;
        }
        return trie[ch - 'a'].startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

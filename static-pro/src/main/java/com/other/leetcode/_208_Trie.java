package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/20 11:17
 */
public class _208_Trie {

    class TrieNode {
        public TrieNode[] next;
        public boolean end;

        public TrieNode() {
            this.next = new TrieNode[26];
            this.end = false;
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public _208_Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.next[index] == null) cur.next[index] = new TrieNode();
            cur = cur.next[index];
        }
        cur.end = true;
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = get(word);
        return cur != null ? cur.end : false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return get(prefix) != null;
    }

    private TrieNode get(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.next[index] == null) return null;
            cur = cur.next[index];
        }
        return cur;
    }

}

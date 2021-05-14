package com.hxh.trie;

/**
 * @author huangxunhui
 * Date: Created in 18/11/28 下午10:07
 * Utils: Intellij Idea
 * Description: Trie测试方法
 */
public class TrieMain {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("world");
        trie.add("hello");

        System.out.println(trie.contains("world"));
        System.out.println(trie.isPrefix("we"));


    }
}

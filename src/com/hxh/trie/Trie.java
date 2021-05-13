package com.hxh.trie;

import javax.xml.soap.Node;
import java.util.TreeMap;

/**
 * @author huangxunhui
 * Date: Created in 2018/11/28 下午5:56
 * Utils: Intellij Idea
 * Version:
 * Description:
 */
public class Trie {

    private class Node{

        boolean isWord;

        public TreeMap<Character , Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    //获得trie中的单词数量
    public int getSize(){
        return size;
    }

    public void add(String word){
        Node curl = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curl.next.get(c) == null){
                curl.next.put(c, new Node());
            }
            curl = curl.next.get(c);
        }
        if(!curl.isWord){
            curl.isWord = true;
            size ++;
        }
    }
}


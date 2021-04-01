package com.hxh.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 下午2:23
 * Utils: Intellij Idea
 * Description: 唯一摩尔斯密码词
 */
public class UniqueMorseRepresentations {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[] word = {"gin", "zen", "gig", "msg"};
        System.out.println(solution1.uniqueMorseRepresentations(word));
    }
}

class Solution1 {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new TreeSet<>();
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word : words) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                result.append(code[word.charAt(i) - 'a']);
            }
            set.add(result.toString());
        }
        return set.size();
    }
}

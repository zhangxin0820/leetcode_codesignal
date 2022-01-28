package com.zx.algorithm.leetcode;

import com.zx.algorithm.TrieNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxin on 2022/01/27.
 * Time : 21:39
 * 在英语中，我们有一个叫做词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * ["a", "aa", "aaa", "aaaa"]
 * "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 *
 * 预期结果："a a a a a a a a bbb baba a"
 */
public class ReplaceWords {

    public static void main(String[] args) {
        /*List<String> dictionary = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";*/
        List<String> dictionary = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }

    private static String replaceWords(List<String> dictionary, String sentence) {

        TrieNode trie = new TrieNode();
        for (String root : dictionary) {
            trie.put(root);
        }
        StringBuilder res = new StringBuilder();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = trie.shortestPrefixOf(words[i]);
            if (!"".equals(prefix)) {
                res.append(prefix);
            } else {
                res.append(words[i]);
            }
            if (i != words.length - 1) res.append(" ");
        }
        return res.toString();
    }
}
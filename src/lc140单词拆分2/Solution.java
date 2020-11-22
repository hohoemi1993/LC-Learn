package lc140单词拆分2;

import java.util.ArrayList;
import java.util.List;

/**
 * 我还是不会
 * 后面再说吧 这题太复杂了
 */
public class Solution {
  public static List<String> wordBreak(String s, List<String> wordDict) {
    ArrayList<String> ans = new ArrayList<>();
    if (s == null || wordDict == null) return ans;

    // 构建前缀树，优化前缀查询
    Node root = buildTrieTree(wordDict);

    // 动态规划，获取DP数组，dp[i]：s[i...]能被分解的方案数
    int[] dp = getDP(s, root);

    // DFS，利用前缀树+DP数组，剪枝
    process(s, root, dp, 0, new ArrayList<>(), ans);

    return ans;
  }

  // root：单词表挂在前缀树上
  // dp：动态规划表，用于回溯 dp[i]含义：s[i...]可以被分解的方案数
  // i：当前位置，i以前的不用考虑，分解结果已经放在words里了，现在的任务是分解s[i...]
  // words：分解出的单词，一个words对应一种分解方案，即 一个DFS深度优先遍历路径
  private static void process(String s, Node root, int[] dp,
      int i, ArrayList<String> words, ArrayList<String> ans) {
    if (i == s.length()) {
      String sentence = buildToSentence(words);
      ans.add(sentence);
      return;
    }

    // s[i ...]无法被分解，剪枝
    if (dp[i] == 0) {
      return;
    }

    // s[i ...]可以被分解
    // 从i开始，向后逐一尝试，看能否分解出一个单词
    Node cur = root;
    for (int end = i; end < s.length(); end++) {
      char curChar = s.charAt(end);
      int path = curChar - 'a';

      if (cur.paths[path] == null) break;

      cur = cur.paths[path];

      // 找到一个方案：分解出一个单词，加入words，从end+1位置向后继续这个方案，DFS
      if (cur.end) {
        String word = s.substring(i, end + 1);
        words.add(word);
        process(s, root, dp, end+1, words, ans);
        words.remove(words.size()-1);
      }

      // 继续向后尝试分解单词，找其他方案
    }
  }

  private static String buildToSentence(ArrayList<String> words) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < words.size(); i++) {
      String word = words.get(i);
      sb.append(word);
      if (i != words.size()-1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }


  static class Node {
    Node[] paths;
    boolean end;


    public Node() {
      paths = new Node[26];
      end = false;
    }
  }

  private static Node buildTrieTree(List<String> wordDict) {
    Node root = new Node();

    for (String word : wordDict) {
      char[] chars = word.toCharArray();
      Node cur = root;
      for (char c : chars) {
        if (cur.paths[c-'a'] == null) {
          cur.paths[c-'a'] = new Node();
        }
        cur = cur.paths[c-'a'];
      }
      cur.end = true;
    }

    return root;
  }


  // 返回dp数组，dp[i]含义：s[i ...]能被分解的方案数
  private static int[] getDP(String s, Node root) {
    int N = s.length();
    int[] dp = new int[N + 1];

    dp[N] = 1;

    for (int i = N-1; i >= 0; i--) {
      int count = 0;
      Node cur = root;

      for (int index = i; index < N; index++) {
        char curChar = s.charAt(index);
        if (cur.paths[curChar-'a'] == null) {
          break;
        }
        cur = cur.paths[curChar-'a'];
        if (cur.end) {
          count += dp[index+1];
        }
      }

      dp[i] = count;
    }

    return dp;
  }
}

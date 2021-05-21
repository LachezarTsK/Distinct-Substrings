package distinctSubstrings.gitHub;

public class Solution {

  /*
  By the problem design on binarysearch.com, we have to work
  around the given method 'public int solve(String s)'
  so that the code can be run on the website. Even though the name 'solve'
  does not make a lot of sense, it is left as it is, so that the code can
  be run directly on the website, without any modifications.
  */
  public int solve(String s) {
    return find_numberOfDistinctSubstrings(s);
  }

  public int find_numberOfDistinctSubstrings(String s) {
    TrieNode root = new TrieNode();
    int numberOfDistinctSubstrings = 0;

    for (int i = 0; i < s.length(); i++) {
      TrieNode current = root;

      for (int j = i; j < s.length(); j++) {
        char ch = s.charAt(j);

        /*
        The total number of distinct substrings is equal to the total number of nodes
        in the Trie. Thus, every time a new TrieNode is created, we increase with '1'
        the value of 'numberOfDistinctSubstrings'.
        */
        if (current.branches[ch - 'a'] == null) {
          current.branches[ch - 'a'] = new TrieNode();
          numberOfDistinctSubstrings++;
        }
        current = current.branches[ch - 'a'];
      }
    }
    return numberOfDistinctSubstrings;
  }
}

// Solving this particular problem does not require the TrieNode to have a boolean 'isEndOfWord'.
class TrieNode {
  TrieNode[] branches;
  final int CHARS_IN_ALPHABET = 26;

  public TrieNode() {
    this.branches = new TrieNode[CHARS_IN_ALPHABET];
  }
}

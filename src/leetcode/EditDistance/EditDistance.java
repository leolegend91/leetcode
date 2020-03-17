package leetcode.EditDistance;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solution.minDistance(word1, word2));

        word1 = "intention";
        word2 = "execution";
        System.out.println(solution.minDistance(word1, word2));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] maxDistance = new int[m + 1][n + 1];

        for (int i= 0;i < m + 1; i++) {
            for (int j = 0;j < n + 1; j++) {
                if (i == 0) {maxDistance[i][j] = j;}
                else if (j == 0) {maxDistance[i][j] = i;}
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {maxDistance[i][j] = maxDistance[i-1][j-1];}
                else {
                    maxDistance[i][j] = 1 + min(maxDistance[i-1][j], maxDistance[i-1][j-1], maxDistance[i][j-1]);
                }
            }
        }
        return maxDistance[m][n];
    }

    private int min(int x, int y, int z) {
        return min(x, y) < z ? min(x, y) : z;
    }

    private int min(int x, int y) {
        return x < y ? x : y;
    }
}
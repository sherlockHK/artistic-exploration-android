package com.gakki.hk.artistic_exploration_android.algorithm;

import com.gakki.hk.artistic_exploration_android.data_structure.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by kai on 2020/5/14
 * Email：kaihu1989@gmail.com
 * Feature:
 */
public class LcUtil {
    public static class Solution1 {
        List<List<Integer>> output = new LinkedList();
        LinkedList<Integer> curr = new LinkedList<>();
        int n;
        int k;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtrack(1);
            return output;
        }

        private void backtrack(int first) {
            // if the combination is done
            if (curr.size() == k) {
                output.add(new LinkedList(curr));
                return;
            }
            for (int i = first; i <= n; ++i) {
                // add i into the current combination
                curr.add(i);
                // use next integers to complete the combination
                backtrack(i + 1);
                // backtrack
                curr.removeLast();
            }
        }
    }

    /**
     * 3.在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        for (int i : nums) {
            if (m.containsKey(i)) {
                return i;
            }
            m.put(i, true);
        }
        return -1;
    }

    /**
     * 4.二维数组中的查找（mid）
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 示例:
     * 现有矩阵 matrix 如下：
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false。
     * 限制：
     * 0 <= n <= 1000
     * 0 <= m <= 1000
     * tips：从最右上侧看（15），就是二叉搜索树
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 5.替换空格
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 示例 1：
     * 输入：s = "We are happy." 输出："We%20are%20happy."
     */
    public static String replaceStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 6.从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     * 输入：head = [1,3,2] 输出：[2,3,1]
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        int length = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        int[] res = new int[length];
        printNode(head, res);
        return res;
    }

    private static int pos1 = 0;

    private static void printNode(ListNode n, int[] res) {
        if (n == null) return;
        printNode(n.next, res);
        res[pos1] = n.val;
        pos1++;
    }

    /**
     * 9.用两个栈实现一个队列。
     * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * (若队列中没有元素，deleteHead 操作返回 -1 )
     */
    public static class CQueue {
        private final LinkedList<Integer> stack1;
        private final LinkedList<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
            return stack2.pop();
        }
    }

    /**
     * 10-1.斐波那契数列
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 示例 1： 输入：n = 2  输出：1
     * 示例 2： 输入：n = 5  输出：5
     */
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 10-2.青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 示例 1：输入：n = 2 输出：2
     * 示例 2：输入：n = 7 输出：21
     * 示例 3：输入：n = 0 输出：1
     */
    public static int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        return numWays(n - 1) + numWays(n - 2);
    }

    /**
     * 11.旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * 示例 1：输入：[3,4,5,1,2] 输出：1
     * 示例 2：输入：[2,2,2,0,1] 输出：0
     */
    //O(n)
    public static int minArray1(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        if (numbers.length == 1) return numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int n = numbers[i];
            if (n < numbers[i - 1]) {
                return n;
            }
        }
        return -1;
    }

    //O(Log2n)
    //tips：排序数字优先考虑二分法，可将"遍历法"的"线性时间"复杂度降低至"对数级别"
    public static int minArray2(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] > numbers[r]) {
                //在左序列
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                //在右序列
                r = mid;
            } else {
                //无法判断是左序列还是右序列，缩小判断范围，eg:[1,0,1,1,1]  [1,1,1,0,1]
                r--;
            }
        }
        return numbers[l];
    }

    /**
     * 12.矩阵中的路径（mid）
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     * 示例 1：输入：board = [
     * ["A","B","C","E"],
     * ["S","F","C","S"],
     * ["A","D","E","E"]], word = "ABCCED"  输出：true
     * 示例 2：输入：board = [
     * ["a","b"],
     * ["c","d"]], word = "abcd"  输出：false
     * <p>
     * ans：
     * 典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决。
     * 深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
     * 剪枝： 在搜索中，遇到这条路不可能和目标字符串匹配成功的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为可行性剪枝。
     * DFS 解析：
     * 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     * 终止条件：
     * 返回 false ： (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
     * 返回 true ： k = len(word) - 1 ，即字符串 word 已全部匹配。
     * 递推工作：
     * 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
     * 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
     * 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
     * 返回值： 返回布尔量res，代表是否搜索到目标字符串。
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist_bfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean exist_bfs(char[][] board, String word, int x, int y, int k) {
        //越界
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) return false;
        //已访问过
        if (board[x][y] == ' ') return false;
        //与目标字符不同
        if (board[x][y] != word.charAt(k)) return false;
        //标记已访问过
        board[x][y] = ' ';
        if (k == word.length() - 1) {
            return true;
        }
        //上、下、左、右四个方向遍历
        boolean res = exist_bfs(board, word, x + 1, y, k + 1) ||
                exist_bfs(board, word, x - 1, y, k + 1) ||
                exist_bfs(board, word, x, y + 1, k + 1) ||
                exist_bfs(board, word, x, y - 1, k + 1);
        //还原字符
        board[x][y] = word.charAt(k);
        return res;
    }

    /**
     * 13.机器人的运动范围（mid）
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * 示例 1：输入：m = 2, n = 3, k = 1  输出：3
     * 示例 2：输入：m = 3, n = 1, k = 0  输出：1
     */
    public static int movingCount(int m, int n, int k) {
        return -1;
    }

    /**
     * 14-1.剪绳子(mid)
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 示例 1： 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:  输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * */
    public int cuttingRope1(int n) {
        return -1;
    }

    /**
     * 14-2.剪绳子2(mid)
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
     * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 示例 1：输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2: 输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * */
    public int cuttingRope2(int n) {
        return -1;
    }

    /**
     * 15.二进制中1的个数
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
     * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     */
    public static int hammingWeight(int n) {
        return -1;
    }

    /**
     * 16.数值的整数次方（mid）
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     * 示例 1: 输入: 2.00000, 10  输出: 1024.00000
     * 示例 2: 输入: 2.10000, 3  输出: 9.26100
     * 示例 3: 输入: 2.00000, -2 输出: 0.25000  解释: 2-2 = 1/22 = 1/4 = 0.25
     */
    public static double myPow(double x, int n) {
        return -1;
    }

    /**
     * 17.打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * 示例 1: 输入: n = 1 输出: [1,2,3,4,5,6,7,8,9]
     */
    public static int[] printNumbers(int n) {
        return null;
    }

}

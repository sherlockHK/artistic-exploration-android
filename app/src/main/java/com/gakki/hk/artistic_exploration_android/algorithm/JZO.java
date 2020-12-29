package com.gakki.hk.artistic_exploration_android.algorithm;

import com.gakki.hk.artistic_exploration_android.data_structure.ListNode;
import com.gakki.hk.artistic_exploration_android.data_structure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kai on 2020/5/14
 * Email：kaihu1989@gmail.com
 * Feature: JZ offer
 */
public class JZO {
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
    //动态规划，非递归方式，避免重复计算
    public static int numWays(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
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
     */
    // 典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决。
    // 深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
    // 剪枝： 在搜索中，遇到这条路不可能和目标字符串匹配成功的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为可行性剪枝。
    // DFS 解析：
    // 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
    // 终止条件：
    // 返回 false ： (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
    // 返回 true ： k = len(word) - 1 ，即字符串 word 已全部匹配。
    // 递推工作：
    // 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
    // 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
    // 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
    // 返回值： 返回布尔量res，代表是否搜索到目标字符串。
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
        boolean[][] visited = new boolean[n][m];
        return moving_dfs(m, n, 0, 0, k, visited);
    }

    //递归
    //参数：坐标x、y，横列坐标数值之和的最大值k，矩阵宽高m、n
    //终止条件 ：
    //返回0 1、x、y越界 2、x、y数位之和大于k  3、已访问过
    //返回1+上下左右dfs的返回值
    //记录已访问过的坐标，存入boolean[][]
    //
    private static int moving_dfs(int m, int n, int x, int y, int k, boolean[][] visited) {
        if (x < 0 || x >= n || y < 0 || y >= m) return 0;
        if (x / 10 + x % 10 + y / 10 + y % 10 > k) return 0;
        if (visited[x][y]) return 0;
        visited[x][y] = true;
        return 1 + moving_dfs(m, n, x + 1, y, k, visited)
                + moving_dfs(m, n, x - 1, y, k, visited)
                + moving_dfs(m, n, x, y + 1, k, visited)
                + moving_dfs(m, n, x, y - 1, k, visited);
    }

    /**
     * 14-1.剪绳子(mid)
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 示例 1： 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:  输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * tips：
     * dp三要素：1、重叠子问题 2、最优子结构（子问题无相关性） 3、状态转移方程
     * dp套路：1、明确base case 2、明确状态 3、明确选择 4、定义dp函数/数组
     */
    //dp数组，dp[i]代表i拆分后的最大乘积，j是i拆分出来第一个数，状态转移方程：dp[i] = Max(j * (i-j), j*dp[i-j]) (遍历1<=j<i，取最大值)，使用动态规划求解
    public static int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int restNum = i - j;
                dp[i] = Math.max(dp[i], Math.max(j * (restNum), j * dp[restNum]));
            }
        }
        return dp[n];
    }

    //dp函数：长度为n的最大乘积
    public static int cuttingRope2(int n) {
        //base case
        if (n < 2) return n;
        int res = 0;
        //明确选择
        for (int j = 1; j < n; j++) {
            res = Math.max(res, j * Math.max(n - j, cuttingRope2(n - j)));
        }
        return res;
    }

    /**
     * 15.二进制中1的个数
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
     * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * Tips：n & (n-1)可以把整数（二进制形式）最右边1变成0，eg：1001 & 1000 = 1000, 1000 & 0111 = 0000
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * 16.数值的整数次方（mid）
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     * 示例 1: 输入: 2.00000, 10  输出: 1024.00000
     * 示例 2: 输入: 2.10000, 3  输出: 9.26100
     * 示例 3: 输入: 2.00000, -2 输出: 0.25000  解释: (2)^-2 = (1/2)^2 = 1/4 = 0.25
     * Tips：负数取倒数，m为奇偶数时分别处理
     */
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        } else {
            return x * myPow(x, n / 2) * myPow(x, n / 2);
        }
    }

    /**
     * 17.打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * 示例 1: 输入: n = 1 输出: [1,2,3,4,5,6,7,8,9]
     */
    public static int[] printNumbers(int n) {
        int total = (int) Math.pow(10, n) - 1;
        int[] re = new int[total];
        while (total > 0) {
            re[total - 1] = total;
            total--;
        }
        return re;
    }

    /**
     * 18.删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 示例 1: 输入: head = [4,5,1,9], val = 5 输出: [4,1,9] 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:输入: head = [4,5,1,9], val = 1 输出: [4,5,9] 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return head;
    }

    /**
     * 20.表示数值的字符串(mid)
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     * Tips：有限状态自动机
     */
    public static boolean isNumber(String s) {
        return false;
    }

    /**
     * 21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 示例：输入：nums = [1,2,3,4] 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     * Tips：利用快速排序思想，partition()函数可以将数组以某种条件分成2部分
     */
    public static int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[r] % 2 == 0) {
                r--;
            }
            swap(nums, l, r);
            while (l < r && nums[l] % 2 != 0) {
                l++;
            }
            swap(nums, l, r);
        }
        return nums;
    }

    private static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    /**
     * 22.链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * 示例：给定一个链表: 1->2->3->4->5, 和 k = 2. 返回链表 4->5.
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        while (k > 1) {
            first = first.next;
            k--;
        }
        while (first.next != null) {
            first = first.next;
            head = head.next;
        }
        return head;
    }

    /**
     * 24.翻转链表
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode p = head;
        ListNode q = p.next;
        while (q != null) {
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        return p;
    }

    /**
     * 25.合并两个排序的链表
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 示例1：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * Tips:双指针
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode re = p;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null) {
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return re.next;
    }

    /**
     * 26.树的子结构（mid）
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * 例如:
     * 给定的树 A:
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     * 示例 1：输入：A = [1,2,3], B = [3,1] 输出：false
     * 示例 2：输入：A = [3,4,5,1,2], B = [4,1] 输出：true
     * Tips:
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        boolean re = false;
        if (A.val == B.val){
            re =isSub(A, B);
        }
        if (!re){
            re =isSub(A.left, B);
        }
        if (!re){
            re = isSub(A.right, B);
        }
        return re;
    }

    private static boolean isSub(TreeNode t1, TreeNode t2){
        if (t2 == null) return true;
        if (t1 == null || t1.val != t2.val) return false;
        return isSub(t1.left, t2.left) && isSub(t1.right, t2.right);
    }

    /**
     * 27.二叉树的镜像(翻转二叉树)
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 例如输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * 示例 1：输入：root = [4,2,7,1,3,6,9] 输出：[4,7,2,9,6,3,1]
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode preLeft = root.right;
        root.right = root.left;
        root.left = preLeft;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * 28.对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * 示例 1：输入：root = [1,2,2,3,4,4,3] 输出：true
     * 示例 2：输入：root = [1,2,2,null,3,null,3] 输出：false
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrorTree(root.left, root.right);
    }

    public static boolean isMirrorTree(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 != null && t2 != null){
            return t1.val == t2.val && isMirrorTree(t1.left, t2.right) && isMirrorTree(t1.right, t2.left);
        }
        return false;
    }

    /**
     * 29.顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * 示例 1：输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * Tips：左上右下，
     */
    public static int[] spiralOrder(int[][] matrix) {
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
        int[] re = new int[(r + 1) * (b + 1)];
        int index = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                re[index++] = matrix[t][i];
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                re[index++] = matrix[i][r];
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                re[index++] = matrix[b][i];
            }
            if (--b < t) break;
            for (int i = b; i >= t; i--) {
                re[index++] = matrix[i][l];
            }
            if (l++ > r) break;
        }
        return re;
    }

    /**
     * 30.包含min函数的栈
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     * 示例:
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     * Tips: 用2个栈实现
     * */
    public static class MinStack {
        private LinkedList<Integer> l1;
        private LinkedList<Integer> l2;
        public MinStack() {
            l1 = new LinkedList<>();
            l2 = new LinkedList<>();
        }

        public void push(int x) {
            l1.push(x);
            if (l2.isEmpty() || x < l2.peek()){
                l2.push(x);
            }else {
                l2.push(l2.peek());
            }
        }

        public void pop() {
            l1.pop();
            l2.pop();
        }

        public int top() {
            return l1.peek();
        }

        public int min() {
            return l2.peek();
        }
    }

    /**
     * 31.栈的压入弹出队列（mid）
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     * */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        return false;
    }

    /**
     * 32-1.从上到下打印二叉树（mid）
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：[3,9,20,15,7]
     * */
    public static int[] levelOrder1(TreeNode root) {
        return null;
    }

    /**
     * 32-2.从上到下打印二叉树
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 例如:给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [[3],
     *  [9,20],
     *  [15,7]]
     * */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        return null;
    }

    /**
     * 32-3.从上到下打印二叉树(mid)
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * 例如:给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [[3],
     *  [20,9],
     *  [15,7]]
     * */
    public static List<List<Integer>> levelOrder3(TreeNode root) {
        return null;
    }

    /**
     * 33.二叉搜索树的后序遍历序列(mid)
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * 参考以下这颗二叉搜索树：
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     * 示例 1：输入: [1,6,3,2,5]  输出: false
     * 示例 2：输入: [1,3,2,6,5]  输出: true
     * */
    public static boolean verifyPostorder(int[] postorder) {
        return false;
    }

    /**
     * 34. 二叉树中和为某一值的路径(mid)
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     * [[5,4,11,2],
     *  [5,8,4,5]]
     * */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        return null;
    }

    /**
     * 35.复杂链表的复制(mid)
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     * 示例 1：
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 示例 2：
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * 示例 3：
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * 示例 4：
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     * */
    public static class RandomNode {
        int val;
        RandomNode next;
        RandomNode random;

        public RandomNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static RandomNode copyRandomList(RandomNode head) {
        return null;
    }

    /**
     * 36.二叉搜索树与双向链表(mid)
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     * */
    public static TreeNode treeToDoublyList(TreeNode root) {
        return null;
    }

    /**
     * 38.字符串的排列（mid）
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * 示例: 输入：s = "abc"  输出：["abc","acb","bac","bca","cab","cba"]
     * */
    public static String[] permutation(String s) {
        return null;
    }

    /**
     * 39.数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1: 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]  输出: 2
     * */
    public static int majorityElement(int[] nums) {
        return -1;
    }

    /**
     * 40. 最小的k个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * 示例 1：
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     * */
    public static int[] getLeastNumbers(int[] arr, int k) {
        return null;
    }

}

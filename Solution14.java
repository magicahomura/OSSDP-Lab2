import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        ans.clear(); // 确保每次调用时答案列表是空的
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了4段 IP 地址并且遍历完了字符串
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到4段 IP 地址就已经遍历完了字符串，提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为0，那么这一段IP地址只能为0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
            return;
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        String s1 = "25525511135";
        String s2 = "0000";
        String s3 = "101023";

        System.out.println("Test case 1: " + solution.restoreIpAddresses(s1)); // 输出 ["255.255.11.135", "255.255.111.35"]
        System.out.println("Test case 2: " + solution.restoreIpAddresses(s2)); // 输出 ["0.0.0.0"]
        System.out.println("Test case 3: " + solution.restoreIpAddresses(s3)); // 输出 ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
    }
}

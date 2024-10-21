package org.example;

import java.util.ArrayList;
import java.util.List;

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

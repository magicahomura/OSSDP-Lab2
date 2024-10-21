import org.example.Solution;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import static org.junit.Assert.*;

public class L_2022211983_14_test {

    private Solution solution;

    /**
     * 初始化Solution实例，供所有测试方法使用。
     */
    @Before
    public void setUp() {
        solution = new Solution();
    }

    /**
     * 测试目的：
     * 测试字符串为一个合法IP地址的标准情况，输入长度刚好能分割成合法IP地址。
     * 测试用例：s = "25525511135"
     * 预期输出：["255.255.11.135", "255.255.111.35"]
     */
    @Test
    public void testValidStandardCase() {
        String s = "25525511135";
        List<String> result = solution.restoreIpAddresses(s);
        assertTrue(result.contains("255.255.11.135"));
        assertTrue(result.contains("255.255.111.35"));
        assertEquals(2, result.size());
    }

    /**
     * 测试目的：
     * 测试字符串为只包含0的特殊情况，应该输出"0.0.0.0"。
     * 测试用例：s = "0000"
     * 预期输出：["0.0.0.0"]
     */
    @Test
    public void testAllZerosCase() {
        String s = "0000";
        List<String> result = solution.restoreIpAddresses(s);
        assertEquals(1, result.size());
        assertEquals("0.0.0.0", result.get(0));
    }

    /**
     * 测试目的：
     * 测试含有前导零的情况，确保只生成合法IP。
     * 测试用例：s = "101023"
     * 预期输出：["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
     */
    @Test
    public void testLeadingZeroCase() {
        String s = "101023";
        List<String> result = solution.restoreIpAddresses(s);
        assertTrue(result.contains("1.0.10.23"));
        assertTrue(result.contains("1.0.102.3"));
        assertTrue(result.contains("10.1.0.23"));
        assertTrue(result.contains("10.10.2.3"));
        assertTrue(result.contains("101.0.2.3"));
        assertEquals(5, result.size());
    }

    /**
     * 测试目的：
     * 测试字符串长度不足或过长的情况，不能生成有效的IP地址。
     * 测试用例：s = "123"（太短）和 s = "1234567890123"（太长）
     * 预期输出：空列表
     */
    @Test
    public void testInvalidLengthCase() {
        String tooShort = "123";
        List<String> result1 = solution.restoreIpAddresses(tooShort);
        assertTrue(result1.isEmpty());

        String tooLong = "1234567890123";
        List<String> result2 = solution.restoreIpAddresses(tooLong);
        assertTrue(result2.isEmpty());
    }

    /**
     * 测试目的：
     * 测试字符串中包含超出合法IP范围的情况，例如255后面的数字大于255。
     * 测试用例：s = "256256256256"
     * 预期输出：空列表
     */
    @Test
    public void testOutOfRangeCase() {
        String s = "256256256256";
        List<String> result = solution.restoreIpAddresses(s);
        assertTrue(result.isEmpty());
    }


}


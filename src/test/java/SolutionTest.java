import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private ListNode input1;
    private int input2;
    private ListNode expected;
    private Solution soln = new Solution2();

    public SolutionTest(ListNode input1, int input2, ListNode output) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {createlist(new int[]{1,4,3,2,5,2}), 3, createlist(new int[]{1,2,2,4,3,5})}
        });
    }

    private static ListNode createlist(int[] nums) {
        ListNode head = null;
        if (nums.length > 0) {
            head = new ListNode(nums[0]);
            ListNode p = head;
            for (int i = 1; i < nums.length; i++) {
                p.next = new ListNode(nums[i]);
                p = p.next;
            }
        }
        return head;
    }

    @Test
    public void testPartition() {
        assert(checkEquals(expected, soln.partition(input1, input2)));
    }

    private boolean checkEquals(ListNode expected, ListNode actual) {
        ListNode p1 = expected, p2 = actual;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p1 == null && p2 == null;
    }

}
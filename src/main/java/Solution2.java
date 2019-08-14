public class Solution2 implements Solution {
    @Override
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = null, larger = null, first = null, second = null;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                if (smaller == null) {
                    smaller = p;
                    first = smaller;
                } else {
                    first.next = p;
                    first = first.next;
                }
            } else {
                if (larger == null) {
                    larger = p;
                    second = larger;
                } else {
                    second.next = p;
                    second = second.next;
                }
            }
            p = p.next;
        }
        if (second != null) {
            second.next = null;
        }

        if (first != null) {
            first.next = larger;
            return smaller;
        } else {
            return larger;
        }
    }
}

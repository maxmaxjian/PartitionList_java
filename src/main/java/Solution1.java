public class Solution1 implements Solution {
    @Override
    public ListNode partition(ListNode head, int x) {

    	if (head == null) {
    		return null;
		}

    	ListNode last = head;
    	while (last.next != null) {
    		last = last.next;
		}
    	ListNode found = find(head, x);
    	head = swap(head, found, last);
    	print(head);
    	ListNode p = head, firstHigh = head;
    	ListNode pnext = p.next, firstHighnext =firstHigh.next;
    	while (p != null) {
    		if (p.val < x) {
    			if (p != firstHigh) {
    				head = swap(head, p, firstHigh);
					print(head);
				}
				firstHigh = firstHighnext;
				firstHighnext = firstHigh.next;
			}
    		p = pnext;
    		if (pnext != null) {
				pnext = p.next;
			}
		}
		print(head);
    	head = swap(head, found, firstHigh);
		print(head);

        return head;
    }

    private void print(ListNode head) {
		if (head != null) {
			System.out.print(head.val + " -> ");
			print(head.next);
		} else {
			System.out.println();
		}
	}

    private ListNode find(ListNode head, int x) {
    	ListNode p = head;
    	while (p != null && p.val != x) {
    		p = p.next;
		}
    	return p;
	}

	private ListNode swap(ListNode head, ListNode pi, ListNode pj) {
		if (pi != pj) {
			if (pi.next == pj) {
				ListNode ppi = findPrev(head, pi);
				if (ppi != null) {
					ppi.next = pj;
					pi.next = pj.next;
					pj.next = pi;
				} else {
					head = pj;
					pi.next = pj.next;
					pj.next = pi;
				}
			} else if (pj.next == pi) {
				ListNode ppj = findPrev(head, pj);
				if (ppj != null) {
					ppj.next = pi;
				} else {
					head = pi;
				}
//				pi.next = pj.next;
//				pj.next = pi;
			} else {
				ListNode ppi = findPrev(head, pi), ppj = findPrev(head, pj);
				if (ppi != null && ppj != null) {
					ppi.next = pj;
					ppj.next = pi;
				} else if (ppi == null) {
					ppj.next = pi;
					head = pj;
				} else {
					ppi.next = pj;
					head = pi;
				}
				ListNode temp = pi.next;
				pi.next = pj.next;
				pj.next = temp;
			}
		}
		return head;
	}

	private ListNode findPrev(ListNode head, ListNode p) {
		ListNode prev;
		if (head == p) {
			prev = null;
		} else {
			prev = head;
			while (prev != null && prev.next != p) {
				prev = prev.next;
			}
		}
		return prev;
	}
}

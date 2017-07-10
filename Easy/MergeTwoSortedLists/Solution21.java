/**
 * Author: dc0453
 * Since: 2017/2/26 下午5:14
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Solution21 {
    /**
     * recursive
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * iterator
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }

        return result.next;

    }

    public void printListNode(ListNode l1) {
        System.out.println("listNode");
        ListNode n = l1;
        while(n.next != null) {
            System.out.println(n.val);
            n = n.next;
        }
        System.out.println(n.val);
        System.out.println("=============");
    }
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        ListNode n1 = new ListNode(1);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n4;
        n4.next = n5;
        n5.next = n6;
        n2.next = n3;
        n3.next = n7;
        n7.next = n8;
        solution21.printListNode(n1);
        solution21.printListNode(n2);
        solution21.printListNode(solution21.mergeTwoLists(n1, n2));

        n1.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        n2.next = n3;
        n3.next = n7;
        n7.next = n8;
        n8.next = null;
        solution21.printListNode(n1);
        solution21.printListNode(n2);
        solution21.printListNode(solution21.mergeTwoLists2(n1, n2));

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {val = x;}
}

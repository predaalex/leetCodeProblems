package main.java;

//        142. Linked List Cycle II
//
//        Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//        There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//
//        Do not modify the linked list.
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        System.out.println(detectCycle(head));
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null)
            return null;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

package main.java;//        19. Remove Nth Node From End of List
//
//        Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//        Example 1:
//        Input: head = [1,2,3,4,5], n = 2
//        Output: [1,2,3,5]
//
//        Example 2:
//        Input: head = [1], n = 1
//        Output: []
//
//        Example 3:
//        Input: head = [1,2], n = 1
//        Output: [1]

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;

        ListNode returned = removeNthFromEnd(head, n);

        while(returned != null){
            System.out.print(returned.val + " ");
            returned = returned.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
            return null;

        ListNode curr = head;

        //Size of list
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        if(n == len) {
            return head.next;
        }

        int prev = len - n;
        int count = 1;
        curr = head;

        while(count < prev) {
            curr = curr.next;
            count++;
        }

        curr.next = curr.next.next;

        return head;
    }

    private static class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

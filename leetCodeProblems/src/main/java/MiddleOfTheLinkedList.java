//        Given the head of a singly linked list, return the middle node of the linked list.
//
//        If there are two middle nodes, return the second middle node.
//
//
//
//        Example 1:
//
//
//        Input: head = [1,2,3,4,5]
//        Output: [3,4,5]
//        Explanation: The middle node of the list is node 3.
//        Example 2:
//
//
//        Input: head = [1,2,3,4,5,6]
//        Output: [4,5,6]
//        Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
import java.util.LinkedList;
public class MiddleOfTheLinkedList {
     int val;
     MiddleOfTheLinkedList next;
     MiddleOfTheLinkedList() {}
     MiddleOfTheLinkedList(int val) { this.val = val; }
     MiddleOfTheLinkedList(int val, MiddleOfTheLinkedList next) { this.val = val; this.next = next; }
}
class Solution2 {
    public static MiddleOfTheLinkedList middleNode(MiddleOfTheLinkedList head) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        MiddleOfTheLinkedList head2 = head;

        while(head != null) {
            linkedList.add(head.val);
            head = head.next;
        }

        int size;

        if(linkedList.size() % 2 == 1)
            size = linkedList.size();
        else
            size = linkedList.size() + 1;

        for(int i = size/2; i < size - 1; i++)
            head2 = head2.next;

        return head2;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList head = new MiddleOfTheLinkedList(1, new MiddleOfTheLinkedList(2, new MiddleOfTheLinkedList(3, new MiddleOfTheLinkedList(4, new MiddleOfTheLinkedList(5, new MiddleOfTheLinkedList(6))))));

        System.out.println(middleNode(head).val);
    }
}
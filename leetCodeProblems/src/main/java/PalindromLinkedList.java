//        Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
//
//
//        Example 1:
//
//
//        Input: head = [1,2,2,1]
//        Output: true


import java.util.LinkedList;
import java.util.Objects;

public class PalindromLinkedList {
    int val;
    PalindromLinkedList next;

    PalindromLinkedList() {
    }

    PalindromLinkedList(int val) {
        this.val = val;
    }

    PalindromLinkedList(int val, PalindromLinkedList next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static boolean isPalindrome(PalindromLinkedList head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        boolean palindrom = false;

        while (head != null) {
            linkedList.add(head.val);
            head = head.next;
        }

        while (linkedList.size() > 1) {
            if (Objects.equals(linkedList.getFirst(), linkedList.getLast())) {
                linkedList.removeLast();
                linkedList.removeFirst();
            } else {
                break;
            }
        }

        if (linkedList.size() <= 1)
            palindrom = true;

        return palindrom;
    }

    public static void main(String[] args) {
        PalindromLinkedList head = new PalindromLinkedList(1, new PalindromLinkedList(2, new PalindromLinkedList(2, new PalindromLinkedList(1))));
        System.out.println(isPalindrome(head));
    }
}
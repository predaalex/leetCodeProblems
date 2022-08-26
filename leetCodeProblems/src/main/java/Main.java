import java.util.LinkedList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        // 234. Palindrom Linked List

        boolean palindrom = false;
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        System.out.println(linkedList);

        while(linkedList.size() > 1) {
            if(Objects.equals(linkedList.getFirst(), linkedList.getLast())){
                linkedList.removeLast();
                linkedList.removeFirst();
            } else {
                break;
            }
        }

        if(linkedList.size() <= 1)
            palindrom = true;

        System.out.println(palindrom);
    }
}

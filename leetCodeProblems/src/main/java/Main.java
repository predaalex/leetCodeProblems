import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] temp = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        List<String> arr = new ArrayList<>(Arrays.asList(temp));
        System.out.println(findPermutation(arr));
    }

    private static int findMax(List<String> arr) {

        TreeSet<Character> uniqueChars = new TreeSet<>();

        for (String word : arr) {
            TreeSet<Character> uniqueWord = new TreeSet<>();
            boolean contains = false;
            for (char c : word.toCharArray()) {

                if (uniqueWord.contains(c) || uniqueChars.contains(c)) {
                    contains = true;
                    break;
                } else
                    uniqueWord.add(c);
            }

            if (!contains)
                for (char c : word.toCharArray())
                    uniqueChars.add(c);
            else {
                System.out.println(uniqueChars + " " + arr + " max " + uniqueChars.size());
                return uniqueChars.size();
            }


        }
        return uniqueChars.size();
    }

    private static int findPermutation(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;
        int max = 0;
        return permutations(arr, 0, max);
    }

    private static int permutations(List<String> arr, int currentIndex, int max) {

        if (currentIndex == arr.size() - 1) {

            return Math.max(max, findMax(arr));
        }

        for (int i = currentIndex; i < arr.size(); i++) {
            Collections.swap(arr, currentIndex, i);
            max = Math.max(max, permutations(arr, currentIndex + 1, max));
            Collections.swap(arr, currentIndex, i);
        }

        return max;
    }

}

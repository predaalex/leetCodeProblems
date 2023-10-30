package main.java;//        692. Top K Frequent Words
//        Given an array of strings words and an integer k, return the k most frequent strings.
//
//        Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
//================================================================================
//        Example 1:
//        Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//        Output: ["i","love"]
//        Explanation: "i" and "love" are the two most frequent words.
//        Note that "i" comes before "love" due to a lower alphabetical order.
//---------------------------------------------------------------------------
//        Example 2:
//        Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
//        Output: ["the","is","sunny","day"]
//        Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words= {"i","love","leetcode","i","love","coding"};
        int k = 3;

        System.out.println(topKFrequent(words, k));
    }

    private static List<String> topKFrequent(String[] words, int k) {
        List<String> wordList = new ArrayList<>();
        List<Integer> frequencyWord = new ArrayList<>();

        for(String word : words) {
            if(!wordList.contains(word)) {
                wordList.add(word);
                frequencyWord.add(1);
            } else {
                int index =  wordList.indexOf(word);
                frequencyWord.set(index, frequencyWord.get(index) + 1);
            }
        }


        for(int i = 0; i < wordList.size(); i++){
            for(int j = i + 1; j < wordList.size(); j++){
                if(frequencyWord.get(i) < frequencyWord.get(j)){
                    int auxInt = frequencyWord.get(j);
                    String auxString = wordList.get(j);

                    frequencyWord.set(j, frequencyWord.get(i));
                    wordList.set(j, wordList.get(i));

                    frequencyWord.set(i, auxInt);
                    wordList.set(i, auxString);
                } else if (Objects.equals(frequencyWord.get(i), frequencyWord.get(j)) &&
                        (wordList.get(i).compareTo(wordList.get(j)) > 0)) {
                    int auxInt = frequencyWord.get(j);
                    String auxString = wordList.get(j);

                    frequencyWord.set(j, frequencyWord.get(i));
                    wordList.set(j, wordList.get(i));

                    frequencyWord.set(i, auxInt);
                    wordList.set(i, auxString);
                }
            }
        }

        List<String> returnList = new ArrayList<>();
        for(int i = 0; i < k;i++)
            returnList.add(wordList.get(i));
        return returnList;
    }
}

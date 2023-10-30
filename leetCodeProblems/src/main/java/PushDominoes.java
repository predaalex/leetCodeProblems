package main.java;

//        838. Push Dominoes
//
//        There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
//
//        After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
//
//        When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
//
//        For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
//
//        You are given a string dominoes representing the initial state where:
//
//        dominoes[i] = 'L', if the ith domino has been pushed to the left,
//        dominoes[i] = 'R', if the ith domino has been pushed to the right, and
//        dominoes[i] = '.', if the ith domino has not been pushed.
//        Return a string representing the final state.
//-----------------------------------------------------
//        Example 1:
//
//        Input: dominoes = "RR.L"
//        Output: "RR.L"
//        Explanation: The first domino expends no additional force on the second domino.
//-----------------------------------------------------
public class PushDominoes {
    public static void main(String[] args) {
        String dominoes = "R.R.L";

        System.out.println(pushDominoes(dominoes));
    }

    private static String pushDominoes(String dominoes2) {

        char[] dominoes = dominoes2.toCharArray();
        StringBuilder returned = new StringBuilder();

        for(int i = 0; i < dominoes.length - 1; i++){
            int start = i, end = i;

            //if there is an L complete arr
            if(i > 0) {
                if (dominoes[i] == 'L' && dominoes[i - 1] == '.') {
                    dominoes[i - 1] = 'L';
                    i -= 2;
                    continue;
                }
            }

            //find where R start and it stops then complete arr
            boolean endBool = false;
            if(dominoes[i] == 'R') {
                while (dominoes[i] != 'L') {
                    i++;
                    if (i == dominoes.length) {
                        endBool = true;
                        break;
                    }
                    end++;
                    if (dominoes[i] == 'R') {
                        for (int j = start; j < end; j++)
                            dominoes[j] = 'R';
                        start = i;
                    }
                }

                System.out.println(start + " " + end);
                if (!endBool) {
                    for (int j = start + 1; j < end; j++) {
                        if ((start + end) % 2 == 1) {
                            if (j <= (start + end) / 2) {
                                dominoes[j] = 'R';
                            } else
                                dominoes[j] = 'L';
                        } else {
                            if (j < (start + end) / 2)
                                dominoes[j] = 'R';
                            else if (j > (start + end) / 2)
                                dominoes[j] = 'L';
                        }
                    }
                    i = end;
                    continue;
                } else {
                    for(int j = start; j <= end; j++)
                        dominoes[j] = 'R';
                }
            }
            if(i < dominoes.length - 1 && dominoes[i] =='.' && dominoes[i + 1] == 'L') {
                dominoes[i] = 'L';
                i--;
            }
        }

        for(char c : dominoes)
            returned.append(c);

        return returned.toString();

    }

}

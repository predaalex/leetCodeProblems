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
        String dominoes = ".L.R.";

        System.out.println(pushDominoes(dominoes));
    }

    private static String pushDominoes(String dominoes2) {

        char[] dominoes = dominoes2.toCharArray();
        String returned = "";
        int moveCounter = 1;
        while(moveCounter != 0){
            moveCounter = 0;
            for(int i = 0; i < dominoes.length - 1; i++){
                if(i < dominoes.length - 2)
                    if(dominoes[i] == 'R' && dominoes[i + 1] == '.' && dominoes[i + 2] == 'L')
                        i+=2;
                if(dominoes[i] == 'R' && dominoes[i + 1] == '.'){
                    dominoes[i + 1] = 'R';
                    i++;
                    moveCounter++;
                }
                if(dominoes[i] =='.' && dominoes[i + 1] == 'L'){
                    dominoes[i] = 'L';
                    i++;
                    moveCounter++;
                }
            }
        }

        for(char c : dominoes)
            returned += c;

        return returned;

    }

}

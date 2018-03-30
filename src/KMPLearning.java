import java.util.HashMap;
import java.util.Random;

/**
 * Created by anusha on 2/26/17.
 */
public class KMPLearning {

    public static StringBuilder HISTORY = new StringBuilder();

    private static int KMPSearch(String prediction, String history)
    {
        int M = prediction.length();
        int N = history.length();

        int occurences = 0;

        // create lps[] that will hold the longest
        // prefix suffix values for pattern

        int lps[] = new int[M];
        int j = 0;  // index for prediction[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(prediction,M,lps);

        int i = 0;  // index for HISTORY[]
        while (i < N)
        {
            if (prediction.charAt(j) == history.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                occurences++;
                j = lps[j-1];
            }

            // mismatch after j matches
            else if (i < N && prediction.charAt(j) != history.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
        return occurences;
    }

    private static void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0)
                {
                    len = lps[len-1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    private static String getAntiMove(String nextMove){
        HashMap<String, String> antiMap = new HashMap<>();
        antiMap.put("Rock", "Paper");
        antiMap.put("Paper", "Scissor");
        antiMap.put("Scissor", "Rock");
        antiMap.put("Lizard", "Rock");
        antiMap.put("Spock", "Lizard");

        return antiMap.get(nextMove);
    }

    public static String getComputerMove(){
        //We will take a subset of size 4.
        //So, last 3 values appended with next possible move will be the subset pattern.
        //We will predict the next move based on which pattern has highest frequency in HISTORY.


        int frequency = 0;
        int prediction = 0;
        int maxFreq = 0;
        String nextMove = "";
        if(HISTORY.length() > 4) {
            String hist = HISTORY.toString().substring(HISTORY.length() - 3, HISTORY.length());

            for (int i = 1; i <= 5; i++) {
                String pattern = hist + i;
                System.out.println(pattern);
                frequency = KMPSearch(pattern, HISTORY.toString());
                System.out.println(frequency);
                if (frequency > maxFreq) {
                    prediction = i;
                }
            }
        }

        if(prediction == 0) {
            Random r = new Random();
            prediction= r.nextInt((5 - 1) + 1) + 1;
        }

        if(prediction == 1)
            nextMove ="Rock";
        else if(prediction == 2)
            nextMove ="Paper";
        else if(prediction == 3)
            nextMove ="Scissor";
        else if(prediction == 4)
            nextMove ="Lizard";
        else if(prediction == 5)
            nextMove ="Spock";

        return getAntiMove(nextMove);
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        System.out.println(HISTORY);
        System.out.println(getComputerMove());
    }

}

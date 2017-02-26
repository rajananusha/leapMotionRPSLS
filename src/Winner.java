import java.util.ArrayList;
import java.util.Random;

/**
 * Created by anusha on 2/26/17.
 */
public class Winner {

    public static ArrayList<String> calculateWinner(String player){
        String computer = KMPLearning.getComputerMove();
        return calculateWinner(computer, player);
    }

    public static ArrayList<String> calculateWinner(String computer, String player) {
        ArrayList<String> result=new ArrayList<String>();
        int comp= 0;
        if(computer.equalsIgnoreCase("Rock"))comp=1;
        else if(computer.equalsIgnoreCase("Paper"))comp=2;
        else if(computer.equalsIgnoreCase("Scissor"))comp=3;
        else if(computer.equalsIgnoreCase("Lizard"))comp=4;
        else if(computer.equalsIgnoreCase("Spock"))comp=5;

        int p1=0;
        if(player.equalsIgnoreCase("Rock"))p1=1;
        else if(player.equalsIgnoreCase("Paper"))p1=2;
        else if(player.equalsIgnoreCase("Scissor"))p1=3;
        else if(player.equalsIgnoreCase("Lizard"))p1=4;
        else if(player.equalsIgnoreCase("Spock"))p1=5;

        if(p1==0)System.out.println("Invalid Gesture");
        if(comp==1 && p1==1){
            result.add("Rock");
            result.add("Rock");
            result.add("Draw");
        }
        else if(comp==2 && p1==2){
            result.add("Paper");
            result.add("Paper");
            result.add("Draw");
        }
        else if(comp==3 && p1==3){
            result.add("Scissor");
            result.add("Scissor");
            result.add("Draw");
        }
        else if(comp==4 && p1==4){
            result.add("Lizard");
            result.add("Lizard");
            result.add("Draw");
        }
        else if(comp==5 && p1==5){
            result.add("Spock");
            result.add("Spock");
            result.add("Draw");
        }

        else if(comp==1 && p1==2){
            result.add("Paper");
            result.add("Rock");
            result.add("Won");
        }
        else if(comp==1 && p1==3){
            result.add("Scissor");
            result.add("Rock");
            result.add("Lost");
        }
        else if(comp==1 && p1==4){
            result.add("Lizard");
            result.add("Rock");
            result.add("Lost");
        }
        else if(comp==1 && p1==5){
            result.add("Spock");
            result.add("Rock");
            result.add("Won");
        }

        else if(comp==2 && p1==1){
            result.add("Rock");
            result.add("Paper");
            result.add("Lost");
        }
        else if(comp==2 && p1==3){
            result.add("Scissor");
            result.add("Paper");
            result.add("Won");
        }
        else if(comp==2 && p1==4){
            result.add("Lizard");
            result.add("Paper");
            result.add("Won");
        }
        else if(comp==2 && p1==5){
            result.add("Spock");
            result.add("Paper");
            result.add("Lost");
        }

        else if(comp==3 && p1==1){
            result.add("Rock");
            result.add("Scissor");
            result.add("Won");
        }
        else if(comp==3 && p1==2){
            result.add("Paper");
            result.add("Scissor");
            result.add("Lost");
        }
        else if(comp==3 && p1==4){
            result.add("Lizard");
            result.add("Scissor");
            result.add("Lost");
        }
        else if(comp==3 && p1==5){
            result.add("Spock");
            result.add("Scissor");
            result.add("Won");
        }

        else if(comp==4 && p1==1){
            result.add("Rock");
            result.add("Lizard");
            result.add("Won");
        }
        else if(comp==4 && p1==2){
            result.add("Paper");
            result.add("Lizard");
            result.add("Lost");
        }
        else if(comp==4 && p1==3){
            result.add("Scissor");
            result.add("Lizard");
            result.add("Won");
        }
        else if(comp==4 && p1==5){
            result.add("Spock");
            result.add("Lizard");
            result.add("Lost");
        }

        else if(comp==5 && p1==1){
            result.add("Rock");
            result.add("Spock");
            result.add("Lost");
        }
        else if(comp==5 && p1==2){
            result.add("Paper");
            result.add("Spock");
            result.add("Won");
        }
        else if(comp==5 && p1==3){
            result.add("Scissor");
            result.add("Spock");
            result.add("Lost");
        }
        else if(comp==5 && p1==4){
            result.add("Lizard");
            result.add("Spock");
            result.add("Won");
        }

        KMPLearning.HISTORY.append(p1);
        System.out.println(KMPLearning.HISTORY);
        return result;
    }
}

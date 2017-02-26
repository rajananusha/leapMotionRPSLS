import com.leapmotion.leap.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anusha on 2/25/17.
 */
class GestListener extends Listener {

    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

//    public void onFrame(Controller controller) {
//        // Get the most recent frame and report some basic information
//        Frame frame = controller.frame();
//
//        //Get hands
//        for(Hand hand : frame.hands()) {
//
//            PointableList pointables = hand.pointables().extended();
//
//            if(pointables.count() == 0){
//                System.out.println("Rock");
//            } else if(pointables.count() == 2){
//                System.out.println("Scissor");
//            }else if(pointables.count() == 5){
//                System.out.println("Paper");
//            }else{
//                System.out.println("Invalid Gesture");
//            }
//        }
//
//        if (!frame.hands().isEmpty()) {
//            System.out.println();
//        }
//    }


    public static String getGesture(Controller controller) {
        // Get the most recent frame and report some basic information
        String userGesture = "";
        Frame frame = controller.frame();

        //Get hands
        for (Hand hand : frame.hands()) {

            PointableList pointables = hand.pointables().extended();

            if (pointables.count() == 0) {
                userGesture = "Rock";
            } else if (pointables.count() == 2) {
                userGesture = "Scissor";
            } else if (pointables.count() == 5) {
                userGesture = "Paper";
            } else if (pointables.count() == 4) {
                userGesture = "Spock";
            } else if (pointables.count() == 3 || pointables.count() == 1) {
                userGesture = "Lizard";
            } else {
                userGesture = "Invalid Gesture";
            }
        }

        if (!frame.hands().isEmpty()) {
            System.out.println();
        }
        return userGesture;
    }
}

public class GestureListener {

    public static int HIGHSCORE = 0;

    public static int CURRENTSTREAK = 0;


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        // Create a sample listener and controller
        GestListener listener = new GestListener();
        Controller controller = new Controller();
        // Have the sample listener receive events from the controller
        controller.addListener(listener);
        System.out.println("Press Enter to quit...");
        boolean exit = false;
        while (true) {
            try {
                int x = 3;
                while (x > 0) {
                    Thread.sleep(1000);
                    System.out.println(x + "...");
                    x--;
                }
                Thread.sleep(1000);
                String gesture = GestListener.getGesture(controller);

                if (gesture.equalsIgnoreCase("Invalid Gesture") || gesture.equalsIgnoreCase("")) {
                    System.out.println("I did not recognize that gesture. Try again.");
                } else {
                    ArrayList<String> result = Winner.calculateWinner(gesture);
                    System.out.println("You: " + result.get(0) + ", Computer: " + result.get(1) + ", You " + result.get(2) + "!");
                    if(result.get(2).equalsIgnoreCase("Won")){
                        CURRENTSTREAK++;
                        HIGHSCORE = Math.max(CURRENTSTREAK, HIGHSCORE);
                    } else if (result.get(2).equalsIgnoreCase("Lost")) {
                        CURRENTSTREAK = 0;
                    }
                }
                System.out.println("CurrentStreak=" + CURRENTSTREAK + ", HighScore:" + HIGHSCORE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Remove the sample listener when done
//        controller.removeListener(listener);
    }
}

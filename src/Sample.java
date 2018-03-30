import java.io.IOException;
import java.lang.Math;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

//Unused code. Used for reference and test library
class SampleListener extends Listener {
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

    public void onFrame(Controller controller) {
        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();

        //Get hands
        for(Hand hand : frame.hands()) {

            PointableList pointables = hand.pointables().extended();

            if(pointables.count() == 0){
                System.out.println("Rock");
            } else if(pointables.count() == 2){
                System.out.println("Scissor");
            }else if(pointables.count() == 5){
                System.out.println("Paper");
            }else if(pointables.count() == 4){
                System.out.println("Spock");
            }else if(pointables.count() == 3 || pointables.count() == 1){
                System.out.println("Lizard");
            }else{
                System.out.println("Invalid Gesture");
            }
        }

        if (!frame.hands().isEmpty()) {
            System.out.println();
        }
    }
}

class Sample {
    public static void main(String[] args) {
        // Create a sample listener and controller
        SampleListener listener = new SampleListener();
        Controller controller = new Controller();

        // Have the sample listener receive events from the controller
        controller.addListener(listener);

        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller.removeListener(listener);
    }
}

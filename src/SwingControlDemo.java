import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo {
    private static int count=3;
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private static JLabel timerLabel;

    public SwingControlDemo(){
        prepareGUI();
    }
    public static void main(String[] args){
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showEventDemo();
    }
    public static void ref(int count,JLabel area){
        area.setText("Hold your gesture for "+ count + "seconds");
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Rock Paper Scissors Lizard Spock");
        mainFrame.setSize(1000,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        timerLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.add(timerLabel);

        timerLabel.setText(""+count);

        mainFrame.setVisible(true);

    }
    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        JButton start = new JButton("Start New Game");
        JButton stop = new JButton("End Game");

        start.setActionCommand("start");
        stop.setActionCommand("stop");


        start.addActionListener(new ButtonClickListener());
        stop.addActionListener(new ButtonClickListener());

        controlPanel.add(start);
        controlPanel.add(stop);

        mainFrame.setVisible(true);
    }

    public void startGame(){
        EventQueue.invokeLater(() -> {
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    //System.out.println("Hello");
                    ref(count, timerLabel);
                    if(count == 0){
                        GestureListener.runGame();
                        count = 3;
                    } else {
                        count--;
                    }
                }
            };
            Timer timer = new Timer(1000, actionListener);
            timer.start();
        });
    }

    public void stopGame(){
        timerLabel.setText("End");
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "start" ))  {
                startGame();
            } else if( command.equals( "stop" ) )  {
                stopGame();
            }
        }
    }
}
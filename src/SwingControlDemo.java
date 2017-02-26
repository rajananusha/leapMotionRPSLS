import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo extends JFrame {
    private int x = 10;
    private JLabel text = new JLabel(String.format("%02d:%02d:%02d", 0, 0, x%60));
    private Timer timer;
    private JButton start;
    private JButton reset;
    private JFrame mainFrame;
    private JPanel statusLabel;


    public SwingControlDemo(){
        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent click) {
                final long current = System.currentTimeMillis();
                try {
                    final long limit = x * 1000; // X seconds
                    timer = new Timer(1000, new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            long time = System.currentTimeMillis();
                            long passed = time - current;
                            long remaining = limit - passed;
                            if(remaining <= 0) {
                                text.setText("End");
                                timer.stop();
                            } else {
                                long seconds = remaining/1000;
                                long minutes = seconds/60;
                                long hours = minutes/60;
                                text.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds%60));
                            }
                        }
                    });
                    timer.start();
                } catch(NumberFormatException nfe) {
                    // debug/report here
                    nfe.printStackTrace();
                }
            }});
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        statusLabel = new JPanel();
        statusLabel.setLayout(new FlowLayout());

        mainFrame.add(start);
//        mainFrame.add(reset);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);

    }


    public static void main(String [] args) throws Exception {
        SwingControlDemo frame = new SwingControlDemo();
        frame.setDefaultCloseOperation(SwingControlDemo.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
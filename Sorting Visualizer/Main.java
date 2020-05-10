import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.EventQueue;

public class Main {
   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                Chooser chooser = new Chooser();

                panel.add(new Visualizer(chooser));
                panel.add(chooser);
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                frame.add(panel);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
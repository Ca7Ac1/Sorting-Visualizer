import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class Chooser extends JPanel {

    private final int LENGTH = 50;
    private final int WIDTH = 520;

    private JButton bubble;
    private JButton merge;
    private JButton quick;
    private JButton reverse;
    private JButton restart;


    public Chooser() {
        setPreferredSize(new Dimension(WIDTH, LENGTH));
        initializeButtons();
    }

    private void initializeButtons() {
        bubble = new JButton("Bubble sort");
        merge = new JButton("Merge sort");
        quick = new JButton("Quick sort");
        reverse = new JButton("Reverse array");
        restart = new JButton("New array");

        add(bubble);
        add(merge);
        add(quick);
        add(reverse);
        add(restart);

        bubble.setEnabled(true);
        merge.setEnabled(true);
        quick.setEnabled(true);
        reverse.setEnabled(true);
        restart.setEnabled(true);
    }

    public void setActionListener(ActionListener ac) {
        bubble.addActionListener(ac);
        merge.addActionListener(ac);
        quick.addActionListener(ac);
        reverse.addActionListener(ac);
        restart.addActionListener(ac);
    }
    
    public JButton getBubble() {
        return bubble;
    }

    public JButton getMerge() {
        return merge;
    }
    
    public JButton getQuick() {
        return quick;
    }

    public JButton getReverse() {
        return reverse;
    }

    public JButton getRestart() {
        return restart;
    }

    public void turnOff() {
        bubble.setEnabled(false);
        merge.setEnabled(false);
        quick.setEnabled(false);    
    }

    public void turnOffAll() {
        bubble.setEnabled(false);
        merge.setEnabled(false);
        quick.setEnabled(false); 
        reverse.setEnabled(false);
        restart.setEnabled(false);
    }

    public void turnOn() {
        bubble.setEnabled(true);
        merge.setEnabled(true);
        quick.setEnabled(true);
        reverse.setEnabled(true);
        restart.setEnabled(true);    
    }
}
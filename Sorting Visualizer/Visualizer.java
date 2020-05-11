import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Visualizer extends JPanel implements ActionListener {

    private final int SIZE = 520;
    private final int LENGTH = 4;
    private final int HEIGHT = 5;

    private Chooser chooser;

    private int[] arr;
    private Random rand;

    public Visualizer(Chooser chooser) {
        this.chooser = chooser;
        arr = new int[130];
        rand = new Random();

        setPreferredSize(new Dimension(SIZE, SIZE));
        setBackground(Color.DARK_GRAY);
        createRandomArray();

        chooser.setActionListener(this);
    }

    public void createRandomArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }
    }

    public int[] getArray() {
        return arr;
    }

    public void setArray(int[] arr) {
        this.arr = arr;

        validate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g, arr);
    }

    public void draw(Graphics g, int[] arr) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);

        for (int i = 0; i < arr.length; i++) {
            g2d.fillRect(i * LENGTH, 0, LENGTH, arr[i] * HEIGHT);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooser.getBubble()) {
            Sorting.bubbleSort(this, chooser);
        } else if (e.getSource() == chooser.getMerge()) {
            Sorting.mergeSort(this, chooser);
        } else if (e.getSource() == chooser.getQuick()) {
            Sorting.quickSort(this, chooser);
        }else if (e.getSource() == chooser.getReverse()) {
            Sorting.reverse(this, chooser);
        } else if (e.getSource() == chooser.getRestart()) {
            createRandomArray();            
            repaint();
            chooser.turnOn();
        }
    }
}

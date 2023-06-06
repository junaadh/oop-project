package oopits;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class myFrame extends JFrame{

    public JPanel currentPanel;

    myFrame() {
        this.setTitle("Energy Monitor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(300, 200, 1220,720);
        this.getContentPane().setBackground(Color.decode("#4E498D"));
        this.setOpacity(1);
        this.setLayout(null);
    }

    public void changePanel(JPanel newPanel) {
        setContentPane(newPanel);
        currentPanel = newPanel;
        revalidate();
        repaint();
    }
}

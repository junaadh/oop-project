package oopits.guiHandlers;

/**
 * @author Junaadh
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import oopits.guiHelper;

public class creditsHandler extends JFrame{
    public creditsHandler() {
        ImageIcon team = new ImageIcon("src/main/java/oopits/assets/team.png");
        ImageIcon teamIcon = guiHelper.resizeIcon(team, 80, 80);

        ImageIcon aboutu= new ImageIcon("src/main/java/oopits/assets/about.png");
        ImageIcon aboutus = guiHelper.resizeIcon(aboutu, 639, 391);

        ImageIcon back = new ImageIcon("src/main/java/oopits/assets/back.png");
        ImageIcon backIcon = guiHelper.resizeIcon(back, 50, 50);

        JLabel menu = new JLabel(backIcon);
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setVerticalAlignment(SwingConstants.CENTER);
        menu.setBounds(35, 35, 60, 60);
        menu.setToolTipText("");
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menu.setToolTipText("Main Menu");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                menu.setToolTipText("");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new welcomeHandler();
            }
        });

        JLabel about = new JLabel("about us");
        about.setFont(new Font("Source Han Sans CN", Font.ITALIC, 40));
        about.setForeground(Color.darkGray);
        about.setBounds(120, 80, 300, 100);
        about.setIcon(teamIcon);
        about.setHorizontalTextPosition(SwingConstants.RIGHT);

        JLabel aboutusIcon = new JLabel(aboutus);
        aboutusIcon.setBounds(505, 115, 639, 391);

        JLabel place = new JLabel();
        place.setText("<html>Created using Java 2023 <br> Powered by Swing x Awt</html>");
        place.setFont(new Font("Poppins", Font.ITALIC, 14));
        place.setBounds(1020, 620, 350, 50);

        String membersText = "<html><ul><li>Muhammad Airell</li><li>Moosa Junad</li><li>Sai Wen Xiang</li><li>Jonathan Tan Kian Hoong</li><li>Zameer bin Mohd Zin</li><li>Lio Wei Xiang</li><li>Muhammad Ahmad</li><li>Naeema Fasal</li><li>Leron A/L Letchumanan</li><li>Michael Liwijaya</li></ul></html>";
        JLabel members = new JLabel();
        members.setText(membersText);
        members.setFont(new Font("Comic Sans", Font.BOLD, 20));
        members.setBounds(100, 100, 500, 500);
        members.setOpaque(false);
        members.setForeground(new Color(0x000080));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1220, 720);
        panel.setBackground(new Color(0x7E939D));
        panel.add(menu);
        panel.add(about);
        panel.add(members);
        panel.add(place);
        panel.add(aboutusIcon);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.setSize(1220, 720);
        this.setTitle("Energy Monitor");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

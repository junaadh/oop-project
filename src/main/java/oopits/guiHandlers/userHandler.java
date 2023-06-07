package oopits.guiHandlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import oopits.FileHandler;
import oopits.User;
import oopits.guiHelper;

public class userHandler extends JFrame implements ActionListener {

    JLabel welcome = new JLabel();

    public userHandler( String username ) {

        ImageIcon usr = new ImageIcon("src/main/java/oopits/assets/userLogin.png");
        ImageIcon usrIcn = guiHelper.resizeIcon(usr, 90, 90);
        JLabel userIcon = new JLabel(usrIcn);
        userIcon.setBounds(565, 170, 90, 90);
        userIcon.setHorizontalAlignment(SwingConstants.CENTER);
        userIcon.setVerticalAlignment(SwingConstants.CENTER);

        User un = (FileHandler.loadUser()).get(username);

        welcome.setText("Welcome, " + un.firstName + " " + un.lastName);
        welcome.setFont(new Font("Inder", Font.PLAIN, 20));
        welcome.setForeground(Color.WHITE);
        welcome.setBounds(410, 300, 400, 35);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setVerticalAlignment(SwingConstants.CENTER);

        JLabel text = new JLabel();
        text.setText("You can check energy consumption by various companies using below options");
        text.setFont(new Font("Calibri", Font.PLAIN, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(260, 400, 700, 35);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        
        ImageIcon b = new ImageIcon("src/main/java/oopits/assets/list.png");
        JButton list = new JButton(b);
        list.setBounds(286, 486, 80, 105);
        list.setText("List View");
        list.setFont(new Font("Calibri", Font.PLAIN, 14));
        list.setHorizontalTextPosition(SwingConstants.CENTER);
        list.setVerticalTextPosition(SwingConstants.BOTTOM);
        list.setForeground(Color.WHITE);
        list.setHorizontalAlignment(SwingConstants.CENTER);
        list.setVerticalAlignment(SwingConstants.CENTER);
        list.setBorder(null);

        ImageIcon a = new ImageIcon("src/main/java/oopits/assets/specificCompany.png");
        JButton companyName = new JButton(a);
        companyName.setBounds(426, 486, 80, 115);
        companyName.setText("<html>Search By<br>Company</html>");
        companyName.setFont(new Font("Calibri", Font.PLAIN, 14));
        companyName.setHorizontalTextPosition(SwingConstants.CENTER);
        companyName.setVerticalTextPosition(SwingConstants.BOTTOM);
        companyName.setForeground(Color.WHITE);
        companyName.setHorizontalAlignment(SwingConstants.CENTER);
        companyName.setVerticalAlignment(SwingConstants.CENTER);
        companyName.setBorder(null);

        ImageIcon c = new ImageIcon("src/main/java/oopits/assets/month.png");
        JButton month = new JButton(c);
        month.setBounds(570, 486, 80, 115);
        month.setText("<html>Search By<br>Month</html>");
        month.setFont(new Font("Calibri", Font.PLAIN, 14));
        month.setHorizontalTextPosition(SwingConstants.CENTER);
        month.setVerticalTextPosition(SwingConstants.BOTTOM);
        month.setForeground(Color.WHITE);
        month.setHorizontalAlignment(SwingConstants.CENTER);
        month.setVerticalAlignment(SwingConstants.CENTER);
        month.setBorder(null);

        ImageIcon d = new ImageIcon("src/main/java/oopits/assets/danger.png");
        JButton baduse = new JButton(d);
        baduse.setBounds(712, 486, 80, 115);
        baduse.setText("<html>Over<br>Consumers</html>");
        baduse.setFont(new Font("Calibri", Font.PLAIN, 14));
        baduse.setHorizontalTextPosition(SwingConstants.CENTER);
        baduse.setVerticalTextPosition(SwingConstants.BOTTOM);
        baduse.setForeground(Color.WHITE);
        baduse.setHorizontalAlignment(SwingConstants.CENTER);
        baduse.setVerticalAlignment(SwingConstants.CENTER);
        baduse.setBorder(null);

        ImageIcon e = new ImageIcon("src/main/java/oopits/assets/logout.png");
        JButton logout = new JButton(e);
        logout.setBounds(857, 486, 80, 105);
        logout.setText("Logout");
        logout.setFont(new Font("Calibri", Font.PLAIN, 14));
        logout.setHorizontalTextPosition(SwingConstants.CENTER);
        logout.setVerticalTextPosition(SwingConstants.BOTTOM);
        logout.setForeground(Color.WHITE);
        logout.setHorizontalAlignment(SwingConstants.CENTER);
        logout.setVerticalAlignment(SwingConstants.CENTER);
        logout.setBorder(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1220, 720);
        panel.setBackground((new Color(0x307085)));
        panel.add(userIcon);
        panel.add(welcome);
        panel.add(text);
        panel.add(list);
        panel.add(companyName);
        panel.add(month);
        panel.add(baduse);
        panel.add(logout);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.setSize(1220, 720);
        this.setTitle("Energy Monitor");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}

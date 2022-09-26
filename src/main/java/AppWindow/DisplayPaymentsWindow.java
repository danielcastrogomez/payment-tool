package AppWindow;

import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DisplayPaymentsWindow extends JFrame implements WindowListener, ActionListener {

    MainWindow mainWindow;
    JScrollPane jPanel;
    JTextArea jTextArea;
    JButton calcPayments;
    private UserService userService;

    public DisplayPaymentsWindow(MainWindow mainWindow, UserService userService){
        this.setVisible(true);
        this.mainWindow = mainWindow;
        this.userService = userService;
        this.setSize(600,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(300,200);
        this.setTitle("Payments");
        this.addWindowListener(this);
        jTextArea = new JTextArea(26,48);
        jPanel = new JScrollPane(jTextArea);
        this.getContentPane().setLayout(new FlowLayout());
        jPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jTextArea.setEditable(false);
        this.getContentPane().add(jPanel);
        calcPayments = new JButton("Make Payments");
        calcPayments.addActionListener(this);
        this.getContentPane().add(calcPayments);

    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mainWindow.setVisible(false);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.mainWindow.setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcPayments){
            this.jTextArea.setText(userService.getUsers().toString());
        }
    }
}

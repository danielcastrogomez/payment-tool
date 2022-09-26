package AppWindow;

import service.UserService;
import service.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JButton createUser;
    JButton calcPayments;
    UserService userService;

    public MainWindow(){

        this.setVisible(true);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(0,0);
        this.setTitle("Payments App");
        this.add(panel);
        createUser = new JButton("Create User");
        calcPayments = new JButton("Calc Payments");
        panel.add(createUser);
        panel.add(calcPayments);
        createUser.addActionListener(this);
        calcPayments.addActionListener(this);
        userService = new UserServiceImpl();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == createUser){
            CreateUserWindow userWindow = new CreateUserWindow(this, this.userService);
        }

        if (e.getSource() == calcPayments){
            DisplayPaymentsWindow paymentsWindow = new DisplayPaymentsWindow(this, this.userService);
        }



    }
}

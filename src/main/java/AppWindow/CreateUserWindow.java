package AppWindow;

import Model.User;
import service.UserService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CreateUserWindow extends JFrame implements WindowListener, ActionListener {

    MainWindow mainWindow;
    JPanel panel;
    JButton createUserButton;
    JButton clearFormButton;
    JTextField nameTextField;
    JTextField lastNameTextField;
    JComboBox<String> positionComboBox;
    String[] comboBoxOptions = {"Director", "Manager", "Developer"};
    private UserService userService;

    public CreateUserWindow(MainWindow mainWindow, UserService userService){
        this.mainWindow = mainWindow;
        this.userService = userService;
        this.setVisible(true);
        this.setSize(300,250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(300,200);
        this.setTitle("Create User");
        this.addWindowListener(this);
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        JLabel name = new JLabel("Name:");
        JLabel lastName = new JLabel("Last Name:");
        JLabel position = new JLabel("Position:");
        nameTextField = new JTextField();
        lastNameTextField = new JTextField();
        name.setBounds(10,20,100,20);
        lastName.setBounds(10,60,100,20);
        position.setBounds(10,100,100,20);
        nameTextField.setBounds(110,20, 150,20);
        nameTextField.setBorder(new LineBorder(Color.black));
        lastNameTextField.setBounds(110,60, 150,20);
        lastNameTextField.setBorder(new LineBorder(Color.black));
        positionComboBox = new JComboBox<>(comboBoxOptions);
        positionComboBox.setSelectedIndex(0);
        positionComboBox.setBounds(110,100, 150,20);
        positionComboBox.addActionListener(this);
        createUserButton = new JButton("Create");
        createUserButton.addActionListener(this);
        clearFormButton = new JButton("Clear Form");
        clearFormButton.addActionListener(this);
        createUserButton.setBounds(60,150,50,20);
        clearFormButton.setBounds(120,150,100,20);
        panel.add(name);
        panel.add(lastName);
        panel.add(position);
        panel.add(nameTextField);
        panel.add(lastNameTextField);
        panel.add(positionComboBox);
        panel.add(createUserButton);
        panel.add(clearFormButton);

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
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createUserButton){
            User user = new User(this.nameTextField.getText(),
                    this.lastNameTextField.getText(),
                    this.positionComboBox.getSelectedItem().toString());
            if(this.userService.saveUser(user)){
                JOptionPane.showConfirmDialog(this.panel,
                        "User Saved", "Confirmation", JOptionPane.DEFAULT_OPTION);
            }

        }

        if (e.getSource() ==  clearFormButton){
            this.nameTextField.setText("");
            this.lastNameTextField.setText("");
            this.positionComboBox.setSelectedItem(this.comboBoxOptions[0]);

        }

    }
}

package codeu.chat.client.simplegui;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import codeu.chat.UserMap;

@SuppressWarnings("serial")
/**
 * @author  Troy Jones
 * @date    5/21/17
 * @brief   Contains all GUI necessary to execute the frame to 
 *          create a new account.
 */
public class NewAccount extends JFrame {

    UserMap userMap;
    HashMap<String, char[]> usernameAndPassword;

    public NewAccount (JFrame mainFrame) {
        JFrame newAccountFrame = new JFrame();
        userMap = new UserMap();
        // create mainPanel
        JPanel mainPanel = new JPanel();
        BoxLayout mainPanelLayout = 
                new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
        mainPanel.setLayout(mainPanelLayout);

        // fill welcomeTextPanel
        JPanel welcomeTextPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to ChatU!");
        welcomeTextPanel.add(welcomeLabel);
        mainPanel.add(welcomeTextPanel);

        // username label and textfield
        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("Choose a user name up to 10 characters");
        usernamePanel.add(usernameLabel);
        JTextField userNameTextField = new JTextField(10);
        usernamePanel.add(userNameTextField);
        mainPanel.add(usernamePanel);

        // password label and textfield
        JPanel userPasswordPanel = new JPanel();
        JLabel userPasswordLabel = new JLabel("Choose a password up to 10 characters");
        userPasswordPanel.add(userPasswordLabel);
        JPasswordField userpasswordTextField = new JPasswordField(10);
        userPasswordPanel.add(userpasswordTextField);
        mainPanel.add(userPasswordPanel);

        // fill buttonsPanel
        JPanel buttonsPanel = new JPanel();
        JButton createAccountButton = new JButton("Create");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String userName = new String(userNameTextField.getText());
                usernameAndPassword = codeu.chat.UserMap.map;

                if(usernameAndPassword.containsKey(userName)) {
                    JOptionPane.showMessageDialog(newAccountFrame, "User already exists.");
                } else {
                    if(userName.length() > 10) {
                        JOptionPane.showMessageDialog(newAccountFrame,
                                "User name is larger than 10 characters.");
                    } else {
                        char[] password = userpasswordTextField.getPassword();
                        if(password.length > 10) {
                            JOptionPane.showMessageDialog(newAccountFrame,
                                    "Password is larger than 10 characters.");
                        } else {
                            usernameAndPassword.put(userName, password);
                            // start chat
                            JOptionPane.showMessageDialog(newAccountFrame, "Please sign in.");
                            newAccountFrame.dispose();
                            mainFrame.setVisible(true);
                        }
                    }
                }
            }
        });

        buttonsPanel.add(createAccountButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mainFrame.setVisible(true);
                newAccountFrame.dispose();
            }
        });
        buttonsPanel.add(cancelButton);
        mainPanel.add(buttonsPanel);

        // publish frame
        newAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newAccountFrame.setTitle("Create an Account");
        newAccountFrame.setSize(500, 200);
        newAccountFrame.add(mainPanel);
        newAccountFrame.setVisible(true);
    } // end of NewAccount()

}   // end of class NewAccount

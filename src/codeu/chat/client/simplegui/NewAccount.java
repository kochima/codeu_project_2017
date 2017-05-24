package codeu.chat.client.simplegui;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
/**
 * @author  Troy Jones
 * @date    5/21/17
 * @brief   Contains all GUI necessary to execute the frame to 
 *          create a new account.
 */
public class NewAccount extends JFrame {

    // constructor
    public NewAccount (JFrame mainFrame) {
        JFrame newAccountFrame = new JFrame();

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
        JLabel usernameLabel = new JLabel("Choose a user name");
        usernamePanel.add(usernameLabel);
        JTextField userNameTextField = new JTextField(10);
        usernamePanel.add(userNameTextField);
        mainPanel.add(usernamePanel);

        // password label and textfield
        JPanel userPasswordPanel = new JPanel();
        JLabel userPasswordLabel = new JLabel("Choose a password");
        userPasswordPanel.add(userPasswordLabel);
        JTextField userpasswordTextField = new JTextField(10);
        userPasswordPanel.add(userpasswordTextField);
        mainPanel.add(userPasswordPanel);

        // fill buttonsPanel
        JPanel buttonsPanel = new JPanel();
        JButton createAccountButton = new JButton("Create");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // query server
                // get success or fail
                // if success, success message
                // else, catch error, message accordingly
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

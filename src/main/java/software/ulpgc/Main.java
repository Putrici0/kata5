package software.ulpgc;

import software.ulpgc.control.LoadRandomUserCommand;
import software.ulpgc.model.User;
import software.ulpgc.view.RandomUserSwingApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LoadRandomUserCommand command = new LoadRandomUserCommand(100);
        command.execute();

        for (User user : command.getUsers()) {
            System.out.println(user.getName());
        }
        SwingUtilities.invokeLater(RandomUserSwingApp::new);
    }
}

package software.ulpgc.view;

import software.ulpgc.control.LoadRandomUserCommand;
import software.ulpgc.model.User;

import javax.swing.*;
import java.awt.*;

public class RandomUserSwingApp {

    private final JLabel photoLabel;
    private final JLabel nameLabel;
    private final JLabel surnameLabel;

    private final LoadRandomUserCommand loadCommand;


    public RandomUserSwingApp() {

        loadCommand = new LoadRandomUserCommand(1);

        JFrame frame = new JFrame("Random User App");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        photoLabel = new JLabel("Photo");
        photoLabel.setPreferredSize(new Dimension(200, 200));

        nameLabel = new JLabel("Name: ");
        surnameLabel = new JLabel("Surname: ");
        JButton loadButton = new JButton("Load Random User");

        frame.add(photoLabel);
        frame.add(nameLabel);
        frame.add(surnameLabel);
        frame.add(loadButton);

        loadButton.addActionListener(e -> loadUser());

        frame.setVisible(true);
    }

    private void loadUser() {
        loadCommand.execute();
        User user = loadCommand.getUsers().getFirst();

        nameLabel.setText("Name: "+ user.getName());
        surnameLabel.setText("Surname: "+ user.getSurname());

        byte[] photoBytes = user.getPhoto();

        if (photoBytes.length > 0) {
            ImageIcon imageIcon = new ImageIcon(photoBytes);
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            photoLabel.setIcon(new ImageIcon(image));
            photoLabel.setText("");
        } else {
            photoLabel.setIcon(null);
            photoLabel.setText("Photo not found.");
        }
    }
}

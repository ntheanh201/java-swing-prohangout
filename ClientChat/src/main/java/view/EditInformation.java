package view;

import model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;


public class EditInformation extends JFrame {
    private JPanel jPanel;
    private JButton changeAvatarButton;
    private JButton changePasswordButton;
    private JLabel label;
    User username = new User();

    public EditInformation() throws IOException {
        this.setLayout(null);
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle(username.getUsername());
        this.setResizable(false);

        setjPanel();
        setChangeAvatarButton();
        setChangePasswordButton();
        setLabel();
        this.validate();
        this.repaint();
    }

    public void setjPanel(){
        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setVisible(true);
        jPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.add(jPanel);
    }

    public void setLabel() throws IOException {
        InputStream path = this.getClass().getClassLoader().getResourceAsStream("images/label.png");
        ImageIcon imgThisImg= new ImageIcon(ImageIO.read(path));
        label = new JLabel();
        label.setIcon(imgThisImg);
        label.setBounds(50, 20, 300, 80);
        jPanel.add(label);
    }

    public void setChangeAvatarButton(){
        changeAvatarButton = new JButton();
        changeAvatarButton.setText("Change Avatar");
        changeAvatarButton.setBounds(50, 250, 300, 80);
        changeAvatarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new AvatarClient();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        jPanel.add(changeAvatarButton);
    }

    public void setChangePasswordButton(){
        changePasswordButton = new JButton();
        changePasswordButton.setText("Change Password");
        changePasswordButton.setBounds(50, 350, 300, 80);
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new ChangePassword();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        jPanel.add(changePasswordButton);
    }

}

package me.ikartko.encrypt_decrypt.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
    private JFrame f;

    public GUI() {
        f = new JFrame();

        JLabel mode = new JLabel();
        mode.setBounds(130, 15, 100, 40);
        mode.setText("Encryption Mode");

        JButton encryptButton = new JButton();
        encryptButton.setBounds(65, 50, 100, 40);
        encryptButton.setText("Encrypt");
        encryptButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                mode.setText("Encryption Mode");
            }

        });

        JButton decryptButton = new JButton();
        decryptButton.setText("Decrypt");
        decryptButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mode.setText("Decryption Mode");
            }
            
        });
        decryptButton.setBounds(195, 50, 100, 40);

        

        f.add(encryptButton);
        f.add(decryptButton);
        f.add(mode);

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

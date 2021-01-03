package me.ikartko.encrypt_decrypt.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
    private JFrame f;
    private Encryptor encryptor;

    public GUI() {
        encryptor = new Encryptor();
        f = new JFrame();

        JLabel mode = new JLabel();
        mode.setBounds(130, 15, 100, 40);
        mode.setText("Encryption Mode");

        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setBounds(15, 220, 350, 120);

        JTextField textField = new JTextField();
        textField.setBounds(15, 110, 350, 60);

        JButton submitToEncrypt = new JButton("Encrypt");
        submitToEncrypt.setBounds(130, 180, 100, 40);
        submitToEncrypt.setVisible(true);

        JButton submitToDecrypt = new JButton("Decrypt");
        submitToDecrypt.setBounds(130, 180, 100, 40);
        submitToDecrypt.setVisible(false);

        JButton encryptButton = new JButton("Encryption");
        encryptButton.setBounds(65, 50, 100, 40);
        encryptButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                mode.setText("Encryption Mode");
                submitToEncrypt.setVisible(true);
                submitToDecrypt.setVisible(false);
            }

        });

        JButton decryptButton = new JButton("Decryption");
        decryptButton.setBounds(195, 50, 100, 40);
        decryptButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mode.setText("Decryption Mode");
                submitToDecrypt.setVisible(true);
                submitToEncrypt.setVisible(false);
            }
            
        });
        
        submitToEncrypt.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                encryptor = new Encryptor();
                String toEncrypt = textField.getText();
                String resultString = encryptor.encrypt(toEncrypt);
                resultField.setText(resultString);
            }
            
        });


        f.add(encryptButton);
        f.add(decryptButton);
        f.add(submitToEncrypt);
        f.add(submitToDecrypt);
        f.add(mode);
        f.add(textField);
        f.add(resultField);

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

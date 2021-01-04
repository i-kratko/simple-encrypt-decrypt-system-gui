package me.ikartko.encrypt_decrypt.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.*;

public class GUI {
    private JFrame f;
    private Encryptor encryptor;
    private Decryptor decryptor;

    public GUI() {
        String applicationName = "Egiginmga V1.2.0";
        encryptor = new Encryptor();
        decryptor = new Decryptor();
        f = new JFrame(applicationName);

        JLabel mode = new JLabel();
        mode.setBounds(132, 15, 100, 40);
        mode.setText("Encryption Mode");

        JTextArea resultField = new JTextArea();
        resultField.setEditable(false);
        resultField.setBounds(17, 230, 350, 120);
        resultField.setWrapStyleWord(true); 
        resultField.setLineWrap(true);

        JTextArea textField = new JTextArea();
        textField.setBounds(17, 110, 350, 60);
        textField.setLineWrap(true);
        

        JButton submitToEncrypt = new JButton("Encrypt");
        submitToEncrypt.setBounds(132, 180, 100, 40);
        submitToEncrypt.setVisible(true);

        JButton submitToDecrypt = new JButton("Decrypt");
        submitToDecrypt.setBounds(132, 180, 100, 40);
        submitToDecrypt.setVisible(false);

        JButton copyText = new JButton("Copy");
        copyText.setBounds(132, 370, 100, 40);

        JButton encryptButton = new JButton("Encryption");
        encryptButton.setBounds(67, 50, 100, 40);
        encryptButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                mode.setText("Encryption Mode");
                submitToEncrypt.setVisible(true);
                submitToDecrypt.setVisible(false);
            }

        });

        JButton decryptButton = new JButton("Decryption");
        decryptButton.setBounds(197, 50, 100, 40);
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
                String encrypted = encryptor.encrypt(textField.getText());
                resultField.setText(encrypted);
                System.out.println("Result: " + encrypted);

            }
            
        });

        submitToDecrypt.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                decryptor = new Decryptor();
                String decrypted = "";
                String[] decryption = textField.getText().split("\\s+");

                for (int i = 0; i < decryption.length; i++) {
                    String temp = decryption[i];
                    String temp2 = decryptor.decrypt(temp);
                    decrypted = decrypted.concat(temp2);
                }

                resultField.setText(decrypted);

                System.out.println("Result: " + decrypted);

            }
            
        });

        copyText.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection StringSelection = new StringSelection(resultField.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(StringSelection, StringSelection);
            }
            
        });


        f.add(encryptButton);
        f.add(decryptButton);
        f.add(submitToEncrypt);
        f.add(submitToDecrypt);
        f.add(copyText);
        f.add(mode);
        f.add(textField);
        f.add(resultField);
        
        f.setSize(400, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo ( null );
        f.setVisible ( true );

        

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

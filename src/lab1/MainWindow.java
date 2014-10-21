/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author viewt_000
 */
public class MainWindow extends JFrame implements ActionListener{
    private JLabel lblPrompt, lblOutput;
    private JTextField txtInput;
    private JButton btnSayHello;
    private Container container;
    
    public MainWindow()
    {
        lblPrompt = new JLabel("Enter your name:");
        lblOutput = new JLabel();
        txtInput = new JTextField();
        btnSayHello = new JButton("Say Hello");
        btnSayHello.addActionListener(this);
        container = this.getContentPane();
        container.add(lblPrompt, BorderLayout.WEST);
        container.add(txtInput, BorderLayout.CENTER);
        container.add(lblOutput, BorderLayout.EAST);
        container.add(btnSayHello, BorderLayout.SOUTH);
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String temp = txtInput.getText();
        String message = "Hello " + temp + "!";
        lblOutput.setText(message);
    }
}

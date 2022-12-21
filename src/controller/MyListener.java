package controller;

import model.FileOperations;
import view.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {
    FileOperations file = new FileOperations();

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "S":
                file.readFile();
                break;
            case "O":
                file.writeFile();
                break;
            case "X":
                System.exit(0);
                break;

            default:
                System.out.println("No Action");
                break;
        }
    }
}

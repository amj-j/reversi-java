package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.ReversiModel;

public class NewGame implements ActionListener {
    ReversiModel theModel;

    public void actionPerformed(ActionEvent event) {
        theModel.newGame();
    }
}

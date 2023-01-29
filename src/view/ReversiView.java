package view;

import java.awt.*;
import javax.swing.*;

import interfaces.ReversiViewInterface;
import utils.Defaults;

public class ReversiView extends JFrame implements ReversiViewInterface {
    
    public ReversiView() {
        setSize(Defaults.WINDOW_WIDTH, Defaults.WINDOW_WIDTH);

    }
}

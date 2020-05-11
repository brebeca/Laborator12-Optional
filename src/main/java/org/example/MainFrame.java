package org.example;


import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * se initializeaza toate componentele paginii cu cele doua componente canvas si configPanel
     * librarii: javax.swing.JFrame implicit doarece foloseste functia add din clasa pe care o mostensest :JFrame
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }


}

package com.innotech.views;

import javax.swing.*;

public class DisplayManager {
    private final JFrame gameWindow = new JFrame("Siege");
    private final MainScreen gameScreen = new MainScreen();

    public DisplayManager() {
        initializeWindow();
    }

    private void initializeWindow() {
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.add(gameScreen);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
    }

    public MainScreen getGameScreen() {
        return gameScreen;
    }
}

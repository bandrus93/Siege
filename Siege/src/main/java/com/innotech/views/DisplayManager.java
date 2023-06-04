package com.innotech.views;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DisplayManager {
    private final JFrame gameWindow = new JFrame("Siege");
    private final MainScreen gameScreen;

    {
        try {
            gameScreen = new MainScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DisplayManager() {
        initializeWindow();
    }

    private void initializeWindow() {
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setBackground(Color.BLACK);
        gameWindow.add(gameScreen);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
    }

    public MainScreen getGameScreen() {
        return gameScreen;
    }
}

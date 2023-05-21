package com.innotech.views;

import com.innotech.controllers.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {
    private final int gridSize = 16;
    private final int gridScale = 1;
    private final int maxSquareHeight = 64;
    private final KeyHandler inputHandler = new KeyHandler();

    public MainScreen() {
        int mapScale = gridSize * gridScale;
        int mapSize = maxSquareHeight * mapScale;
        setPreferredSize(new Dimension(mapSize, mapSize));
        setDoubleBuffered(true);
        addKeyListener(inputHandler);
        setFocusable(true);
    }

    public void update() {}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
    }
}

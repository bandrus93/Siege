package com.innotech.views;

import com.innotech.controllers.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {
    private final int gridSize = 16;
    private final int gridScale = 1;
    private final int maxSquareHeight = 64;
    private final KeyHandler inputHandler = new KeyHandler();
    private TileManager tileManager = new TileManager(this);

    public MainScreen() {
        int mapScale = getGridSize();
        int mapSize = maxSquareHeight * mapScale;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(mapSize, mapSize));
        setDoubleBuffered(true);
        addKeyListener(inputHandler);
        setFocusable(true);
    }

    public int getGridSize() {
        return gridSize * gridScale;
    }

    public void update() {}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        tileManager.draw(graphics);
    }
}

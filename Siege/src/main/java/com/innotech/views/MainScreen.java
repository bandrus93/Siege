package com.innotech.views;

import com.innotech.controllers.KeyHandler;
import com.innotech.map.TileManager;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {
    private final int gridSize = 16;
    private final int gridScale = 1;
    private final int maxSquareHeight = 56;
    private final KeyHandler inputHandler = new KeyHandler();
    private final TileManager tileManager = new TileManager(this);

    public MainScreen() {
        int mapScale = getGridSize();
        int mapSize = maxSquareHeight * mapScale;
        setPreferredSize(new Dimension(mapSize, mapSize));
        setDoubleBuffered(true);
        addKeyListener(inputHandler);
        setFocusable(true);
    }

    public int getGridSize() {
        return gridSize * gridScale;
    }

    public int getTileSize() { return gridSize * gridScale * 2; }

    public int getWindowHeightInPixels() { return maxSquareHeight * gridSize * gridScale; }

    public void update() {}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        ((Graphics2D) g).setBackground(Color.BLACK);
        g.setColor(Color.RED);
        tileManager.draw(graphics);
    }
}

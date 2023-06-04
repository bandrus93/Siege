package com.innotech.views;

import com.innotech.controllers.KeyHandler;
import com.innotech.map.MapGenerator;
import com.innotech.map.PlayerMap;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainScreen extends JPanel {
    private final int gridSize = 16;
    private final int gridScale = 1;
    private final int maxSquareHeight = 56;
    private final KeyHandler inputHandler = new KeyHandler();
    private final PlayerMap map = MapGenerator.getPlayerMapInstance(this);

    public MainScreen() throws IOException {
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

    public int getSideLength() {
        double computedLength = getWindowHeightInPixels() * Math.tan(0.392699);
        if (computedLength % getTileSize() == 0) {
            return (int) computedLength;
        } else {
            double correctedLength = computedLength - (computedLength % getTileSize());
            return (int) correctedLength + getTileSize();
        }
    }

    public int getOffsetLength() {
        double computedLength = (getWindowHeightInPixels() * Math.tan(0.392699)) / Math.sqrt(2);
        if (computedLength % getTileSize() == 0) {
            return (int) computedLength;
        } else {
            double correctedLength = computedLength - (computedLength % getTileSize());
            return (int) correctedLength;
        }
    }

    public int getTotalTileSpaces() {
        int sLength = getWindowHeightInPixels() / getTileSize();
        int aLength = getOffsetLength() / getTileSize();
        int totalCanvasArea = sLength * sLength;
        int excludedTiles = ((aLength * aLength) - sLength) * 4;
        return totalCanvasArea - excludedTiles;
    }

    public void update() {}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        ((Graphics2D) g).setBackground(Color.BLACK);
        g.setColor(Color.RED);
        map.draw(graphics);
    }
}

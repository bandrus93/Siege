package com.innotech.views;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {
    private final int gridSize = 16;
    private final int gridScale = 1;
    private final int maxSquareHeight = 64;

    public MainScreen() {
        int mapScale = gridSize * gridScale;
        int mapSize = maxSquareHeight * mapScale;
        setPreferredSize(new Dimension(mapSize, mapSize));
        setDoubleBuffered(true);
    }
}

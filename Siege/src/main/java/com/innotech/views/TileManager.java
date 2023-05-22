package com.innotech.views;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TileManager {
    private MainScreen canvas;
    private ArrayList<BackgroundTile> tileGrid = new ArrayList<>();

    public TileManager(MainScreen gameWindow) {
        canvas = gameWindow;
        loadTileImage();
    }

    private void loadTileImage() {
        try {
            tileGrid.add(new BackgroundTile(ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/grass.jpg")))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D graphics) {
        graphics.drawImage(tileGrid.get(0).getImage(),0,0, canvas.getGridSize(), canvas.getGridSize(), null);
    }
}

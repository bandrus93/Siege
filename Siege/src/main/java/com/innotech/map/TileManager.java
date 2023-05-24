package com.innotech.map;

import com.innotech.map.BackgroundTile;
import com.innotech.views.MainScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TileManager {
    private MainScreen canvas;
    private ArrayList<BackgroundTile> tileGrid = new ArrayList<>();
    private final MapCalculator calculator;
    private final MapGenerator map;
    public enum Tile {
        WATER,
        GRASS
    }

    public TileManager(MainScreen gameWindow) {
        canvas = gameWindow;
        calculator = new MapCalculator(canvas);
        map = new MapGenerator(calculator);
        loadMap(map.generate());
    }

    private void loadMap(byte[] mapData) {
        try {
            for (int i = 0; i < mapData.length; i++) {
                tileGrid.add(new BackgroundTile(ImageIO.read(Objects.requireNonNull(getClass().getResource(getTilePath(mapData[i]))))));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTilePath(int byteValue) {
        for (Tile tile : Tile.values()) {
            if (tile.ordinal() == byteValue) {
                return "/" + tile.toString().toLowerCase() + ".jpg";
            }
        }
        return "/water.jpg";
    }

    public void draw(Graphics2D graphics) {
        int nextTileIndex = 0;
        int tileSize = canvas.getTileSize();
        for (int i = 0; i < canvas.getWindowHeightInPixels(); i += tileSize) {
            for (int j = 0; j < canvas.getWindowHeightInPixels(); j += tileSize) {
                graphics.drawImage(tileGrid.get(nextTileIndex).getImage(),i,j, tileSize, tileSize, null);
                nextTileIndex++;
            }
        }
    }
}

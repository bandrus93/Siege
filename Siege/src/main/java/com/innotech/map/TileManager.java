package com.innotech.map;

import com.innotech.views.MainScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TileManager {
    private final MainScreen canvas;
    private final ArrayList<BackgroundTile> tileGrid = new ArrayList<>();
    private final MapCalculator calculator;
    private final MapGenerator map;
    public enum Tile {
        WATER,
        TEMPERATE_GRASS
    }

    public TileManager(MainScreen gameWindow) {
        canvas = gameWindow;
        calculator = new MapCalculator(canvas);
        map = new MapGenerator(calculator);
        loadMap(map.generate());
    }

    private void loadMap(byte[] mapData) {
        try {
            for (byte mapDatum : mapData) {
                tileGrid.add(new BackgroundTile(ImageIO.read(Objects.requireNonNull(getClass().getResource(getTilePath(mapDatum))))));
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
        int rowOffset = calculator.getOffsetLength();
        int rowEnd = rowOffset + calculator.getSideLength();
        for (int i = 0; i < canvas.getWindowHeightInPixels(); i += tileSize) {
            for (int j = rowOffset; j < rowEnd; j += tileSize) {
                graphics.drawImage(tileGrid.get(nextTileIndex).getImage(),j,i, tileSize, tileSize, null);
                nextTileIndex++;
            }
            if (i < calculator.getOffsetLength()) {
                rowOffset -= tileSize;
                rowEnd += tileSize;
            } else if (i >= (calculator.getOffsetLength() + calculator.getSideLength()) - canvas.getTileSize()) {
                rowOffset += tileSize;
                rowEnd -= tileSize;
            }
        }
        int mapCenterPoint = canvas.getWindowHeightInPixels() / 2;
        graphics.fillRect(mapCenterPoint,mapCenterPoint,4,4);
    }
}

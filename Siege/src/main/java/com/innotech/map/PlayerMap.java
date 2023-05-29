package com.innotech.map;

import com.innotech.views.MainScreen;

import java.awt.*;

public class PlayerMap extends Map {
    private final int totalTileSpaces;

    public PlayerMap(MainScreen canvas) {
        super(canvas);
        totalTileSpaces = canvas.getTotalTileSpaces();
    }
    public void draw(Graphics2D graphics) {
        int nextTileIndex = 0;
        int tileSize = canvas.getTileSize();
        int rowOffset = canvas.getOffsetLength();
        int rowEnd = rowOffset + canvas.getSideLength();
        for (int i = 0; i < canvas.getWindowHeightInPixels(); i += tileSize) {
            for (int j = rowOffset; j < rowEnd; j += tileSize) {
                graphics.drawImage(tileGrid.get(nextTileIndex).getImage(),j,i, tileSize, tileSize, null);
                nextTileIndex++;
            }
            if (i < canvas.getOffsetLength()) {
                rowOffset -= tileSize;
                rowEnd += tileSize;
            } else if (i >= (canvas.getOffsetLength() + canvas.getSideLength()) - canvas.getTileSize()) {
                rowOffset += tileSize;
                rowEnd -= tileSize;
            }
        }
        int mapCenterPoint = canvas.getWindowHeightInPixels() / 2;
        graphics.fillRect(mapCenterPoint,mapCenterPoint,4,4);
    }

    public byte[] generate() {
        byte[] mapData = new byte[totalTileSpaces];
        for (int i = 0; i < totalTileSpaces; i++) {
            mapData[i] = 4;
        }
        return mapData;
    }

}

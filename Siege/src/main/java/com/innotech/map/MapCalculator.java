package com.innotech.map;

import com.innotech.views.MainScreen;

public class MapCalculator {
    private final MainScreen canvas;

    public MapCalculator(MainScreen canvas) {
        this.canvas = canvas;
    }

    public int getSideLength() {
        double computedLength = canvas.getWindowHeightInPixels() * Math.tan(0.392699);
        if (computedLength % canvas.getTileSize() == 0) {
            return (int) computedLength;
        } else {
            double correctedLength = computedLength - (computedLength % canvas.getTileSize());
            return (int) correctedLength + canvas.getTileSize();
        }
    }

    public int getOffsetLength() {
        double computedLength = (canvas.getWindowHeightInPixels() * Math.tan(0.392699)) / Math.sqrt(2);
        if (computedLength % canvas.getTileSize() == 0) {
            return (int) computedLength;
        } else {
            double correctedLength = computedLength - (computedLength % canvas.getTileSize());
            return (int) correctedLength;
        }
    }

    public int getTotalTileSpaces() {
        int sLength = canvas.getWindowHeightInPixels() / canvas.getTileSize();
        int aLength = getOffsetLength() / canvas.getTileSize();
        int totalCanvasArea = sLength * sLength;
        int excludedTiles = ((aLength * aLength) - sLength) * 4;
        return totalCanvasArea - excludedTiles;
    }
}

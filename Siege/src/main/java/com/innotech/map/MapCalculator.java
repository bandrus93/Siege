package com.innotech.map;

import com.innotech.views.MainScreen;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

public class MapCalculator {
    private final MainScreen canvas;
    private final MathContext context = new MathContext(3, RoundingMode.DOWN);
    private final int sLength;
    private final int xDimension;
    private final int yDimension;

    public MapCalculator(MainScreen canvas) {
        this.canvas = canvas;
        sLength = (canvas.getMaxSquareHeight() * canvas.getGridSize()) / canvas.getTileSize();
        xDimension = computeXDimension();
        yDimension = ((sLength - xDimension) / 2) - 1;
    }

    public HashMap<String,Integer> getMapDimensions() {
        HashMap<String,Integer> mapDimensions = new HashMap<>();
        mapDimensions.put("x", xDimension);
        mapDimensions.put("y", yDimension);
        return mapDimensions;
    }

    private int computeXDimension() {
        double computedDimension = ((sLength / 2.0) * Math.tan(0.392699)) * 2;
        return new BigDecimal(Double.toString(computedDimension),context).intValue() + 1;
    }

    public int getSLength() { return sLength; }

    public int getTotalTileSpaces() {
//        int totalCanvasArea = sLength * sLength;
//        int excludedTiles = ((((sLength - xDimension) / 2) * ((sLength - xDimension) / 2)) - sLength) * 4;
//        return totalCanvasArea - excludedTiles;
        return sLength * sLength;
    }
}

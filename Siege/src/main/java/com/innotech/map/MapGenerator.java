package com.innotech.map;

public class MapGenerator {
    private final MapCalculator calculator;
    private final int totalTileSpaces;

    public MapGenerator(MapCalculator calculator) {
        this.calculator = calculator;
        totalTileSpaces = calculator.getTotalTileSpaces();
    }

    public byte[] generate() {
        byte[] mapData = new byte[totalTileSpaces];
        for (int i = 0; i < totalTileSpaces; i++) {
            mapData[i] = 1;
        }
        return mapData;
    }
}

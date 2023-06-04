package com.innotech.map.tile;

import com.innotech.map.Map;

public class TileManager {
    private final Map map;

    public TileManager(Map map) {
        this.map = map;
    }

    public void loadMap(byte[] mapData) {
        for (byte mapDatum : mapData) {
            BackgroundTile tile = new BackgroundTile(map.biome, mapDatum);
            map.tileGrid.add(tile);
        }
    }
}

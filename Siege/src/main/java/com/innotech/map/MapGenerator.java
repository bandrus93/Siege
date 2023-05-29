package com.innotech.map;

import com.innotech.views.MainScreen;

public class MapGenerator {

    public MapGenerator() {

    }

    public static PlayerMap getPlayerMapInstance(MainScreen canvas) {
        PlayerMap map = new PlayerMap(canvas);
        map.biome = Biome.getInstance();
        map.layoutManager = new TileManager(map);
        map.layoutManager.loadMap(map.generate());
        return map;
    }
}

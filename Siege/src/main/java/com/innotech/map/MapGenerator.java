package com.innotech.map;

import com.innotech.map.biome.Biome;
import com.innotech.map.tile.TileManager;
import com.innotech.views.MainScreen;

import java.io.IOException;

public class MapGenerator {

    public MapGenerator() {

    }

    public static PlayerMap getPlayerMapInstance(MainScreen canvas) throws IOException {
        PlayerMap map = new PlayerMap(canvas);
        map.biome = new Biome.Generator()
                .setClimate(Biome.Climate.TEMPERATE)
                .setEcology(Biome.Ecology.PLAINS)
                .configureTextures(map.data.getTexturePacks())
                .generate();
        map.layoutManager = new TileManager(map);
        map.layoutManager.loadMap(map.generate());
        return map;
    }
}

package com.innotech.map;

import com.innotech.map.biome.Biome;
import com.innotech.map.tile.TileManager;
import com.innotech.views.MainScreen;

import java.io.IOException;
import java.util.Random;

public class MapGenerator {

    public MapGenerator() {

    }

    public static PlayerMap getPlayerMapInstance(MainScreen canvas) throws IOException {
        PlayerMap map = new PlayerMap(canvas);
        map.biome = new Biome.Generator()
                .setClimate(Biome.fetchClimate(new Random().nextInt(Biome.Climate.values().length)))
                .setEcology(Biome.fetchEcology(new Random().nextInt(Biome.Ecology.values().length)))
                .configureTextures(map.data.getTexturePacks())
                .generate();
        map.layoutManager = new TileManager(map);
        map.layoutManager.loadMap(map.generate());
        return map;
    }
}

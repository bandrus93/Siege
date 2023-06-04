package com.innotech.map;

import com.innotech.map.biome.Biome;
import com.innotech.map.data.MapData;
import com.innotech.map.tile.Tile;
import com.innotech.map.tile.TileManager;
import com.innotech.views.MainScreen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Map {
    protected MainScreen canvas;
    protected TileManager layoutManager;
    public ArrayList<Tile> tileGrid = new ArrayList<>();
    protected final MapData data = new MapData.Loader().loadTexturePacks().load();
    public Biome biome;

    public Map(MainScreen canvas) throws IOException {
        this.canvas = canvas;
    }

    public abstract void draw(Graphics2D graphics);
    public abstract byte[] generate();
}

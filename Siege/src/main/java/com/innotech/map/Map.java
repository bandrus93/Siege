package com.innotech.map;

import com.innotech.map.tile.Tile;
import com.innotech.views.MainScreen;

import java.awt.*;
import java.util.ArrayList;

public abstract class Map {
    protected MainScreen canvas;
    protected TileManager layoutManager;
    protected ArrayList<Tile> tileGrid = new ArrayList<>();
    protected Biome biome;

    public Map(MainScreen canvas) {
        this.canvas = canvas;
    }

    public abstract void draw(Graphics2D graphics);
    public abstract byte[] generate();
}

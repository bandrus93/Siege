package com.innotech.map.tile;

import com.innotech.map.Biome;

import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Tile {
    protected BufferedImage image;
    protected String textureFormat = ".jpg";

    public Tile(Biome biome, byte val) {
        try {
            image = loadTexture(biome,val);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract BufferedImage loadTexture(Biome biome, byte val) throws IOException;
    public abstract BufferedImage getImage();
}

package com.innotech.map.tile;

import com.innotech.map.biome.Biome;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BackgroundTile extends Tile {

    private boolean isObstacle = false;

    public BackgroundTile(Biome biome, byte val) {
        super(biome,val);
    }

    @Override
    protected BufferedImage loadTexture(Biome biome, byte value) throws IOException {
        String terrain = "";
        for (Biome.Terrain tile : Biome.Terrain.values()) {
            if (tile.ordinal() == value) {
                terrain = tile.toString().toLowerCase() + this.textureFormat;
            }
        }
        if (terrain.equals("")) {
            terrain = "water" + this.textureFormat;
        }
        String texturePath = String.format("/map/terrain/%s/%s/%s", biome.getClimate().toString().toLowerCase(), biome.getEcology().toString().toLowerCase(), terrain);
        return ImageIO.read(Objects.requireNonNull(getClass().getResource(texturePath)));
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}

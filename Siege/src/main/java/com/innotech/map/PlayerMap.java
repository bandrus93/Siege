package com.innotech.map;

import com.innotech.map.data.Texture;
import com.innotech.map.data.TexturePack;
import com.innotech.views.MainScreen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerMap extends Map {
    private final int totalTileSpaces;

    public PlayerMap(MainScreen canvas) throws IOException {
        super(canvas);
        totalTileSpaces = canvas.getTotalTileSpaces();
    }
    public void draw(Graphics2D graphics) {
        int nextTileIndex = 0;
        int tileSize = canvas.getTileSize();
        int rowOffset = canvas.getOffsetLength();
        int rowEnd = rowOffset + canvas.getSideLength();
        for (int i = 0; i < canvas.getWindowHeightInPixels(); i += tileSize) {
            for (int j = rowOffset; j < rowEnd; j += tileSize) {
                graphics.drawImage(tileGrid.get(nextTileIndex).getImage(),j,i, tileSize, tileSize, null);
                nextTileIndex++;
            }
            if (i < canvas.getOffsetLength()) {
                rowOffset -= tileSize;
                rowEnd += tileSize;
            } else if (i >= (canvas.getOffsetLength() + canvas.getSideLength()) - canvas.getTileSize()) {
                rowOffset += tileSize;
                rowEnd -= tileSize;
            }
        }
        int mapCenterPoint = canvas.getWindowHeightInPixels() / 2;
        graphics.fillRect(mapCenterPoint,mapCenterPoint,4,4);
    }

    public byte[] generate() {
        TexturePack texturePack = biome.getData();
        int offsetTiles = canvas.getOffsetLength() / canvas.getTileSize();
        int rowEnd = (canvas.getSideLength() / canvas.getTileSize()) + offsetTiles;
        int rowBegin = offsetTiles + 1;
        List<SeedRegion> tileRegions = new ArrayList<>();
        SeedRegion activeRegion;
        int xRaster = rowBegin;
        int yRaster = canvas.getWindowHeightInPixels() / canvas.getTileSize();
        byte[] mapData = new byte[totalTileSpaces];
        for (int i = 0; i < totalTileSpaces; i++) {
            if ((activeRegion = SeedRegion.isInBounds(tileRegions,xRaster,yRaster)) != null) {
                double noiseValue = PerlinNoise2D.noise(xRaster,yRaster);
                mapData[i] = noiseValue <= activeRegion.seedHeight && noiseValue >= activeRegion.seedHeight - activeRegion.seedTile.getSeedValue()
                        ? activeRegion.seedTile.getByteValue()
                        : texturePack.getDefaultTexture().getByteValue();
            } else {
                Texture selected = texturePack.getRandomTexture();
                mapData[i] = selected.getByteValue();
                if (selected.getSeedValue() < 2) {
                    double altitude = PerlinNoise2D.noise(xRaster,yRaster);
                    SeedRegion toSeed = new SeedRegion(selected,xRaster,yRaster,altitude, canvas.getWindowHeightInPixels());
                    if (!toSeed.isOverlapping(tileRegions)) tileRegions.add(toSeed);
                }
            }
            xRaster++;
            if (yRaster > offsetTiles + (canvas.getSideLength() / canvas.getTileSize()) && xRaster > rowEnd) {
                yRaster--;
                rowBegin--;
                rowEnd++;
                xRaster = rowBegin;
            } else if (yRaster <= offsetTiles + 1 && xRaster > rowEnd) {
                yRaster--;
                rowBegin++;
                rowEnd--;
                xRaster = rowBegin;
            }
        }
        return mapData;
    }

    private static class SeedRegion {
        int xBegin;
        int xEnd;
        int yEnd;
        Texture seedTile;
        double seedHeight;

        public SeedRegion(Texture toTile, int xBegin, int yBegin, double altitude, int screenWidth) {
            int tileRadius = (int) Math.round(toTile.getSeedRadius() * screenWidth);
            this.xBegin = xBegin;
            seedTile = toTile;
            seedHeight = altitude;
            xEnd = xBegin + tileRadius;
            yEnd = yBegin - tileRadius;
        }

        public boolean isOverlapping(List<SeedRegion> activeRegions) {
            for (SeedRegion region : activeRegions) {
                if (xEnd >= region.xBegin) return true;
            }
            return false;
        }

        public static SeedRegion isInBounds(List<SeedRegion> activeRegions, int x, int y) {
            for (SeedRegion region : activeRegions) {
                if (region.xBegin <= x && region.xEnd >= x && region.yEnd <= y) return region;
            }
            return null;
        }
    }

}

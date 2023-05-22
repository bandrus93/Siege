package com.innotech.views;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundTile {
    private final BufferedImage image;
    private boolean isObstacle = false;

    public BackgroundTile(BufferedImage image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}

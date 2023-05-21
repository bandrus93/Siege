package com.innotech.controllers;

import com.innotech.views.MainScreen;

public class GameClock implements Runnable {
    private Thread gameLoop;
    private MainScreen canvas;
    private final int frameRate = 60;

    public GameClock(MainScreen canvas) {
        this.canvas = canvas;
        gameLoop = new Thread(this);
    }

    public void startGame() {
        gameLoop.start();
    }

    public void run() {
        double drawInterval = 1000000000.0 / frameRate;
        double delta = 0;
        long beginTimestamp = System.nanoTime();
        long currentTimestamp;

        do {
            currentTimestamp = System.nanoTime();
            delta += (currentTimestamp - beginTimestamp) / drawInterval;
            beginTimestamp = currentTimestamp;
            if (delta >= 1) {
                canvas.update();
                canvas.repaint();
                delta--;
            }
        } while (gameLoop.isAlive());
    }
}

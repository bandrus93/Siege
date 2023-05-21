package com.innotech.controllers;

import javax.swing.*;

public class GameClock implements Runnable {
    private Thread gameLoop;

    public GameClock() {
        gameLoop = new Thread(this);
    }

    public void startGame() {
        gameLoop.start();
    }

    public void run() {
        //
    }
}

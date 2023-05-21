package com.innotech;

import com.innotech.controllers.GameClock;
import com.innotech.views.DisplayManager;

public class App
{
    public static void main( String[] args )
    {
        DisplayManager viewManager = new DisplayManager();
        GameClock clock = new GameClock();
        clock.startGame();
    }
}

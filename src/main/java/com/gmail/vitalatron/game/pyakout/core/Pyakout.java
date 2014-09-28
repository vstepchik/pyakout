package com.gmail.vitalatron.game.pyakout.core;

import com.gmail.vitalatron.game.pyakout.scenes.MenuScene;
import com.gmail.vitalatron.game.visual.GameWindow;
import com.gmail.vitalatron.game.visual.SwingGameWindow;

import java.awt.*;

public class Pyakout {
    private static final int WINDOW_WIDTH = 800;

    private static final int WINDOW_HEIGHT = 600;

    private final GameWindow window;

    public Pyakout() {
        this.window = new SwingGameWindow("Pyakout", new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        MenuScene menuScene = new MenuScene();
        this.window.addScene(menuScene);
        this.window.setCurrentScene(menuScene);
        this.window.show();
    }


}

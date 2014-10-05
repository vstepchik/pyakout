package com.gmail.vitalatron.game.pyakout.core;

import com.gmail.vitalatron.game.input.SwingUserInputHandler;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.pyakout.scenes.MenuScene;
import com.gmail.vitalatron.game.visual.SceneHolder;
import com.gmail.vitalatron.game.visual.SwingGameWindow;

import java.awt.*;

public class Pyakout {
    private static final int WINDOW_WIDTH = 800;

    private static final int WINDOW_HEIGHT = 600;

    private final SwingGameWindow window;

    private final UserInputHandler inputHandler;

    private final SceneHolder sceneHolder = new SceneHolder();

    public Pyakout() {
        this.window = new SwingGameWindow("Pyakout", new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.inputHandler = new SwingUserInputHandler(this.window.getFrame());

        this.window.setSceneHolder(this.sceneHolder);

        MenuScene menuScene = new MenuScene();
        this.sceneHolder.addScene(menuScene);
        this.sceneHolder.setCurrentScene(menuScene);
        this.window.show();
    }


}

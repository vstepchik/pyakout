package com.gmail.vitalatron.game.pyakout.scenes;

import com.gmail.vitalatron.game.input.controls.ControlAction;
import com.gmail.vitalatron.game.input.controls.TextMenuItem;
import com.gmail.vitalatron.game.pyakout.controls.MainMenu;
import com.gmail.vitalatron.game.res.ImageResourceLoader;
import com.gmail.vitalatron.game.visual.Layer;
import com.gmail.vitalatron.game.visual.Scene;
import com.gmail.vitalatron.game.visual.Sprite;

public class MenuScene extends Scene {

    public static final String SCENE_NAME = "menu";

    private static final String CONTROLS_LAYER = "controls";

    private static final String LOGO_LAYER = "logo";

    private final Layer logoLayer = new Layer(LOGO_LAYER, 200);

    private final Layer menuControlsLayer = new Layer(CONTROLS_LAYER, 100);

    private final MainMenu mainMenu = createMainMenu();

    public MenuScene() {
        super(SCENE_NAME);
        initLayers();
    }

    private void initLayers() {
        initControlsLayer();
    }

    private void initControlsLayer() {
        mainMenu.getLocation().setLocation(400, 130);
        mainMenu.next();
        mainMenu.next();
        mainMenu.select();
        menuControlsLayer.addDrawable(mainMenu);

        Sprite logoSprite = new Sprite(ImageResourceLoader.loadImage("/logo.png"));
        logoSprite.setX(20);
        logoSprite.setY(20);
        logoLayer.addDrawable(logoSprite);

        addLayer(menuControlsLayer);
        addLayer(logoLayer);
    }

    private MainMenu createMainMenu() {
        TextMenuItem mainMenu = new TextMenuItem(null);
        TextMenuItem start = new TextMenuItem(mainMenu, "START");
        TextMenuItem optionsMenu = new TextMenuItem(mainMenu, "OPTIONS");

        TextMenuItem testMenu = new TextMenuItem(mainMenu, "TEST");
        TextMenuItem testMenu1 = new TextMenuItem(testMenu, "T1");
        TextMenuItem testMenu2 = new TextMenuItem(testMenu, "T2");
        TextMenuItem testMenu3 = new TextMenuItem(testMenu, "T3", new ControlAction() {
            @Override
            public void perform() {
                System.out.println("entered T3");
            }
        });
        TextMenuItem testMenu31 = new TextMenuItem(testMenu3, "T3-1", new ControlAction() {
            @Override
            public void perform() {
                System.out.println("T3-1 performed");
            }
        });
        TextMenuItem testMenu32 = new TextMenuItem(testMenu3, "T3-2", new ControlAction() {
            @Override
            public void perform() {
                System.out.println("T3-2 performed");
            }
        });
        TextMenuItem testMenu33 = new TextMenuItem(testMenu3, "T3-3", new ControlAction() {
            @Override
            public void perform() {
                System.out.println("T3-3 performed");
            }
        });
        TextMenuItem testMenu4 = new TextMenuItem(testMenu, "T4");
        TextMenuItem testMenu41 = new TextMenuItem(testMenu4, "T4-1", new ControlAction() {
            @Override
            public void perform() {
                System.out.println("T4-1 performed");
            }
        });
        TextMenuItem testMenu42 = new TextMenuItem(testMenu4, "T4-2", new ControlAction() {
            @Override
            public void perform() {
                System.out.println("T4-2 performed");
            }
        });
        TextMenuItem testMenu5 = new TextMenuItem(testMenu, "T5");

        TextMenuItem quit = new TextMenuItem(mainMenu, "QUIT");
        return new MainMenu(mainMenu);
    }

}

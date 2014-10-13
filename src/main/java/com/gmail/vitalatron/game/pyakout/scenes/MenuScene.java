package com.gmail.vitalatron.game.pyakout.scenes;

import com.gmail.vitalatron.game.input.KeyboardButton;
import com.gmail.vitalatron.game.input.controls.ControlAction;
import com.gmail.vitalatron.game.input.controls.TextMenuItem;
import com.gmail.vitalatron.game.pyakout.controls.MainMenu;
import com.gmail.vitalatron.game.res.ImageResourceLoader;
import com.gmail.vitalatron.game.visual.Drawable;
import com.gmail.vitalatron.game.visual.Layer;
import com.gmail.vitalatron.game.visual.Scene;
import com.gmail.vitalatron.game.visual.Sprite;

import java.awt.*;

public class MenuScene extends Scene {

    public static final String SCENE_NAME = "menu";

    private static final String CONTROLS_LAYER = "controls";

    private static final String LOGO_LAYER = "logo";

    private static final String BACKGROUND_LAYER = "background";

    private static final Color BACKGROUND_COLOR = Color.decode("#222222");

    private static final Color MENU_COLOR = Color.decode("#CCCCDD");

    private static final Color INACTIVE_MENU_COLOR = Color.decode("#555577");

    private static final Color MENU_LINES_COLOR = Color.decode("#224466");

    private final Layer logoLayer = new Layer(LOGO_LAYER, 200);

    private final Layer menuControlsLayer = new Layer(CONTROLS_LAYER, 100);

    private final Layer menuBackgroundLayer = new Layer(BACKGROUND_LAYER, -100);

    private final MainMenu mainMenu = createMainMenu();

    private final int width;

    private final int height;

    public MenuScene(int width, int height) {
        super(SCENE_NAME);
        this.width = width;
        this.height = height;
        initLayers();
    }

    private void initLayers() {
        initControlsLayer();
    }

    private void initControlsLayer() {
        mainMenu.getLocation().setLocation((width - MainMenu.MENU_ITEM_WIDTH) / 2, height - 200);
        mainMenu.setActiveMenuColor(MENU_COLOR);
        mainMenu.setInactiveMenuColor(INACTIVE_MENU_COLOR);
        mainMenu.setMenuLinesColor(MENU_LINES_COLOR);
        menuControlsLayer.addDrawable(mainMenu);
        menuBackgroundLayer.addDrawable(new Drawable() {
            @Override
            public void draw(Graphics2D g) {
                g.setColor(BACKGROUND_COLOR);
                g.fillRect(0, 0, width, height);
            }
        });

        Sprite logoSprite = new Sprite(ImageResourceLoader.loadImage("/logo.png"));
        logoSprite.setX(20);
        logoSprite.setY(20);
        logoLayer.addDrawable(logoSprite);

        addLayer(menuBackgroundLayer);
        addLayer(menuControlsLayer);
        addLayer(logoLayer);
    }

    private MainMenu createMainMenu() {
        final TextMenuItem mainMenu = new TextMenuItem(null);
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
        TextMenuItem quitNo = new TextMenuItem(quit, "NO", new ControlAction() {
            @Override
            public void perform() {
                MenuScene.this.mainMenu.back();
            }
        });
        TextMenuItem quitYes = new TextMenuItem(quit, "YES", new ControlAction() {
            @Override
            public void perform() {
                System.exit(0);
            }
        });
        return new MainMenu(mainMenu, BACKGROUND_COLOR);
    }

    @Override
    public void keyPressed(KeyboardButton button) {
        switch (button) {
            case UP:
            case W:
                mainMenu.previous();
                break;
            case DOWN:
            case S:
                mainMenu.next();
                break;
            case LEFT:
            case A:
            case ESC:
                mainMenu.back();
                break;
            case RIGHT:
            case D:
            case ENTER:
                mainMenu.select();
                break;
        }
    }
}

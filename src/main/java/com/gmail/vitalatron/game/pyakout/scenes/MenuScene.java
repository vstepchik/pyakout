package com.gmail.vitalatron.game.pyakout.scenes;

import com.gmail.vitalatron.game.visual.Drawable;
import com.gmail.vitalatron.game.visual.Layer;
import com.gmail.vitalatron.game.visual.Scene;

import java.awt.*;

public class MenuScene extends Scene {

    public static final String SCENE_NAME = "menu";

    private static final String CONTROLS_LAYER = "controls";

    private final Layer menuControlsLayer = new Layer(CONTROLS_LAYER, 100);

    public MenuScene() {
        super(SCENE_NAME);
        initLayers();
    }

    private void initLayers() {
        initControlsLayer();
    }

    private void initControlsLayer() {
        menuControlsLayer.addDrawable(new Drawable() {
            @Override
            public void draw(Graphics2D g) {
                g.drawString("Pyakout!", 30, 40);
            }
        });
        addLayer(menuControlsLayer);
    }

}

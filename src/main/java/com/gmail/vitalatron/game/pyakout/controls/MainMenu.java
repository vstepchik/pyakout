package com.gmail.vitalatron.game.pyakout.controls;

import com.gmail.vitalatron.game.input.controls.Menu;
import com.gmail.vitalatron.game.input.controls.TextMenuItem;
import com.gmail.vitalatron.game.visual.Drawable;

import java.awt.*;

public class MainMenu extends Menu<TextMenuItem> implements Drawable {

    private Point location = new Point();

    private static final int MENU_WIDTH = 200;

    private static final int H_PADDING = 20;

    public MainMenu(TextMenuItem rootMenu) {
        super(rootMenu);
    }

    @Override
    public void draw(Graphics2D g) {
        if (currentMenu.getParent() != null) {
            int yOffset = 0;
            for (TextMenuItem menuItem : currentMenu.getParent().getChildren()) {
                g.setColor(menuItem.equals(currentMenu) ? Color.BLUE : Color.GRAY);
                g.drawString(menuItem.getLabel(), location.x - MENU_WIDTH + H_PADDING, location.y + yOffset);
                yOffset += 20;
            }
        }
        int yOffset = 0;
        for (TextMenuItem menuItem : currentMenu.getChildren()) {
            g.setColor(menuItem.equals(selectedMenuItem) ? Color.GREEN : Color.WHITE);
            g.drawString(menuItem.getLabel(), location.x, location.y + yOffset);
            yOffset += 20;
        }
    }

    public Point getLocation() {
        return location;
    }
}

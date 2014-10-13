package com.gmail.vitalatron.game.pyakout.controls;

import com.gmail.vitalatron.game.input.controls.Menu;
import com.gmail.vitalatron.game.input.controls.TextMenuItem;
import com.gmail.vitalatron.game.pyakout.core.Pyakout;
import com.gmail.vitalatron.game.visual.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenu extends Menu<TextMenuItem> implements Drawable {

    public static final int MENU_ITEM_WIDTH = 120;

    public static final int MENU_ITEM_HEIGHT = 16;

    public static final int H_PADDING = 20;

    public static final int V_PADDING = 8;

    private static Font menuFont;

    private BufferedImage FADE_IMAGE;

    private Point location = new Point();

    private Color activeMenuColor = Color.WHITE;

    private Color inactiveMenuColor = Color.GRAY;

    private Color menuLinesColor = Color.WHITE;

    static {
        try {
            menuFont = Font.createFont(Font.TRUETYPE_FONT, MainMenu.class.getResourceAsStream("/fonts/hachicro.ttf"));
            menuFont = menuFont.deriveFont(16f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MainMenu(TextMenuItem rootMenu, Color backgroundColor) {
        super(rootMenu);
        initFadeImage(backgroundColor);
    }

    @Override
    public void next() {
        super.next();
    }

    @Override
    public void previous() {
        super.previous();
    }

    @Override
    public void select() {
        super.select();
    }

    @Override
    public void back() {
        super.back();
    }

    @Override
    public void draw(Graphics2D g) {
        // selection lines
        g.setColor(menuLinesColor);
        g.drawLine(location.x - MENU_ITEM_WIDTH - H_PADDING, location.y - MENU_ITEM_HEIGHT - 1,
                location.x + MENU_ITEM_WIDTH * 2 + H_PADDING - 1, location.y - MENU_ITEM_HEIGHT - 1);
        g.drawLine(location.x - MENU_ITEM_WIDTH - H_PADDING, location.y + 2,
                location.x + MENU_ITEM_WIDTH * 2 + H_PADDING - 1, location.y + 2);

        int i;
        // prev menu
        g.setColor(inactiveMenuColor);
        g.setFont(menuFont);
        if (currentMenu.getParent() != null) {
            i = -currentMenu.getParent().getChildren().indexOf(currentMenu);
            for (TextMenuItem menuItem : currentMenu.getParent().getChildren()) {
                int yOffset = i * (MENU_ITEM_HEIGHT + V_PADDING);
                drawMenuLabel(g, location.x - (MENU_ITEM_WIDTH + H_PADDING), location.y + yOffset, menuItem.getLabel());
                i++;
            }
        }

        // current menu
        g.setColor(activeMenuColor);
        i = -currentMenu.getChildren().indexOf(selectedMenuItem);
        for (TextMenuItem menuItem : currentMenu.getChildren()) {
            int yOffset = i * (MENU_ITEM_HEIGHT + V_PADDING);
            drawMenuLabel(g, location.x, location.y + yOffset, menuItem.getLabel());
            i++;
        }

        // next menu
        g.setColor(inactiveMenuColor);
        g.setFont(menuFont);
        i = 0;
        for (TextMenuItem menuItem : selectedMenuItem.getChildren()) {
            int yOffset = i * (MENU_ITEM_HEIGHT + V_PADDING);
            drawMenuLabel(g, location.x + MENU_ITEM_WIDTH + H_PADDING, location.y + yOffset, menuItem.getLabel());
            i++;
        }

        g.drawImage(FADE_IMAGE, location.x - (MENU_ITEM_WIDTH + H_PADDING), 0, null);
    }

    private void initFadeImage(Color bgColor) {
        int menuWidth = MENU_ITEM_WIDTH * 3 + H_PADDING * 2;
        int menuHeight = Pyakout.WINDOW_HEIGHT;
        FADE_IMAGE = new BufferedImage(menuWidth, menuHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage tmp = new BufferedImage(FADE_IMAGE.getWidth(), FADE_IMAGE.getHeight(), FADE_IMAGE.getType());
        Graphics2D g = tmp.createGraphics();
        for (int i = 0; i < MENU_ITEM_WIDTH; i++) {
            int alpha = (i < MENU_ITEM_WIDTH / 3)
                    ? 255
                    : 255 - (int) (255d * (i - MENU_ITEM_WIDTH / 3) / MENU_ITEM_WIDTH * 1.4);
            g.setColor(new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), alpha));
            g.drawLine(i, 0, i, menuHeight);
        }

        g = FADE_IMAGE.createGraphics();
        g.drawImage(tmp, 0, 0, FADE_IMAGE.getWidth(), FADE_IMAGE.getHeight(), null);
        g.drawImage(tmp,
                0, 0, FADE_IMAGE.getWidth(), FADE_IMAGE.getHeight(),
                FADE_IMAGE.getWidth(), FADE_IMAGE.getHeight(), 0, 0,
                null);
    }

    private void drawMenuLabel(Graphics2D g, int x, int y, String label) {
        FontMetrics fm = g.getFontMetrics();
        x += (MENU_ITEM_WIDTH - fm.stringWidth(label)) / 2;
        g.drawString(label, x, y);
    }

    public Point getLocation() {
        return location;
    }

    public void setActiveMenuColor(Color activeMenuColor) {
        this.activeMenuColor = activeMenuColor;
    }

    public void setInactiveMenuColor(Color inactiveMenuColor) {
        this.inactiveMenuColor = inactiveMenuColor;
    }

    public void setMenuLinesColor(Color menuLinesColor) {
        this.menuLinesColor = menuLinesColor;
    }
}

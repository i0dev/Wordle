package com.i0dev.tilegame.tiles;

import com.i0dev.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BlankTile extends Tile {
    public BlankTile(int id) {
        super(Assets.blank, id);
    }


    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(Assets.blank, x, y, 50, 50, null);
    }
}

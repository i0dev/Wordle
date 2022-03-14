package com.i0dev.wordle.tiles;

import com.i0dev.wordle.gfx.Assets;

import java.awt.*;

public class Background extends Tile {
    public Background(int id) {
        super(Assets.background, id);
    }


    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(Assets.background, 0, 0, 720, 720, null);
    }
}

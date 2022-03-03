package com.i0dev.tilegame.states;

import com.i0dev.tilegame.Game;
import com.i0dev.tilegame.tiles.Tile;

import java.awt.*;

public class GameState extends State {


    public GameState(Game game) {
        super(game);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        Tile.background.render(g, 0, 0);
        for (int y = 200, i = 0; i < 6; y += 50, i++) {
            for (int x = -100; x <= 100; x += 50) {
                Tile.blankTile.render(g, (game.width / 2 - 25) - x, y);
            }
        }
    }
}

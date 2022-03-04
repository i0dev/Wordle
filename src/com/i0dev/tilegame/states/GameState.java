package com.i0dev.tilegame.states;

import com.i0dev.tilegame.Game;
import com.i0dev.tilegame.gfx.Assets;
import com.i0dev.tilegame.tiles.BoardTile;
import com.i0dev.tilegame.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameState extends State {


    public GameState(Game game) {
        super(game);
    }

    @Override
    public void tick() {

    }

    static BoardTile[][] board = new BoardTile[5][6];

    boolean loadedLocations = false;

    public void loadLocations() {
        for (int y = 200, i = 0; i < 6; y += 50, i++) {
            for (int x = -100, j = 0; j < 5; x += 50, j++) {
                if (j == 0 && i == 0) {
                    board[j][i] = new BoardTile(((game.width / 2 - 25) - x), y, Assets.a);
                } else
                    board[j][i] = new BoardTile(((game.width / 2 - 25) - x), y);
            }
        }
        loadedLocations = true;
    }

    @Override
    public void render(Graphics g) {
        if (!loadedLocations) loadLocations();
        for (BoardTile[] boardTiles : board) {
            for (BoardTile boardTile : boardTiles) {
                g.drawImage(boardTile.asset, boardTile.getXLoc(), boardTile.getYLoc(), 50, 50, null);
            }
        }
    }
}

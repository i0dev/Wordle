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
        for (int yLoc = 200, y = 0; y < 6; yLoc += 50, y++) {
            for (int xLoc = 100, x = 0; x < 5; xLoc -= 50, x++) {
                board[x][y] = new BoardTile(((game.width / 2 - 25) - xLoc), yLoc);
            }
        }
        loadedLocations = true;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        if (!loadedLocations) loadLocations();
        for (BoardTile[] boardTiles : board) {
            for (BoardTile boardTile : boardTiles) {
                if (boardTile != null)
                    g.drawImage(boardTile.asset, boardTile.getXLoc(), boardTile.getYLoc(), 50, 50, null);
            }
        }
    }
}

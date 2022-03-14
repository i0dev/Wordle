package com.i0dev.wordle.tiles;

import com.i0dev.wordle.gfx.Assets;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter
@NoArgsConstructor
public class BoardTile {

    public BoardTile(int x, int y) {
        xLoc = x;
        yLoc = y;
    }

    public BoardTile(int x, int y, Image asset) {
        xLoc = x;
        yLoc = y;
        this.asset = asset;
    }

    int xLoc, yLoc = 0;

    public Color color;
    public char letter = ' ';

    public Image asset = Assets.blank;
    public boolean inPlace = false;

    @Override
    public String toString() {
        return "[" + xLoc + "," + yLoc + "]";
    }
}

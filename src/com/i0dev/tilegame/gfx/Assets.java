package com.i0dev.tilegame.gfx;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
@Setter
public class Assets {

    public static BufferedImage background, blank;

    public static void init() {

        background = ImageLoader.loadImage("/textures/Wordle.png");
        blank = ImageLoader.loadImage("/textures/BlankTile.png");

    }
}

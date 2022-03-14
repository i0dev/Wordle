package com.i0dev.wordle;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Wordle!", 720, 720);
        game.start();
    }

}

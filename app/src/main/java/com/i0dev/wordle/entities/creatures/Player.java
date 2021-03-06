package com.i0dev.wordle.entities.creatures;

import com.i0dev.wordle.Game;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().up) yMove = -speed;
        if (game.getKeyManager().down) yMove = speed;
        if (game.getKeyManager().left) xMove = -speed;
        if (game.getKeyManager().right) xMove = speed;
    }

    @Override
    public void render(Graphics g) {
    }
}

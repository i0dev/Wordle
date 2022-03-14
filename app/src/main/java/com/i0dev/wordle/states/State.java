package com.i0dev.wordle.states;

import com.i0dev.wordle.Game;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class State {

    @Getter
    @Setter
    private static State currentState = null;

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    // CLASS
    public abstract void tick();

    public abstract void render(Graphics g);

}

package com.i0dev.tilegame.entities.creatures;

import com.i0dev.tilegame.entities.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0F;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        setSpeed(DEFAULT_SPEED);
        setHealth(DEFAULT_HEALTH);
        setXMove(0);
        setYMove(0);
    }

    public void move() {
        x += xMove;
        y += yMove;
    }

}

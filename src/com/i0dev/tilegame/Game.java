package com.i0dev.tilegame;

import com.i0dev.tilegame.display.Display;
import com.i0dev.tilegame.gfx.Assets;
import com.i0dev.tilegame.gfx.ImageLoader;
import com.i0dev.tilegame.gfx.SpriteSheet;
import com.i0dev.tilegame.input.KeyManager;
import com.i0dev.tilegame.states.GameState;
import com.i0dev.tilegame.states.MenuState;
import com.i0dev.tilegame.states.State;
import lombok.Getter;
import lombok.SneakyThrows;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

@Getter
public class Game implements Runnable {

    private Display display;
    public int height, width;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //states
    private State gameState;
    private State menuState;

    private KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.height = height;
        this.title = title;
        this.width = width;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);

        State.setCurrentState(gameState);
    }

    private void tick() {
        keyManager.tick();
        if (State.getCurrentState() != null) State.getCurrentState().tick();
    }


    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0, 0, width, height);
        // Draw Start

        if (State.getCurrentState() != null) State.getCurrentState().render(g);

        // Draw End
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000D / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }


    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @SneakyThrows
    public synchronized void stop() {
        if (!running) return;
        running = false;
        thread.join();
    }
}

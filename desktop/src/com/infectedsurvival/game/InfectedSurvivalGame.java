package com.infectedsurvival.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

 


public class InfectedSurvivalGame extends ApplicationAdapter {
    // Declare variables for game objects, such as the player and enemies
    private Player player;
    private Enemy[] enemies;
    private PowerUp[] powerUps; // Array of power-ups
    private SpriteBatch batch;
    private boolean isDragging;    

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InfectedSurvivalGame(), config);
    }
    
    @Override
    public void create() {
        // Initialize game objects and set up the SpriteBatch
        player = new Player();
        enemies = new Enemy[5]; // Initialize array of enemies
        powerUps = new PowerUp[10]; // Initialize array of power-ups
        batch = new SpriteBatch();

        // Populate the enemy and power-up arrays with actual instances of the Enemy and PowerUp classes
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(i);
        }
        for (int i = 0; i < powerUps.length; i++) {
            powerUps[i] = new PowerUp(i);
        }
        // Initialize isDragging to false
        isDragging = false;
    }

    @Override
    public void render() {
        // Update and render game objects
        player.update();
        for (Enemy enemy : enemies) {
            enemy.update();
        }
        for (PowerUp powerUp : powerUps) {
            powerUp.update();
        }

        // Begin drawing using the SpriteBatch
        batch.begin();
        player.render(batch);
        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }
        for (PowerUp powerUp : powerUps) {
            powerUp.render(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        // Dispose of the SpriteBatch and AssetManager objects when the game is closed
        batch.dispose();
        assetManager.dispose();
    }

    private void updatePlayer() {
        // Handle player input using mouse drag
        if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
            // If the left mouse button is pressed, check if the player is currently dragging the character
            if (isDragging) {
                // If the player is dragging the character, update the character's position to the mouse position
                player.setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            } else {
                // If the player is not dragging the character, check if the mouse position is within the character's bounds
                if (player.getBounds().contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                    // If the mouse position is within the character's bounds, start dragging the character
                    isDragging = true;
                }
            }
        } else {
            // If the left mouse button is not pressed, stop dragging the character
            isDragging = false;
        }
    }
}

package com.infectedsurvival.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    // Declare variables for player attributes, such as position, health, and magic and skills
    private Vector2 position;
    private int health;
    private boolean hasMagic;
    private boolean hasSkill;
    private Texture playerTexture;
    private boolean beingDragged;
    private Vector2 dragAnchor;

    public Player(AssetLoader assetLoader) {
        // Initialize player attributes and retrieve the player texture from the AssetLoader
        position = new Vector2(0, 0);
        health = 100;
        hasMagic = false;
        hasSkill = false;
        playerTexture = assetLoader.getAssetManager().get("sprites/characters/Player_01.png", Texture.class);
        beingDragged = false;
        dragAnchor = new Vector2();
    }

    public void update() {
        // Update player attributes, such as position and health, based on player input and game logic
    }

    public void render(SpriteBatch batch) {
        // Draw the player texture on the screen using the SpriteBatch
        batch.draw(playerTexture, position.x, position.y);
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // Check if the player is touching the character
        if (screenX >= position.x && screenX <= position.x + playerTexture.getWidth() &&
            screenY >= position.y && screenY <= position.y + playerTexture.getHeight()) {
            // Set the drag anchor and flag the player as being dragged
            dragAnchor.set(screenX, screenY);
            beingDragged = true;
            return true;
        }
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // Check if the player is being dragged
        if (beingDragged) {
            // Update the player's position based on the drag distance
            position.x += screenX - dragAnchor.x;
            position.y += screenY - dragAnchor.y;
            // Update the drag anchor
            dragAnchor.set(screenX, screenY);
            return true;
        }
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // Check if the player was being dragged
        if (beingDragged) {
            // Flag the player as no longer being dragged
            beingDragged = false;
            return true;
        }
        return false;
    }
}

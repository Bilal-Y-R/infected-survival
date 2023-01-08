package com.infectedsurvival.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy {
// Declare variables for enemy attributes, such as position, health, and speed
private float x, y;
private int health;
private float speed;
private Texture enemyTexture;
private Animation<TextureRegion> animation;

public Enemy(AssetLoader assetLoader, int enemyType) {
    // Initialize enemy attributes and retrieve the enemy texture from the AssetLoader based on the enemy type
    x = 0;
    y = 0;
    health = 100;
    speed = 1; // Initialize the enemy speed to a default value of 1
    enemyTexture = assetLoader.getAssetManager().get("sprites/characters/Enemy_0" + enemyType + ".png", Texture.class);
}

public void update() {
    // Update enemy attributes, such as position and health, based on enemy AI and game logic
}

public void render(SpriteBatch batch) {
    // Draw the enemy texture on the screen using the SpriteBatch
    batch.draw(enemyTexture, x, y);
}

public void setSpeed(float newSpeed) {
    // Set the enemy's speed to the specified value
    speed = newSpeed;
}

public float getSpeed() {
    // Return the enemy's current speed
    return speed;
}

public void chasePlayer(Player player) {
    // Update the enemy's position to chase the player based on the enemy's AI and speed
}

public void attackPlayer(Player player) {
    // Perform actions to attack the player, such as reducing the player's health
}
}

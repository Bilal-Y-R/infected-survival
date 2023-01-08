package com.infectedsurvival.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Map;
import java.util.HashMap;

public class AssetLoader {
    private AssetManager assetManager;
    private static final String SPELL_NAME = "Spell_Explosion_01";

    public AssetLoader() {
        // Create an AssetManager object
        assetManager = new AssetManager();

        // Load assets with the AssetManager
        assetManager.load("sprites/characters/Player_01.png", Texture.class);
        assetManager.load("sprites/enemies/Enemy_01.png", Texture.class);
        assetManager.load("sprites/enemies/Enemy_02.png", Texture.class);
        assetManager.load("sprites/enemies/Enemy_03.png", Texture.class);
        assetManager.load("sprites/enemies/Enemy_04.png", Texture.class);
        assetManager.load("sprites/enemies/Enemy_05.png", Texture.class);
        assetManager.load("sprites/backgrounds/Lands/Land_Grass.jpg", Texture.class);

        // Load the explosion texture regions using the AssetManager
        for (int i = 1; i <= 10; i++) {
            assetManager.load("sprites/magic spells/" + SPELL_NAME + "/Explosion_" + i + ".png", Texture.class);
        }

        // Wait for the assets to finish loading
        assetManager.finishLoading();

        // Create a TextureRegion array to store the texture regions in the order that they should be played
        TextureRegion[] explosionFrames = new TextureRegion[10];

        for (int i = 0; i < 10; i++) {
            explosionFrames[i] = new TextureRegion(assetManager.get("sprites/magic spells/" + SPELL_NAME + "/Explosion_" + (i+1) + ".png", Texture.class));
        }

        // Create an Animation object using the TextureRegion array
        Animation<TextureRegion> explosionAnimation = new Animation<>(0.1f, explosionFrames);

        // Wait for all assets to finish loading
        assetManager.finishLoading();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void dispose() {
        // Dispose of the AssetManager object when it is no longer needed
        assetManager.dispose();
    }
}

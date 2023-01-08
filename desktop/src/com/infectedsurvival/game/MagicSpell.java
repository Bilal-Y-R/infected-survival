package com.infectedsurvival.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class MagicSpell {
    // Declare variables for magic spell attributes, such as name, damage, and effect
    private String name;
    private int damage;
    private int effect;
    private float castInterval; // interval between automatic casts, in seconds
    private float elapsedTime; // elapsed time since last automatic cast
    private Animation<TextureRegion> animation; // animation for spell casting
    private TextureRegion currentFrame; // current frame of the animation
    private float animationTime; // elapsed time for the animation

    public MagicSpell(float castInterval, Animation<TextureRegion> animation) {
        // Initialize magic spell attributes
        name = "";
        damage = 0;
        effect = 0;
        this.castInterval = castInterval;
        elapsedTime = 0;
        this.animation = animation;
        currentFrame = animation.getKeyFrame(0);
        animationTime = 0;
    }

    public void update(float delta) {
        // Update elapsed time and check if it's time to automatically cast the spell
        elapsedTime += delta;
        if (elapsedTime >= castInterval) {
            elapsedTime = 0;
            cast();
        }

        // Update the animation
        animationTime += delta;
        currentFrame = animation.getKeyFrame(animationTime);
    }

    public void cast() {
        // Perform magic spell actions, such as applying damage or a special effect
    }
}

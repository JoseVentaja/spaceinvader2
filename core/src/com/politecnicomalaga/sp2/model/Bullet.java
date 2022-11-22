package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Bullet extends Actor {

    private final Animation<TextureRegion> skin;

    public Bullet(float positionX, float positionY) {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions(AssetsManager.ENEMY_SHOT), Animation.PlayMode.LOOP);
        this.setBounds(0, 0, SettingsManager.sizeBulletWIDTH, SettingsManager.sizeBulletHEIGHT);
        this.setX(positionX);
        this.setY(positionY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        float x = getX() + SettingsManager.ALLY_CENTER - SettingsManager.allyBulletCenter;
        float y = getY() + SettingsManager.ALLY_HEIGHT;
        if (getY() < SettingsManager.SCREEN_HEIGHT) {
            this.setY(getY() + SettingsManager.speedBullet);
            batch.draw(currentFrame, x, y, SettingsManager.sizeBulletWIDTH, SettingsManager.sizeBulletHEIGHT);
        }
    }
}
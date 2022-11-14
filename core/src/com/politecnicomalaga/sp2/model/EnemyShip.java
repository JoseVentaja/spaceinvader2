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

public class EnemyShip extends Actor {

    private final Animation<TextureRegion> skin;

    public EnemyShip() {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions(AssetsManager.ENEMY_SPRITES), Animation.PlayMode.LOOP);
        // Hacer variables de las rutas en AssetManager
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, SettingsManager.ENEMY_WIDTH, SettingsManager.ENEMY_HEIGHT);
    }
}

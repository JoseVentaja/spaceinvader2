package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.managers.ShootManager;

public class PlayerSpaceShip extends Actor {

    private final Animation<TextureRegion> skin;
    private final Stage baseStage;
    private final ShootManager Shooters;
    private float shootTime = 0;

    public PlayerSpaceShip(Stage baseStage) {
        super();
        Shooters = ShootManager.getSingleton();
        this.baseStage = baseStage;
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions(AssetsManager.SPACESHIP_SPRITES), Animation.PlayMode.LOOP);
        this.setBounds(0, 0, SettingsManager.ALLY_WIDTH, SettingsManager.ALLY_HEIGHT);
        this.setX(SettingsManager.positionshipX - SettingsManager.ALLY_CENTER);
        this.setY(SettingsManager.positionshipY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, getX(), getY(), SettingsManager.ALLY_WIDTH, SettingsManager.ALLY_HEIGHT);
        shootTime += 1;
        if (shootTime >= SettingsManager.tiempoEntreDisparos) {
            shootTime -= SettingsManager.tiempoEntreDisparos;
            baseStage.addActor(Shooters.shootCreate(getX(), getY()));
        }
    }
}

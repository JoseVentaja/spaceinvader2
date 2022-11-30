package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Fondo extends Actor {
    private Texture skin=new Texture(AssetsManager.FONDO);

    public Fondo(float positionX, float positionY) {
        super();
        this.skin = skin;
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));

        this.setBounds(0, 0, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
        this.setX(positionX);
        this.setY(positionY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float x = 0;
        float y =0;
        batch.draw(skin, x, y, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);

    }
}

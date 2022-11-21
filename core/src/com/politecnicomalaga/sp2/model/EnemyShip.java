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
import com.politecnicomalaga.sp2.managers.ShootManager;

public class EnemyShip extends Actor {

    private final Animation<TextureRegion> skin;
    private ShootManager shooters = ShootManager.getSingleton();
    public EnemyShip() {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        skin = new Animation<TextureRegion>(SettingsManager.SPEED, atlas.findRegions(AssetsManager.ENEMY_SPRITES), Animation.PlayMode.LOOP);
        this.setBounds(0, 0,SettingsManager.ENEMY_WIDTH,SettingsManager.ENEMY_HEIGHT);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for(int i = 0; i<shooters.getListBullet().size();i++){
            if(this.getX()+SettingsManager.ENEMY_CENTER>=shooters.getListBullet().get(i).getX()&&this.getX()-SettingsManager.ENEMY_CENTER<=shooters.getListBullet().get(i).getX()){
                if(this.getY()-SettingsManager.ALLY_HEIGHT<=shooters.getListBullet().get(i).getY()){
                    this.setVisible(false);
                    shooters.deadShoot(shooters.getListBullet().get(i),i);
                }

            };
        }

        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY(),SettingsManager.ENEMY_WIDTH,SettingsManager.ENEMY_HEIGHT);


    }


}

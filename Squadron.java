package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Squadron {

    private Array<EnemyShip> troops;
    private int posX;

    public Squadron(Stage baseStage) {
        //Initiate the arraylist
        troops = new Array<EnemyShip>();
        posX = SCREEN_WIDTH / (N_ENEMIES_PER_SQUAD + 1);
        posX = posX - ENEMY_CENTER;

        //We have to create all the squadrons
        for (int i = 0; i < N_ENEMIES_PER_SQUAD; i++) {
            EnemyShip newEnemy = new EnemyShip();
            baseStage.addActor(newEnemy);
            posX = posX + ENEMY_WIDTH;
            //SquadronPosition
            troops.add(newEnemy);
        }


    }

    public void draw(Stage baseStage) {
        for (EnemyShip enemy : troops) {
            enemy.draw(baseStage);

        }
    }
}

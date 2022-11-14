package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Squadron {

    private Array<EnemyShip> troops;
    private int posX, additionPosX;

    public Squadron(Stage baseStage, int posy) {
        //Initiate the arraylist
        troops = new Array<EnemyShip>();
        additionPosX = SettingsManager.SCREEN_WIDTH / (SettingsManager.N_ENEMIES_PER_SQUAD + 1);
        posX = additionPosX - SettingsManager.ENEMY_CENTER;

        //We have to create all the squadrons
        for (int i = 0; i < SettingsManager.N_ENEMIES_PER_SQUAD; i++) {
            EnemyShip newEnemy = new EnemyShip();
            newEnemy.setX(posX);
            newEnemy.setY(posy);
            baseStage.addActor(newEnemy);
            posX = posX + additionPosX;
            //SquadronPosition
            troops.add(newEnemy);
        }
    }


}
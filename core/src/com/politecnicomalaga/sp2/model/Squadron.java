package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.managers.ShootManager;

public class Squadron {

    private final Array<EnemyShip> troops;
    private int posX;
    private final int additionPosX;
    private final ShootManager shooters = ShootManager.getSingleton();
    private float shootTime = 0;
    private Stage stage;

    public Squadron(Stage baseStage, int posy) {
        //Initiate the arraylist
        this.stage=baseStage;
        troops = new Array<EnemyShip>();
        additionPosX = SettingsManager.SCREEN_WIDTH / (SettingsManager.N_ENEMIES_PER_SQUAD + 1);
        posX = additionPosX - SettingsManager.ENEMY_CENTER;

        //We have to create all the squadrons
        for (int i = 0; i < SettingsManager.N_ENEMIES_PER_SQUAD; i++) {
            EnemyShip newEnemy = new EnemyShip(this);
            newEnemy.setX(posX);
            newEnemy.setY(posy);
            baseStage.addActor(newEnemy);
            posX = posX + additionPosX;
            //SquadronPosition
            troops.add(newEnemy);
        }
    }
    public void RandomShoot(){
        int enemyShooting = (int) (Math.random()*SettingsManager.N_ENEMIES_PER_SQUAD);
        if(troops.get(enemyShooting).isVisible()){
            int enemyShootingX=(int) troops.get(enemyShooting).getX();
            int enemyShootingY= (int) troops.get(enemyShooting).getY();
            shootTime += 1;
            if (shootTime >= SettingsManager.tiempoEntreDisparosEnemy) {
                shootTime -= SettingsManager.tiempoEntreDisparosEnemy;
                stage.addActor(shooters.shootCreate(enemyShootingX,enemyShootingY, false));
            }
        }

    }
}
package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Battalion {
    private final Array<Squadron> battalion;
    private final int distanceBetweenSquadrons;
    private int posY;

    public Battalion(Stage baseStage) {
        //Initiate the arraylist
        battalion = new Array<Squadron>();
        distanceBetweenSquadrons = (SettingsManager.SCREEN_HEIGHT / 2) / SettingsManager.N_SQUADS_PER_BATTALION;
        posY = SettingsManager.SCREEN_HEIGHT - SettingsManager.ENEMY_HEIGHT;

        //Creamos los escuadrones
        for (int i = 0; i < SettingsManager.N_SQUADS_PER_BATTALION; i++) {
            Squadron squadron = new Squadron(baseStage, posY);
            posY = posY - distanceBetweenSquadrons;
            battalion.add(squadron);
        }
    }
    //PosicionBatallon

}
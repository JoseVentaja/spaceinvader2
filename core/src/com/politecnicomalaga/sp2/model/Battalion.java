package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class Battalion {
    private Array<Squadron> squadrons;
    private int PosY;

    public Battalion(Stage baseStage) {
        //Initiate the arraylist
        squad = new Array<Squadron>();
        distanceBetweenSquadrons = (settingsManager.Height / 2) / settingsManager.N_SQUADS_PER_BATTALION;


        //Creamos los escuadrones
        for (i = 0; i < settingsManager.N_SQUADS_PER_BATTALION; i++) {
            squadron = new Squadron((short) settingsManager.SCREEN_WIDTH, settingsManager.SCREENHEIGHT - distanceBetweenSquadrons * (i + 1), miDibujoNormal, miDibujoExplosion, miImg2, dibujoDisparoEnemigo);
            squad .add(squadron);
        }

        //We have to create the squad
        for (int i = 0; i < numberOfSquadronForBatallion; i++) {
            Squadron newSquad = new Squadron(baseStage);
        }
        //PosicionBatallon
        public void draw(){
            for(Squadron squadron : squad){
            squadron.draw(baseStage);
            }
        }


    }

}

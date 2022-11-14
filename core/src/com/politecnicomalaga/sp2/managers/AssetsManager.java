package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetsManager {
    //Constantes
    public static final String NUMBERS_SPRITES = "numbers/digito";
    public static final String NUMBERS_EXT_SPRITES =".png";
    public static final String SPACESHIP_SPRITES ="player";
    public static final String ENEMY_SPRITES ="enemy";
    public static final String ALLY_SHOT ="ally_shot";
    public static final String ENEMY_SHOT ="enemy_shot";
    public static final String EXPLOSION_SPRITES ="explosion";
    public static final String ATLAS_FILE="sp2.atlas";
    private static Skin textSkin;


//    public static Skin getTextSkin(){
//        if(textSkin==null){
//            textSkin=new Skin(Gdx.files.internal("glassy-ui.json"));
//        }
//        return textSkin;
//    }

}

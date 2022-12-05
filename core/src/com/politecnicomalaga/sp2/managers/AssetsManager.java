package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetsManager {
    //Constantes
    public static final String NUMBERS_SPRITES = "numbers/digito";
    public static final String NUMBERS_EXT_SPRITES = ".png";
    public static final String SPACESHIP_SPRITES = "player";
    public static final String ENEMY_SPRITES = "enemy";
    public static final String ALLY_SHOT = "disparo_aliado";
    public static final String ENEMY_SHOT = "enemy_shot";
    public static final String EXPLOSION_SPRITES = "explosion";
    public static final String BUTTON = "button";
    public static final String TITLE_LABEL = "SPACE-INVADER";
    public static final String ATLAS_FILE = "assets.atlas";
    public static final String NOMBRE1 = "ALVARO ALGARRA CEREZO";
    public static final String NOMBRE2 = "JAVIER FROCHOSO GARCIA";
    public static final String NOMBRE3 = "JAVIER BOTELLA MUNOZ";
    public static final String NOMBRE4 = "JOSE VENTAJA ANDRADE";
    public static final String NOMBRE5 = "LEANDRO PAGANO MARQUEZ";
    public static final String BIG_FONT = "big-black";
    public static final String FONDO = "fondo.jpg";
    private static Skin textSkin;

    public static Skin getTextSkin() {
        if (textSkin == null) {
            textSkin = new Skin(Gdx.files.internal("glassy-ui.json"));
        }
        return textSkin;
    }
}

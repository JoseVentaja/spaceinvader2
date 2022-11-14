package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Gdx;

//No se ha tocado nada en la primera fase
public class GameManager {
    private float gameTime;
    private static GameManager singleton;

    public static GameManager getSingleton() {
        if (singleton == null) {
            singleton = new GameManager();
        }
        return singleton;
    }

    public float getGameTime() {
        return gameTime;
    }

    public float additionGameTime() {
        gameTime += Gdx.graphics.getDeltaTime();
        return gameTime;
    }
}

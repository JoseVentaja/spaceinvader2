package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.politecnicomalaga.sp2.model.GameOver;
import com.politecnicomalaga.sp2.model.SettingScreen;
import com.politecnicomalaga.sp2.view.CreditScreen;
import com.politecnicomalaga.sp2.view.GameScreen;
import com.politecnicomalaga.sp2.view.StartScreen;

public class ScreensManager extends ScreenAdapter {

    private static ScreensManager singleton;

    private Game game;

    public static ScreensManager getSingleton() {
        if (singleton == null) {
            singleton = new ScreensManager();
        }
        return singleton;
    }

    public enum SCREENS {
        GAME_SCREEN, GAMEOVER_SCREEN ,SETTINGS_SCREEN,CREDITS_SCREEN,START_SCREEN
    }

    public Screen getScreen(Game game, SCREENS screenToGet) {
        Screen newScreen = null;
        switch (screenToGet) {
            case GAME_SCREEN:
                newScreen = new GameScreen(game);
                break;
            case GAMEOVER_SCREEN:
                newScreen = new GameOver(game);
                break;
            case SETTINGS_SCREEN:
                newScreen = new SettingScreen(game);
                break;
            case CREDITS_SCREEN:
                newScreen = new CreditScreen(game);
                break;
            case START_SCREEN:
                newScreen = new StartScreen(game);
                break;
        }
        return newScreen;
    }
}
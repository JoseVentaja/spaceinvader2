package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.politecnicomalaga.sp2.view.GameScreen;

public class ScreensManager extends ScreenAdapter {

    private static ScreensManager singleton;
    private Screen GAME_SCREEN;
    private Screen GAMEOVER_SCREEN;
    private Game game;

    public static ScreensManager getSingleton() {
        if (singleton == null) {
            singleton = new ScreensManager();
        }
        return singleton;
    }

    public enum SCREENS {
        GAME_SCREEN, GAMEOVER_SCREEN
    }

    public Screen getScreen(Game game, SCREENS screenToGet) {
        Screen newScreen = null;
        switch (screenToGet) {
            case GAME_SCREEN:
                newScreen = new GameScreen(game);
                break;
            case GAMEOVER_SCREEN:
                newScreen = new GameScreen(game);
                break;
        }
        return newScreen;
    }
}


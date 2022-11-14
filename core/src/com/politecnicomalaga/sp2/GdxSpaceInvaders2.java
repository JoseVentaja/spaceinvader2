package com.politecnicomalaga.sp2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class GdxSpaceInvaders2 extends Game {
    SpriteBatch batch;
    OrthographicCamera camera;
    Screen myScreen;
    ScreensManager myScreenManager;
    GameManager myGame;

    @Override
    public void create() {
        batch = new SpriteBatch();
        myScreenManager = ScreensManager.getSingleton();
        myGame = GameManager.getSingleton();
        myScreen = myScreenManager.getScreen(this, ScreensManager.SCREENS.GAME_SCREEN);
        this.setScreen(myScreen);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        this.getScreen().render(myGame.additionGameTime());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}


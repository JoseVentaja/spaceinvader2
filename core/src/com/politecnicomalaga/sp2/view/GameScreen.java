package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.model.Battalion;
import com.politecnicomalaga.sp2.model.PlayerSpaceShip;

/**
 * GameScreen Class. Where we play the game and we have the main battle
 * Created by Andrés Alcaraz Rey on 5/11/2022.
 */
public class GameScreen implements Screen {

    private final Stage stage;
    private final Game game;
    private final Battalion empire;
    private final PlayerSpaceShip heroShip;

    public GameScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());
        //Esta orden se puede poner también en el show()
        Gdx.input.setInputProcessor(stage);

        //We add the battalion, "the empire"
        empire = new Battalion(stage);

        //We add the main player
        heroShip = new PlayerSpaceShip(stage);
        heroShip.addListener(new InputListener() {
            public void clicked(InputEvent event, float x, float y, int pointer, int button) {
                //return true;
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                //if (heroShip.getX()<event.getStageX() && heroShip.getX()+ SettingsManager.ALLY_WIDTH>event.getStageX() && heroShip.getY()<event.getStageY() && heroShip.getY()+SettingsManager.ALLY_HEIGHT>event.getStageY()){}
                if (event.getStageX() > 0 && 1024 - SettingsManager.ALLY_WIDTH > event.getStageX()) {
                    heroShip.setX(event.getStageX());
                }
            }
        });
        heroShip.setTouchable(Touchable.enabled);
        stage.addActor(heroShip);
    }

    @Override
    public void show() {
        Gdx.app.log("MainScreen", "show");

    }

    public void render(float delta) {
        //jave 8
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
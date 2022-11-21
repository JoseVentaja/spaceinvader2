package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;

public class GameoverScreen implements Screen {
private Stage stage;
private Game game;
    public GameoverScreen(final Game aGame){
        game=aGame;
        stage=new Stage(new ScreenViewport());
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        Gdx.input.setInputProcessor(stage);

        //Título
        Label titulo = new Label("Game Over", AssetsManager.getTextSkin(), "Big Black");
        titulo.setAlignment(Align.center);
        titulo.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        titulo.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);

        //Botón reintentar
        TextButton RetryButton =new TextButton((LanguageManager.getSingleton().getString(LanguageManager.START)),AssetsManager.getTextSkin(),AssetsManager.BUTTON);
        RetryButton.setWidth(Gdx.graphics.getWidth()/2);
        RetryButton.setPosition(Gdx.graphics.getWidth()/2-RetryButton.getWidth()/2,Gdx.graphics.getHeight()-RetryButton.getHeight()*4);
        RetryButton.addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game,ScreensManager.SCREENS.GAME_SCREEN));
            }
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(RetryButton);

        //Botón salir
        TextButton ExitButton =new TextButton((LanguageManager.getSingleton().getString(LanguageManager.START)),AssetsManager.getTextSkin(),AssetsManager.BUTTON);
        ExitButton.setWidth(Gdx.graphics.getWidth()/2);
        ExitButton.setPosition(Gdx.graphics.getWidth()/2-ExitButton.getWidth()/2,Gdx.graphics.getHeight()-ExitButton.getHeight()*6);
        ExitButton.addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
            }
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(ExitButton);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
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

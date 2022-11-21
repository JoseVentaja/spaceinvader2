package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;

public class CreditsScreen implements Screen {
private Stage stage;
private Game game;
    public CreditsScreen(final Game aGame){
        game=aGame;
        stage=new Stage(new ScreenViewport());
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        Gdx.input.setInputProcessor(stage);

        //Título
        Label titulo = new Label(LanguageManager.getSingleton().getString(LanguageManager.CREDITS), AssetsManager.getTextSkin(), "Big Black");
        titulo.setAlignment(Align.center);
        titulo.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        titulo.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);

        //Nombre 1
        Label n1 = new Label(AssetsManager.NOMBRE1, AssetsManager.getTextSkin(), "Big Black");
        n1.setAlignment(Align.center);
        n1.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        n1.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);

        //Nombre 2
        Label n2 = new Label(AssetsManager.NOMBRE2, AssetsManager.getTextSkin(), "Big Black");
        n2.setAlignment(Align.center);
        n2.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        n2.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);

        //Nombre 3
        Label n3 = new Label(AssetsManager.NOMBRE3, AssetsManager.getTextSkin(), "Big Black");
        n3.setAlignment(Align.center);
        n3.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        n3.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);

        //Nombre 4
        Label n4 = new Label(AssetsManager.NOMBRE4, AssetsManager.getTextSkin(), "Big Black");
        n4.setAlignment(Align.center);
        n4.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        n4.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);

        //Nombre 5
        Label n5 = new Label(AssetsManager.NOMBRE5, AssetsManager.getTextSkin(), "Big Black");
        n5.setAlignment(Align.center);
        n5.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        n5.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);
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

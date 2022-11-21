package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;

public class CreditScreen implements Screen {

    private Stage stage;
    private Game game;
    public CreditScreen(Game aGame) {

        game = aGame;
        stage = new Stage(new ScreenViewport());


        Gdx.input.setInputProcessor(stage);

        Label nombre1 = new Label("", AssetsManager.getTextSkin(),AssetsManager.NOMBRE1);
        nombre1.setAlignment(Align.center);
        nombre1.setY(Gdx.graphics.getHeight()-nombre1.getHeight()*2);
        nombre1.setWidth(Gdx.graphics.getWidth());

        stage.addActor(nombre1);
        //-------------------------------------------------------------------------------------------------------------------------//

        Label nombre2 = new Label("", AssetsManager.getTextSkin(),AssetsManager.NOMBRE2);
        nombre2.setAlignment(Align.center);
        nombre2.setY(Gdx.graphics.getHeight()-nombre2.getHeight()*4);
        nombre2.setWidth(Gdx.graphics.getWidth());

        stage.addActor(nombre2);

        //-------------------------------------------------------------------------------------------------------------------------//


        Label nombre3 = new Label("", AssetsManager.getTextSkin(),AssetsManager.NOMBRE3);
        nombre3.setAlignment(Align.center);
        nombre3.setY(Gdx.graphics.getHeight()-nombre3.getHeight()*6);
        nombre3.setWidth(Gdx.graphics.getWidth());

        stage.addActor(nombre3);

        //-------------------------------------------------------------------------------------------------------------------------//


        Label nombre4 = new Label("", AssetsManager.getTextSkin(),AssetsManager.NOMBRE4);
        nombre3.setAlignment(Align.center);
        nombre3.setY(Gdx.graphics.getHeight()-nombre3.getHeight()*8);
        nombre3.setWidth(Gdx.graphics.getWidth());

        stage.addActor(nombre4);

        //-------------------------------------------------------------------------------------------------------------------------//

        Label nombre5 = new Label("", AssetsManager.getTextSkin(),AssetsManager.NOMBRE5);
        nombre5.setAlignment(Align.center);
        nombre5.setY(Gdx.graphics.getHeight()-nombre5.getHeight()*10);
        nombre5.setWidth(Gdx.graphics.getWidth());

        stage.addActor(nombre5);



    }

    @Override
    public void show() {
        Gdx.app.log("CreditScreen","show");

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

    }
}

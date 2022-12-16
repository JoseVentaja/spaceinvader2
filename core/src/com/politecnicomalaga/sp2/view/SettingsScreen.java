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
import com.politecnicomalaga.sp2.model.Fondo;
import com.politecnicomalaga.sp2.model.PlayerSpaceShip;

import sun.net.ResourceManager;

public class SettingsScreen implements Screen {
    private final Stage stage;
    private final Game game;
    private PlayerSpaceShip naveAlidada;
    private ResourceManager rm;

    public SettingsScreen(final Game aGame) {
        game = aGame;

        stage = new Stage(new ScreenViewport());
        Fondo fondo=new Fondo(0,0);
        stage.addActor(fondo);
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        Gdx.input.setInputProcessor(stage);

        //Título
        Label titulo = new Label(LanguageManager.getSingleton().getString(LanguageManager.SETTINGS), AssetsManager.getTextSkin(), AssetsManager.BIG_FONT);
        titulo.setAlignment(Align.center);
        titulo.setY(Gdx.graphics.getHeight() - titulo.getHeight() * 2);
        titulo.setWidth(Gdx.graphics.getWidth());
        stage.addActor(titulo);

        //Botón español
        TextButton SpanishButton = new TextButton((LanguageManager.getSingleton().getString(LanguageManager.SPANISH_BUTTON)), AssetsManager.getTextSkin());
        SpanishButton.setWidth(Gdx.graphics.getWidth() / 2);
        SpanishButton.setPosition(Gdx.graphics.getWidth() / 2 - SpanishButton.getWidth() / 2, Gdx.graphics.getHeight() - SpanishButton.getHeight() * 3);
        SpanishButton.addListener(new InputListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                LanguageManager.getSingleton().setString(LanguageManager.lang.SPANISH);
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.START_SCREEN));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(SpanishButton);

        //Botón inglés
        TextButton EnglishButton = new TextButton((LanguageManager.getSingleton().getString(LanguageManager.ENGLISH_BUTTON)), AssetsManager.getTextSkin());
        EnglishButton.setWidth(Gdx.graphics.getWidth() / 2);
        EnglishButton.setPosition(Gdx.graphics.getWidth() / 2 - EnglishButton.getWidth() / 2, Gdx.graphics.getHeight() - EnglishButton.getHeight() * 4.5f);
        EnglishButton.addListener(new InputListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                LanguageManager.getSingleton().setString(LanguageManager.lang.ENGLISH);
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.SETTINGS_SCREEN));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(EnglishButton);

        //Botón volver
        TextButton ReturnButton = new TextButton((LanguageManager.getSingleton().getString(LanguageManager.GO_BACK)), AssetsManager.getTextSkin());
        ReturnButton.setWidth(Gdx.graphics.getWidth() / 2);
        ReturnButton.setPosition(Gdx.graphics.getWidth() / 2 - ReturnButton.getWidth() / 2, Gdx.graphics.getHeight() - ReturnButton.getHeight() * 6);
        ReturnButton.addListener(new InputListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.START_SCREEN));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(ReturnButton);

    }

    @Override
    public void show() {
        Gdx.app.log("StartScreen", "show");
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

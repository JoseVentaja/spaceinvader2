package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.model.Fondo;

import javax.swing.ImageIcon;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;

public class StartScreen implements Screen {

    private final Stage stage;
    private final Game game;

    public StartScreen(final Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());
        SpriteBatch sb=new SpriteBatch();
        Fondo fondo=new Fondo(0,0);
        stage.addActor(fondo);
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));

        //-------------------------------------------------------------------------------------------------------------------------//



//-------------------------------------------------------------------------------------------------------------------------//

        Label title = new Label(AssetsManager.TITLE_LABEL, AssetsManager.getTextSkin(), AssetsManager.BIG_FONT);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight() - title.getHeight() * 2);
        title.setWidth(Gdx.graphics.getWidth());

        stage.addActor(title);

//-------------------------------------------------------------------------------------------------------------------------//

        TextButton StartButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.START), AssetsManager.getTextSkin());
        StartButton.setWidth(Gdx.graphics.getWidth() / 2);
        StartButton.setPosition(Gdx.graphics.getWidth() / 2 - StartButton.getWidth() / 2, Gdx.graphics.getHeight() - StartButton.getHeight() * 3);
        StartButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.GAME_SCREEN));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(StartButton);

        //-------------------------------------------------------------------------------------------------------------------------//

        TextButton settingsButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.SETTINGS), AssetsManager.getTextSkin());
        settingsButton.setWidth(Gdx.graphics.getWidth() / 2);
        settingsButton.setPosition(Gdx.graphics.getWidth() / 2 - settingsButton.getWidth() / 2, Gdx.graphics.getHeight() - settingsButton.getHeight() * 4.5f);
        settingsButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.SETTINGS_SCREEN));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(settingsButton);

        //-------------------------------------------------------------------------------------------------------------------------//

        TextButton CreditButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.CREDITS), AssetsManager.getTextSkin());
        CreditButton.setWidth(Gdx.graphics.getWidth() / 2);
        CreditButton.setPosition(Gdx.graphics.getWidth() / 2 - CreditButton.getWidth() / 2, Gdx.graphics.getHeight() - CreditButton.getHeight() * 6);
        CreditButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.CREDITS_SCREEN));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(CreditButton);
    }

    @Override
    public void show() {
        Gdx.app.log("StartScreen", "show");
        Gdx.input.setInputProcessor(stage);
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
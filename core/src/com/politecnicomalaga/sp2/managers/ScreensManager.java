package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

import org.graalvm.compiler.phases.common.NodeCounterPhase;

public class ScreensManager implements Screen    {

       private static ScreensManager singleton;
       private Stage stage;
       private Screen GAME_SCREEN;

       public ScreensManager(){
         super();
       }

       public static ScreensManager getSingleton() {
           if (singleton == null) {
               singleton = new ScreensManager();
           }
           return singleton;
       }


    @Override
    public void show() {

           GAME_SCREEN.show();

    }

    @Override
    public void render(float delta) {

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


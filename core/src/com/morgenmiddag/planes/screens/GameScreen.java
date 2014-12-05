package com.morgenmiddag.planes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.morgenmiddag.planes.BgRenderer;

/**
 * Created by yuridesnaijer on 05-12-14.
 */
public class GameScreen implements Screen{

    SpriteBatch batch = new SpriteBatch();

    BgRenderer bgRenderer = new BgRenderer();

    @Override
    public void render(float delta) {

        bgRenderer.Update();

        Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        batch.begin();
        bgRenderer.Draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

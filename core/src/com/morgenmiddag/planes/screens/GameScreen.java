package com.morgenmiddag.planes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.morgenmiddag.planes.BgRenderer;
import com.morgenmiddag.planes.HUD;

/**
 * Created by yuridesnaijer on 05-12-14.
 */
public class GameScreen implements Screen{

    SpriteBatch batch = new SpriteBatch();
    BgRenderer bgRenderer = new BgRenderer();
    HUD hud = new HUD(this);

    private Viewport viewport;
    private Camera camera;

    public enum State {
        RUN,
        PAUSE,
        RESUME,
        STOP
    }

    private State state;

    public GameScreen(){

        state = State.RUN;

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(16, 9, camera);
    }

    @Override
    public void render(float delta) {

        switch (state){
            case RUN:
                bgRenderer.Update();

                break;
            case PAUSE:
//                System.out.println("PAUSE");
                break;
        }

        Gdx.graphics.getGL20().glClearColor( 1, 1, 1, 0 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        batch.begin();
        bgRenderer.draw(batch);
        hud.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

        state = State.PAUSE;
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

        batch.dispose();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

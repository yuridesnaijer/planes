package com.morgenmiddag.planes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by yuridesnaijer on 05-12-14.
 */
public class BgRenderer {

    private Texture bg1;
    private Sprite cloud;
    private Array<Vector2> cloudArray = new Array<Vector2>();
    private Array<Sprite> backgroundArray = new Array<Sprite>();
    private int speed = 2;
    private Random r = new Random();

    public BgRenderer(){
        bg1 = new Texture("bg1.png");

        for (int i = 0; i < 2; i++){
            backgroundArray.add(new Sprite(bg1, 0, 0, bg1.getWidth(), bg1.getHeight()));
            backgroundArray.get(i).setPosition(i * bg1.getWidth(), 0);
        }

        cloud = new Sprite(new Texture("cloud.png"));
    }

    public void draw(SpriteBatch batch){

        for (int i = 0; i < backgroundArray.size; i++){
            backgroundArray.get(i).draw(batch);
        }

        for (int i = 0; i < cloudArray.size; i++){
            batch.draw(cloud, cloudArray.get(i).x, cloudArray.get(i).y);
        }
    }

    public void Update(){

        for (int i = 0; i < backgroundArray.size; i++){
            Sprite bg = backgroundArray.get(i);
            float x = bg.getX();
            bg.setX(x -= speed);

            if (bg.getX() + bg.getWidth() < 1){
                bg.setX(i * bg.getWidth() + bg.getWidth());
            }
        }

        CreateCloud();

        if(cloudArray.size > 0){
            for (int i = 0; i < cloudArray.size; i++){
                if(cloudArray.get(i).x < 0 - cloud.getWidth()){
                    cloudArray.removeIndex(i);
                } else {
                    cloudArray.get(i).set(cloudArray.get(i).x -= 1.5f, cloudArray.get(i).y += 0.2f);
                }
            }
        }
    }

    public void CreateCloud(){
        if(r.nextInt(1000) < 2){
            cloudArray.add(new Vector2(Gdx.graphics.getWidth() + 10 ,0));
        }

    }
}

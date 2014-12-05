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
    private Vector2 bg1Position;
    private int speed = 2;
    private Random r = new Random();

    public BgRenderer(){
        bg1 = new Texture("bg1.png");
        bg1Position = new Vector2(0, 0);
        cloud = new Sprite(new Texture("cloud.png"));
    }

    public void Draw(SpriteBatch batch){
        batch.draw(bg1, bg1Position.x, bg1Position.y);
        for (int i = 0; i < cloudArray.size; i++){
            batch.draw(cloud, cloudArray.get(i).x, cloudArray.get(i).y);
        }
    }

    public void Update(){
        bg1Position.x -= speed;

        if (bg1Position.x < -1920){
            bg1Position.x = 0;
        }

        CreateCloud();
    }

    public void CreateCloud(){
        if(r.nextInt(1000) < 2){
            cloudArray.add(new Vector2(Gdx.graphics.getWidth() + 10 ,0));
        }
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
}

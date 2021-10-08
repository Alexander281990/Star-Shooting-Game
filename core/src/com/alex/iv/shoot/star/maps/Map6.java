package com.alex.iv.shoot.star.maps;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Map6 extends BaseActor {

    public Map6(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("background/space.png");
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setMaxSpeed(100);
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

        if (getX() + getWidth() > (getWorldBounds().width) * 6)
            setX((getWorldBounds().width) * 6 - getWidth());

        if ((getX() + getWidth() * 4) < 0 )
            setX((-getWorldBounds().width) * 4);
    }
}
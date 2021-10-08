package com.alex.iv.shoot.star.maps;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Map2 extends BaseActor {

    public Map2(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("background/fon4.png");
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setMaxSpeed(100);
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

        if (getX() + getWidth() > (getWorldBounds().width) * 2)
            setX((getWorldBounds().width) * 2 - getWidth());

        if ((getX() + getWidth() * 8) < 0 )
            setX((-getWorldBounds().width) * 8);

    }
}

package com.alex.iv.shoot.star.maps;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Map3 extends BaseActor {
    public Map3(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("background/fon5.png");
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setMaxSpeed(3000);
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

        if (getX() + getWidth() > (getWorldBounds().width) * 3)
            setX((getWorldBounds().width) * 3 - getWidth());

        if ((getX() + getWidth() * 7) < 0 )
            setX((-getWorldBounds().width) * 7);

    }
}

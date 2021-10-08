package com.alex.iv.shoot.star.maps;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Map5 extends BaseActor {
    public Map5(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("background/space.png");
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setMaxSpeed(3000);
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

        if (getX() + getWidth() > (getWorldBounds().width) * 5)
            setX((getWorldBounds().width) * 5 - getWidth());

        if ((getX() + getWidth() * 5) < 0 )
            setX((-getWorldBounds().width) * 5);

    }
}

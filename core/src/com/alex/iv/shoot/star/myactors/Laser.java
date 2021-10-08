package com.alex.iv.shoot.star.myactors;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Laser extends BaseActor {
    Laser(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("my_spaceship/laser.png");
        addAction(Actions.delay(2F));
        addAction(Actions.after(Actions.fadeOut(0.5F)));
        addAction(Actions.after(Actions.removeActor()));
        setSpeed(1000);
        setMaxSpeed(1000);
        setDeceleration(0);
        setAcceleration(400);
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

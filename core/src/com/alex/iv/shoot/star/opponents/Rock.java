package com.alex.iv.shoot.star.opponents;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;

public class Rock extends BaseActor {

    public Rock(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("opponents/rock.png");
        float random = MathUtils.random(30);
        addAction( Actions.forever( Actions.rotateBy(30 + random, 1) ) );
        setSpeed(100 + random);
        setMaxSpeed(100 + random);
        setDeceleration(0);
        setMotionAngle( MathUtils.random(180, 360) );
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        wrapAroundWorld();
    }

}

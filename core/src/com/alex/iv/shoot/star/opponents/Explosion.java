package com.alex.iv.shoot.star.opponents;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Explosion extends BaseActor {

    public Explosion(float x, float y, Stage s) {
        super(x,y,s);
        loadAnimationFromSheet("animations/explosion.png", 6, 6, 0.03f, false);
    }

    public void act(float dt) {
        super.act(dt);
        if ( isAnimationFinished() )
            remove();
    }

}

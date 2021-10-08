package com.alex.iv.shoot.star.maps;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Castle extends BaseActor {
    public Castle(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("buttons/zamok.png");
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

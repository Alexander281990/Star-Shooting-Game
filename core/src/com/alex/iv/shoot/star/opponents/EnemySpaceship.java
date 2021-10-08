package com.alex.iv.shoot.star.opponents;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class EnemySpaceship extends BaseActor {

    public EnemySpaceship(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("opponents/spaceship.png");
        setSize(100, 100);
        setSpeed(100);
        setMaxSpeed(400);
        setDeceleration(0); // замедление
        setMotionAngle(- 90); // заставляет двигаться обьект сверху в низ
        setBoundaryPolygon(8);
    }

    //////////////////////////////////

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

        // если вражеский звездолет достиг нижней части, то он удаляется
        if (getY() + Gdx.graphics.getHeight() < 0) {
            remove();
        }
    }
}

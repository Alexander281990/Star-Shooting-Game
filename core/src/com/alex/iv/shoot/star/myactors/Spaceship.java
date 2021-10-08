package com.alex.iv.shoot.star.myactors;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Spaceship extends BaseActor {
    public Spaceship(float x, float y, Stage s) {
        super(x, y, s);

        loadTexture( "my_spaceship/eps01.png" );
        //setSize(200, 150);
        setAcceleration(400); // ускорение
        //setMaxSpeed(400); // максимальная скорость // закоментирована, потому-что скорость присутствует в LevelScreen_1
        setDeceleration(800); // замедление
        setBoundaryPolygon(8);
    }

    // метод для стрельбы лазерами
    public void shoot() {
            com.alex.iv.shoot.star.myactors.Laser laser = new Laser(0, 0, this.getStage());
            laser.centerAtActor(this); // начальная координата пуль с центра звездолет
            laser.setMotionAngle(90); // заставляет лететь пули снизу в верх
        }

    //////////////////////////////////

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
    }

}

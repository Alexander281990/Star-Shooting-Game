package com.alex.iv.shoot.star.opponents;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;

public class FinishEnemySpaceship extends BaseActor {

    public ProgressBar finishEnemySpaceshipBar;

    public FinishEnemySpaceship(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("opponents/finishEnemySpaceship.png");
        setSize(300, 300);
        setBoundaryPolygon(8);

    }

    // метод для стрельбы лазерами
    public void shoot() {
        com.alex.iv.shoot.star.opponents.EnemyLaser enemyLaser = new EnemyLaser(0, 0, this.getStage());
        enemyLaser.positionAtActor(this); // начальная координата пуль с центра звездолет
        enemyLaser.setMotionAngle(-90); // заставляет лететь пули снизу в верх
    }


    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

    }
}

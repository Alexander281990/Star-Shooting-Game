package com.alex.iv.shoot.star.myactors;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Ground extends BaseActor {
    public Ground(float x, float y, Stage s) {
        super(x, y, s);
//        loadTexture("background/space.png"); // закоментированны, так как при создании будут разные картинки
//        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // закоментированны, так как при создании, без loadTexture, не отрисовывается размер(не знаю почему)
        setSpeed(100);
        setMotionAngle(- 90); // заставляет двигаться обьект сверху в низ
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

        // метод, который говорит, что одна картинка полностью переместилась с верху в низ, и запускает следующую картинку
        if (getY() + Gdx.graphics.getHeight() < 0) {
            moveBy(0, 2 * Gdx.graphics.getHeight());
        }
    }
}

package com.alex.iv.shoot.star;

import com.alex.iv.shoot.star.controllers.BaseActor;
import com.alex.iv.shoot.star.controllers.BaseGame;
import com.alex.iv.shoot.star.controllers.BaseScreen;
import com.alex.iv.shoot.star.controllers.LevelScreenMain;
import com.alex.iv.shoot.star.myactors.Ground;
import com.alex.iv.shoot.star.opponents.EnemySpaceship;
import com.alex.iv.shoot.star.opponents.Explosion;
import com.alex.iv.shoot.star.opponents.FinishEnemySpaceship;
import com.alex.iv.shoot.star.opponents.Rock;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;

public class LevelScreen_2 extends LevelScreenMain {

    private float random = MathUtils.random(10000);
    private float starTimer;
    private Label Time; // метка, которая отображает проигранное время
 ////////////////////////////////////////////////////////////////////////////
    private float starTimerFinishEnemySpaceship;// переменная, которая отсчитывает время до появления финального противника
    private int countFinishEnemySpaceship;// считает, сколько сбито финальных противников
    private float enemyLaserTime;// переменная, которая отсчитывает время до выстрела финального противника
    private float enemyLaserTimeInterval; // переменная, которая отсчитывает интервал между выстрелами финального противника
    private float powerEnemyFinishActor;// переменная, которая отсчитывает линию жизни у финального противника
    private float enemyTimer;// переменная, которая отсчитывает время до появления промежуточных противников
    private float enemyTimeInterval;// переменная, которая отсчитывает интервал между появлением промежуточных противников
    private float enemySpaceshipSpeed;// скорость промежуточных противников
    private boolean rockFlag;//когда true - увеличивает
    private boolean booleanFinishEnemySpaceship;// переменная = true, если финальный противник еще не создан или уничтожен
    private boolean isBoolean;// = true, пока фин. противник выезжает на экран(как только он выехал, то скорость его == 0, и isBoolean = false)
    private boolean overlap;// = true, пока фин. противник не уничтожен(если его уничтожили overlap = false(не дает проверять перекрытие лазера и полигона фин. противника))
    private FinishEnemySpaceship finishEnemySpaceship;
    private ProgressBar finishEnemySpaceshipBar;

    public void initialize() {

        starTimer = 0;
        // инициализация метки для отображения проигранного времени
        Time = new Label("Time:", BaseGame.labelStyle);
        Time.setColor( Color.CYAN );
        Time.setPosition(40, Gdx.graphics.getHeight() / 2f);
        uiStage.addActor(Time);
        // инициализация метки для отображения проигранного времени(конец)
///////////////////////////////////////////////////////////////////////////////////////////////
        Ground ground = new Ground(0, 0, mainStage);
        ground.loadTexture("background/space.png");
        ground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Ground ground1 = new Ground(0, Gdx.graphics.getHeight(), mainStage);
        ground1.loadTexture("background/space.png");
        ground1.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        starTimerFinishEnemySpaceship = 0;
        countFinishEnemySpaceship = 0;
        booleanFinishEnemySpaceship = true;
        isBoolean = true;
        overlap = true;
        enemyLaserTime = 0;
        enemyLaserTimeInterval = 1;
        powerEnemyFinishActor = 10;
        enemyTimer = 0;
        enemyTimeInterval = 4;
        enemySpaceshipSpeed = 150;

        super.initialize();

    }

    public void update(float dt) {

        starTimer += dt;
        Time.setText("Time:" + starTimer);
 ////////////////////////////////////////////////////////////////////////////////
        starTimerFinishEnemySpaceship += dt;
        enemyLaserTime += dt;
        enemyTimer += dt;

        // момент появления камня
        if (starTimer > 7.10 && starTimer < 7.12) {
            new Rock(MathUtils.random(0, Gdx.graphics.getWidth()), Gdx.graphics.getHeight(), mainStage);
        }
        // момент появления камня(конец)
        //  если попал с камень, то он взрывается. Если коснулся камня, то корабль взрывается
        for ( BaseActor rockActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.Rock") ) {
//            if (rockActor.overlaps(spaceship)) {
//                Explosion boom2 = new Explosion(0, 0, mainStage);
//                boom2.centerAtActor(rockActor);
//                rockActor.remove();
////                powerActor = powerActor - 0.5f;
////                points ++;
//                if (live == 0 && powerActor <= 0 ) {
//                    spaceship.remove();
//                    rockActor.remove();
//                    spaceship.setPosition(-1000,-1000);
//                    points ++;
//                }
//            }
            for ( BaseActor laserActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.myactors.Laser") ) {
                if (laserActor.overlaps(rockActor)) {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(rockActor);
                    laserActor.remove();
                    rockActor.remove();
                    if (BaseActor.count(mainStage, "com.alex.iv.shoot.star.opponents.Rock") < 16) {
                        new Rock(random, Gdx.graphics.getHeight(), mainStage);
                        new Rock(random, Gdx.graphics.getHeight(), mainStage);
                    }
                }
            }
        }
        //  если попал с камень, то он взрывается. Если коснулся камня, то корабль взрывается(конец)

        // если финальный корабль сталкивается с камнями
        for ( BaseActor enemyFinishSpaceshipActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.FinishEnemySpaceship") ) {
            for ( BaseActor rockActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.Rock") ) {
                rockActor.preventOverlap(enemyFinishSpaceshipActor);
            }
        }
        // если финальный корабль сталкивается с камнями(конец)

        for ( BaseActor spaceship : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.myactors.Spaceship") ) {
            for ( BaseActor rockActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.Rock") ) {
                if (rockActor.overlaps(spaceship)) {
                    rockActor.preventOverlap(spaceship);
                }
            }
        }


        // момент появления противников
        if (enemyTimer > enemyTimeInterval && booleanFinishEnemySpaceship) {
            EnemySpaceship enemySpaceship = new EnemySpaceship(MathUtils.random(0, Gdx.graphics.getWidth()), Gdx.graphics.getHeight(), mainStage);
            enemyTimer = 0;
            enemySpaceship.setSpeed(enemySpaceshipSpeed);
            if (countFinishEnemySpaceship > 0) {
                enemySpaceshipSpeed += 50;
                enemyTimeInterval -= 0.2f;
                if (enemyTimeInterval < 0.5f) {
                enemyTimeInterval = 0.5f;
                }
            }
        }
        //
        for ( BaseActor enemySpaceshipActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.EnemySpaceship") ) {
//            if (enemySpaceshipActor.overlaps(spaceship)) {
//                Explosion boom2 = new Explosion(0, 0, mainStage);
//                boom2.centerAtActor(enemySpaceshipActor);
//                enemySpaceshipActor.remove();
//                spaceship.remove();
//                enemySpaceshipActor.remove();
//            }
            for ( BaseActor laserActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.myactors.Laser") ) {
                if (laserActor.overlaps(enemySpaceshipActor)) {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(enemySpaceshipActor);
                    laserActor.remove();
                    enemySpaceshipActor.remove();
                }
            }
        }

        // момент появления финального противника
        if (starTimerFinishEnemySpaceship > 30.0f && booleanFinishEnemySpaceship) {
            finishEnemySpaceship = new FinishEnemySpaceship(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight(), mainStage);
            finishEnemySpaceshipBar = new ProgressBar(0.0f, 10.0f, 0.01f, false, BaseScreen.progressBarStyle);
            finishEnemySpaceshipBar.setAnimateDuration(0.25f);
            finishEnemySpaceshipBar.setBounds(finishEnemySpaceship.getX() + finishEnemySpaceship.getWidth(), finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() - 50, 100, 20);
            uiStage.addActor(finishEnemySpaceshipBar);
            booleanFinishEnemySpaceship = false;
            overlap = true;
        }
        // останавливает финального противника и заставляет его стрелять и двигаться рандомно в право и лево
        if (booleanFinishEnemySpaceship == false) {
            if (finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() > Gdx.graphics.getHeight()) {
                finishEnemySpaceship.setSpeed(100);
                finishEnemySpaceship.setMotionAngle(-90);
            } else if (finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() < Gdx.graphics.getHeight()) {
                if (isBoolean) {
                    finishEnemySpaceship.setSpeed(0);
                    isBoolean = false;
                }
                finishEnemySpaceshipBar.setValue(powerEnemyFinishActor); // метод для изменения линии жизни
                finishEnemySpaceshipBar.setBounds(finishEnemySpaceship.getX() + finishEnemySpaceship.getWidth(), finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() - 50, 100, 20);
                finishEnemySpaceship.leftRightMoving(0, 3, 600, 700, 0, 180);
                finishEnemySpaceship.boundToWorld();
                if (enemyLaserTime > enemyLaserTimeInterval) {
                    finishEnemySpaceship.shoot();
                    enemyLaserTime = 0;
                }
            }
        }
        // момент появления финального противника(конец)

        // если лазер попал по финальному кораблю
        if (booleanFinishEnemySpaceship == false) {
            for (BaseActor laserActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.myactors.Laser")) {
                if (laserActor.overlaps(finishEnemySpaceship) && finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() < Gdx.graphics.getHeight() && overlap) {
                    Explosion boom = new Explosion(0, 0, mainStage);
                    boom.centerAtActor(laserActor);
                    laserActor.remove();
                    powerEnemyFinishActor -= 0.5f;
                    if (powerEnemyFinishActor <= 0) {
                        countFinishEnemySpaceship ++;
                        starTimerFinishEnemySpaceship = 0;
                        booleanFinishEnemySpaceship = true;
                        isBoolean = true;
                        powerEnemyFinishActor = 10;
                        finishEnemySpaceship.remove();
                        finishEnemySpaceshipBar.remove();
                        overlap = false;
                    }
                }
            }
        }

        super.update(dt);
    }
}

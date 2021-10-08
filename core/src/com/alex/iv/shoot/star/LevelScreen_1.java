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
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class LevelScreen_1 extends LevelScreenMain {

    private float random = MathUtils.random(10000);
    private FinishEnemySpaceship finishEnemySpaceship;
    private FinishEnemySpaceship finishEnemySpaceship_2;
    private FinishEnemySpaceship finishEnemySpaceship_3;
    private ProgressBar finishEnemySpaceshipBar;
    private ProgressBar finishEnemySpaceshipBar_2;
    private ProgressBar finishEnemySpaceshipBar_3;
    private Label rockLaser; // метка, которая отображает оставшееся количество пуль
    private Label Time; // метка, которая отображает проигранное время
    private float enemyLaserTime;
    private float enemyLaserTimeInterval;
    private float powerEnemyFinishActor;
    private float powerEnemyFinishActor_2;
    private float powerEnemyFinishActor_3;
    private boolean rockFlag;
    private boolean liveFinishEnemySpaceship_1;
    private boolean liveFinishEnemySpaceship_2;
    private boolean liveFinishEnemySpaceship_3;
    private float starTimer;
    private float enemyTimer;
    private float enemyTimeInterval;
    private float enemySpaceshipSpeed;
    private float enemySpaceshipSpeed_2;
    private float enemySpaceshipSpeed_3;
    private float starTimerFinishEnemySpaceship;
    private int numberFinishEnemySpaceship;

    private int time;

    public void initialize() {
        Ground ground = new Ground(0, 0, mainStage);
        ground.loadTexture("background/space.png");
        ground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Ground ground1 = new Ground(0, Gdx.graphics.getHeight(), mainStage);
        ground1.loadTexture("background/space.png");
        ground1.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        finishEnemySpaceship = new FinishEnemySpaceship(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight(), mainStage);
        finishEnemySpaceship_2 = new FinishEnemySpaceship(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight(), mainStage);
        finishEnemySpaceship_3 = new FinishEnemySpaceship(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight(), mainStage);
        rockFlag = true;
        liveFinishEnemySpaceship_1 = true;
        liveFinishEnemySpaceship_2 = true;
        liveFinishEnemySpaceship_3 = true;
        starTimer = 0;
        starTimerFinishEnemySpaceship = 0;
        enemyTimer = 0;
        enemyTimeInterval = 3;
        enemySpaceshipSpeed = 100;
        enemySpaceshipSpeed_2 = 100;
        enemySpaceshipSpeed_3 = 100;
        enemyLaserTime = 0;
        enemyLaserTimeInterval = 1;
        powerEnemyFinishActor = 10;
        powerEnemyFinishActor_2 = 10;
        powerEnemyFinishActor_3 = 10;
        numberFinishEnemySpaceship = 0;
        // инициализация метки для отображения проигранного времени
        Time = new Label("Time:", BaseGame.labelStyle);
        Time.setColor( Color.CYAN );
        Time.setPosition(40, Gdx.graphics.getHeight() / 2f);
        uiStage.addActor(Time);
        // инициализация метки для отображения проигранного времени(конец)
        /////////////////////////
        finishEnemySpaceshipBar = new ProgressBar(0.0f, 10.0f, 0.01f, false, BaseScreen.progressBarStyle);
        finishEnemySpaceshipBar.setValue(powerEnemyFinishActor); // метод для изменения линии жизни
        finishEnemySpaceshipBar.setAnimateDuration(0.25f);
        finishEnemySpaceshipBar.setBounds(finishEnemySpaceship.getX() + finishEnemySpaceship.getWidth(), finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() - 50, 100, 20);
        uiStage.addActor(finishEnemySpaceshipBar);
        finishEnemySpaceshipBar_2 = new ProgressBar(0.0f, 10.0f, 0.01f, false, BaseScreen.progressBarStyle);
        finishEnemySpaceshipBar_2.setValue(powerEnemyFinishActor_2); // метод для изменения линии жизни
        finishEnemySpaceshipBar_2.setAnimateDuration(0.25f);
        finishEnemySpaceshipBar_2.setBounds(finishEnemySpaceship_2.getX() + finishEnemySpaceship_2.getWidth(), finishEnemySpaceship_2.getY() + finishEnemySpaceship_2.getHeight() - 50, 100, 20);
        uiStage.addActor(finishEnemySpaceshipBar_2);
        finishEnemySpaceshipBar_3 = new ProgressBar(0.0f, 10.0f, 0.01f, false, BaseScreen.progressBarStyle);
        finishEnemySpaceshipBar_3.setValue(powerEnemyFinishActor_2); // метод для изменения линии жизни
        finishEnemySpaceshipBar_3.setAnimateDuration(0.25f);
        finishEnemySpaceshipBar_3.setBounds(finishEnemySpaceship_3.getX() + finishEnemySpaceship_3.getWidth(), finishEnemySpaceship_3.getY() + finishEnemySpaceship_3.getHeight() - 50, 100, 20);
        uiStage.addActor(finishEnemySpaceshipBar_3);
        // инициализация линии жизни(конец)

        time = 0;

        super.initialize();

    }

    public void update(float dt) {
        super.update(dt);

        starTimer += dt;
        time = (int)starTimer;

        enemyTimer += dt;
        enemyLaserTime += dt;
        starTimerFinishEnemySpaceship += dt;
        finishEnemySpaceshipBar.setValue(powerEnemyFinishActor);// метод для изменения линии жизни врага
        finishEnemySpaceshipBar_2.setValue(powerEnemyFinishActor_2);// метод для изменения линии жизни врага
        finishEnemySpaceshipBar_3.setValue(powerEnemyFinishActor_3);// метод для изменения линии жизни врага

        // момент появления финального противника
        // первая строчка держит progressBar в верху справа
        finishEnemySpaceshipBar.setBounds(finishEnemySpaceship.getX() + finishEnemySpaceship.getWidth(), finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() - 50, 100, 20);
        if (starTimerFinishEnemySpaceship > 30.0 && finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() > Gdx.graphics.getHeight()) {
            finishEnemySpaceship.setSpeed(100);
            finishEnemySpaceship.setMotionAngle(-90);
        } else if (finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() < Gdx.graphics.getHeight()) {
            finishEnemySpaceship.leftRightMoving(0, 3, 500, 600, 0, 180);
            finishEnemySpaceship.boundToWorld();
            if (enemyLaserTime > enemyLaserTimeInterval && liveFinishEnemySpaceship_1) {
                finishEnemySpaceship.shoot();
                enemyLaserTime = 0;
            }
        }
        ///////////////////////////////
        finishEnemySpaceshipBar_2.setBounds(finishEnemySpaceship_2.getX() + finishEnemySpaceship_2.getWidth(), finishEnemySpaceship_2.getY() + finishEnemySpaceship_2.getHeight() - 50, 100, 20);
        if (starTimerFinishEnemySpaceship > 30.0 && finishEnemySpaceship_2.getY() + finishEnemySpaceship_2.getHeight() > Gdx.graphics.getHeight() && numberFinishEnemySpaceship == 1) {
            finishEnemySpaceship_2.setSpeed(100);
            finishEnemySpaceship_2.setMotionAngle(-90);
        } else if (finishEnemySpaceship_2.getY() + finishEnemySpaceship_2.getHeight() < Gdx.graphics.getHeight()) {
            finishEnemySpaceship_2.leftRightMoving(0, 3, 500, 600, 0, 180);
            finishEnemySpaceship_2.boundToWorld();
            if (enemyLaserTime > enemyLaserTimeInterval && liveFinishEnemySpaceship_2) {
                finishEnemySpaceship_2.shoot();
                enemyLaserTime = 0;
            }
        }
        ///////////////////////////////
        finishEnemySpaceshipBar_3.setBounds(finishEnemySpaceship_3.getX() + finishEnemySpaceship_3.getWidth(), finishEnemySpaceship_3.getY() + finishEnemySpaceship_3.getHeight() - 50, 100, 20);
        if (starTimerFinishEnemySpaceship > 30.0 && finishEnemySpaceship_3.getY() + finishEnemySpaceship_3.getHeight() > Gdx.graphics.getHeight() && numberFinishEnemySpaceship == 2) {
            finishEnemySpaceship_3.setSpeed(100);
            finishEnemySpaceship_3.setMotionAngle(-90);
        } else if (finishEnemySpaceship_3.getY() + finishEnemySpaceship_3.getHeight() < Gdx.graphics.getHeight()) {
            finishEnemySpaceship_3.leftRightMoving(0, 3, 500, 600, 0, 180);
            finishEnemySpaceship_3.boundToWorld();
            if (enemyLaserTime > enemyLaserTimeInterval && liveFinishEnemySpaceship_3) {
                finishEnemySpaceship_3.shoot();
                enemyLaserTime = 0;
            }
        }


        // момент появления камня
        if (starTimer > 7.10 && starTimer < 7.12) {
            new Rock(MathUtils.random(0, Gdx.graphics.getWidth()), Gdx.graphics.getHeight(), mainStage);
        }

        // момент появления противников
        // в условии: если время противника больше интервального времени и финальный противник еще не появился, то выполняем
        // код в фигурных скобках
        if (enemyTimer > enemyTimeInterval && finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() > Gdx.graphics.getHeight() && numberFinishEnemySpaceship == 0) {
            EnemySpaceship enemySpaceship = new EnemySpaceship(MathUtils.random(0, Gdx.graphics.getWidth()), Gdx.graphics.getHeight(), mainStage);
            enemyTimer = 0;
            enemySpaceship.setSpeed(enemySpaceshipSpeed);
            enemySpaceshipSpeed += 30;
            enemyTimeInterval -= 0.2f;
            if (enemyTimeInterval < 0.5f) {
                enemyTimeInterval = 0.5f;
            }
        }

        for ( BaseActor enemySpaceshipActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.EnemySpaceship") ) {
            if (enemySpaceshipActor.overlaps(spaceship)) {
                Explosion boom2 = new Explosion(0, 0, mainStage);
                boom2.centerAtActor(enemySpaceshipActor);
                enemySpaceshipActor.remove();
                powerActor = powerActor - 1;
                points += 2;
                if (live == 0 && powerActor <= 0) {
                    spaceship.remove();
                    enemySpaceshipActor.remove();
                    spaceship.setPosition(-1000,-1000);
                    points += 2;
                }
            }
            for ( BaseActor laserActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.myactors.Laser") ) {
                if (laserActor.overlaps(enemySpaceshipActor)) {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(enemySpaceshipActor);
                    laserActor.remove();
                    enemySpaceshipActor.remove();
                    points += 2;
                }
            }
        }

        //  если попал с камень, то он взрывается. Если коснулся камня, то корабль взрывается
        for ( BaseActor rockActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.Rock") ) {
            if (rockActor.overlaps(spaceship)) {
                Explosion boom2 = new Explosion(0, 0, mainStage);
                boom2.centerAtActor(rockActor);
                rockActor.remove();
                powerActor = powerActor - 0.5f;
                points ++;
                if (live == 0 && powerActor <= 0 ) {
                    spaceship.remove();
                    rockActor.remove();
                    spaceship.setPosition(-1000,-1000);
                    points ++;
                }
            }

            for ( BaseActor laserActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.myactors.Laser") ) {
                if (laserActor.overlaps(rockActor)) {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(rockActor);
                    laserActor.remove();
                    rockActor.remove();
                    points ++;
                    if (rockFlag) {
                        new Rock(random, Gdx.graphics.getHeight(), mainStage);
                        new Rock(random, Gdx.graphics.getHeight(), mainStage);
                    }
                    if (BaseActor.count(mainStage, "com.alex.iv.shoot.star.opponents.Rock") > 24) {
                        rockFlag = false;
                    }
                }
            }
        }
        //  если попал с камень, то он взрывается. Если коснулся камня, то корабль взрывается(конец)

        // если лазер попал по финальному кораблю
        for ( BaseActor laserActor : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.myactors.Laser") ) {
            if (laserActor.overlaps(finishEnemySpaceship) && finishEnemySpaceship.getY() + finishEnemySpaceship.getHeight() < Gdx.graphics.getHeight() && liveFinishEnemySpaceship_1) {
                Explosion boom = new Explosion(0,0, mainStage);
                boom.centerAtActor(laserActor);
                laserActor.remove();
                powerEnemyFinishActor = powerEnemyFinishActor - 0.5f ;
                if (powerEnemyFinishActor <= 0) {
                    liveFinishEnemySpaceship_1 = false;
                    finishEnemySpaceship.remove();
                    finishEnemySpaceshipBar.remove();
                    starTimerFinishEnemySpaceship = 0;
                    boom.remove();
                    numberFinishEnemySpaceship = 1;
                    enemyTimer = 0;
                }
            }
            if (laserActor.overlaps(finishEnemySpaceship_2) && finishEnemySpaceship_2.getY() + finishEnemySpaceship_2.getHeight() < Gdx.graphics.getHeight() && liveFinishEnemySpaceship_2) {
                Explosion boom = new Explosion(0,0, mainStage);
                boom.centerAtActor(laserActor);
                laserActor.remove();
                powerEnemyFinishActor_2 = powerEnemyFinishActor_2 - 0.5f ;
                if (powerEnemyFinishActor_2 <= 0) {
                    liveFinishEnemySpaceship_2 = false;
                    finishEnemySpaceship_2.remove();
                    finishEnemySpaceshipBar_2.remove();
                    starTimerFinishEnemySpaceship = 0;
                    boom.remove();
                    numberFinishEnemySpaceship = 2;
                }
            }
            if (laserActor.overlaps(finishEnemySpaceship_3) && finishEnemySpaceship_3.getY() + finishEnemySpaceship_3.getHeight() < Gdx.graphics.getHeight() && liveFinishEnemySpaceship_3) {
                Explosion boom = new Explosion(0,0, mainStage);
                boom.centerAtActor(laserActor);
                laserActor.remove();
                powerEnemyFinishActor_3 = powerEnemyFinishActor_3 - 0.5f ;
                if (powerEnemyFinishActor_3 <= 0) {
                    liveFinishEnemySpaceship_3 = false;
                    finishEnemySpaceship_3.remove();
                    finishEnemySpaceshipBar_3.remove();
                    starTimerFinishEnemySpaceship = 0;
                    boom.remove();
                    numberFinishEnemySpaceship = 3;
                }
            }
        }
        // если лазер попал по финальному кораблю(конец)

        //  если вражеский лазер попал по кораблю
        for ( BaseActor laserEnemy : BaseActor.getList(mainStage, "com.alex.iv.shoot.star.opponents.EnemyLaser") ) {
            if (laserEnemy.overlaps(spaceship)) {
                Explosion boom = new Explosion(0,0, mainStage);
                boom.centerAtActor(laserEnemy);
                laserEnemy.remove();
                powerActor = powerActor - 1.0f;
            }
        }
        //  если вражеский лазер попал по кораблю(конец)

        //rockLabel.setText("Rock: " + BaseActor.count(mainStage, "com.alex.iv.shoot.star.opponents.Rock"));// код, который установит текст метки для отображения фактического количества оставшихся камней:
        Time.setText("Time:" + starTimerFinishEnemySpaceship);

    }
}

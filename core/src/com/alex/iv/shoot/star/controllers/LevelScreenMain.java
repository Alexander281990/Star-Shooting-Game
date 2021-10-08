package com.alex.iv.shoot.star.controllers;

import com.alex.iv.shoot.star.myactors.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LevelScreenMain extends BaseScreen {

    protected Spaceship spaceship;
    protected Touchpad touchpad;
    private ProgressBar spaceshipBar;
    private Label StartTimeGame; // метка, которая отображает обратный отсчет до начала игры
    private Label pointsLabel; // метка, которая отображает набранные очки
    private Label spaceshipLive; // метка, которая отображает количество жизней

    protected static int points; // переменная, которая считает набранные очки(стоит в pointsLabel)
    protected float powerActor; // переменная, которая считает попадания по кораблю и уменшает линии жизни(стоит в ProgressBar)

    private float startTimeGame; // переменная для отображения обратного отсчета до начала игры
    protected static int live; // переменная для количества жизней

    @Override
    public void initialize() {

        startTimeGame = 4;
        live = 3;
        powerActor = 10;

        spaceship = new Spaceship((Gdx.graphics.getWidth())/2f, 10, mainStage);

        BaseActor.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // инициализация метки для отображения обратного отсчета до начала игры
        StartTimeGame = new Label("StartTime:", BaseGame.labelStyle);
        StartTimeGame.setColor( Color.CYAN );
        StartTimeGame.setSize(100, 100);
        StartTimeGame.setPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        uiStage.addActor(StartTimeGame);
        // инициализация метки для отображения обратного отсчета до начала игры(конец)

        //        // отвечает за изображение джойстика
        Gdx.graphics.setWindowedMode(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Touchpad.TouchpadStyle touchStyle = new Touchpad.TouchpadStyle();
        Texture padKnobTex = new Texture(Gdx.files.internal("buttons/joystick-knob.png"));
        TextureRegion padKnobReg = new TextureRegion(padKnobTex);
        touchStyle.knob = new TextureRegionDrawable(padKnobReg);
        Texture padBackTex = new Texture(Gdx.files.internal("buttons/joystick-background-new.png"));
        TextureRegion padBackReg = new TextureRegion(padBackTex);
        touchStyle.background = new TextureRegionDrawable(padBackReg);
        touchpad = new Touchpad(5, touchStyle);
        touchpad.setSize(500, 500);
        mainStage.addActor(touchpad);
//        // отвечает за изображение джойстика (конец)

        // инициализация и показ кнопки для стрельбы
        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        Texture buttonTex = new Texture( Gdx.files.internal("buttons/ufo.png") );
        TextureRegion buttonRegion = new TextureRegion(buttonTex);
        buttonStyle.up = new TextureRegionDrawable( buttonRegion );
        final Button shootButton = new Button( buttonStyle );
        shootButton.setColor( Color.CYAN );
        shootButton.setPosition((Gdx.graphics.getWidth() - shootButton.getWidth()) - 300,10);
        shootButton.setSize(300, 300);
        uiStage.addActor(shootButton);
        // инициализация и показ кнопки для стрельбы (конец)
        // при нажатии на кнопку происходит выстрел
        shootButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        spaceship.shoot();
                        //laser --;
//                        if (laser == 0) {
//                            shootButton.setTouchable(Touchable.disabled); // заставляет кнопку быть не активной
//                        }
                        return false;
                    }
                }
        );
        // при нажатии на кнопку происходит выстрел (конец)

        // инициализация метки для отображения текста с количеством сбитых камней
        pointsLabel = new Label("Points:", BaseGame.labelStyle);
        pointsLabel.setColor( Color.CYAN );
        pointsLabel.setPosition( 40, (Gdx.graphics.getHeight() - pointsLabel.getHeight()) - 20);
        uiStage.addActor(pointsLabel);
        points = 0;
        // инициализация метки для отображения текста с количеством сбитых камней(конец)
        // инициализация метки для отображения текста с количеством жизней
        spaceshipLive = new Label("Live:", BaseGame.labelStyle);
        spaceshipLive.setColor( Color.CYAN );
        spaceshipLive.setPosition( (Gdx.graphics.getWidth() - spaceshipLive.getWidth()) - 150, (Gdx.graphics.getHeight() - spaceshipLive.getHeight()) - 20);
        uiStage.addActor(spaceshipLive);
        // инициализация метки для отображения текста с количеством жизней(конец)
        // инициализация линии жизни
        spaceshipBar = new ProgressBar(0.0f, 10.0f, 0.01f, false, BaseScreen.progressBarStyle);
        spaceshipBar.setValue(powerActor); // метод для изменения линии жизни
        spaceshipBar.setAnimateDuration(0.25f);
        spaceshipBar.setBounds((Gdx.graphics.getWidth() - spaceshipBar.getWidth()) - 150, spaceshipLive.getY() - 30, 300, 20);
        uiStage.addActor(spaceshipBar);
        /////////////////////////

    }

    @Override
    public void update(float dt) {

        startTimeGame -= dt;
        int timeGameStart = (int)startTimeGame;

        spaceshipBar.setValue(powerActor); // метод для изменения линии жизни

        // Этод метод заставляет двигаться звездолет с помощью джойстика
        Vector2 direction = new Vector2(this.touchpad.getKnobPercentX(), this.touchpad.getKnobPercentY());
        //Vector2 direction = new Vector2(Gdx.input.getDeltaX(), -Gdx.input.getDeltaY());
        float length = direction.len();
        if (length > 0.0F) {
            this.spaceship.setSpeed(2000.0F * length);
            this.spaceship.setDeceleration(2000);
            this.spaceship.setMotionAngle(direction.angle());
        }
        // Этод метод заставляет двигаться звездолет с помощью джойстика(конец)

        // если обратный отсчет закончился, то удаляем метку
        if (timeGameStart == 0) {
            StartTimeGame.remove();
        }

        // если линия жизни закончилась, то отнимаем одну жизнь
        if (powerActor <= 0 && live != 0) {
            powerActor = 10;
            live -- ;
        }



        StartTimeGame.setText(timeGameStart); // код, который установит текст метки для обратного отсчета времени старта
        pointsLabel.setText("Points:" + points); // код, который установит текст метки для отображения набранных очков
        spaceshipLive.setText("Live:" + live); // код, который установит текст метки для отображения жизней
    }
}

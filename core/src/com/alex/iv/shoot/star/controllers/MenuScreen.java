package com.alex.iv.shoot.star.controllers;

import com.alex.iv.shoot.star.LevelScreen_1;
import com.alex.iv.shoot.star.myactors.Ground;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;

public class MenuScreen extends BaseScreen {
    @Override
    public void initialize() {
        new Ground(0, 0, mainStage);
        new Ground(0, Gdx.graphics.getHeight(), mainStage);

        // инициализация кнопок New game и continue
        TextButton startButton = new TextButton( "New game", BaseGame.textButtonStyle );
        //startButton.setPosition(150,150);
        uiStage.addActor(startButton);
        startButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(Type.touchDown))
                            return false;
                        CustomGame.setActiveScreen(new LevelScreen_1());
                        return false;
                    }
                }
        );

        TextButton continueButton = new TextButton( "Continue", BaseGame.textButtonStyle );
        //continueButton.setPosition(1000,150);
        uiStage.addActor(continueButton);
        continueButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(Type.touchDown))
                            return false;
                        //Gdx.app.exit(); // выходит из игры
                        CustomGame.setActiveScreen(new MapGame());
                        return false;
                    }
                }
        );
        // инициализация кнопок New game и continue(конец)

        //uiTable.row();
        uiTable.add(startButton);
        uiTable.add().size(250, startButton.getHeight());
        uiTable.add(continueButton);

    }

    @Override
    public void update(float dt) {

    }
}

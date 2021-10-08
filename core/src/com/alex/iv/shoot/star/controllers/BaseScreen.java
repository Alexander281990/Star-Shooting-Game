package com.alex.iv.shoot.star.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public abstract class BaseScreen implements Screen, InputProcessor {

    protected Stage mainStage;
    protected Stage uiStage; // с ее помощью сообщение "You win" появляется всегда в центре камеры а не экрана
    Table uiTable;
    Table uiTableMap1;
    Table uiTableMap2;
    Table uiTableMap3;
    Table uiTableMap4;
    Table uiTableMap5;
    Table uiTableMap6;
    Table uiTableMap7;
    Table uiTableMap8;
    Table uiTableMap9;
    Table uiTableMap10;

    public static ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle(); // стиль для линии жизни


    public BaseScreen() {
        mainStage = new Stage();
        uiStage = new Stage();
        uiTable = new Table();
        uiTable.setFillParent(true);
        uiStage.addActor(uiTable);

        // инициализация и создание стиля для линии жизни
        Pixmap pixmap = new Pixmap(300, 20, Pixmap.Format.RGB888);
        pixmap.setColor(Color.RED);
        pixmap.fill();
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
        progressBarStyle.background = drawable;
        pixmap = new Pixmap(0, 20, Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();
        drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
        pixmap.dispose();
        progressBarStyle.knob = drawable;
        pixmap = new Pixmap(300, 20, Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();
        drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
        pixmap.dispose();
        progressBarStyle.knobBefore = drawable;
        // инициализация и создание стиля для линии жизни(конец)

        uiTableMap1 = new Table();
        uiTableMap1.setFillParent(true);
        uiStage.addActor(uiTableMap1);

        uiTableMap2 = new Table();
        uiTableMap2.setFillParent(true);
        uiStage.addActor(uiTableMap2);

        uiTableMap3 = new Table();
        uiTableMap3.setFillParent(true);
        uiStage.addActor(uiTableMap3);

        uiTableMap4 = new Table();
        uiTableMap4.setFillParent(true);
        uiStage.addActor(uiTableMap4);

        uiTableMap5 = new Table();
        uiTableMap5.setFillParent(true);
        uiStage.addActor(uiTableMap5);

        uiTableMap6 = new Table();
        uiTableMap6.setFillParent(true);
        uiStage.addActor(uiTableMap6);

        uiTableMap7 = new Table();
        uiTableMap7.setFillParent(true);
        uiStage.addActor(uiTableMap7);

        uiTableMap8 = new Table();
        uiTableMap8.setFillParent(true);
        uiStage.addActor(uiTableMap8);

        uiTableMap9 = new Table();
        uiTableMap9.setFillParent(true);
        uiStage.addActor(uiTableMap9);

        uiTableMap10 = new Table();
        uiTableMap10.setFillParent(true);
        uiStage.addActor(uiTableMap10);

        initialize();
    }

    public abstract void initialize();

    public abstract void update(float dt);

    public void render(float dt) {
        uiStage.act(dt);
        mainStage.act(dt);
        update(dt);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
        uiStage.draw();
    }

    public void resize(int width, int height) {}

    public void pause() {}

    public void resume() {}

    public void dispose() {}

    public void show() {
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.addProcessor(this);
        im.addProcessor(this.uiStage);
        im.addProcessor(this.mainStage);
    }

    public void hide() {
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.removeProcessor(this);
        im.removeProcessor(uiStage);
        im.removeProcessor(mainStage);
    }

    // Метод, который используется для проверки того, соответствует ли событие мыши нажатию кнопки (например, в отличие от события перемещения мыши)
    public boolean isTouchDownEvent(Event e) {
        return (e instanceof InputEvent) && ((InputEvent)e).getType().equals(InputEvent.Type.touchDown);
    }


    // Методы для InputProcessor

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char c) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    // Методы для свайпа
    public boolean isSwipeRight() {
        if (Gdx.input.isTouched() && Gdx.input.getDeltaX() > 0) {
            return true;
        }
        return false;
    }

    public boolean isSwipeLeft() {
        if (Gdx.input.isTouched() && Gdx.input.getDeltaX() < 0) {
            return true;
        }
        return false;
    }

    public boolean isSwipeUp() {
        if (Gdx.input.isTouched() && Gdx.input.getDeltaY() > 0) {
            return true;
        }
        return false;
    }

    public boolean isSwipeDown() {
        if (Gdx.input.isTouched() && Gdx.input.getDeltaY() < 0) {
            return true;
        }
        return false;
    }


}
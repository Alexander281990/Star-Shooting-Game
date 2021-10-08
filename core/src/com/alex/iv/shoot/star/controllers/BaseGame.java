package com.alex.iv.shoot.star.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public abstract class BaseGame extends Game {
    private static BaseGame game;
    public static LabelStyle labelStyle;
    public static TextButtonStyle textButtonStyle;
    public static TextButtonStyle textButtonLevel;

    public BaseGame() {
        game = this;
    }

    public void create() {
        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);
        labelStyle = new LabelStyle(); // метки для отображения текста
        //labelStyle.font = new BitmapFont(); // метки для отображения текста
        //labelStyle.font = new BitmapFont( Gdx.files.internal("myCustomFont.fnt") ); // метки для отображения текста
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans.ttf"));
        // настройка внешнего вида шрифта
        FreeTypeFontParameter fontParameters = new FreeTypeFontParameter();
        fontParameters.size = 60;
        fontParameters.color = Color.WHITE;
        fontParameters.borderWidth = 2;
        fontParameters.borderColor = Color.BLACK;
        fontParameters.borderStraight = true;
        fontParameters.minFilter = TextureFilter.Linear;
        fontParameters.magFilter = TextureFilter.Linear;
        // настройка внешнего вида шрифта(конец)
        BitmapFont customFont = fontGenerator.generateFont(fontParameters);// метки для отображения текста
        labelStyle.font = customFont;// метки для отображения текста

        // настройки текстовой кнопки
        textButtonStyle = new TextButtonStyle();
        Texture	buttonTex = new	Texture( Gdx.files.internal("buttons/button.png") );
        NinePatch buttonPatch = new	NinePatch(buttonTex, 24,24,24,24);
        textButtonStyle.up = new NinePatchDrawable( buttonPatch );
        textButtonStyle.font = customFont;
        textButtonStyle.fontColor =	Color.GRAY;

        // настройки текстовой кнопки уровня игры
        textButtonLevel = new TextButtonStyle();
        Texture	buttonLev = new	Texture( Gdx.files.internal("buttons/levelButton.png") );
        NinePatch buttonPatchLev = new	NinePatch(buttonLev, 24,24,24,24);
        textButtonLevel.up = new NinePatchDrawable( buttonPatchLev );
        textButtonLevel.font = customFont;
        textButtonLevel.fontColor =	Color.GRAY;

    }

    public static void setActiveScreen(BaseScreen s) {
        game.setScreen(s);
    }
}

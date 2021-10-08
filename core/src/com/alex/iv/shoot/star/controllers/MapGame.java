package com.alex.iv.shoot.star.controllers;

import com.alex.iv.shoot.star.LevelScreen_2;
import com.alex.iv.shoot.star.maps.Castle;
import com.alex.iv.shoot.star.maps.Map1;
import com.alex.iv.shoot.star.maps.Map10;
import com.alex.iv.shoot.star.maps.Map2;
import com.alex.iv.shoot.star.maps.Map3;
import com.alex.iv.shoot.star.maps.Map4;
import com.alex.iv.shoot.star.maps.Map5;
import com.alex.iv.shoot.star.maps.Map6;
import com.alex.iv.shoot.star.maps.Map7;
import com.alex.iv.shoot.star.maps.Map8;
import com.alex.iv.shoot.star.maps.Map9;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MapGame extends BaseScreen {

    private Map1 map1;
    private Map2 map2;
    private Map3 map3;
    private Map4 map4;
    private Map5 map5;
    private Map6 map6;
    private Map7 map7;
    private Map8 map8;
    private Map9 map9;
    private Map10 map10;


    @Override
    public void initialize() {
        BaseActor.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        map1 = new Map1(0, 0, mainStage);
        map2 = new Map2(Gdx.graphics.getWidth(), 0, mainStage);
        map3 = new Map3((Gdx.graphics.getWidth() * 2), 0, mainStage);
        map4 = new Map4((Gdx.graphics.getWidth() * 3), 0, mainStage);
        map5 = new Map5((Gdx.graphics.getWidth() * 4), 0, mainStage);
        map6 = new Map6((Gdx.graphics.getWidth() * 5), 0, mainStage);
        map7 = new Map7((Gdx.graphics.getWidth() * 6), 0, mainStage);
        map8 = new Map8((Gdx.graphics.getWidth() * 7), 0, mainStage);
        map9 = new Map9((Gdx.graphics.getWidth() * 8), 0, mainStage);
        map10 = new Map10((Gdx.graphics.getWidth() * 9), 0, mainStage);

        // инициализация кнопок Level
        TextButton level_1_Button = new TextButton("1", BaseGame.textButtonLevel);
        uiStage.addActor(level_1_Button);
        TextButton level_2_Button = new TextButton("2", BaseGame.textButtonLevel);
        uiStage.addActor(level_2_Button);
        TextButton level_3_Button = new TextButton("3", BaseGame.textButtonLevel);
        uiStage.addActor(level_3_Button);
        TextButton level_4_Button = new TextButton("4", BaseGame.textButtonLevel);
        uiStage.addActor(level_4_Button);
        TextButton level_5_Button = new TextButton("5", BaseGame.textButtonLevel);
        uiStage.addActor(level_5_Button);

        TextButton level_6_Button = new TextButton("6", BaseGame.textButtonLevel);
        uiStage.addActor(level_6_Button);
        TextButton level_7_Button = new TextButton("7", BaseGame.textButtonLevel);
        uiStage.addActor(level_7_Button);
        TextButton level_8_Button = new TextButton("8", BaseGame.textButtonLevel);
        uiStage.addActor(level_8_Button);
        TextButton level_9_Button = new TextButton("9", BaseGame.textButtonLevel);
        uiStage.addActor(level_9_Button);
        TextButton level_10_Button = new TextButton("10", BaseGame.textButtonLevel);
        uiStage.addActor(level_10_Button);

        TextButton level_11_Button = new TextButton("11", BaseGame.textButtonLevel);
        uiStage.addActor(level_11_Button);
        TextButton level_12_Button = new TextButton("12", BaseGame.textButtonLevel);
        uiStage.addActor(level_12_Button);
        TextButton level_13_Button = new TextButton("13", BaseGame.textButtonLevel);
        uiStage.addActor(level_13_Button);
        TextButton level_14_Button = new TextButton("14", BaseGame.textButtonLevel);
        uiStage.addActor(level_14_Button);
        TextButton level_15_Button = new TextButton("15", BaseGame.textButtonLevel);
        uiStage.addActor(level_15_Button);

        TextButton level_16_Button = new TextButton("16", BaseGame.textButtonLevel);
        uiStage.addActor(level_16_Button);
        TextButton level_17_Button = new TextButton("17", BaseGame.textButtonLevel);
        uiStage.addActor(level_17_Button);
        TextButton level_18_Button = new TextButton("18", BaseGame.textButtonLevel);
        uiStage.addActor(level_18_Button);
        TextButton level_19_Button = new TextButton("19", BaseGame.textButtonLevel);
        uiStage.addActor(level_19_Button);
        TextButton level_20_Button = new TextButton("20", BaseGame.textButtonLevel);
        uiStage.addActor(level_20_Button);

        TextButton level_21_Button = new TextButton("21", BaseGame.textButtonLevel);
        uiStage.addActor(level_21_Button);
        TextButton level_22_Button = new TextButton("22", BaseGame.textButtonLevel);
        uiStage.addActor(level_22_Button);
        TextButton level_23_Button = new TextButton("23", BaseGame.textButtonLevel);
        uiStage.addActor(level_23_Button);
        TextButton level_24_Button = new TextButton("24", BaseGame.textButtonLevel);
        uiStage.addActor(level_24_Button);
        TextButton level_25_Button = new TextButton("25", BaseGame.textButtonLevel);
        uiStage.addActor(level_25_Button);

        TextButton level_26_Button = new TextButton("26", BaseGame.textButtonLevel);
        uiStage.addActor(level_26_Button);
        TextButton level_27_Button = new TextButton("27", BaseGame.textButtonLevel);
        uiStage.addActor(level_27_Button);
        TextButton level_28_Button = new TextButton("28", BaseGame.textButtonLevel);
        uiStage.addActor(level_28_Button);
        TextButton level_29_Button = new TextButton("29", BaseGame.textButtonLevel);
        uiStage.addActor(level_29_Button);
        TextButton level_30_Button = new TextButton("30", BaseGame.textButtonLevel);
        uiStage.addActor(level_30_Button);

        TextButton level_31_Button = new TextButton("31", BaseGame.textButtonLevel);
        uiStage.addActor(level_31_Button);
        TextButton level_32_Button = new TextButton("32", BaseGame.textButtonLevel);
        uiStage.addActor(level_32_Button);
        TextButton level_33_Button = new TextButton("33", BaseGame.textButtonLevel);
        uiStage.addActor(level_33_Button);
        TextButton level_34_Button = new TextButton("34", BaseGame.textButtonLevel);
        uiStage.addActor(level_34_Button);
        TextButton level_35_Button = new TextButton("35", BaseGame.textButtonLevel);
        uiStage.addActor(level_35_Button);

        TextButton level_36_Button = new TextButton("36", BaseGame.textButtonLevel);
        uiStage.addActor(level_36_Button);
        TextButton level_37_Button = new TextButton("37", BaseGame.textButtonLevel);
        uiStage.addActor(level_37_Button);
        TextButton level_38_Button = new TextButton("38", BaseGame.textButtonLevel);
        uiStage.addActor(level_38_Button);
        TextButton level_39_Button = new TextButton("39", BaseGame.textButtonLevel);
        uiStage.addActor(level_39_Button);
        TextButton level_40_Button = new TextButton("40", BaseGame.textButtonLevel);
        uiStage.addActor(level_40_Button);

        TextButton level_41_Button = new TextButton("41", BaseGame.textButtonLevel);
        uiStage.addActor(level_41_Button);
        TextButton level_42_Button = new TextButton("42", BaseGame.textButtonLevel);
        uiStage.addActor(level_42_Button);
        TextButton level_43_Button = new TextButton("43", BaseGame.textButtonLevel);
        uiStage.addActor(level_43_Button);
        TextButton level_44_Button = new TextButton("44", BaseGame.textButtonLevel);
        uiStage.addActor(level_44_Button);
        TextButton level_45_Button = new TextButton("45", BaseGame.textButtonLevel);
        uiStage.addActor(level_45_Button);

        TextButton level_46_Button = new TextButton("46", BaseGame.textButtonLevel);
        uiStage.addActor(level_46_Button);
        TextButton level_47_Button = new TextButton("47", BaseGame.textButtonLevel);
        uiStage.addActor(level_47_Button);
        TextButton level_48_Button = new TextButton("48", BaseGame.textButtonLevel);
        uiStage.addActor(level_48_Button);
        TextButton level_49_Button = new TextButton("49", BaseGame.textButtonLevel);
        uiStage.addActor(level_49_Button);
        TextButton level_50_Button = new TextButton("50", BaseGame.textButtonLevel);
        uiStage.addActor(level_50_Button);

        level_1_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        CustomGame.setActiveScreen(new LevelScreen_2());
                        return false;
                    }
                }
        );

        uiTableMap1.add(level_1_Button);
        uiTableMap1.add().size(100, level_1_Button.getHeight());
        uiTableMap1.add(level_2_Button);
        uiTableMap1.add().size(100, level_2_Button.getHeight());
        uiTableMap1.add(level_3_Button);
        uiTableMap1.add().size(100, level_3_Button.getHeight());
        uiTableMap1.add(level_4_Button);
        uiTableMap1.add().size(100, level_4_Button.getHeight());
        uiTableMap1.add(level_5_Button);
        uiTableMap1.add().size(100, level_5_Button.getHeight());

        uiTableMap2.add(level_6_Button);
        uiTableMap2.add().size(100, level_6_Button.getHeight());
        uiTableMap2.add(level_7_Button);
        uiTableMap2.add().size(100, level_7_Button.getHeight());
        uiTableMap2.add(level_8_Button);
        uiTableMap2.add().size(100, level_8_Button.getHeight());
        uiTableMap2.add(level_9_Button);
        uiTableMap2.add().size(100, level_9_Button.getHeight());
        uiTableMap2.add(level_10_Button);
        uiTableMap2.add().size(100, level_10_Button.getHeight());

        uiTableMap3.add(level_11_Button);
        uiTableMap3.add().size(100, level_11_Button.getHeight());
        uiTableMap3.add(level_12_Button);
        uiTableMap3.add().size(100, level_12_Button.getHeight());
        uiTableMap3.add(level_13_Button);
        uiTableMap3.add().size(100, level_13_Button.getHeight());
        uiTableMap3.add(level_14_Button);
        uiTableMap3.add().size(100, level_14_Button.getHeight());
        uiTableMap3.add(level_15_Button);
        uiTableMap3.add().size(100, level_15_Button.getHeight());

        uiTableMap4.add(level_16_Button);
        uiTableMap4.add().size(100, level_16_Button.getHeight());
        uiTableMap4.add(level_17_Button);
        uiTableMap4.add().size(100, level_17_Button.getHeight());
        uiTableMap4.add(level_18_Button);
        uiTableMap4.add().size(100, level_18_Button.getHeight());
        uiTableMap4.add(level_19_Button);
        uiTableMap4.add().size(100, level_19_Button.getHeight());
        uiTableMap4.add(level_20_Button);
        uiTableMap4.add().size(100, level_20_Button.getHeight());

        uiTableMap5.add(level_21_Button);
        uiTableMap5.add().size(100, level_21_Button.getHeight());
        uiTableMap5.add(level_22_Button);
        uiTableMap5.add().size(100, level_22_Button.getHeight());
        uiTableMap5.add(level_23_Button);
        uiTableMap5.add().size(100, level_23_Button.getHeight());
        uiTableMap5.add(level_24_Button);
        uiTableMap5.add().size(100, level_24_Button.getHeight());
        uiTableMap5.add(level_25_Button);
        uiTableMap5.add().size(100, level_25_Button.getHeight());

        uiTableMap6.add(level_26_Button);
        uiTableMap6.add().size(100, level_26_Button.getHeight());
        uiTableMap6.add(level_27_Button);
        uiTableMap6.add().size(100, level_27_Button.getHeight());
        uiTableMap6.add(level_28_Button);
        uiTableMap6.add().size(100, level_28_Button.getHeight());
        uiTableMap6.add(level_29_Button);
        uiTableMap6.add().size(100, level_29_Button.getHeight());
        uiTableMap6.add(level_30_Button);
        uiTableMap6.add().size(100, level_30_Button.getHeight());

        uiTableMap7.add(level_31_Button);
        uiTableMap7.add().size(100, level_31_Button.getHeight());
        uiTableMap7.add(level_32_Button);
        uiTableMap7.add().size(100, level_32_Button.getHeight());
        uiTableMap7.add(level_33_Button);
        uiTableMap7.add().size(100, level_33_Button.getHeight());
        uiTableMap7.add(level_34_Button);
        uiTableMap7.add().size(100, level_34_Button.getHeight());
        uiTableMap7.add(level_35_Button);
        uiTableMap7.add().size(100, level_35_Button.getHeight());

        uiTableMap8.add(level_36_Button);
        uiTableMap8.add().size(100, level_36_Button.getHeight());
        uiTableMap8.add(level_37_Button);
        uiTableMap8.add().size(100, level_37_Button.getHeight());
        uiTableMap8.add(level_38_Button);
        uiTableMap8.add().size(100, level_38_Button.getHeight());
        uiTableMap8.add(level_39_Button);
        uiTableMap8.add().size(100, level_39_Button.getHeight());
        uiTableMap8.add(level_40_Button);
        uiTableMap8.add().size(100, level_40_Button.getHeight());

        uiTableMap9.add(level_41_Button);
        uiTableMap9.add().size(100, level_41_Button.getHeight());
        uiTableMap9.add(level_42_Button);
        uiTableMap9.add().size(100, level_42_Button.getHeight());
        uiTableMap9.add(level_43_Button);
        uiTableMap9.add().size(100, level_43_Button.getHeight());
        uiTableMap9.add(level_44_Button);
        uiTableMap9.add().size(100, level_44_Button.getHeight());
        uiTableMap9.add(level_45_Button);
        uiTableMap9.add().size(100, level_45_Button.getHeight());

        uiTableMap10.add(level_46_Button);
        uiTableMap10.add().size(100, level_46_Button.getHeight());
        uiTableMap10.add(level_47_Button);
        uiTableMap10.add().size(100, level_47_Button.getHeight());
        uiTableMap10.add(level_48_Button);
        uiTableMap10.add().size(100, level_48_Button.getHeight());
        uiTableMap10.add(level_49_Button);
        uiTableMap10.add().size(100, level_49_Button.getHeight());
        uiTableMap10.add(level_50_Button);
        uiTableMap10.add().size(100, level_50_Button.getHeight());

        Castle castle = new Castle(0, 0, mainStage);
        level_2_Button.addActor(castle);
    }

    @Override
    public void update(float dt) {

        uiTableMap1.setPosition(map1.getX(), map1.getY());
        uiTableMap2.setPosition(map2.getX(), map2.getY());
        uiTableMap3.setPosition(map3.getX(), map3.getY());
        uiTableMap4.setPosition(map4.getX(), map4.getY());
        uiTableMap5.setPosition(map5.getX(), map5.getY());
        uiTableMap6.setPosition(map6.getX(), map6.getY());
        uiTableMap7.setPosition(map7.getX(), map7.getY());
        uiTableMap8.setPosition(map8.getX(), map8.getY());
        uiTableMap9.setPosition(map9.getX(), map9.getY());
        uiTableMap10.setPosition(map10.getX(), map10.getY());

        if (isSwipeLeft()) {
            map1.moveBy(-50, 0);
            map2.moveBy(-50, 0);
            map3.moveBy(-50, 0);
            map4.moveBy(-50, 0);
            map5.moveBy(-50, 0);
            map6.moveBy(-50, 0);
            map7.moveBy(-50, 0);
            map8.moveBy(-50, 0);
            map9.moveBy(-50, 0);
            map10.moveBy(-50, 0);
        }

        if (isSwipeRight()) {
            map1.moveBy(50, 0);
            map2.moveBy(50, 0);
            map3.moveBy(50, 0);
            map4.moveBy(50, 0);
            map5.moveBy(50, 0);
            map6.moveBy(50, 0);
            map7.moveBy(50, 0);
            map8.moveBy(50, 0);
            map9.moveBy(50, 0);
            map10.moveBy(50, 0);
        }

    }
}

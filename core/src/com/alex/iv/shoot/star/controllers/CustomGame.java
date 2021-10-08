package com.alex.iv.shoot.star.controllers;

import com.alex.iv.shoot.star.LevelScreen_1;

public class CustomGame extends BaseGame {
    public CustomGame() {
    }

    public void create() {
        super.create();
        setActiveScreen(new MenuScreen());
    }
}
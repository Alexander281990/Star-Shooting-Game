package com.alex.iv.shoot.star.desktop;

import com.alex.iv.shoot.star.controllers.CustomGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new CustomGame(), config);
		config.width = 800;
		config.height = 600;
	}
}

package com.dbeef.memoboxes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.dbeef.memoboxes.Main;

//A span between the application start and main menu
//Gives some time to load textures by rendering game's logo for 3.5 seconds

public class LogoScreen implements Screen {

	double timerSleep = 0;

	double darkness = 1;
	double scale = 0;

	boolean logoScaleOversized = false;
	boolean backgroundLightOverdosed = false;

	boolean changeScreen = false;
	boolean timeLimitExpired = false;

	final Main game;

	public LogoScreen(final Main myGdxGame) {
		game = myGdxGame;

		game.logo.setPosition(-75, 400);
		game.logo.setScale(0);
	}

	@Override
	public void render(float delta) {
		updateTimers(delta);
		draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	public void draw() {
		Gdx.gl.glClearColor(1, 1, 123, 180);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.batch.begin();
		game.batch.setColor(1, 1, 1, 1);

		game.batch.draw(game.bezoweTlo, 0, 0);
		game.batch.setColor(1, 1, 1, 1);
		game.logo.draw(game.batch);
		game.batch.setColor(1, 1, 1, (float) darkness);
		game.batch.draw(game.czarny, 0, 0);

		game.batch.end();
	}

	public void updateTimers(float delta) {

		game.logo.setScale((float) scale);

		if (scale < 1.2f && logoScaleOversized == false) {
			scale += delta * 3;
		}
		if (scale > 1.2f) {
			scale = 1.2f;
			logoScaleOversized = true;
		}
		if (scale > 1.0f && logoScaleOversized == true) {
			scale -= delta * 2;
			if (scale <= 1)
				scale = 1;
		}

		if (darkness > 0 && backgroundLightOverdosed == false) {
			darkness -= delta * 2;

			if (darkness < 0) {
				darkness = 0;
				backgroundLightOverdosed = true;

			}
		}

		if (backgroundLightOverdosed == true)
			timerSleep += delta;

		if (timerSleep > 3.5f)
			timeLimitExpired = true;

		if (timeLimitExpired == true) {
			darkness += delta * 2;
			if (scale > 0) {
				scale -= delta * 4;
			}
			if (scale < 0)
				scale = 0;
			if (darkness > 1) {
				darkness = 1;
				changeScreen = true;
			}
		}

		if (changeScreen == true) {
			dispose();
			game.setScreen(new MenuScreen(game));
		}
	}
}
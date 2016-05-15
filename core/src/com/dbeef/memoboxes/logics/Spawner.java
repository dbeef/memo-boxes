package com.dbeef.memoboxes.logics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spawner {

	Sprite spawner;
	Sprite animationFrame;

	static final int FRAME_COLS = 13;
	static final int FRAME_ROWS = 2;

	Animation fireAnimation;
	TextureRegion[] fireFrames;
	TextureRegion currentFrame;

	Texture fireSheet;
	Texture switchRed;
	Texture switchGreen;

	float stateTime;
	float timerPos = 0;
	float spawnerPositionX;
	static float spawnerPositionY;

	boolean justSpawned = false;

	public Spawner(Texture s, int xS, int yS, Texture wS, Texture sRed, Texture sGreen) {
		
			spawner = new Sprite(s);
			spawner.setPosition(xS, yS);
			spawner.setScale(1.6f);

			spawnerPositionY = yS;

			spawnerPositionX = xS;

			fireSheet = wS;
			TextureRegion[][] tmp = TextureRegion.split(fireSheet,
					fireSheet.getWidth() / FRAME_COLS, fireSheet.getHeight()
							/ FRAME_ROWS);
			fireFrames = new TextureRegion[26];
			int index = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 13; j++) {
					fireFrames[index++] = tmp[i][j];
				}
			}
			fireAnimation = new Animation(0.01f, fireFrames);
			stateTime = 0f;
		
	switchRed = sRed;
	switchGreen = sGreen;
	}
	
	
	public void draw(Batch batch) {

		spawnerPositionX = spawner.getX();
		timerPos += Gdx.graphics.getDeltaTime();
	
		if (justSpawned == true && spawner.getY() < spawnerPositionY + 20) {
			if (timerPos > 0.05f)
				spawner.setPosition(spawnerPositionX, spawner.getY() + 2);
		} else {
			justSpawned = false;
			stateTime = 0;
		}
		if (justSpawned == false && spawner.getY() > spawnerPositionY) {
			if (timerPos > 0.05f)
				spawner.setPosition(spawnerPositionX, spawner.getY() - 2);
		}
		
		if (spawner.getY() < spawnerPositionY)
			spawner.setPosition(spawnerPositionX, spawnerPositionY);
		
		stateTime += Gdx.graphics.getDeltaTime();
		animationFrame = new Sprite(fireAnimation.getKeyFrame(stateTime, true));
		animationFrame.setPosition(spawnerPositionX - 57, spawner.getY() - 80);

		if (justSpawned == true)
			animationFrame.draw(batch);

		spawner.draw(batch);
	
		
		if (justSpawned == true)
			batch.draw(switchGreen, spawnerPositionX + 25, spawner.getY() + 31);
		else
			batch.draw(switchRed, spawnerPositionX + 25, spawner.getY() + 31);

	}

	public void setPositionX(float x) {
		spawner.setPosition(x, spawner.getY());
	}

	public void setJustSpawned(boolean jS) {
		justSpawned = jS;
	}
}
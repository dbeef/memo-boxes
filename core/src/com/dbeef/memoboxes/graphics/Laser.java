package com.dbeef.memoboxes.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Laser {

	double laserTimer = 0;
	double laserPosY = -20;
	double zwiekszajacaLasers = 2;
	
	public Sprite s;
	public Sprite laserCannon;
	
	public static final int FRAME_COLS = 11; // #1 // 3
	public static final int FRAME_ROWS = 2; // #2 // 9


	public int x;
	public double y;

	public Texture walkSheet;
	Animation walkAnimation;
	TextureRegion[] walkFrames;
	TextureRegion currentFrame;

	float stateTime;
	float rotation;
	
	public Laser(Texture wS, int x, int y, int rot, Texture lasCan) {
		this.x = x;
		this.y = y;

		laserCannon = new Sprite(lasCan);
		
		walkSheet = wS;

		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight()
						/ FRAME_ROWS);
		walkFrames = new TextureRegion[22];
		int index = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 11; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}
		walkAnimation = new Animation(0.005f, walkFrames); // #11
stateTime = 0f;

rotation = rot;
laserCannon.setRotation(rotation);

	}

	public void draw(Batch batch) {
		
		laserTimer += Gdx.graphics.getDeltaTime();
	
		if (laserTimer > 0.01) {
			laserTimer = 0;
			y += zwiekszajacaLasers;
			zwiekszajacaLasers += 0.1;
		}

		
		stateTime += Gdx.graphics.getDeltaTime();
	
		s = new Sprite(walkAnimation.getKeyFrame(stateTime, true));
		s.setColor(Color.RED);
		s.setScale(2.5f, 1);
		s.setRotation(rotation);
		s.setPosition(x, (int)y - 65);
	
		s.draw(batch);

		laserCannon.setPosition(x, (int)y - 65);
		laserCannon.setScale(1.5f,1.5f);
		
		laserCannon.draw(batch);

	}
	public void setRotation(){
		
	}
}
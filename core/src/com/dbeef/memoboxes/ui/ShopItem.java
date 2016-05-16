package com.dbeef.memoboxes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ShopItem {

	public int y;
	public int x;
	
	public boolean blink = false;
	public double blinkTimer = 0.65f;

	public Sprite border;

	public boolean isAlreadyBought;
	public boolean isJustChoosen;

	public ShopItem(TextureRegion t, int x, int y, boolean iab, boolean ijc) {
		this.x = x + 100;
		this.y = y - 15;
		isAlreadyBought = iab;
		isJustChoosen = ijc;
		border = new Sprite(t);
		border.setScale(2f, 1.5f);	
	}
	
	public void draw(Batch batch) {

		if (isAlreadyBought == true) {
			if (blinkTimer < 1f)
				blinkTimer += Gdx.graphics.getDeltaTime();
			if (blinkTimer > 1f)
				blinkTimer = 1f;
		}
		border.setPosition(x, y);
		border.setColor((float) blinkTimer, (float) blinkTimer, 1, 1);

		if (blink == true) {
			if (blinkTimer > 0.7f)
				blinkTimer -= 4 * Gdx.graphics.getDeltaTime();
			if (blinkTimer < 0.7f) {
				blinkTimer = 0.7f;
				blink = false;
			}
		}
		border.draw(batch);
	}

	public boolean buttonMouseCollision(float x, float y) {
		if (x > this.x - 70 && x < (this.x - 70 + 350) && y > this.y && y < (this.y + 45))
			return true;
		else
			return false;
	}
}
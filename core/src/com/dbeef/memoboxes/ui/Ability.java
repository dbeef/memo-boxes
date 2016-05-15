package com.dbeef.memoboxes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Ability {

	public int manaCost;

	public int x, y;

	public double loadingAbilityTime = 0;

	public boolean clicked = false;
	public boolean clickedBefore = false;

	public Rectangle touchArea = new Rectangle();

	public Texture abilityImage;
	public Texture abilityImageBorder;
	public Texture manaLoadingBorder;

	public void load(int mc, int x, int y, Texture ai, Texture aib, Texture mlb) {

		abilityImage = ai;
		manaCost = mc;
		abilityImageBorder = aib;
		manaLoadingBorder = mlb;
		this.x = x;
		this.y = y;
		touchArea.setSize(50);
		touchArea.setPosition(x, y);

	}

	public void draw(Batch batch, int mana) {
		if (mana < manaCost) {
			batch.setColor(0.85f, 0.85f, 1, 1);
		}

		if (clicked == false && clickedBefore == true) {
			loadingAbilityTime = 0;
			clickedBefore = false;
		}

		if (loadingAbilityTime < 60f)
			loadingAbilityTime += Gdx.graphics.getDeltaTime() * 10;
		if (loadingAbilityTime > 60f)
			loadingAbilityTime = 60;

		batch.draw(abilityImageBorder, x - 5, y - 5);
		batch.draw(manaLoadingBorder, x - 5, y - 5, 0, 0,
				(int) loadingAbilityTime, 60);

		if (clicked == true)
			batch.setColor(0.6f, 0.6f, 0.6f, 0.5f);
		if (loadingAbilityTime < 60)
			batch.setColor(0.6f, 0.6f, 0.6f, 0.5f);

		batch.draw(abilityImage, x, y);

		batch.setColor(1, 1, 1, 1);
	}

	public void checkCollision(int x, int y, int currentMana) {
		if (loadingAbilityTime == 60 && currentMana >= manaCost) {
			if (touchArea.contains(x, y) == true) {
				clicked = true;
				clickedBefore = true;
				loadingAbilityTime = 0;
			}

		}

	}

}

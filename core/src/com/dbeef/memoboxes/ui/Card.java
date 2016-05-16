package com.dbeef.memoboxes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Card {
	public double skaleKart[] = new double[5];
	double timer = 0;
	public int posX;
	public int posY;
	public double skala = 1.0f;
	public Sprite spriteGreen;
	public Sprite spriteRed;
	public Sprite spriteBlue;
	double timerSpawn = 0;

	public int status = 0;
	public int statusWychodzacy = 0;

	public void ustaw(Texture textureG, Texture textureR, Texture textureB) {
		for (int a = 0; a < 5; a++) {
			skaleKart[a] = 1f;
		}

		spriteGreen = new Sprite(textureG);
		spriteRed = new Sprite(textureB);
		spriteBlue = new Sprite(textureR);

		spriteGreen.setSize(140, 190);
		spriteRed.setSize(140, 190);
		spriteBlue.setSize(140, 190);

	}

	public void narysuj(int x, int y, int ktora, Batch batch, int ktoraKarta) {
		timer += Gdx.graphics.getDeltaTime();
		if (timer > 0.001f) {
			if (y < 400 && y > 300) {
				skaleKart[ktoraKarta] += 0.01f;
				if (ktora == 1)
					status = 1;
				if (ktora == 2)
					status = 2;
				if (ktora == 3)
					status = 3;
			}
			if (y < 300 && y > 200)
				skaleKart[ktoraKarta] -= 0.01f;
			timer = 0;
		}

		if (ktora == 2) {
			spriteBlue.setScale((float) skaleKart[ktoraKarta]);
			spriteBlue.setPosition(x, y);
			spriteBlue.draw(batch);
			spriteBlue.setScale(1f);
		}
		if (ktora == 1) {
			spriteRed.setScale((float) skaleKart[ktoraKarta]);
			spriteRed.setPosition(x, y);
			spriteRed.draw(batch);
			spriteRed.setScale(1f);
			// spawnCzerwonyGem(batch);
		}
		if (ktora == 3) {
			spriteGreen.setScale((float) skaleKart[ktoraKarta]);

			spriteGreen.setPosition(x, y);
			spriteGreen.draw(batch);
			spriteGreen.setScale(1f);
		}
	}
}

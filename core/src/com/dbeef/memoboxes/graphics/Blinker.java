package com.dbeef.memoboxes.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Blinker {
	public int blinkingColor = 4;

	public double redValue = 1;
	public double greenValue = 1;
	public double blueValue = 1;

	public double tempR = 1;
	public double tempG = 1;
	public double tempB = 1;

	public Sprite blinkingBar;

	public double timer = 0;

	public Blinker(Texture bB, int x, int y, float scale) {
		blinkingBar = new Sprite(bB);
		blinkingBar.setPosition(x, y);
		blinkingBar.setScale(scale);
	}

	public Blinker(TextureRegion bB, int x, int y, float scale) {
		blinkingBar = new Sprite(bB);
		blinkingBar.setPosition(x, y);
		blinkingBar.setScale(scale);
	}

	public void changeColor(int bC) {
		blinkingColor = bC;
	}

	public void render(Batch batch) {
		blinkingBar.setColor((float) redValue, (float) greenValue,
				(float) blueValue, 1);
		blinkingBar.draw(batch);
	}

	public void updateTimers() {

		if (blinkingColor == 2) { // RED
			if (greenValue > 0.5f)
				greenValue -= Gdx.graphics.getDeltaTime();
			if (blueValue > 0.5f)
				blueValue -= Gdx.graphics.getDeltaTime();
			if (redValue < 1) {
				redValue += Gdx.graphics.getDeltaTime();

				if (redValue > 1)
					redValue = 1;
			}
		}
		if (blinkingColor == 4) { // RESET COLOURS (DEFAULT)
			if (redValue < 1) {
				redValue += Gdx.graphics.getDeltaTime();

				if (redValue > 1)
					redValue = 1;
			}
			if (greenValue < 1) {
				greenValue += Gdx.graphics.getDeltaTime();

				if (greenValue > 1)
					greenValue = 1;
			}
			if (blueValue < 1) {
				blueValue += Gdx.graphics.getDeltaTime();

				if (blueValue > 1)
					blueValue = 1;

			}
		}

		if (blinkingColor == 3) { // GREEN
			if (redValue > 0.5f)
				redValue -= Gdx.graphics.getDeltaTime();
			if (blueValue > 0.5f)
				blueValue -= Gdx.graphics.getDeltaTime();
			if (greenValue < 1) {
				greenValue += Gdx.graphics.getDeltaTime();

				if (greenValue > 1)
					greenValue = 1;
			}
		}
		if (blinkingColor == 1) { // BLUE
			if (redValue > 0.5f)
				redValue -= Gdx.graphics.getDeltaTime();
			if (greenValue > 0.5f)
				greenValue -= Gdx.graphics.getDeltaTime();
			if (blueValue < 1) {
				blueValue += Gdx.graphics.getDeltaTime();

				if (blueValue > 1)
					blueValue = 1;
			}
		}
		if (tempR != redValue || tempG != greenValue || tempB != blueValue) {
			blinkingBar
					.setColor((float) tempR, (float) tempG, (float) tempB, 1);
			tempR = redValue;
			tempG = greenValue;
			tempB = blueValue;
		}

	}

}
package com.dbeef.memoboxes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Prompter {
	// public boolean interrupts[] = new boolean[13];
	public double delaySprite[] = new double[21];
	public double delayWait[] = new double[21];
	public Sprite sprite[] = new Sprite[21];
	public boolean stopWaiting = false;
	public boolean gotIt = false;
	public int ktore = 0;
	public boolean makeItStop = false;
	public int ileRazem = 0;
	public double alfa = 0;

	public void rysuj(Batch batch) {
		waiting();
		if (stopWaiting == true && gotIt == false) {
			if (sprite[ktore].getScaleX() > 1)
				sprite[ktore].setScale(sprite[ktore].getScaleX()
						- Gdx.graphics.getDeltaTime() * 5);
			if (alfa <= 1)
				sprite[ktore].setAlpha((float) alfa);
			if (sprite[ktore].getScaleX() < 1) {
				sprite[ktore].setScale(1);
				gotIt = true;
			}
			if (gotIt == false)
				if (alfa <= 1)
					alfa += Gdx.graphics.getDeltaTime() * 5;

		}
		if (gotIt == true) {
			if (delaySprite[ktore] > 0)
				delaySprite[ktore] -= Gdx.graphics.getDeltaTime();
			if (delaySprite[ktore] <= 0) {
				delaySprite[ktore] = 0;
				makeItStop = true;
			}
		}
		if (makeItStop == true) {
			if (sprite[ktore].getScaleX() > 0)
				sprite[ktore].setScale(sprite[ktore].getScaleX()
						- Gdx.graphics.getDeltaTime() * 3);
			// if(alfa > 0)alfa -= Gdx.graphics.getDeltaTime()*1f;
			// if(alfa >= 0)sprite[ktore].setAlpha((float)alfa);
			if (sprite[ktore].getScaleX() < 0) {
				sprite[ktore].setScale(0);
				if (ktore < ileRazem)
					ktore++;
				stopWaiting = false;
				gotIt = false;
				makeItStop = false;
				alfa = 0;
			}
		}

		if (stopWaiting == true)
			sprite[ktore].draw(batch);

	}

	public void waiting() {
		if (delayWait[ktore] > 0) {
			delayWait[ktore] -= Gdx.graphics.getDeltaTime();
			if (delayWait[ktore] <= 0) {
				delayWait[ktore] = 0;
				stopWaiting = true;
			}
		}
	}

}

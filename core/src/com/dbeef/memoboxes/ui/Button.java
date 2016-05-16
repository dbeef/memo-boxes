package com.dbeef.memoboxes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Button {

	public int width;
	public int height;

	public int x;
	public int y;

	public double timer = 0;
	public double timer2 = 0;
	
	public double scale = 1f;

	public boolean szybkiPrzycisk = false;
	public boolean clicked = false;
	public boolean czySzybki = false;
	public boolean czyClicked = false;

	public Sprite buttonImage;

	public void setButtonPropeties(int w, int h, TextureRegion tex1, int x,
			int y) {
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		buttonImage = new Sprite(tex1);
		buttonImage.setPosition(x, y);
	}

	public void setButtonPropeties(int w, int h, Texture tex1, int x, int y) {
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		buttonImage = new Sprite(tex1);
		buttonImage.setPosition(x, y);
	}

	public void button_display(Batch batch) {
		buttonImage.setPosition(x, y);

		if (clicked == false)
			buttonImage.draw(batch);
		if (clicked == true) {
			czyClicked = true;
		}

		if (czyClicked == true) {
			if (czySzybki == true) {
				timer += Gdx.graphics.getDeltaTime();
				timer2 += Gdx.graphics.getDeltaTime();
			}
			timer += Gdx.graphics.getDeltaTime();
			timer2 += Gdx.graphics.getDeltaTime();
			if (timer2 > 0.7f) {
				czyClicked = false;
				scale = 1;
				timer = 0;
				timer2 = 0;
			}

			if (timer > 0.04f && timer2 < 0.35f) {
				timer = 0;
				scale += 0.01f;
				if (szybkiPrzycisk == true) {
					scale += 0.02f;
				}
			}

			if (timer > 0.04f && timer2 > 0.35f) {
				timer = 0;
				scale -= 0.01f;

				if (szybkiPrzycisk == true) {
					scale -= 0.02f;
				}
			}
			buttonImage.setScale((float) scale);
			buttonImage.draw(batch);

		}

	}

	public void button_display_second(Batch batch) {
		if (clicked == false)
			buttonImage.draw(batch);
		if (clicked == true) {
			czyClicked = true;
		}

		if (czyClicked == true) {
			timer += Gdx.graphics.getDeltaTime();
			timer2 += Gdx.graphics.getDeltaTime();
			if (timer2 > 0.7f) {
				czyClicked = false;
				scale = 1;
				timer = 0;
				timer2 = 0;
			}

			if (timer > 0.04f && timer2 < 0.35f) {
				timer = 0;
				scale += 0.08f;
				if (szybkiPrzycisk == true) {
					scale += 0.02f;
				}
			}

			if (timer > 0.04f && timer2 > 0.35f) {
				timer = 0;
				scale -= 0.08f;

				if (szybkiPrzycisk == true) {
					scale -= 0.02f;
				}
			}
			batch.setColor(1f, 1f, (float) scale, 1);

		}

	}

	public boolean button_mouse_collision(float x, float y) {
		if (x > this.x && x < (this.x + width) && y > this.y
				&& y < (this.y + height))
			return true;
		else
			return false;
	}

	public void changePosition(int x, int y) {
		this.x = x;
		this.y = y;
		buttonImage.setPosition(x, y);
	}
}
package com.dbeef.memoboxes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Button {

	public int doladujX = 0;
	public int doladujY = 0;

	public int width;
	public int height;

	public int x;
	public int y;

	public double timer = 0;
	public double timer2 = 0;
	public double timer3 = 0;
	public double skala = 1f;
	public float obrot = 0;
	public float updateTime = 0;

	public boolean szybkiPrzycisk = false;
	public boolean clicked = false;
	public boolean czySzybki = false;
	public boolean czyClicked = false;
	public boolean czyDoladowano = false;

	public Sprite buttonImage;
	public Texture button_texture_notClicked = null;

	public void update() {
		if (updateTime < 0.01) {
			updateTime += Gdx.graphics.getDeltaTime();
		} else {
			updateTime = 0;
			obrot += 0.4;
		}

	}

	public void setButtonPropeties(int w, int h, TextureRegion tex1, int x,
			int y) {
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		buttonImage = new Sprite(tex1);
		buttonImage.setPosition(x, y);

	}
	public void setButtonPropeties(int w, int h, Texture tex1, int x,
			int y) {
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
				skala = 1;
				timer = 0;
				timer2 = 0;
			}

			if (timer > 0.04f && timer2 < 0.35f) {
				timer = 0;
				// if(czySzybki == true)skala+=0.09f;
				skala += 0.01f;
				if (szybkiPrzycisk == true) {
					skala += 0.02f;
				}
			}

			if (timer > 0.04f && timer2 > 0.35f) {
				timer = 0;
				// if(czySzybki == true)skala-=0.09f;
				skala -= 0.01f;

				if (szybkiPrzycisk == true) {
					skala -= 0.02f;
				}
			}
			buttonImage.setScale((float) skala);
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
				skala = 1;
				timer = 0;
				timer2 = 0;
			}

			if (timer > 0.04f && timer2 < 0.35f) {
				timer = 0;
				skala += 0.08f;
				if (szybkiPrzycisk == true) {
					skala += 0.02f;
				}
			}

			if (timer > 0.04f && timer2 > 0.35f) {
				timer = 0;
				skala -= 0.08f;

				if (szybkiPrzycisk == true) {
					skala -= 0.02f;
				}
			}
			batch.setColor(1f, 1f, (float) skala, 1);
			// batch.draw(button_texture_Clicked,x,y);

		}

	}

	public boolean button_mouse_collision(float x, float y) {
		
		if (this.x > x && this.x < (x + width)
				&& this.y > y
				&& this.y < (y + height))
			return true;
		else
			return false;
	}

	public boolean button_mouse_collision2(float x, float y) {
		if (this.x > x + doladujX
				&& this.x < (x + doladujX + width)
				&& this.y > y + doladujY
				&& this.y < (y + doladujY + height))
			return true;
		else
			return false;
	}

	public void doladowanie(int x, int y) {
		czyDoladowano = true;
		doladujX = x;
		doladujY = y;
	}
	public void changePosition(int x, int y){
		this.x = x;
		this.y = y;
		buttonImage.setPosition(x, y);
	}
}
package com.dbeef.memoboxes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ShopItem {

	public int item_y;
	public int item_x;
	public boolean mrygnij = false;
	public double poziomKolor = 0.65f;
	
	public Sprite spriteTexture;

	public Texture mem1;
	public Texture mem2;
	public Texture mem3;
	
	
	//game.buttonHardClicked
	
	public double colourTexture = 1;
	public double colourTexture2 = 1;
	
	public boolean czyKupiony;
	public boolean czyWybrany;
	
	public void load(TextureRegion t, int x, int y, boolean cK, boolean cW){
		item_x = x+100;
		item_y = y-15;
		czyKupiony = cK;
		czyWybrany = cW;
		spriteTexture = new Sprite(t);
	spriteTexture.setScale(2f,1.5f);
	}
	
	public void draw(Batch batch){
		


		if(czyKupiony == true){
			if(poziomKolor < 1f)poziomKolor += Gdx.graphics.getDeltaTime();
	if(poziomKolor > 1f)poziomKolor = 1f;
		}
		spriteTexture.setPosition(item_x, item_y);

spriteTexture.setColor((float)poziomKolor,(float)poziomKolor,1,1);

if(mrygnij == true){
if(poziomKolor > 0.7f)poziomKolor -= 4*Gdx.graphics.getDeltaTime();
if(poziomKolor < 0.7f){poziomKolor = 0.7f;mrygnij = false;}
}
		spriteTexture.draw(batch);
	}
	

public boolean button_mouse_collision(float x, float y)
		{
	if(x > item_x-70 && x < (item_x-70 + 350) && y > item_y && y < (item_y + 45))
		return true;
		else 
			return false;
		}	
}

package com.dbeef.memoboxes.screens;

import java.util.Iterator;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.dbeef.memoboxes.Main;
import com.dbeef.memoboxes.ui.Button;

public class MenuScreen implements Screen {
	//
	
	
	public double timerDoGory = 0;
	//
	public double redTimer = 1;
	
	public double skalaInfo = 0;
	
	public boolean odkliknijInfo = false;
	//
	public boolean czyPrzestac = false;
	
	public boolean czyWroc = false;
	public int ileGier;
	public boolean czySklep = false;
	public double timerSklep = 1;
	public boolean czyCzerwony = false;
	public double odejmujacaSklep = 1;
	public boolean wlaczTimer = false;
	public double timer1 = 0;
	public double generalAlpha = 1;
	public boolean czyPrzejscie = false;
	//
	public boolean przejscieDoInfo = false;
	double spawnTimer = 1;
		//
		double timerBcg =0;		
		int pozycjeBackground[];
		//
		
		float tablicaAlfa[] = new float[480];
		int ktore = 1;
		double timerKtore = 0;
	//
Body bodybody;
		public double exitTimer = 0;

		double timerSettings = 0;
		
	double skalaOgolna = 0f;
	boolean czyMinus = false;
	

	double skalaOgolna2 = 0f;
	boolean czyMinus2 = false;
	
	boolean czyRysowacPrzyciski = false;
	
	double timerLogo = 0.0;
	double zoom = 1;
	boolean czyZoom = true;
	//Spritegame.batch game.batch;
	public double timerPoKupieniu = 0;
	//
	public boolean czyInfo = false;
	public double infoTimer = 0;
	public boolean infoPrzejscie = false;
	//
	//OrthographicCamera camera;

	double skala = 1f;
	
	//Piatek. Ekran ustawien cd
	boolean czyPrzyciemnienie = false;
public boolean czyR1 = false;
public boolean czyR2 = false;
public boolean czyR3 = false;
public boolean czyR4 = false;
public boolean czyR5 = false;
public boolean czyR6 = false;
public boolean czyR7 = false;
public boolean czyR8 = false;
public boolean czyR9 = false;
public boolean czyR10 = false;
public boolean czyR11 = false;
public boolean czyR12 = false;
public boolean czyR13 = false;
public boolean czyR14 = false;
public boolean czyR15 = false;
public boolean czyR16 = false;
public boolean czyR17 = false;
public boolean czyR18 = false;

public boolean pokazReklame = false;
public boolean ukryjReklame = false;
public double R1Scale = 0.8f;
public double R2Scale = 0.8f;
public double R3Scale = 0.8f;
public double R4Scale = 1.5f;
public double R5Scale = 1.5f;
public double R6Scale = 1.5f;
public double R7Scale = 0.8f;
public double R8Scale = 0.8f;
public double R9Scale = 0.8f;
public double R10Scale = 1.2f;
public double R11Scale = 1.2f;
public double R12Scale = 1.2f;
public double R13Scale = 0.7f;
public double R14Scale = 0.7f;
public double R15Scale = 0.7f;
public double R16Scale = 1.4f;
public double R17Scale = 1.4f;
public double R18Scale = 1.4f;

public double timerCzyR1 = 0;	
//
	boolean czyPrzyciemnienie2 = true;
	double timerPrzyciemnienie3 = 1;
	//
	
	double timerPrzyciemnienie = 0;
	double timerPrzyciemnienie2 = 1;
	
	double timerBackground = 0;
	//
	boolean przyciskStart = false;
	boolean przyciskUstawienia = false;
	boolean przyciskWyjscie = false;
	
	
	//Czwartek. Ekran ustawien:
	double kolor1 = 1f;
	double kolor2 = 1f;
	
	boolean czyUstawienia = false;
	boolean english = true;
	boolean polish = false;
	
	//Box2DDebugRenderer renderer;
	
    int a = 0;
    int b = 1024;
	public int ostatniWynik;

	Iterator iterInt ;
	Iterator<Body> iter ;

	final Main game;

public MenuScreen(final Main main) {

	game = main;
	game.logo.setPosition(-80, 605);
//	game.spriteLogoBackground.setPosition(-120,580);

	 iterInt = game.spriteTypes.iterator();
 iter = game.bodies.iterator();

//	game.adsController.changeSizeMedium();
//	game.adsController.changePosition(0,-300);
 game.spritePlay.setPosition(160,490);
 game.grajSprite.setPosition(140,485);
	
 
	game.bodies.clear();
	ostatniWynik = game.prefs.getInteger("highscore");
	ileGier = game.prefs.getInteger("ileGier");
	game.ileGier = ostatniWynik;
	game.wibracje = game.prefs.getBoolean("wibracje");
	
	if(game.prefs.getInteger("music") != 0)
	game.poziomMuzyki = game.prefs.getInteger("music");
	if(game.prefs.getInteger("sound") != 0)
	game.poziomDzwieku = game.prefs.getInteger("sound");
	


	
	game.pol = game.prefs.getBoolean("pol");
	game.uk = game.prefs.getBoolean("uk");
	
	game.ileGemow = game.prefs.getInteger("ileGemow");
if(game.prefs.getInteger("ktorySkin") != 0)
	game.ktorySkin = game.prefs.getInteger("ktorySkin");
	
	
	
//	System.out.println(game.poziomDzwieku);
//	System.out.println(game.poziomMuzyki);

	game.jukebox.changeVolume(game.poziomMuzyki, game.poziomDzwieku);

	game.jukebox.playMusic();
	if(game.wibracje == false)
    game.vibrationsButton.buttonImage = new Sprite(game.textureVibrationsButtonOff);
     if(game.wibracje == true)
    game.vibrationsButton.buttonImage = new Sprite(game.textureVibrationsButtonOn);

	//game.button3.buttonImage.setScale(1);
	//game.buttonNormal.buttonImage.setScale(1);
	//game.buttonHard.buttonImage.setScale(1);
	//game.buttonHard.clicked =false;
	//game.buttonHard.czyClicked =false;
	/*
game.logo.setAlpha(1);
game.spriteLogoBackground.setAlpha(1);

game.button3.buttonImage.setAlpha(1);
game.buttonNormal.buttonImage.setAlpha(1);
game.buttonHard.buttonImage.setAlpha(1);
game.backButtonShop.buttonImage.setAlpha(1);
game.buttonShop.buttonImage.setAlpha(1);
game.buttonInfo.buttonImage.setAlpha(1);

game.spriteCart.setAlpha(1);
game.spriteInfo.setAlpha(1);

game.spriteBestScore.setAlpha(1);
game.spriteGamesPlayed.setAlpha(1);

game.spriteSettings.setAlpha(1);
game.spritePlay.setAlpha(1);
game.exitSprite.setAlpha(1);
*/
//Set all alpha to 1

 	pozycjeBackground = new int[23];
 	for(int a=-379, b = 0;a<481;a++){
 	pozycjeBackground[b] = a;
 		b++;
 		a+=39;
 		}
	/*
	pozycjeBackground = new int[14];
	for(int a=0, b = 0;a<560;a++){
		pozycjeBackground[b] = a;
		b++;
		a+=39;
		}
		*/
  	 game.backButtonShop.y = -100;
  	 //game.backButtonShop.buttonImage.setColor(0.65f,0.65f,1,1);
  	 game.camera = new OrthographicCamera();
		game.camera.setToOrtho(false, 480, 800);
		game.world = new World( new Vector2(0,-70f),false);
			game.ileKart = 3;
			game.numerPoziomu = 1;

			game.batch = new SpriteBatch(5460);
		    game.batch.setProjectionMatrix(game.camera.combined);
			
			//box2d
		game.width = Gdx.graphics.getWidth()/5;
		game.height = Gdx.graphics.getHeight()/5;
		//game.world = new World( new Vector2(0,-70f),false);
//		renderer = new Box2DDebugRenderer();
		
		
	//	texGem = new Texture("element_green_square_glossy.png");
	//	texGem.setFilter(TextureFilter.Linear, TextureFilter.MipMapLinearLinear);
	///	gem = new Sprite(texGem);
		
	
//		game.ktorySkin = game.prefs.getInteger("ktorySkin");
//		game.s1.czyKupiony = game.prefs.getBoolean("s1");
		game.s2.isAlreadyBought = game.prefs.getBoolean("s2");
		game.s3.isAlreadyBought = game.prefs.getBoolean("s3");
	game.s4.isAlreadyBought = game.prefs.getBoolean("s4");
	game.s5.isAlreadyBought = game.prefs.getBoolean("s5");
	game.s6.isAlreadyBought = game.prefs.getBoolean("s6");
		
		
		   
		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.position.set(0,0);
		Body groundBody = game.world.createBody(groundBodyDef);
for(int a =0;a<480;a++){
	tablicaAlfa[a] = 0;
}

	PolygonShape groundBox = new PolygonShape();
	groundBox.setAsBox(480, 14f);
	
	groundBody.createFixture(groundBox,0.0f);

	BodyDef groundBodyDefLeft = new BodyDef();
	groundBodyDefLeft.position.set(0,0);
	Body groundBodyLeft = game.world.createBody(groundBodyDefLeft);

PolygonShape groundBoxLeft = new PolygonShape();
groundBoxLeft.setAsBox(14f, 1000f);

groundBodyLeft.createFixture(groundBoxLeft,0.0f);

	
BodyDef groundBodyDefRight = new BodyDef();
groundBodyDefRight.position.set(575,0);
Body groundBodyRight = game.world.createBody(groundBodyDefRight);

PolygonShape groundBoxRight = new PolygonShape();
groundBoxRight.setAsBox(140f, 1000f);

groundBodyRight.createFixture(groundBoxRight,0.0f);
game.czyOdciemnic = true;
	game.logo.setPosition(-80, 605);
	
//	groundBox.setAsBox(2, 500f);
	for(int a =0;a<15;a++)spawnBody(true);
	game.ustawienia2Sprite.setScale(0);
}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 123, 180);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.exitSprite.setScale((float)skalaOgolna);
		game.spritePlay.setScale((float)skalaOgolna);
		game.settingsMenu.setScale((float)skalaOgolna2);
		game.spriteBestScore.setScale((float)skalaOgolna);
		game.spriteGamesPlayed.setScale((float)skalaOgolna);
		game.spriteCart.setScale((float)skalaOgolna);
		game.spriteInfo.setScale((float)skalaOgolna);
//
		   if(generalAlpha >0.93 && ukryjReklame == false && pokazReklame == false){
			   ukryjReklame = false;
			   pokazReklame = false;
		   }

game.najlepszySprite.setScale((float)skalaOgolna);
game.rozegraneSprite.setScale((float)skalaOgolna);
if(skalaOgolna < 0.615f)
game.ustawienia2Sprite.setScale((float)skalaOgolna);
if(skalaOgolna < 0.80f)
game.grajSprite.setScale((float)skalaOgolna);
if(skalaOgolna < 0.9f)
game.wyjscieSprite.setScale((float)skalaOgolna);
		//
		
if(skalaOgolna2 < 0.9f && czyMinus2 == false){
skalaOgolna2+= Gdx.graphics.getDeltaTime()*(skalaOgolna2+2);
if(skalaOgolna2 > 0.9f){skalaOgolna2 = 0.9f;
czyMinus2 = true;
}
}
if(czyMinus2 == true){
	if(skalaOgolna2 > 0.74f)
	{
		skalaOgolna2 -= Gdx.graphics.getDeltaTime()*(skalaOgolna2+0.5f);
		if(skalaOgolna2 < 0.74f){skalaOgolna2 = 0.74f;
		//czyRysowacPrzyciski = true;
		}
		}
}



if(skalaOgolna < 1.2 && czyMinus == false){
skalaOgolna+= Gdx.graphics.getDeltaTime()*(skalaOgolna+2);
if(skalaOgolna > 1.2){skalaOgolna = 1.2;
czyMinus = true;
}
}
if(czyMinus == true){
	if(skalaOgolna > 1f)
	{
		skalaOgolna -= Gdx.graphics.getDeltaTime()*(skalaOgolna+0.5f);
		if(skalaOgolna < 1f)skalaOgolna = 1;
	}
}
//if(czySklep == true){
//}
if(game.button3.clicked == true)exitTimer+=Gdx.graphics.getDeltaTime();
if(exitTimer > 0.3f){
	   game.prefs.flush();

	Gdx.app.exit();
}
setGeneralAlpha();
//
if(czyInfo == true){

	if(infoTimer > 0){
	infoTimer -= 3*Gdx.graphics.getDeltaTime();
	}
	
	
}
if(infoTimer < 0){infoTimer = 0;
czyInfo = false;
}

if(czyInfo == false && infoTimer < 1)infoTimer+=3*Gdx.graphics.getDeltaTime();
if(infoTimer > 1)infoTimer = 1;
if(infoTimer < 0)infoTimer = 0;
//

//
if(czySklep == true){
	czyPrzejscie = true;

timerSklep -= 3*Gdx.graphics.getDeltaTime();
}
if(timerSklep < 0 ){
	timerSklep = 0;
czyCzerwony = true;
}
if(czyCzerwony == true){
	timerSklep += 3*Gdx.graphics.getDeltaTime();
	czySklep = false;
}
if(timerSklep > 1){timerSklep = 1;
czyCzerwony = false;
}
if(przejscieDoInfo == false)
game.buttonShop.buttonImage.setColor((float)timerSklep, 1,(float) timerSklep, 1);
//game.buttonInfo.buttonImage.setColor(1,1,1, 1);
game.buttonInfo.buttonImage.setColor((float)infoTimer ,1,(float)infoTimer,1);

//game.spriteLogoBackground.setColor(1,1,1,1);	  


if (Gdx.input.isTouched()) {
	
	Vector3 touchPos = new Vector3();
       touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
     
       game.camera.unproject(touchPos);
       
       if(generalAlpha >0.93){
if(game.button3.button_mouse_collision(touchPos.x, touchPos.y) == true){
czyPrzyciemnienie = true;
game.button3.clicked = true;
game.jukebox.playClick();
if(game.wibracje == true)Gdx.input.vibrate(40);		

}

       if(game.buttonInfo.button_mouse_collision(touchPos.x, touchPos.y) == true){
    	// game.buttonInfo.doladowanie(100, 25);
    	   czyInfo = true;
    	  czySklep = true;
    	  przejscieDoInfo = true;
    	  game.jukebox.playClick();
    	  if(game.wibracje == true)Gdx.input.vibrate(40);		
       }
       else{ //game.buttonShop.clicked = false;
      
       }
     
       
	   
       if(game.buttonNormal.button_mouse_collision(touchPos.x, touchPos.y) == true){
    	
    	   game.buttonNormal.clicked = true;

    	   czyPrzyciemnienie = true;
    	   
    	   przyciskStart = true;
    		  game.jukebox.playClick();
    		  if(game.wibracje == true)Gdx.input.vibrate(40);
       }
       else{ game.buttonNormal.clicked = false;
       }    
       if(game.buttonHard.button_mouse_collision(touchPos.x, touchPos.y) == true){
    	   game.buttonHard.clicked = true;
    		  game.jukebox.playClick();
    		  if(game.wibracje == true)Gdx.input.vibrate(40);
    	   czyPrzyciemnienie = true;
    	   przyciskUstawienia = true;
    	   
    	   //
    	   iter = game.bodies.iterator();

    	   while (iter.hasNext()){
    	   	 bodybody = iter.next();
    	   	
    	   bodybody.setLinearVelocity(0, MathUtils.random(0,1000));
    	   
    	   //
    	   }
       }
       else {
    	   game.buttonHard.clicked = false;

 }

       if(game.buttonShop.button_mouse_collision(touchPos.x, touchPos.y) == true){
    	if(przyciskUstawienia == false)   czySklep = true;
  	  game.jukebox.playClick();
  	 if(game.wibracje == true)Gdx.input.vibrate(40);
       }
       else{ //game.buttonShop.clicked = false;
      
       }
       }
       //
       if(game.s1.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s1.isAlreadyBought == false && generalAlpha == 0 ){
    	   game.s1.isAlreadyBought = true;
    	   timerPoKupieniu = 0.5f;
    	   //  game.prefs.putBoolean("s1", true);
    	 //50,150,350,500,1000
       }   if(game.s2.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s2.isAlreadyBought == false && generalAlpha == 0 && game.ileGemow >= 50){
 	   game.s2.isAlreadyBought = true;
 	   game.ileGemow -= 50;
 		game.prefs.putInteger("ileGemow", game.ileGemow);
	   timerPoKupieniu = 0.5f;
	   game.prefs.putBoolean("s2", true);
//	   game.prefs.flush();
 }   if(game.s3.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s3.isAlreadyBought == false && generalAlpha == 0 && game.ileGemow >= 150){
	   game.ileGemow -= 150;
		game.prefs.putInteger("ileGemow", game.ileGemow);

	 game.s3.isAlreadyBought = true;
	   timerPoKupieniu = 0.5f;
	   game.prefs.putBoolean("s3", true);
//	   game.prefs.flush();
 }   if(game.s4.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s4.isAlreadyBought == false && generalAlpha == 0 && game.ileGemow >= 350){
	   game.ileGemow -= 350;
		game.prefs.putInteger("ileGemow", game.ileGemow);

	 game.s4.isAlreadyBought = true;
	   timerPoKupieniu = 0.5f;
	   game.prefs.putBoolean("s4", true);
//	   game.prefs.flush();
}   if(game.s5.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s5.isAlreadyBought == false && generalAlpha == 0 && game.ileGemow >= 500){
	   game.ileGemow -= 500;
		game.prefs.putInteger("ileGemow", game.ileGemow);

	game.s5.isAlreadyBought = true;
	   timerPoKupieniu = 0.5f;
	   game.prefs.putBoolean("s5", true);
//	   game.prefs.flush();
}
       if(game.s6.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s6.isAlreadyBought == false && generalAlpha == 0 && game.ileGemow >= 1000){
     	   game.ileGemow -= 1000;
    		game.prefs.putInteger("ileGemow", game.ileGemow);

    	   game.s6.isAlreadyBought = true;
    	   timerPoKupieniu = 0.5f;
    	   game.prefs.putBoolean("s6", true);
    	   
//    	   game.prefs.flush();
       }
 //

       if(game.s1.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s1.isAlreadyBought == true && generalAlpha == 0 && timerPoKupieniu == 0 && czyWroc == false && game.backButtonShop.y >= 710){
    	  if(game.ktorySkin != 1){
    			  game.Green.button_texture_notClicked = game.cardGreen;
    			  game.Green.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    			  game.Green.buttonImage = new Sprite(game.Green.button_texture_notClicked);
    			  game.Red.button_texture_notClicked = game.cardRed;
    			  game.Red.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    			  game. Red.buttonImage = new Sprite(game.Red.button_texture_notClicked);
    			  game. Blue.button_texture_notClicked = game.cardBlue;
    			  game. Blue.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    			  game.  Blue.buttonImage = new Sprite(game.Blue.button_texture_notClicked);
    	    
    	   game.kartonator.spriteGreen = new Sprite(game.cardGreen);
    	   	game.kartonator.spriteRed = new Sprite(game.cardBlue);
    	   	game.kartonator.spriteBlue = new Sprite(game.cardRed);

    	   	game.kartonator.spriteGreen.setSize(140, 190);
    	   	game.kartonator.spriteRed.setSize(140, 190);
    	   	game.kartonator.spriteBlue.setSize(140, 190);
    	  }
    	   game.s1.isAlreadyBought = true;
    	   wlaczTimer = true;
      		czyWroc = true;
     	   czyPrzejscie = false;
    	  game.jukebox.playClick();
    	  game.s1.blink = true;
    	 if(game.wibracje == true)Gdx.input.vibrate(40);
    	 game.ktorySkin = 1;
  	   game.prefs.putInteger("ktorySkin", 1);
  	  // game.prefs.flush();


    }   if(game.s2.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s2.isAlreadyBought == true && generalAlpha == 0 && timerPoKupieniu == 0 && czyWroc == false && game.backButtonShop.y >= 710){
  	  if(game.ktorySkin != 2){
		  game.Green.button_texture_notClicked = game.cardGreen2;
		  game.Green.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Green.buttonImage = new Sprite(game.Green.button_texture_notClicked);
		  game.Red.button_texture_notClicked = game.cardRed2;
		  game.Red.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Red.buttonImage = new Sprite(game.Red.button_texture_notClicked);
		  game.Blue.button_texture_notClicked = game.cardBlue2;
		  game.Blue.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Blue.buttonImage = new Sprite(game.Blue.button_texture_notClicked);

    	game.kartonator.spriteGreen = new Sprite(game.cardGreen2);
       	game.kartonator.spriteRed = new Sprite(game.cardBlue2);
       	game.kartonator.spriteBlue = new Sprite(game.cardRed2);

       	game.kartonator.spriteGreen.setSize(140, 190);
       	game.kartonator.spriteRed.setSize(140, 190);
       	game.kartonator.spriteBlue.setSize(140, 190);
  	  }
    	game.s2.isAlreadyBought = true;
	   wlaczTimer = true;
  		czyWroc = true;
 	   czyPrzejscie = false;
	  game.jukebox.playClick();
	 if(game.wibracje == true)Gdx.input.vibrate(40);
	 game.s2.blink = true;  
	   game.ktorySkin = 2;
	   game.prefs.putInteger("ktorySkin", 2);
//game.prefs.flush();
    }   if(game.s3.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s3.isAlreadyBought == true && generalAlpha == 0 && timerPoKupieniu == 0 && czyWroc == false && game.backButtonShop.y >= 710){
    	  if(game.ktorySkin != 3){
    		  game.Green.button_texture_notClicked = game.cardGreen3;
    		  game.Green.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    		  game.Green.buttonImage = new Sprite(game.Green.button_texture_notClicked);
    		  game.Red.button_texture_notClicked = game.cardRed3;
    		  game.Red.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    		  game.Red.buttonImage = new Sprite(game.Red.button_texture_notClicked);
    		  game.Blue.button_texture_notClicked = game.cardBlue3;
    		  game.Blue.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    		  game.Blue.buttonImage = new Sprite(game.Blue.button_texture_notClicked);

        	game.kartonator.spriteGreen = new Sprite(game.cardGreen3);
           	game.kartonator.spriteRed = new Sprite(game.cardBlue3);
           	game.kartonator.spriteBlue = new Sprite(game.cardRed3);

           	game.kartonator.spriteGreen.setSize(140, 190);
           	game.kartonator.spriteRed.setSize(140, 190);
           	game.kartonator.spriteBlue.setSize(140, 190);
      	  }
    	game.s3.isAlreadyBought = true;
	   game.s3.blink = true;
	   wlaczTimer = true;
  		czyWroc = true;
 	   czyPrzejscie = false;
	  game.jukebox.playClick();
	 if(game.wibracje == true)Gdx.input.vibrate(40);
	 game.ktorySkin = 3;
	   game.prefs.putInteger("ktorySkin", 3);
	 // game.prefs.flush(); 
}   if(game.s4.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s4.isAlreadyBought == true && generalAlpha == 0 && timerPoKupieniu == 0 && czyWroc == false && game.backButtonShop.y >= 710){
	  if(game.ktorySkin != 4){
		  game.Green.button_texture_notClicked = game.cardGreen4;
		  game.Green.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Green.buttonImage = new Sprite(game.Green.button_texture_notClicked);
		  game.Red.button_texture_notClicked = game.cardRed4;
		  game.Red.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Red.buttonImage = new Sprite(game.Red.button_texture_notClicked);
		  game.Blue.button_texture_notClicked = game.cardBlue4;
		  game.Blue.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Blue.buttonImage = new Sprite(game.Blue.button_texture_notClicked);

  	game.kartonator.spriteGreen = new Sprite(game.cardGreen4);
     	game.kartonator.spriteRed = new Sprite(game.cardBlue4);
     	game.kartonator.spriteBlue = new Sprite(game.cardRed4);

     	game.kartonator.spriteGreen.setSize(140, 190);
     	game.kartonator.spriteRed.setSize(140, 190);
     	game.kartonator.spriteBlue.setSize(140, 190);
	  }   
	game.s4.isAlreadyBought = true;
	   game.s4.blink = true;
	   wlaczTimer = true;
  		czyWroc = true;
 	   czyPrzejscie = false;
	  game.jukebox.playClick();
	 if(game.wibracje == true)Gdx.input.vibrate(40);
	   game.ktorySkin = 4;
	   game.prefs.putInteger("ktorySkin", 4);
	//game.prefs.flush();   
}   if(game.s5.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s5.isAlreadyBought == true && generalAlpha == 0 && timerPoKupieniu == 0 && czyWroc == false && game.backButtonShop.y >= 710){
	  if(game.ktorySkin != 5){
		  game.Green.button_texture_notClicked = game.cardGreen5;
		  game.Green.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Green.buttonImage = new Sprite(game.Green.button_texture_notClicked);
		  game.Red.button_texture_notClicked = game.cardRed5;
		  game.Red.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Red.buttonImage = new Sprite(game.Red.button_texture_notClicked);
		  game.Blue.button_texture_notClicked = game.cardBlue5;
		  game.Blue.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		  game.Blue.buttonImage = new Sprite(game.Blue.button_texture_notClicked);

  	game.kartonator.spriteGreen = new Sprite(game.cardGreen5);
     	game.kartonator.spriteRed = new Sprite(game.cardBlue5);
     	game.kartonator.spriteBlue = new Sprite(game.cardRed5);

     	game.kartonator.spriteGreen.setSize(140, 190);
     	game.kartonator.spriteRed.setSize(140, 190);
     	game.kartonator.spriteBlue.setSize(140, 190);
	  }   
	game.s5.isAlreadyBought = true;
	   game.s5.blink = true;
	   wlaczTimer = true;
  		czyWroc = true;
 	   czyPrzejscie = false;
	  game.jukebox.playClick();
	 if(game.wibracje == true)Gdx.input.vibrate(40);
	 game.ktorySkin = 5;
	   game.prefs.putInteger("ktorySkin", 5);	   
	 // game.prefs.flush();
}
       if(game.s6.buttonMouseCollision(touchPos.x, touchPos.y) == true && game.s6.isAlreadyBought == true && generalAlpha == 0 && timerPoKupieniu == 0 && czyWroc == false && game.backButtonShop.y >= 710){
    	  	  if(game.ktorySkin != 6){
    			  game.Green.button_texture_notClicked = game.cardGreen6;
    			  game.Green.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    			  game.Green.buttonImage = new Sprite(game.Green.button_texture_notClicked);
    			  game.Red.button_texture_notClicked = game.cardRed6;
    			  game.Red.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    			  game.Red.buttonImage = new Sprite(game.Red.button_texture_notClicked);
    			  game.Blue.button_texture_notClicked = game.cardBlue6;
    			  game.Blue.button_texture_notClicked.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    			  game.Blue.buttonImage = new Sprite(game.Blue.button_texture_notClicked);

    	    	game.kartonator.spriteGreen = new Sprite(game.cardGreen6);
    	       	game.kartonator.spriteRed = new Sprite(game.cardBlue6);
    	       	game.kartonator.spriteBlue = new Sprite(game.cardRed6);

    	       	game.kartonator.spriteGreen.setSize(140, 190);
    	       	game.kartonator.spriteRed.setSize(140, 190);
    	       	game.kartonator.spriteBlue.setSize(140, 190);
    	  	  }
    	   game.s6.blink = true;
    	   game.s6.isAlreadyBought = true;
    	   wlaczTimer = true;
      		czyWroc = true;
     	   czyPrzejscie = false;
    	  game.jukebox.playClick();
    	 if(game.wibracje == true)Gdx.input.vibrate(40);
    	 game.ktorySkin = 6;
  	   game.prefs.putInteger("ktorySkin", 6);
  	 //  game.prefs.flush();
    }
     
       //
       if(game.backButtonShop.button_mouse_collision(touchPos.x, touchPos.y) == true && generalAlpha == 0 && game.backButtonShop.y >= 710 ){
    
    	   
    	   wlaczTimer = true;
   		czyWroc = true;
  	   czyPrzejscie = false;
 	  game.jukebox.playClick();
 	 if(game.wibracje == true)Gdx.input.vibrate(40);
    	   
    	   //game.backButtonShop.clicked = true;
       }
       else{ //game.buttonShop.clicked = false;
      
       }
       
}
if(Gdx.input.isTouched() == false)game.buttonNormal.clicked = false;
if(Gdx.input.isTouched() == false)game.buttonHard.clicked = false;



if(game.czyOdciemnic == true ){
	timerPrzyciemnienie2 -= Gdx.graphics.getDeltaTime()*2;
	if(timerPrzyciemnienie2 < 0 ){timerPrzyciemnienie2 = 0;
	game.czyOdciemnic = false;
	}
}


if(czyPrzyciemnienie == true){
timerPrzyciemnienie += Gdx.graphics.getDeltaTime()*3;
if(timerPrzyciemnienie > 1  && przyciskUstawienia == true){timerPrzyciemnienie = 1;
czyPrzyciemnienie = false;
game.prefs.flush();
game.setScreen(new SettingsScreen(game));

}
if(timerPrzyciemnienie > 1  && przyciskStart == true){timerPrzyciemnienie = 1;
czyPrzyciemnienie = false;
game.prefs.flush();
if(game.rozegranoTutorial == false)
;
//	game.setScreen(new EndScreen(game));
else
	game.setScreen(new GameScreen(game));
	
}
}

//
		timerSettings += Gdx.graphics.getDeltaTime();
		if(timerSettings > 0.6f)
		{
		czyRysowacPrzyciski = true;
		}
		//
		
		//
		game.jukebox.updateTimers();
	//	game.camera.update();
		if(timerPoKupieniu > 0)timerPoKupieniu -= Gdx.graphics.getDeltaTime();
		if(timerPoKupieniu < 0)timerPoKupieniu = 0;
	   //
		if(czyR4 == true){
			if(R4Scale < 1.8f){R4Scale += Gdx.graphics.getDeltaTime();}
			if(R4Scale > 1.8f){R4Scale = 1.8f;czyR4 = false;}
		}
		if(czyR4 == false && R4Scale > 1.5f){
			czyR5 = true;
			R4Scale -= Gdx.graphics.getDeltaTime();
			if(R4Scale < 1.5f)R4Scale = 1.5f;
		}
		if(czyR5 == true){
			if(R5Scale < 1.8f){R5Scale += Gdx.graphics.getDeltaTime();}
			if(R5Scale > 1.8f){R5Scale = 1.8f;czyR5 = false;}
		}
		if(czyR5 == false && R5Scale > 1.5f){
			czyR6 = true;
			R5Scale -= Gdx.graphics.getDeltaTime();
			if(R5Scale < 1.5f)R5Scale = 1.5f;
		}
		if(czyR6 == true){
			if(R6Scale < 1.8f){R6Scale += Gdx.graphics.getDeltaTime();}
			if(R6Scale > 1.8f){R6Scale = 1.8f;czyR6 = false;}
		}
		if(czyR6 == false && R6Scale > 1.5f){
			czyR1 = true;
			R6Scale -= Gdx.graphics.getDeltaTime();
			if(R6Scale < 1.5f)R6Scale = 1.5f;
		}
		if(czyR1 == true){
			if(R1Scale < 1.1f){R1Scale += Gdx.graphics.getDeltaTime();}
			if(R1Scale > 1.1f){R1Scale = 1.1f;czyR1 = false;}
		}
		if(czyR1 == false && R1Scale > 0.8f){
			czyR2 = true;
			R1Scale -= Gdx.graphics.getDeltaTime();
			if(R1Scale < 0.8f)R1Scale = 0.8f;
		}
		if(czyR2 == true){
			if(R2Scale < 1.1f){R2Scale += Gdx.graphics.getDeltaTime();}
			if(R2Scale > 1.1f){R2Scale = 1.1f;czyR2 = false;}
		}
		if(czyR2 == false && R2Scale > 0.8f){
			czyR3 = true;
			R2Scale -= Gdx.graphics.getDeltaTime();
			if(R2Scale < 0.8f)R2Scale = 0.8f;
		}
		if(czyR3 == true){
			if(R3Scale < 1.1f){R3Scale += Gdx.graphics.getDeltaTime();}
			if(R3Scale > 1.1f){R3Scale = 1.1f;czyR3 = false;}
		}
		if(czyR3 == false && R3Scale > 0.8f){
			czyR7 = true;
			R3Scale -= Gdx.graphics.getDeltaTime();
			if(R3Scale < 0.8f)R3Scale = 0.8f;
		}
		if(czyR7 == true){
			if(R7Scale < 1.1f){R7Scale += Gdx.graphics.getDeltaTime();}
			if(R7Scale > 1.1f){R7Scale = 1.1f;czyR7 = false;}
		}
		if(czyR7 == false && R7Scale > 0.8f){
			czyR8 = true;
			R7Scale -= Gdx.graphics.getDeltaTime();
			if(R7Scale < 0.8f)R7Scale = 0.8f;
		}
		if(czyR8 == true){
			if(R8Scale < 1.1f){R8Scale += Gdx.graphics.getDeltaTime();}
			if(R8Scale > 1.1f){R8Scale = 1.1f;czyR8 = false;}
		}
		if(czyR8 == false && R8Scale > 0.8f){
			czyR9 = true;
			R8Scale -= Gdx.graphics.getDeltaTime();
			if(R8Scale < 0.8f)R8Scale = 0.8f;
		}
		if(czyR9 == true){
			if(R9Scale < 1.1f){R9Scale += Gdx.graphics.getDeltaTime();}
			if(R9Scale > 1.1f){R9Scale = 1.1f;czyR9 = false;}
		}
		if(czyR9 == false && R9Scale > 0.8f){
			czyR10 = true;
			R9Scale -= Gdx.graphics.getDeltaTime();
			if(R9Scale < 0.8f)R9Scale = 0.8f;
		}
		//
		if(czyR10 == true){
			if(R10Scale < 1.5f){R10Scale += Gdx.graphics.getDeltaTime();}
			if(R10Scale > 1.5f){R10Scale = 1.5f;czyR10 = false;}
		}
		if(czyR10 == false && R10Scale > 1.2f){
			czyR11 = true;
			R10Scale -= Gdx.graphics.getDeltaTime();
			if(R10Scale < 1.2f)R10Scale = 1.2f;
		}
		if(czyR11 == true){
			if(R11Scale < 1.5f){R11Scale += Gdx.graphics.getDeltaTime();}
			if(R11Scale > 1.5f){R11Scale = 1.5f;czyR11 = false;}
		}
		if(czyR11 == false && R11Scale > 1.2f){
			czyR12 = true;
			R11Scale -= Gdx.graphics.getDeltaTime();
			if(R11Scale < 1.2f)R11Scale = 1.2f;
		}
		
		if(czyR12 == true){
			if(R12Scale < 1.5f){R12Scale += Gdx.graphics.getDeltaTime();}
			if(R12Scale > 1.5f){R12Scale = 1.5f;czyR12 = false;}
		}
		if(czyR12 == false && R12Scale > 1.2f){
			czyR13 = true;
			R12Scale -= Gdx.graphics.getDeltaTime();
			if(R12Scale < 1.2f)R12Scale = 1.2f;
		}
		//
		if(czyR13 == true){
			if(R13Scale < 1f){R13Scale += Gdx.graphics.getDeltaTime();}
			if(R13Scale > 1f){R13Scale = 1f;czyR13 = false;}
		}
		if(czyR13 == false && R13Scale > 0.7f){
			czyR14 = true;
			R13Scale -= Gdx.graphics.getDeltaTime();
			if(R13Scale < 0.7f)R13Scale = 0.7f;
		}
		if(czyR14 == true){
			if(R14Scale < 1f){R14Scale += Gdx.graphics.getDeltaTime();}
			if(R14Scale > 1f){R14Scale = 1f;czyR14 = false;}
		}
		if(czyR14 == false && R14Scale > 0.7f){
			czyR15 = true;
			R14Scale -= Gdx.graphics.getDeltaTime();
			if(R14Scale < 0.7f)R14Scale = 0.7f;
		}
		if(czyR15 == true){
			if(R15Scale < 1f){R15Scale += Gdx.graphics.getDeltaTime();}
			if(R15Scale > 1f){R15Scale = 1f;czyR15 = false;}
		}
		if(czyR15 == false && R15Scale > 0.7f){
			czyR16 = true;
			R15Scale -= Gdx.graphics.getDeltaTime();
			if(R15Scale < 0.7f)R15Scale = 0.7f;
		}
		//
		if(czyR16 == true){
			if(R16Scale < 1.7f){R16Scale += Gdx.graphics.getDeltaTime();}
			if(R16Scale > 1.7f){R16Scale = 1.7f;czyR16 = false;}
		}
		if(czyR16 == false && R16Scale > 1.4f){
			czyR17 = true;
			R16Scale -= Gdx.graphics.getDeltaTime();
			if(R16Scale < 1.4f)R16Scale = 1.4f;
		}
		if(czyR17 == true){
			if(R17Scale < 1.7f){R17Scale += Gdx.graphics.getDeltaTime();}
			if(R17Scale > 1.7f){R17Scale = 1.7f;czyR17 = false;}
		}
		if(czyR17 == false && R17Scale > 1.4f){
			czyR18 = true;
			R17Scale -= Gdx.graphics.getDeltaTime();
			if(R17Scale < 1.4f)R17Scale = 1.4f;
		}
		if(czyR18 == true){
			if(R18Scale < 1.7f){R18Scale += Gdx.graphics.getDeltaTime();}
			if(R18Scale > 1.7f){R18Scale = 1.7f;czyR18 = false;}
		}
		if(czyR18 == false && R18Scale > 1.4f){
			//czyR18 = true;
			R18Scale -= Gdx.graphics.getDeltaTime();
			if(R18Scale < 1.4f)R18Scale = 1.4f;
		}
		//
		if(timerCzyR1 > 5f){
			czyR4 = true;
			timerCzyR1 = 0;
		}
		
		timerCzyR1+= Gdx.graphics.getDeltaTime();
		//
		//camera.zoom = 3.5f;
		//camera.update();
		
		game.batch.begin();
		
		if( generalAlpha == 0 && timerPoKupieniu == 0 && czyWroc == false && game.backButtonShop.y >= 710){
			if(pokazReklame == false)
			{
		//		game.adsController.showBannerAd();
			pokazReklame = true;
			}
		}
		else
		{if(pokazReklame == true)
		//game.adsController.hideBannerAd();
		pokazReklame  = false;
		}
		//System.out.println(game.ktorySkin);
drawBackground();		
//System.out.println(game.wind.loadTime);
		timerBackground += Gdx.graphics.getDeltaTime();
if(timerBackground > 0.01){
		if(game.a>-1024)game.a-=4;
		else game.a = 0;
	
		if(game.b>0)game.b-=4;
		else game.b = 1024;
timerBackground = 0;
}
spawnTimer += Gdx.graphics.getDeltaTime();
if(spawnTimer > 1 && game.limit < 20){
	spawnTimer = 0;
	spawnBody(false);
	game.limit++;
}
//box2d
game.gem.setScale(1.3f);
game.boxExplosiveSprite.setScale(1.3f);
game.gemRed.setScale(1.3f);
game.gemBlue.setScale(1.3f);

game.world.step(1/60f,6,2);
iterInt = game.spriteTypes.iterator();
iter = game.bodies.iterator();

while (iter.hasNext()){
	Body bodybody = iter.next();
	int d = (Integer) iterInt.next();
	
Vector2 vector = new Vector2();
vector = bodybody.getPosition();
if(d == 1){
game.gem.setRotation(bodybody.getAngle() * MathUtils.radiansToDegrees);
//
game.gem.setPosition((bodybody.getPosition().x * game.PIXELS_TO_METERS) - game.gem.
        getWidth()/2 , 
(bodybody.getPosition().y * game.PIXELS_TO_METERS) -game.gem.getHeight()/2 )
;
game.gem.setPosition(vector.x, vector.y);
game.gem.draw(game.batch);
}
if(d == 2){
game.gemRed.setRotation(bodybody.getAngle() * MathUtils.radiansToDegrees);
//
game.gemRed.setPosition((bodybody.getPosition().x * game.PIXELS_TO_METERS) - game.gem.
        getWidth()/2 , 
(bodybody.getPosition().y * game.PIXELS_TO_METERS) -game.gem.getHeight()/2 )
;
game.gemRed.setPosition(vector.x, vector.y);
game.gemRed.draw(game.batch);
}
if(d == 3){
game.gemBlue.setRotation(bodybody.getAngle() * MathUtils.radiansToDegrees);
//
game.gemBlue.setPosition((bodybody.getPosition().x * game.PIXELS_TO_METERS) - game.gemBlue.
        getWidth()/2 , 
(bodybody.getPosition().y * game.PIXELS_TO_METERS) -game.gem.getHeight()/2 )
;
game.gemBlue.setPosition(vector.x, vector.y);
game.gemBlue.draw(game.batch);
}


}
//game.batch.setColor(1,1,1,0.3f);
//game.batch.draw(game.przyciemnionyPasek,0,194);

//game.batch.draw(game.przyciemnionyPasek,0,96);
game.batch.setColor(1,1,1,1f);

timerKtore += Gdx.graphics.getDeltaTime();
if(timerKtore > 0.01){
	timerKtore = 0;
	ktore+= 5;
}
float r = 0f;
for(int a=239,b = ktore;a>0;a--){
if(b > 0 && tablicaAlfa[a] < 0.3f - r){
	tablicaAlfa[a] += 0.005f;
}
	if(tablicaAlfa[a] > 0.3f - r)tablicaAlfa[a] = 0.3f- r;
b--;

r+= 0.0014f;
}
r = 0f;
for(int a=240,b = ktore;a<480;a++){
if(b > 0 && tablicaAlfa[a] < 0.3f- r){
	tablicaAlfa[a] += 0.005f;
}
	if(tablicaAlfa[a] > 0.3f- r)tablicaAlfa[a] = 0.3f- r;;
b--;
r+= 0.0014f;

}


for(int a=0;a<480;a++){
if(generalAlpha > 0.95f)
game.przyciemnionyPasekPikselSprite.setScale(1);
else
	game.przyciemnionyPasekPikselSprite.setScale((float)generalAlpha);
game.przyciemnionyPasekPikselSprite.setAlpha(tablicaAlfa[a]);
game.przyciemnionyPasekPikselSprite.setPosition(a, 76);
game.przyciemnionyPasekPikselSprite.draw(game.batch);
game.przyciemnionyPasekPikselSprite.setPosition(a, 154);
game.przyciemnionyPasekPikselSprite.draw(game.batch);

}
	


//float tablicaAlfa[] = new float[480];
//int ktore = 1;
///////////////////////////////////////////////////////////////PASEK

if(wlaczTimer == true){
	timer1+= Gdx.graphics.getDeltaTime();
	if(timer1 > 0.5f){
	}
}



game.buttonSprite = new Sprite(game.regionsMenu[20]);
game.buttonSprite.setAlpha((float)generalAlpha);
game.buttonSprite.setScale((float)skalaOgolna);
game.buttonSprite.setPosition(41, 465);

//game.buttonSprite.setScale(1.332f, 1f);
game.buttonSprite.draw(game.batch);
game.buttonSprite = new Sprite(game.regionsMenu[19]);
game.buttonSprite.setAlpha((float)generalAlpha);
game.buttonSprite.setScale((float)skalaOgolna);
game.buttonSprite.setPosition(40, 360);
game.buttonSprite.draw(game.batch);
game.buttonSprite.setPosition(143, 255);
game.buttonSprite.draw(game.batch);


if(skalaOgolna*1/3 < 0.3) game.buttonSprite.setScale((float)skalaOgolna*1/3,(float)skalaOgolna);
else{ game.buttonSprite.setScale(0.3f, (float)skalaOgolna);}
game.buttonSprite.setPosition(246, 360);
game.buttonSprite.setAlpha((float)generalAlpha);
game.buttonSprite.draw(game.batch);
game.buttonSprite.setPosition(-64, 255);
game.buttonSprite.draw(game.batch);


if(czyRysowacPrzyciski == true){
	//System.out.println(game.buttonNormal.buttonImage.getScaleX());
game.buttonNormal.button_display(game.batch);
game.buttonHard.button_display(game.batch);
game.button3.button_display(game.batch);

game.buttonShop.buttonImage.setAlpha((float)generalAlpha);
game.buttonShop.button_display(game.batch);

game.buttonInfo.buttonImage.setAlpha((float)generalAlpha);
game.buttonInfo.button_display(game.batch);

}
//System.out.println(game.pol);
if(game.pol == false){
		game.spriteBestScore.draw(game.batch);
		game.spriteGamesPlayed.draw(game.batch);	
		game.settingsMenu.draw(game.batch);
		game.spritePlay.draw(game.batch);
		game.exitSprite.draw(game.batch);

			game.spriteCart.draw(game.batch);
			game.spriteInfo.draw(game.batch);

}
else
{

	
	//
	game.ustawienia2Sprite.setPosition(-52, 375);
//
	game.najlepszySprite.draw(game.batch);
	game.rozegraneSprite.draw(game.batch);
	game.ustawienia2Sprite.draw(game.batch);
	game.grajSprite.draw(game.batch);
	game.wyjscieSprite.draw(game.batch);
//
	
	//game.batch.draw(game.textButtonExitPL,115,285);
	game.ustawienia2Sprite.setPosition(0, 375);
	//game.ustawienia2Sprite.setScale(0.60f);
	game.ustawienia2Sprite.setColor(1,1,1,1);


game.spriteCart.draw(game.batch);
game.spriteInfo.draw(game.batch);

}

//game.spriteLogoBackground.setScale((float)skalaOgolna);
game.spriteBlueGem.draw(game.batch);

if(game.ileGemow < 10)
game.wypiszCzas(game.batch, game.ileGemow, 250, 187, 0.75f, 1, 1, 1, (float)generalAlpha);
if(game.ileGemow >= 10 && game.ileGemow < 100)
	game.wypiszCzas(game.batch, game.ileGemow, 263, 187, 0.75f, 1, 1, 1, (float)generalAlpha);
if(game.ileGemow >= 100 && game.ileGemow <1000)	
	game.wypiszCzas(game.batch, game.ileGemow, 287, 187, 0.75f, 1, 1, 1, (float)generalAlpha);
if(game.ileGemow >= 1000)	
	game.wypiszCzas(game.batch, game.ileGemow, 297, 187, 0.75f, 1, 1, 1, (float)generalAlpha);

if(skalaOgolna < 0.75f){
	
	if(ileGier > 99){
		game.wypiszGP(game.batch,ileGier,193,100,(float)skalaOgolna,1,1,1,(float)generalAlpha);
	}
	else
	if(ileGier > 0)
	game.wypiszGP(game.batch,ileGier,207,100,(float)skalaOgolna,1,1,1,(float)generalAlpha);
	else
		game.wypiszGP(game.batch,ileGier,220,100,(float)skalaOgolna,1,1,1,(float)generalAlpha);
	
	if(ostatniWynik > 99){
		game.wypiszBS(game.batch,ostatniWynik,193,24,(float)skalaOgolna,1,1,1,(float)generalAlpha);
	}
	else
	if(ostatniWynik > 0)
	game.wypiszBS(game.batch,ostatniWynik,207,24,(float)skalaOgolna,1,1,1,(float)generalAlpha);
	else
		game.wypiszBS(game.batch,ostatniWynik,220,24,(float)skalaOgolna,1,1,1,(float)generalAlpha);
		
}else{
	if(ileGier > 99){
		game.wypiszGP(game.batch,ileGier,193,100,0.75f,1,1,1,(float)generalAlpha);
	}
	else
	if(ileGier > 0)
game.wypiszGP(game.batch,ileGier,207,100,0.75f,1,1,1,(float)generalAlpha);
	else
		game.wypiszGP(game.batch,ileGier,220,100,0.75f,1,1,1,(float)generalAlpha);
		
	if(ostatniWynik > 99){
		game.wypiszBS(game.batch,ostatniWynik,193,24,0.75f,1,1,1,(float)generalAlpha);
}
	else
	if(ostatniWynik >0)
game.wypiszBS(game.batch,ostatniWynik,207,24,0.75f,1,1,1,(float)generalAlpha);
	else
		game.wypiszBS(game.batch,ostatniWynik,220,24,0.75f,1,1,1,(float)generalAlpha);

}
//game.spriteLogoBackground.draw(game.batch);
game.batch.setColor(1,1,1,(float)generalAlpha);
		game.batch.draw(game.regionsMenu[6],-120,580);
		game.logo.setScale((float)zoom);
		game.logo.draw(game.batch);
	
		game.batch.setColor(1,1,1,1);
		if(game.backButtonShop.y > -50)
		game.backButtonShop.button_display(game.batch);
		//
	
		if(przejscieDoInfo == false){
		//
			if(game.s1.y > -100)
		game.s1.draw(game.batch);
if(game.s1.isAlreadyBought == true){
	game.r4Sprite.setScale((float)R4Scale);
	game.r5Sprite.setScale((float)R5Scale);
	game.r6Sprite.setScale((float)R6Scale);
	game.r4Sprite.setPosition(game.s1.x - 60,game.s1.y +5);
	game.r5Sprite.setPosition(game.s1.x - 12,game.s1.y + 5);
	game.r6Sprite.setPosition(game.s1.x + 36,game.s1.y + 5);
	if( game.s1.y > - 60){
	game.r4Sprite.draw(game.batch);
	game.r5Sprite.draw(game.batch);
	game.r6Sprite.draw(game.batch);
}
}
if(game.s2.y > -100)
game.s2.draw(game.batch);
		if(game.s2.isAlreadyBought == true){
		game.r1Sprite.setScale((float)R1Scale);
		game.r2Sprite.setScale((float)R2Scale);
		game.r3Sprite.setScale((float)R3Scale);
		game.r1Sprite.setPosition(game.s2.x - 80,game.s2.y -12);
		game.r2Sprite.setPosition(game.s2.x - 32,game.s2.y -12);
		game.r3Sprite.setPosition(game.s2.x + 16,game.s2.y -12);			 
		if( game.s2.y > - 60){

		game.r1Sprite.draw(game.batch);
		game.r2Sprite.draw(game.batch);
		game.r3Sprite.draw(game.batch);
		}
		}		
		if(game.s3.y > -100)
		game.s3.draw(game.batch);
		if(game.s3.isAlreadyBought == true){
			game.r7Sprite.setScale((float)R7Scale);
			game.r8Sprite.setScale((float)R8Scale);
			game.r9Sprite.setScale((float)R9Scale);
			game.r7Sprite.setPosition(game.s3.x - 80,game.s3.y -12);
			game.r8Sprite.setPosition(game.s3.x - 32,game.s3.y -12);
			game.r9Sprite.setPosition(game.s3.x + 16,game.s3.y -12);			 
			if( game.s3.y > - 60){
			game.r7Sprite.draw(game.batch);
			game.r8Sprite.draw(game.batch);
			game.r9Sprite.draw(game.batch);
			}
			}
		if(game.s4.y > -100)
		game.s4.draw(game.batch);
		if(game.s4.isAlreadyBought == true){
			game.r10Sprite.setScale((float)R10Scale);
			game.r11Sprite.setScale((float)R11Scale);
			game.r12Sprite.setScale((float)R12Scale);
			game.r10Sprite.setPosition(game.s4.x - 68,game.s4.y -12);
			game.r11Sprite.setPosition(game.s4.x - 28,game.s4.y -12);
			game.r12Sprite.setPosition(game.s4.x + 12,game.s4.y -12);			 
			if( game.s4.y > - 60){

			game.r10Sprite.draw(game.batch);
			game.r11Sprite.draw(game.batch);
			game.r12Sprite.draw(game.batch);
			}
			}
		if(game.s5.y > -100)
		game.s5.draw(game.batch);
		if(game.s5.isAlreadyBought == true){
			game.r13Sprite.setScale((float)R13Scale);
			game.r14Sprite.setScale((float)R14Scale);
			game.r15Sprite.setScale((float)R15Scale);
			game.r13Sprite.setPosition(game.s5.x - 68,game.s5.y -12);
			game.r14Sprite.setPosition(game.s5.x - 28,game.s5.y -12);
			game.r15Sprite.setPosition(game.s5.x + 12,game.s5.y -12);			 
			if( game.s5.y > - 60){
			game.r13Sprite.draw(game.batch);
			game.r14Sprite.draw(game.batch);
			game.r15Sprite.draw(game.batch);
			}
			}
		if(game.s6.y > -100)
		game.s6.draw(game.batch);
		if(game.s6.isAlreadyBought == true){
			game.r16Sprite.setScale((float)R16Scale);
			game.r17Sprite.setScale((float)R17Scale);
			game.r18Sprite.setScale((float)R18Scale);
			game.r16Sprite.setPosition(game.s6.x - 68,game.s6.y -12);
			game.r17Sprite.setPosition(game.s6.x - 28,game.s6.y -12);
			game.r18Sprite.setPosition(game.s6.x + 12,game.s6.y -12);			 
			if( game.s6.y > - 60){
			game.r16Sprite.draw(game.batch);
			game.r17Sprite.draw(game.batch);
			game.r18Sprite.draw(game.batch);
			}
			}
		
if(game.s1.isAlreadyBought == false){
	if( game.s1.y > - 60){

		game.batch.draw(game.blueGem,game.s1.x+210,game.s1.y);		
		game.WypiszPieniadzeHUD(game.batch, 0, game.s1.x+170, game.s1.y-10, 1, 1, 1, 1);
}
}
else{
	if( game.s1.y > - 60){

	game.batch.draw(game.regionsMenu[16],game.s1.x + 120,game.s1.y+ 7);
}
}
if(game.s2.isAlreadyBought == false){
	game.batch.draw(game.blueGem,game.s2.x+145,game.s2.y);		
	game.WypiszPieniadzeHUD(game.batch, 50, game.s2.x+70, game.s2.y-10, 1, 1, 1, 1);
}
else{
	if( game.s2.y > - 60){

	game.batch.draw(game.regionsMenu[16],game.s2.x + 120,game.s2.y+ 7);
	}
	}
if(game.s3.isAlreadyBought == false){
	game.batch.draw(game.blueGem,game.s3.x+120,game.s3.y);		
	game.WypiszPieniadzeHUD(game.batch, 150, game.s3.x+20, game.s3.y-10, 1, 1, 1, 1);
}
else
{
	if( game.s3.y > - 60){

	game.batch.draw(game.regionsMenu[16],game.s3.x + 120,game.s3.y+ 7);
	}
	}
if(game.s4.isAlreadyBought == false){
	game.batch.draw(game.blueGem,game.s4.x+145,game.s4.y);		
	game.WypiszPieniadzeHUD(game.batch, 350, game.s4.x+50, game.s4.y-10, 1, 1, 1, 1);
}
else
{
	if( game.s4.y > - 60){

game.batch.draw(game.regionsMenu[16],game.s4.x + 120,game.s4.y+ 7);

	}
	}
if(game.s5.isAlreadyBought == false){
	game.batch.draw(game.blueGem,game.s5.x+120,game.s5.y);		
	game.WypiszPieniadzeHUD(game.batch, 500, game.s5.x+30, game.s5.y-10, 1, 1, 1, 1);
}
else
{	if( game.s5.y > - 60){

game.batch.draw(game.regionsMenu[16],game.s5.x + 120,game.s5.y+ 7);
}}
if(game.s6.isAlreadyBought == false){
	game.batch.draw(game.blueGem,game.s6.x+145,game.s6.y);		
	game.WypiszPieniadzeHUD(game.batch, 1000, game.s6.x+30, game.s6.y-10, 1, 1, 1, 1);
}
else{	if( game.s6.y > - 60){

game.batch.draw(game.regionsMenu[16],game.s6.x + 120,game.s6.y+ 7);

}}


	if(game.backButtonShop.y + 12 > -50){
game.batch.draw(game.cardsText,game.backButtonShop.x + 85,game.backButtonShop.y+12);
game.WypiszPieniadzeHUD(game.batch, game.ileGemow, game.backButtonShop.x + 310, game.backButtonShop.y, 1, 1, 1, 1);
		game.gemBlueSprite.setScale((float)zoom+0.3f);
		
		game.gemBlueSprite.setPosition(game.backButtonShop.x + 255, game.backButtonShop.y+12);
		game.gemBlueSprite.draw(game.batch);
	}	
	}
		else
			game.spriteMessage.draw(game.batch);		
		
		
		//	game.batch.draw(textureBackButton,10,500);
for(int a= 0;a<12;a++){
if(a<8)game.batch.draw(game.regionsMenu[3],a*64 -16,0);
game.spritePodloze.setPosition(-18, 48 + a*64);
game.spritePodloze.draw(game.batch);
game.spritePodloze.setPosition(435, 48 + a*64);
game.spritePodloze.draw(game.batch);
}



//game.WypiszPieniadzeHUD(game.batch, 111, 225, 187, 0.75f, 1, 1, 1);
		//Dodatkowe elementy menu, do dopracowania
		//game.batch.draw(starGold,140,30);
		//game.batch.draw(flatMedal,140,120);
		//game.batch.draw(groundSnow,0,0);
		//
		
	//	game.batch.setColor(1, 1, 1, (float)generalAlpha);


		if(game.czyOdciemnic == true){
	game.batch.setColor(1f, 1f, 1f, (float)timerPrzyciemnienie2);
	game.batch.draw(game.czarny,0,0);
	game.batch.setColor(1f,1f,1f,1f);
	
}
		
		game.batch.setColor(1f, 1f, 1f, (float)timerPrzyciemnienie);
		game.batch.draw(game.czarny,0,0);
		game.batch.setColor(1f,1f,1f,1f);
	      //if(game.backButtonShop.button_mouse_collision(touchPos.x, touchPos.y) == true && generalAlpha == 0 && game.backButtonShop.y >= 710 ){
	    //System.out.println("generalAlpha:");
		//System.out.println(generalAlpha);
	    //S/ystem.out.println("backButtonShop.y:");
		//System.out.println(game.backButtonShop.y);
		//  	  game.WypiszPieniadzeHUD(game.batch, (int)generalAlpha, 100, 300, 1, 1, 1, 1);
	   // 	  game.WypiszPieniadzeHUD(game.batch, (int)game.backButtonShop.y, 100, 400, 1, 1, 1, 1);

	    	  game.batch.end();
	
	setLogoZoom();
	
	}
//Odpowiada za pulsujace logo w menu//
void setLogoZoom(){
	timerLogo += Gdx.graphics.getDeltaTime();
	if(timerLogo > 0.01f){timerLogo = 0.0;
	if(zoom > 1.05f){czyZoom = false;}
	if(zoom < 0.95f){czyZoom = true;}
	if(czyZoom == true){
	zoom+=0.01;
			}
	if(czyZoom == false){
	zoom-=0.01;
		}
	
}
	}

	
	@Override
	public void resize(int width, int height) {
	}
 
	@Override
	public void show() {

	//	  game.rainMusic.play(); game.cipher.stop();
	//	  game.wallpaper.stop();

	}
	

	@Override
	public void hide() {
	}
 
	@Override
	public void pause() {
	}
 
	@Override
	public void resume() {
	}
 
	@Override
	public void dispose() {
	game.batch.dispose();
	
	}
	 void spawnBody(Boolean czyPoczatek){
//setForces();

int random = MathUtils.random(1,3);
game.spriteTypes.add(random);

		         	Body body;
		        	BodyDef bodyDef = new BodyDef();
		            bodyDef.type = BodyDef.BodyType.DynamicBody;
if(czyPoczatek == false)
		            bodyDef.position.set(MathUtils.random(40,450) ,MathUtils.random(840,860));
	if(czyPoczatek == true)
        bodyDef.position.set(MathUtils.random(42,440) ,MathUtils.random(100,800));


		bodyDef.angle = MathUtils.random(0,30); 
		           body = game.world.createBody(bodyDef);
		         //   polygonBody = world.createBody(bodyDef);
		           PolygonShape shape = new PolygonShape();
		           shape.setAsBox(20f,20f);
		           FixtureDef fixtureDef = new FixtureDef();
		           fixtureDef.shape = shape;
		           fixtureDef.density = 0.01f;
body.setAngularVelocity(MathUtils.random(0,0.5f));
		           Fixture fixture =  body.createFixture(fixtureDef);
		       	if(czyPoczatek == true)	body.setLinearVelocity(0, -100);
		           game.bodies.add(body);
		           shape.dispose();
		           
	 }
//void setForces(){
//	Iterator<Body> iter = game.bodies.iterator();
//	while (iter.hasNext()){
//		Body bodybody = iter.next();
//
//	}
//}
void drawBackground(){
	

	timerBcg+= Gdx.graphics.getDeltaTime();
	if(timerBcg > 0.02){
		for(int a=0;a<23;a++){
		pozycjeBackground[a] -= 2;	

		}	
	}
	for(int a=1;a<23;a++){
//System.out.println(pozycjeBackground[0]);
		if(a%2 == 0){

			game.lightGreenSprite.setPosition(33 + 180, pozycjeBackground[a-1]+ 170);
			game.lightGreenSprite.draw(game.batch);
		}
		else{
			game.darkGreenSprite.setPosition(33 + 180, pozycjeBackground[a-1] + 170);
			game.darkGreenSprite.draw(game.batch);

		}
	}
	if(pozycjeBackground[0] < -457){
	for(int a=-379, b = 0;a<481;a++){
		
		pozycjeBackground[b] = a;
		b++;
		a+=39;
		}
	}
	
	/*
	game.batch.setColor(1f,1f,1f,1f);
	timerBcg+= Gdx.graphics.getDeltaTime();
	if(timerBcg > 0.02){
		for(int a=0;a<14;a++){
		pozycjeBackground[a] -= 2;	

		}	
	}
	for(int a=1;a<15;a++){
		if(a%2 == 0){
			game.batch.draw(game.darkGreen,pozycjeBackground[a-1],0);
		}
		else{
			game.batch.draw(game.lightGreen,pozycjeBackground[a-1],0);	
		}
	}
	if(pozycjeBackground[0] == -78){
	for(int a=0, b = 0;a<560;a++){
		pozycjeBackground[b] = a;
		b++;
		a+=39;
		}
	}
	*/
}

public void setGeneralAlpha(){
	if(czyPrzejscie == true){
	timerDoGory += Gdx.graphics.getDeltaTime();
		if(timerDoGory > 0.01)
		{
			timerDoGory = 0;
	if(game.backButtonShop.y <= 710)	{
		//System.out.println(odejmujacaSklep);
		game.backButtonShop.y +=odejmujacaSklep;
	game.s1.y += odejmujacaSklep;
	game.s2.y += odejmujacaSklep;
	game.s3.y += odejmujacaSklep;
	game.s4.y += odejmujacaSklep;
	game.s5.y += odejmujacaSklep;
	game.s6.y += odejmujacaSklep;
	game.spriteMessage.setPosition(game.spriteMessage.getX(), (float) (game.spriteMessage.getY() + odejmujacaSklep));
	}
	odejmujacaSklep += 0.4;
		if(game.backButtonShop.y >= 700 && czyPrzestac == false){odejmujacaSklep = -5.5;
	czyPrzestac = true;
	wlaczTimer = false;
	timer1 = 0;
		}
	if(game.backButtonShop.y >= 710){odejmujacaSklep = 1;}
		}
		
		if(generalAlpha > 0)
	generalAlpha -= Gdx.graphics.getDeltaTime();
if(generalAlpha < 0 )
	generalAlpha = 0;
game.logo.setAlpha((float)generalAlpha);	
game.spriteBestScore.setAlpha((float)generalAlpha);
game.spriteGamesPlayed.setAlpha((float)generalAlpha);	
game.settingsMenu.setAlpha((float)generalAlpha);	
game.spritePlay.setAlpha((float)generalAlpha);	
game.exitSprite.setAlpha((float)generalAlpha);	
game.spriteCart.setAlpha((float)generalAlpha);	
game.spriteInfo.setAlpha((float)generalAlpha);	
game.spriteBlueGem.setAlpha((float)generalAlpha);
game.buttonNormal.buttonImage.setAlpha((float)generalAlpha);
game.buttonHard.buttonImage.setAlpha((float)generalAlpha);
game.button3.buttonImage.setAlpha((float)generalAlpha);
game.buttonShop.buttonImage.setColor(1, 1, 1, (float)generalAlpha);
game.buttonInfo.buttonImage.setColor(1, 1, 1, (float)generalAlpha);


game.najlepszySprite.setAlpha((float)generalAlpha);
game.rozegraneSprite.setAlpha((float)generalAlpha);
game.ustawienia2Sprite.setAlpha((float)generalAlpha);
game.grajSprite.setAlpha((float)generalAlpha);
game.wyjscieSprite.setAlpha((float)generalAlpha);

//

//
	}

	if(czyWroc == true){
		if(generalAlpha < 1  && timer1 > 0.75f)
	generalAlpha += 3.5f*Gdx.graphics.getDeltaTime();
if(generalAlpha > 1 )
	generalAlpha = 1;
game.logo.setAlpha((float)generalAlpha);	
game.spriteBestScore.setAlpha((float)generalAlpha);
game.spriteGamesPlayed.setAlpha((float)generalAlpha);	
game.settingsMenu.setAlpha((float)generalAlpha);	
game.spritePlay.setAlpha((float)generalAlpha);	
game.exitSprite.setAlpha((float)generalAlpha);	
game.spriteCart.setAlpha((float)generalAlpha);	
game.spriteInfo.setAlpha((float)generalAlpha);	

game.spriteBlueGem.setAlpha((float)generalAlpha);

game.buttonNormal.buttonImage.setAlpha((float)generalAlpha);
game.buttonHard.buttonImage.setAlpha((float)generalAlpha);
game.button3.buttonImage.setAlpha((float)generalAlpha);
game.buttonShop.buttonImage.setColor(1, 1, 1, (float)generalAlpha);
game.buttonInfo.buttonImage.setColor(1, 1, 1, (float)generalAlpha);
game.najlepszySprite.setAlpha((float)generalAlpha);	
game.rozegraneSprite.setAlpha((float)generalAlpha);	

game.ustawienia2Sprite.setAlpha((float)generalAlpha);	
game.grajSprite.setAlpha((float)generalAlpha);	
game.wyjscieSprite.setAlpha((float)generalAlpha);	

timerDoGory += Gdx.graphics.getDeltaTime();
if(timerDoGory > 0.01)
{
	timerDoGory = 0;
if(game.backButtonShop.y > -100){		game.backButtonShop.y -=odejmujacaSklep;

game.s1.y -= odejmujacaSklep;
game.s2.y -= odejmujacaSklep;
game.s3.y -= odejmujacaSklep;
game.s4.y -= odejmujacaSklep;
game.s5.y -= odejmujacaSklep;
game.s6.y -= odejmujacaSklep;
game.spriteMessage.setPosition(game.spriteMessage.getX(), (float) (game.spriteMessage.getY() - odejmujacaSklep));

if(game.backButtonShop.y < -100)
przejscieDoInfo = false;

odejmujacaSklep += 0.4;
}
else{czyWroc = false;odejmujacaSklep = 1; czyPrzejscie = false;czyPrzestac = false; game.backButtonShop.y = -100;
game.s1.y = -175;
game.s2.y = -255;
game.s3.y = -333;
game.s4.y = -410;
game.s5.y = -485;
game.s6.y = -560;
game.spriteMessage.setPosition(70,-700);

}
		
}
	
	}
	
}
}
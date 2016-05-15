package com.dbeef.memoboxes.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.dbeef.memoboxes.Main;
import com.dbeef.memoboxes.ui.Button;

public class SettingsScreen implements Screen {
	//
	Iterator<Body> iter;
public	Rectangle soundRectangle = new Rectangle();
public 	Rectangle musicRectangle = new Rectangle();
public 	Rectangle kursor = new Rectangle(); 
public int posXwskaznikSound = 58;
public int posXwskaznikMusic = 280;
public boolean tykamSound = false;
public boolean tykamMusic = false;
public double timerWib = 0; // do zmniejszenia czestotliwosci klikania przycisku wibracji	
public double timerWib2 = 0;
public boolean czyNaliczac = false;
//
	double timerWibracje = 0;
	boolean czyWibracjeWcisniete = false;
	double timerLogo = 0.0;
public int pozycjeBackground[] = new int[14];

	double skalaOgolna = 0;
	boolean czyMinus = false;
	double timerGearBig = 0;
	double timerGearSmall = 0;
	
	double rotationBig = 0;
	double rotationSmall = 0;
	
	double zoom = 1;
	boolean czyZoom = true;
//	SpriteBatch batch;
double timerBackground = 0;
	
	double alfaUk;
	double alfaPol;
	public double timerBcg =0;
	Button backButton;
	float tablicaAlfa[] = new float[480];
	int ktore = 1;
	double timerKtore = 0;
	
//	OrthographicCamera camera;
	boolean czyPrzyciemnienie = true;
	boolean czyPrzyciemnij = false;
	double timerPrzyciemnienie = 1;
double skalaUk;
double skalaPol;
double timer =0;
int a = 0;
    int b = 1024;
	//
	//
    Button buttonUk = new Button();
	Button buttonPol = new Button();
  final Main game;

public SettingsScreen(final Main myGdxGame) {
	
	backButton = new Button();
		game = myGdxGame;
		
		posXwskaznikMusic = 279;
		posXwskaznikSound = 58;
		if(game.prefs.getInteger("music") != 0)
		posXwskaznikMusic = game.prefs.getInteger("music");
		if(game.prefs.getInteger("sound") != 0)
		posXwskaznikSound = game.prefs.getInteger("sound");
		game.jukebox.changeVolume
		(posXwskaznikMusic, posXwskaznikSound);
			
for(int a =0;a<480;a++){
		tablicaAlfa[a] = 0;
	}
game.vibrationsButton.czySzybki = true;

for(int a=0, b = 0;a<560;a++){
	pozycjeBackground[b] = a;
	b++;
	a+=39;
	}

soundRectangle.setPosition(58,475);
musicRectangle.setPosition(280,475);
soundRectangle.setSize(158,70);
musicRectangle.setSize(158,70);
kursor.setSize(1);
	buttonUk.setButtonPropetiesTexture(80, 48, game.pasek,  258, 130);
	buttonPol.setButtonPropetiesTexture(80, 48, game.pasek,  138, 130);
	game.camera = new OrthographicCamera();
		game.camera.setToOrtho(false, 800, 480);
		game.batch = new SpriteBatch();
if(game.uk == true){
	skalaUk = 1f;
	skalaPol = 0.7f;
	alfaPol = 0.7f;
	alfaUk = 1f;
}
else{
	skalaUk = 0.7f;
	skalaPol = 1f;
	alfaPol  = 1f;
	alfaUk = 0.7f;
}
		
		game.camera = new OrthographicCamera();
		game.camera.setToOrtho(false,480,800);
	    game.batch.setProjectionMatrix(game.camera.combined);

	backButton.setButtonPropetiesTexture(80, 80, game.back, 200, 10);
backButton.szybkiPrzycisk = true;

	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 123, 180);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


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

tykamSound = false;
tykamMusic = false;
if (Gdx.input.isTouched()) {
	Vector3 touchPos = new Vector3();
       touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
       game.camera.unproject(touchPos);
       
       kursor.setPosition(touchPos.x, touchPos.y);
       if(kursor.overlaps(soundRectangle)){
    	   posXwskaznikSound= (int)touchPos.x;
       tykamSound = true;
   	game.prefs.putInteger("sound", posXwskaznikSound);
   	game.prefs.flush();

       }
       if(kursor.overlaps(musicRectangle)){
    	   posXwskaznikMusic = (int)touchPos.x;
       tykamMusic = true;
      	game.prefs.putInteger("music", posXwskaznikMusic);
       	game.prefs.flush();
       
       }
       
       if(backButton.button_mouse_collision(touchPos.x, touchPos.y) == true){
         	game.prefs.flush();

    	   backButton.clicked = true;
    	   czyPrzyciemnij = true;
    	//   game.setScreen(new MainMenuScreen(game));

    		game.jukebox.changeVolume(game.poziomMuzyki, game.poziomDzwieku);
    		game.jukebox.playClick();
    		if(game.wibracje == true)Gdx.input.vibrate(40);		

    		Iterator<Body> iter = game.bodies.iterator();

    	   while (iter.hasNext()){
    	   	Body bodybody = iter.next();
    	   	
    	   bodybody.setLinearVelocity(0, MathUtils.random(0,1000));}
       }
       if(buttonUk.button_mouse_collision(touchPos.x, touchPos.y) == true){
       game.pol = false;
       game.uk = true;
       game.prefs.putBoolean("pol", false);
       game.prefs.putBoolean("uk", true);
      	game.jukebox.playClick();
      	if(game.wibracje == true)Gdx.input.vibrate(40);		
      
       }
       if(buttonPol.button_mouse_collision(touchPos.x, touchPos.y) == true){
           game.pol = true;
           game.uk = false;
           game.prefs.putBoolean("pol", true);
           game.prefs.putBoolean("uk", false);

           game.jukebox.playClick();
          	if(game.wibracje == true)Gdx.input.vibrate(40);		
              
       }
       if(game.vibrationsButton.button_mouse_collision(touchPos.x, touchPos.y) == true && czyWibracjeWcisniete == false && timerWib > 0.5f){
           czyWibracjeWcisniete = true;
         timerWib = 0;
           if(game.wibracje == true)game.wibracje = false;
           else if(game.wibracje == false)game.wibracje = true;
           
           game.jukebox.playClick();
           if(game.wibracje == true)Gdx.input.vibrate(40);		
        
           if(game.wibracje == false)
           game.vibrationsButton.spriteButton = new Sprite(game.textureVibrationsButtonOff);
            if(game.wibracje == true)
           game.vibrationsButton.spriteButton = new Sprite(game.textureVibrationsButtonOn);

        	game.prefs.putBoolean("wibracje", game.wibracje);

            
          czyNaliczac = true;
          game.vibrationsButton.clicked = true;
       }
       
       //System.out.println(game.uk);
       
    
}



if(Gdx.input.isTouched() == false)backButton.clicked = false;
if(timerWib2 > 0.5f){czyNaliczac = false;game.vibrationsButton.clicked = false;timerWib2 = 0;}
//if(Gdx.input.isTouched() == false)game.vibrationsButton.clicked = false;

	if(czyWibracjeWcisniete == true){
		timerWibracje+= Gdx.graphics.getDeltaTime();
		if(timerWibracje > 0.2f){
			timerWibracje = 0;
			czyWibracjeWcisniete = false;
		}
	}
	

    //System.out.println(game.wibracje);
		if(czyPrzyciemnienie == true && czyPrzyciemnij == false)
		{
			timerPrzyciemnienie -= Gdx.graphics.getDeltaTime()*5;
		
		}
		if(timerPrzyciemnienie < 0){czyPrzyciemnienie = false;
		timerPrzyciemnienie = 0;
		}
		
		if(czyPrzyciemnij == true){
			timerPrzyciemnienie += Gdx.graphics.getDeltaTime()*3;
		if(timerPrzyciemnienie > 1) {timerPrzyciemnienie = 1;game.czyOdciemnic = true;game.setScreen(new MenuScreen(game));}
		}
		
		game.spritePol.setScale((float)skalaPol);
		game.spriteUk.setScale((float)skalaUk);
		game.spritePol.setAlpha((float)alfaPol);
		game.spriteUk.setAlpha((float)alfaUk);
		timer += Gdx.graphics.getDeltaTime();
		if(timer > 0.01f){
			timer = 0;
		if(game.uk == false)
		{
			if(skalaPol < 1.3f)
				skalaPol +=0.1f;
			if(skalaPol > 1.3f)
				skalaPol = 1.3f;
			if(skalaUk > 0.7f)
				skalaUk -= 0.1f;
			if(skalaUk < 0.7f)
				skalaUk = 0.7f;
		
			if(alfaUk > 0.5f)
				alfaUk-= 0.1f;
			if(alfaUk< 0.5f)
				alfaUk = 0.5f;
			
			if(alfaPol < 1f)
				alfaPol+= 0.1f;
			if(alfaPol > 1f)
				alfaPol = 1f;
			
		}
		
		else
		{
			if(skalaUk < 1.3f)
				skalaUk +=0.1f;
			if(skalaUk > 1.3f)
				skalaUk = 1.3f;
			if(skalaPol > 0.7f)
				skalaPol -= 0.1f;
			if(skalaPol < 0.7f)
				skalaPol = 0.7f;
		

			if(alfaPol > 0.5f)
				alfaPol-= 0.1f;
			if(alfaPol< 0.5f)
				alfaPol = 0.5f;
			
			if(alfaUk < 1f)
				alfaUk+= 0.1f;
			if(alfaUk > 1f)
				alfaUk = 1f;
		}
		
		}
		//Chwilowo tutaj:
		// game.setScreen(new GameScreen(game));
		//
		
		//game.camera.update();
game.jukebox.updateTimers();
		game.batch.begin();
drawBackground();
//		game.batch.draw(game.screen,game.a,0);

	//	game.batch.draw(game.screen,game.b,0);
		game.world.step(1/60f,6,2);
//		game.batch.setColor(1,1,1,0.3f);
//		game.batch.draw(game.przyciemnionyPasek,0,561);
//		game.batch.draw(game.przyciemnionyPasek,0,211);
//		game.batch.draw(game.przyciemnionyPasek,0,431);
//		game.batch.setColor(1,1,1,1);

		//

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
	game.batch.setColor(1,1,1,tablicaAlfa[a]);
	game.batch.draw(game.przyciemnionyPasekPiksel,a,561);
	game.batch.draw(game.przyciemnionyPasekPiksel,a,211);
	game.batch.draw(game.przyciemnionyPasekPiksel,a,431);
	
}
game.batch.setColor(1,1,1,1);

		//
		
		for(int a= 0;a<13;a++){
			game.batch.draw(game.regionsMenu[3],a*64 -16,0);
		game.spritePodloze.setPosition(-18, 48 + a*64);
		game.spritePodloze.draw(game.batch);
		game.spritePodloze.setPosition(435, 48 + a*64);
		game.spritePodloze.draw(game.batch);
		}
		
		iter = game.bodies.iterator();
		while (iter.hasNext()){
			Body bodybody = iter.next();


		Vector2 vector = new Vector2();
		vector = bodybody.getPosition();
		game.boxExplosiveSprite.setRotation(bodybody.getAngle() * MathUtils.radiansToDegrees);
		//
		game.boxExplosiveSprite.setPosition((bodybody.getPosition().x * game.PIXELS_TO_METERS) - game.boxExplosiveSprite.
		        getWidth()/2 , 
		(bodybody.getPosition().y * game.PIXELS_TO_METERS) -game.boxExplosiveSprite.getHeight()/2 )
		;
		game.boxExplosiveSprite.setPosition(vector.x, vector.y);
		game.boxExplosiveSprite.draw(game.batch);

		}
		timerBackground += Gdx.graphics.getDeltaTime();
if(timerBackground > 0.01){
		if(game.a>-1024)game.a-=4;
		else game.a = 0;
	
		if(game.b>0)game.b-=4;
		else game.b = 1024;
timerBackground = 0;
}
timerGearBig+= Gdx.graphics.getDeltaTime();
timerGearSmall+= Gdx.graphics.getDeltaTime();

if(timerGearBig > 0.01f){
	timerGearBig = 0;
	rotationBig++;
}
if(timerGearSmall > 0.01f){
	timerGearSmall = 0;
	rotationSmall-= 3;
}
game.gearBig.setRotation((float)rotationBig);
game.gearSmall.setRotation((float)rotationSmall);

game.gearRed.setRotation((float)rotationBig);
game.gearYellow.setRotation((float)rotationBig);


//Dodatkowe elementy menu, do dopracowania
		//game.batch.draw(starGold,140,30);
		//game.batch.draw(flatMedal,140,120);
		//game.batch.draw(groundSnow,0,0);
		//
if(game.wibracje == true){
//game.batch.draw(game.textureVibrationsButtonOff,162,270);
}
else
{
//	game.batch.draw(game.textureVibrationsButtonOn,162,270);
}

	game.gearBig.draw(game.batch);
game.gearSmall.draw(game.batch);
game.gearSmall.setPosition(0,585);
game.gearSmall.draw(game.batch);
game.gearSmall.setPosition(250, 550);
game.gearRed.draw(game.batch);
game.gearYellow.draw(game.batch);

/*
 gearBig.setScale(0.8f);
gearSmall.setScale(0.4f);

gearBig.setPosition(150, 660);
gearSmall.setPosition(250, 550);
 */
//game.gearBig.setColor(0.5f,1f,1,1);
//game.gearBig.setScale(0.35f);
//game.gearBig.setPosition(30,600);
//game.gearBig.draw(game.batch);
//

timerWib += Gdx.graphics.getDeltaTime();
if(czyNaliczac == true)timerWib2 += Gdx.graphics.getDeltaTime();
if(tykamMusic == false)
{

game.batch.draw(game.pasek,280,510);

	game.batch.draw(game.wskaznik,posXwskaznikMusic,510);
}
	else
{
	game.batch.setColor(0.7f, 1, 0.3f, 1);

game.batch.draw(game.pasek,280,510);

	game.batch.draw(game.wskaznik,posXwskaznikMusic,510);
	game.batch.setColor(1,1, 1, 1);

}
if(tykamSound == false){


game.batch.draw(game.pasek,58,510);
	game.batch.draw(game.wskaznik,posXwskaznikSound,510);
}
else
{
	game.batch.setColor(0.7f, 1, 0.3f, 1);


game.batch.draw(game.pasek,58,510);
	game.batch.draw(game.wskaznik,posXwskaznikSound,510);
	game.batch.setColor(1, 1, 1, 1);

}

if(game.uk == true)
{
	//game.batch.draw(game.soundEN,70,560);
	//game.batch.draw(game.musicEN,295,560);
	//game.batch.draw(game.language,128,210);
	
	//game.batch.draw(game.settingsTextureEN,40,700);
game.spriteSettings.draw(game.batch);
game.spriteSettings.setScale((float)skalaOgolna);
	game.spriteSound.setScale((float)skalaOgolna);
game.spriteMusic.setScale((float)skalaOgolna);
game.spriteLanguage.setScale((float)skalaOgolna);
game.spriteVibrations.setScale((float)skalaOgolna);

game.spriteSound.draw(game.batch);
	game.spriteMusic.draw(game.batch);
	game.spriteLanguage.draw(game.batch);
	game.spriteVibrations.draw(game.batch);
	
	
//game.batch.draw(game.textVibrationsEN,120,430);
}
	else
{
		
		game.ustawienia2Sprite.setScale((float)skalaOgolna);
		game.spriteSoundPL.setScale((float)skalaOgolna);
	game.spriteMusicPL.setScale((float)skalaOgolna);
	game.spriteLanguagePL.setScale((float)skalaOgolna);
	game.spriteVibrationsPL.setScale((float)skalaOgolna);
		/*
		game.batch.draw(game.textSoundPL,50,560);
		game.batch.draw(game.textMusicPL,260,560);		
		game.batch.draw(game.textLanguagePL,168,210);
	//	game.batch.draw(game.textSettingsPL,40,700);
		game.ustawienia2Sprite.setPosition(0, 700);
		game.ustawienia2Sprite.setScale(0.82f);
		//game.ustawienia2Sprite.setColor(Color.PINK);
		game.ustawienia2Sprite.draw(game.batch);
game.batch.draw(game.textVibrationsPL,135,430);
*/
		game.spriteSoundPL.draw(game.batch);
		game.spriteMusicPL.draw(game.batch);
		game.spriteVibrationsPL.draw(game.batch);
		game.spriteLanguagePL.draw(game.batch);		
		game.ustawienia2Sprite.setPosition(0, 700);
//		game.ustawienia2Sprite.setScale(0.82f);
		game.ustawienia2Sprite.draw(game.batch);
}

game.spritePol.draw(game.batch);
game.spriteUk.draw(game.batch);
game.vibrationsButton.button_display(game.batch);



game.batch.setColor(1f,1f,1f,(float)timerPrzyciemnienie);
backButton.button_display(game.batch);
game.batch.draw(game.czarny,0,0);

game.batch.setColor(1f,1f,1f,1);

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
	}

void drawBackground(){
	//game.batch.draw(game.screen,game.a,0);
	//game.batch.draw(game.screen,game.b,0);
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
}

}



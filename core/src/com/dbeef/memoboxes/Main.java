package com.dbeef.memoboxes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.dbeef.memoboxes.ads.AdsController;
import com.dbeef.memoboxes.graphics.Blinker;
import com.dbeef.memoboxes.logics.Spawner;
import com.dbeef.memoboxes.screens.LogoScreen;
import com.dbeef.memoboxes.sounds.Jukebox;
import com.dbeef.memoboxes.ui.Ability;
import com.dbeef.memoboxes.ui.Button;
import com.dbeef.memoboxes.ui.Card;
import com.dbeef.memoboxes.ui.ShopItem;

public class Main extends Game {

	public AdsController adsController;

	public Main(AdsController adsController) {
		this.adsController = adsController;
	}

	public Texture podlozePrototyp;

public	ParticleEffect coinsParticle;
public	ParticleEffect gemsParticle;
public	ParticleEffect iceParticle;
	
	public int doPorownywania;
	public int doPorownywaniaCzas = 0;
	public int doPorownywaniaMana = 0;
	public int doPorownywaniaPunkty = 0;

	public int doPorownywaniaGP = 0;
	public int doPorownywaniaBS = 0;

	public String doWypisywania = new String();
	public String doWypisywaniaCzas = new String();
	public String doWypisywaniaMana = new String();
	public String doWypisywaniaPunkty = new String();

	public String doWypisywaniaGP = new String();
	public String doWypisywaniaBS = new String();

	public Sprite s;

	public Texture beamHoles;

	public Texture miganiePuste;
	public Sprite miganiePusteSprite;
	public int limit = 0;
	// public Texture tile1;
	// public Sprite tile1Sprite;
	public Texture back;
	//
	public Ability fire = new Ability();
	public Ability wind = new Ability();
	public Ability ice = new Ability();

	public Array<Body> bodies = new Array();
	public Array spriteTypes = new Array();
	// box2
	public Sprite currentFrameSprite;

	public World world;
	public Texture laserDown;
	public Sprite gemBlue;
	public Sprite gemRed;
	public Sprite blackPixel;
	public Texture blackPixelTex;
	public Body polygonBody;
	public Body polygonBody2;
	public final float PIXELS_TO_METERS = 100f;

	public Button Red = new Button();
	public Button Blue = new Button();
	public Button Green = new Button();

	public Texture lightOrange;
	public Texture darkOrange;

	public Texture wskaznik;

	public Sprite gem;
	public Sprite spritePodloze;

	public float width, height;
	public boolean uk = true;
	public boolean pol = false;
	public Texture grey;
	public Sprite spriteUk;
	public Sprite spritePol;

	public Texture gearRedTexture;
	public Texture gearYellowTexture;

	public Sprite gearRed;
	public Sprite gearYellow;

	public Button buttonTick = new Button();
	public Button buttonCross = new Button();

	public Texture circleObramowanie;
	public Texture circleObramowanie2;

	public Texture DIGITSHUD[] = new Texture[10];
	public Texture hudGem;
	public Texture hudGem2;
	public Texture DIGITS[] = new Texture[10];
	public Texture czarny;
	public int ileGemow = 0;

	public Texture collectedEN;
	public boolean czyOdciemnic = false;
	public int a = 0;
	public int b = 1024;
	// Zrobic tekstury:
	// public ParticleEffect starsGreen;
	public ParticleEffect starsYellow;
	public ParticleEffect starsOrange;
	public ParticleEffect leafParticles;
	public ParticleEffect leafParticles2;
	public ParticleEffect leafParticles3;

	public ParticleEffect tutorialParticles1;
	public ParticleEffect tutorialParticles2;

	public ParticleEffect flashParticle;
	public ParticleEffect flashParticleDown;
	// public ParticleEffect flashParticleLeft;
	// public ParticleEffect flashParticleRight;

	public ParticleEffect spawnParticleLeft;
	public ParticleEffect spawnParticleRight;

	public boolean rozegranoTutorial = false;

	public int ileGier = 0;
	public boolean particleStart = false;
	// do gemow, 22062015
	// public ParticleEffect coinParticle;
	// public ParticleEffect colourParticle;
	// public ParticleEffect gemene;
	//

	//
	public Texture levelText;
	Sound soundClick;
	Music track1;
	public Texture flagUk; // Done
	public Texture flagPol; // Done
	public Texture blueTick;// Done
	public Texture blueBox; // Done
	public Texture hudCoin; // Done

	public Texture lightBlue;
	public Texture darkBlue;
	public Sprite tutorialENSprite;
	public Texture tutorialEN;
	public Texture spritesheetTwoflames;

	// public Sprite lightBlueSprite;
	// public Sprite darkBlueSprite;
	//
	public Sprite spriteSoundPL;
	public Sprite spriteMusicPL;
	public Sprite spriteLanguagePL;
	public Sprite spriteVibrationsPL;
	public Card kartonator;
	public Sprite r4Sprite;
	public Sprite r5Sprite;
	public Sprite r6Sprite;
	public Sprite goodTextSprite;
	public Sprite badTextSprite;

	//
	public Texture textureVibrationsButtonOn;
	public Texture textureVibrationsButtonOff;

	public Sprite spriteCart;
	public Sprite spriteInfo;

	public Texture coin;
	public Spawner spawner;
	public Spawner spawner2;

	public boolean wibracje = true;
	public Sprite spriteSettings;
	public Texture lost1;
	// ParticleEffect p;
	public Animation walkAnimation; // #3
	public Texture walkSheet; // #4
	public TextureRegion[] walkFrames; // #5
	public TextureRegion currentFrame; // #7
	public static final int FRAME_COLS = 11; // #1 // 3
	public static final int FRAME_ROWS = 2; // #2 // 9

	//
	public Texture miganie;
	// public Sprite miganieSprite;
	public Sprite najlepszySprite;
	public Sprite rozegraneSprite;
	public int poziomMuzyki = 58;
	public int poziomDzwieku = 279;
	//
	public Texture textSettingsEN;
	public Texture textSoundEN;
	public Texture textMusicEN;
	public Texture tutorialPL;
	public Sprite tutorialPOLSprite;
	//
	public Sprite cool;
	public Texture coolT;

	public Sprite gem1;
	public Sprite gem2;
	public Sprite gem3;
	public Sprite gem4;
	public Sprite gemFrozen;
	//
	public Texture Menu;
	public Texture memoBoxesPack1;
	public Texture memoBoxesPack2;

	public Texture cardRedS2;
	public Texture cardBlueS2;
	public Texture cardGreenS2;

	public Texture cardRedS3;
	public Texture cardBlueS3;
	public Texture cardGreenS3;

	public Texture cardRedS4;
	public Texture cardBlueS4;
	public Texture cardGreenS4;

	public Texture cardRedS5;
	public Texture cardBlueS5;
	public Texture cardGreenS5;

	public Texture cardRedS6;
	public Texture cardBlueS6;
	public Texture cardGreenS6;
	public Sprite spriteYesPL;
	public Sprite spriteNoPL;

	public Blinker migacz ;
	public Blinker miganie3;
	public Blinker miganie2 ;
	
	public Sprite r1Sprite;
	public Sprite r2Sprite;
	public Sprite r3Sprite;

	public Texture textVibrationsEN;
	public Texture yesEN;
	public Texture noEN;
	public Sprite spriteYesEN;
	public Sprite spriteNoEN;
	public Texture recommendedEN;
	public Sprite spriteRecommendedEN;
	public Texture textLanguageEN;
	public Sprite przyciemnionyPasekPikselSprite;
	public Texture laserMachine;
	// public Texture laserBeam;

	public Sprite laserMachineSprite;

	// Texture czarny;

	// public Texture score;
	// public Sprite scoreSprite;
	public Texture textSettingsPL;
	public Sprite spriteWskaz;
	public Texture repeatOrderEN;
	public Texture textSoundPL;
	public Texture textMusicPL;
	public Texture textVibrationsPL;
	public Texture badText2;
	public Texture goodText2;
	public Texture textLanguagePL;
	public Sprite sWin2;

	public Sprite darkGreenSprite;
	public Sprite lightGreenSprite;
	public Texture textButtonPlayEN;
	public Texture textButtonSettingsEN;
	public TextureRegion[] regions = new TextureRegion[34];
	public TextureRegion[] regionsMenu = new TextureRegion[23];


	public Sprite wyjscieSprite;
	public Sprite gemBlueSprite;
	public Texture textButtonPlayPL;
	public Texture textButtonSettingsPL;
	public ShopItem s1;
	public ShopItem s2;
	public ShopItem s3;
	public ShopItem s4;
	public ShopItem s5;
	public ShopItem s6;


	public Jukebox jukebox;
	
	public Texture bezoweTlo;
	public Texture resetStatsButton;
	// Koniec czwartkowej pracy

	// Texture screen;
	public Texture lovely;
	public Texture nice;
	public Texture great;
	public Texture amazing;

	public Texture switchGreen;
	public Texture switchRed;

	public Sprite lovelySprite;
	public Sprite niceSprite;
	public Sprite greatSprite;
	public Sprite amazingSprite;

	public Texture przyciemnionyPasekPiksel;
	public Texture cardBlueS;
	public Texture cardRedS;
	public Texture cardGreenS;
	public Sprite spriteLogoBackground;

	public Texture starGold;

	public Sprite spriteBestScore;
	public Sprite spriteGamesPlayed;
	public Sprite coinSprite;
	public Texture r1;
	public Texture r2;
	public Texture r3;
	public Texture r4;
	public Texture r5;
	public Texture r6;

	public Sprite spriteSound;
	public Sprite spriteMusic;
	public Sprite spriteLanguage;
	public Sprite spriteVibrations;

	public Texture yesPL;
	public Texture noPL;
	public Texture temp;
	public Texture barYellow;
	public Sprite barYellowSprite;

	public Texture red2T;

	public Texture bestScore;
	public Texture justScore;
	public Texture boxExplosive;

	public Sprite exitSprite;

	public Texture najlepszyWynik;

	public Sprite spritePlay;
	public Texture getReady;
	public Sprite boxExplosiveSprite;

	// public Texture textureHard;

	// public Texture textureNormalClicked;
	public Texture spritesheetAura;
	public Sprite ustawieniaMenu;
	public Sprite settingsMenu;
	public Sprite buttonSprite;
	public Texture elementBlue;
	public Button backButtonShop;

	public Sprite ustawienia2Sprite;
	public Texture helloEN3Tex;
	public Texture helloEN4Tex;
	public Texture helloEN5Tex;
	public Texture helloEN6Tex;
	public Texture helloEN7Tex;
	public Texture helloEN8Tex;
	public Texture helloEN9Tex;
	public Texture helloEN10Tex;
	public Texture helloEN11Tex;
	public Texture helloEN12Tex;
	public Texture helloEN13Tex;
	public Texture helloEN14Tex;
	public Texture helloEN15Tex;
	public Texture helloEN16Tex;
	public Texture helloEN17Tex;
	public Texture helloEN18Tex;
	public Texture helloEN19Tex;
	public Texture helloEN20Tex;
	public Texture helloEN21Tex;

	public Texture helloPL;
	public Texture helloPL2Tex;
	public Texture helloPL3Tex;
	public Texture helloPL4Tex;
	public Texture helloPL5Tex;
	public Texture helloPL6Tex;
	public Texture helloPL7Tex;
	public Texture helloPL8Tex;
	public Texture helloPL9Tex;
	public Texture helloPL10Tex;
	public Texture helloPL11Tex;
	public Texture helloPL12Tex;
	public Texture helloPL13Tex;
	public Texture helloPL14Tex;
	public Texture helloPL15Tex;
	public Texture helloPL16Tex;
	public Texture helloPL17Tex;
	public Texture helloPL18Tex;
	public Texture helloPL19Tex;
	public Texture helloPL20Tex;
	public Texture helloPL21Tex;

	// public Texture win1;
	public Texture win2;

	public Texture ooopsText;
	public Sprite r13Sprite;
	public Sprite r14Sprite;

	public Texture wskaz;
	public Sprite r15Sprite;
	public Texture helloENTex;

	public Texture helloEN2Tex;

	public Sprite r16Sprite;
	public Sprite r17Sprite;
	public Sprite r18Sprite;

	public Texture musicEN;
	public Texture soundEN;

	public Texture message;
	public Sprite spriteMessage;

	public Sprite grajSprite;
	public Texture lightGreen;
	public Texture darkGreen;

	public Texture przyciemnionyPasek;
	public Button buttonNormal;
	public Button buttonHard;
	public Button button3;
	public Button buttonYes;
	public Button buttonNo;
	public Button buttonShop;
	public Sprite spriteRecommendedPL;
	public Texture recommendedPL;
	public Texture askEN;
	public Texture askPOL;

	public Sprite spriteAskEN;
	public Sprite spriteAskPOL;

	public Texture blueGem;
	public Sprite spriteBlueGem;
	public Sprite r7Sprite;
	public Sprite r8Sprite;
	public Sprite r9Sprite;

	public Sprite r10Sprite;
	public Sprite r11Sprite;
	public Sprite r12Sprite;

	public Texture r10;
	public Texture r11;
	public Texture r12;

	public Texture r13;
	public Texture r14;
	public Texture r15;

	public Texture r16;
	public Texture r17;
	public Texture r18;

	public Button buttonInfo;

	public Texture starS;
	public Texture starG;

	public Sprite starSil;
	public Sprite starGol;


	public Texture gear;
	public Texture cardBlue;
	public Texture cardGreen;
	public Texture cardRed;

	public Texture cardBlue2;
	public Texture cardGreen2;
	public Texture cardRed2;

	public Texture cardBlue3;
	public Texture cardGreen3;
	public Texture cardRed3;

	public Texture cardBlue4;
	public Texture cardGreen4;
	public Texture cardRed4;

	public Texture cardBlue5;
	public Texture cardGreen5;
	public Texture cardRed5;

	public Texture cardBlue6;
	public Texture cardGreen6;
	public Texture cardRed6;

	public Texture cardMystery;
	public Texture goodText;
	// public Texture gem;
	public Texture weatherIcon;

	public Texture fireIcon;
	public Texture iceIcon;

	public Texture cardsText;
	public OrthographicCamera camera;
	public SpriteBatch batch;

	// public Texture backgroundButtons;
	public Texture language;
	public Sprite logo;
	public Texture pasek;
	public int ileKart = 3;
	public int numerPoziomu = 1;

	public Button vibrationsButton = new Button();

	public boolean czyWibracje = true;

	public boolean tablicaKupionych[] = new boolean[6];
	public int ktorySkin = 1;

	public Sprite gearBig;
	public Sprite gearSmall;
	// Texture groundSnow;
	public Preferences prefs;

	public void create() {

		camera = new OrthographicCamera();
		batch = new SpriteBatch();
		camera.setToOrtho(false, 480, 800);
		batch.setProjectionMatrix(camera.combined);

		
		prefs = Gdx.app.getPreferences("My Preferences");
		if (prefs.getInteger("ktorySkin") != 0)
			ktorySkin = prefs.getInteger("ktorySkin");

		rozegranoTutorial = prefs.getBoolean("rozegranoTutorial");

		czarny = new Texture("czarny.png");
		czarny.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		// screen = new Texture("blue_land.png");//MEMO-BOXES
		// screen.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		textureVibrationsButtonOff = new Texture("vibrationsOFF.png");// MEMO-BOXES
		textureVibrationsButtonOff.setFilter(TextureFilter.Linear,
				TextureFilter.Linear);
		textVibrationsEN = new Texture("vibrationsTextEN.png");// MEMO-BOXES
		textVibrationsEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		przyciemnionyPasek = new Texture("przyciemnionyPasek.png");// MEMO-BOXES

		przyciemnionyPasek
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		textureVibrationsButtonOn = new Texture("vibrationsON.png");// MEMO-BOXES
		textureVibrationsButtonOn.setFilter(TextureFilter.Linear,
				TextureFilter.Linear);
		//
		vibrationsButton.setButtonPropeties(154, 132,
				textureVibrationsButtonOff, 162, 270);
		//
		// world = new World( new Vector2(0,-120f),false);

		cardBlue = new Texture("cardBack_blue1.png");// MEMO-BOXES
		cardBlue.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreen = new Texture("cardBack_green1.png");// MEMO-BOXES
		cardGreen.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardRed = new Texture("cardBack_red1.png");// MEMO-BOXES
		cardRed.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardBlue2 = new Texture("cardBack_blue2.png");// MEMO-BOXES
		cardBlue2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreen2 = new Texture("cardBack_green2.png");// MEMO-BOXES
		cardGreen2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardRed2 = new Texture("cardBack_red2.png");// MEMO-BOXES
		cardRed2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardBlue3 = new Texture("cardBack_blue3.png");// MEMO-BOXES
		cardBlue3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreen3 = new Texture("cardBack_green3.png");// MEMO-BOXES
		cardGreen3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardRed3 = new Texture("cardBack_red3.png");// MEMO-BOXES
		cardRed3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardBlue4 = new Texture("cardBack_blue4.png");// MEMO-BOXES
		cardBlue4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreen4 = new Texture("cardBack_green4.png");// MEMO-BOXES
		cardGreen4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardRed4 = new Texture("cardBack_red4.png");// MEMO-BOXES
		cardRed4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardBlue5 = new Texture("cardBack_blue5.png");// MEMO-BOXES
		cardBlue5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreen5 = new Texture("cardBack_green5.png");// MEMO-BOXES
		cardGreen5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardRed5 = new Texture("cardBack_red5.png");// MEMO-BOXES
		cardRed5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardBlue6 = new Texture("cardBack_blue6.png");// MEMO-BOXES
		cardBlue6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreen6 = new Texture("cardBack_green6.png");// MEMO-BOXES
		cardGreen6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardRed6 = new Texture("cardBack_red6.png");// MEMO-BOXES
		cardRed6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		// backgroundButtons = new Texture("backgroundButtons.png");//MEMO-BOXES
		// backgroundButtons.setFilter(TextureFilter.Nearest,
		// TextureFilter.Nearest);
		getReady = new Texture("getReady.png");// MEMO-BOXES
		getReady.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		goodText = new Texture("goodText.png");// MEMO-BOXES
		goodText.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		goodText2 = new Texture("goodSummary.png");// MEMO-BOXES
		goodText2.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		podlozePrototyp = new Texture("podlozePrototyp.png");// MEMO-BOXES
		podlozePrototyp.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		badText2 = new Texture("wrongSummary.png");// MEMO-BOXES
		badText2.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		coin = new Texture("coin.png");// MEMO-BOXES
		coin.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		coinSprite = new Sprite(coin);
		goodTextSprite = new Sprite(goodText2);


		gear = new Texture("gear.png");// MEMO-BOXES
		gear.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		soundClick = Gdx.audio.newSound(Gdx.files
				.internal("data/soundClick.mp3"));
		track1 = Gdx.audio.newMusic(Gdx.files.internal("data/track1.mp3"));

		for (int a = 0; a < 6; a++) {
			tablicaKupionych[a] = false;
		}
		tablicaKupionych[0] = true;

		gearBig = new Sprite(gear);
		gearSmall = new Sprite(gear);

		gearBig.setScale(0.8f);
		gearSmall.setScale(0.4f);

		gearBig.setPosition(150, 660);
		gearSmall.setPosition(250, 550);

		spritesheetTwoflames = new Texture("spritesheetTwoflames.png");// MEMO-BOXES
		spritesheetTwoflames.setFilter(TextureFilter.Nearest,
				TextureFilter.Nearest);

		laserDown = new Texture("laserDown.png");// MEMO-BOXES
		laserDown.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		switchRed = new Texture("switchRed.png");// MEMO-BOXES
		switchRed.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		switchGreen = new Texture("switch.png");// MEMO-BOXES
		switchGreen.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		spawner = new Spawner(laserDown, 55, 698, spritesheetTwoflames, switchRed, switchGreen);
		spawner2 = new Spawner(laserDown, 355, 698, spritesheetTwoflames, switchRed, switchGreen);

		miganie = new Texture("miganie.png");// MEMO-BOXES
		miganie.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		// miganieSprite = new Sprite(laserDown);
		cardRedS = new Texture("cardRedS.png");// MEMO-BOXES
		cardRedS.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardBlueS = new Texture("cardBlueS.png");// MEMO-BOXES
		cardBlueS.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreenS = new Texture("cardGreenS.png");// MEMO-BOXES
		cardGreenS.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardRedS2 = new Texture("cardRedS2.png");// MEMO-BOXES
		cardRedS2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardBlueS2 = new Texture("cardBlueS2.png");// MEMO-BOXES
		cardBlueS2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreenS2 = new Texture("cardGreenS2.png");// MEMO-BOXES
		cardGreenS2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardRedS3 = new Texture("cardRedS3.png");// MEMO-BOXES
		cardRedS3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardBlueS3 = new Texture("cardBlueS3.png");// MEMO-BOXES
		cardBlueS3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreenS3 = new Texture("cardGreenS3.png");// MEMO-BOXES
		cardGreenS3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardRedS4 = new Texture("cardRedS4.png");// MEMO-BOXES
		cardRedS4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardBlueS4 = new Texture("cardBlueS4.png");// MEMO-BOXES
		cardBlueS4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreenS4 = new Texture("cardGreenS4.png");// MEMO-BOXES
		cardGreenS4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardRedS5 = new Texture("cardRedS5.png");// MEMO-BOXES
		cardRedS5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardBlueS5 = new Texture("cardBlueS5.png");// MEMO-BOXES
		cardBlueS5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreenS5 = new Texture("cardGreenS5.png");// MEMO-BOXES
		cardGreenS5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardRedS6 = new Texture("cardRedS6.png");// MEMO-BOXES
		cardRedS6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardBlueS6 = new Texture("cardBlueS6.png");// MEMO-BOXES
		cardBlueS6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		cardGreenS6 = new Texture("cardGreenS6.png");// MEMO-BOXES
		cardGreenS6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		language = new Texture("languageEN.png");// MEMO-BOXES
		language.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		textSoundPL = new Texture("dzwiek.png");// MEMO-BOXES
		textSoundPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		bezoweTlo = new Texture("bezoweTlo.png");// MEMO-BOXES
		bezoweTlo.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		miganiePuste = new Texture("miganiePuste.png");// MEMO-BOXES
		miganiePuste.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		miganiePusteSprite = new Sprite(miganiePuste);
		miganiePusteSprite.setScale(1.65f);

		// score = new Texture("score.png");//MEMO-BOXES
		// score.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		// scoreSprite = new Sprite(score);
		// scoreSprite.setPosition(10, 650);
		// scoreSprite.setScale(0.5f);

		blackPixelTex = new Texture("blackPixel.png");// MEMO-BOXES
		blackPixelTex.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		blackPixel = new Sprite(blackPixelTex);

		textMusicPL = new Texture("muzyka.png");// MEMO-BOXES
		textMusicPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		textVibrationsPL = new Texture("wibracje.png");// MEMO-BOXES
		textVibrationsPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		textLanguagePL = new Texture("jezyk.png");// MEMO-BOXES
		textLanguagePL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		weatherIcon = new Texture("weather.png");// MEMO-BOXES
		weatherIcon.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		fireIcon = new Texture("fire.png");// MEMO-BOXES
		fireIcon.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		iceIcon = new Texture("ice.png");// MEMO-BOXES
		iceIcon.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		gearRedTexture = new Texture("gearRed.png");// MEMO-BOXES
		gearRedTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		gearYellowTexture = new Texture("gearYellow.png");// MEMO-BOXES
		gearYellowTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		doWypisywaniaGP = "0";
		doWypisywaniaBS = "0";

		gearRed = new Sprite(gearRedTexture);
		gearYellow = new Sprite(gearYellowTexture);

		gearRed.setScale(0.6f);
		gearYellow.setScale(0.5f);

		gearRed.setPosition(0, 650);
		gearYellow.setPosition(120, 550);

		// game.gearBig.setScale(0.35f);
		// game.gearBig.setPosition(30,600);

		textSettingsPL = new Texture("ustawienia.png");// MEMO-BOXES
		textSettingsPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);


		lightOrange = new Texture("lightOrange.png");// MEMO-BOXES
		lightOrange.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		darkOrange = new Texture("darkOrange.png");// MEMO-BOXES
		darkOrange.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		barYellow = new Texture("barYellow.png");// MEMO-BOXES
		barYellow.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		barYellowSprite = new Sprite(barYellow);

		// winScreen = new Texture("winScreen.png");//MEMO-BOXES
		// winScreen.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lost1 = new Texture("polowaLostScreen.png");// MEMO-BOXES
		lost1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		ooopsText = new Texture("ooopsText.png");// MEMO-BOXES
		ooopsText.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		badTextSprite = new Sprite(badText2);
		soundEN = new Texture("soundEN.png");// MEMO-BOXES
		soundEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		musicEN = new Texture("musicEN.png");// MEMO-BOXES
		musicEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		memoBoxesPack1 = new Texture("MemoBoxesPack.png");// MEMO-BOXES
		memoBoxesPack1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		memoBoxesPack2 = new Texture("MemoBoxesPack2.png");// MEMO-BOXES
		memoBoxesPack2.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		Menu = new Texture("Menu.png");// MEMO-BOXES
		Menu.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		regionsMenu[0] = new TextureRegion(Menu, 447, 505, 32, 32); // element_blue_square_glossy
		regionsMenu[1] = new TextureRegion(Menu, 964, 891, 32, 32); // element_green_square_glossy
		regionsMenu[2] = new TextureRegion(Menu, 917, 839, 32, 32); // element_red_square_glossy
		regionsMenu[3] = new TextureRegion(Menu, 1, 1, 64, 32); // element_red_square_glossy
		regionsMenu[4] = new TextureRegion(Menu, 1, 167, 40, 470); // element_red_square_glossy
		regionsMenu[5] = new TextureRegion(Menu, 43, 167, 40, 470); // element_red_square_glossy
		regionsMenu[6] = new TextureRegion(Menu, 1, 834, 704, 189); // element_red_square_glossy
		regionsMenu[7] = new TextureRegion(Menu, 1, 707, 704, 125); // element_red_square_glossy
		regionsMenu[8] = new TextureRegion(Menu, 1, 639, 486, 66); // element_red_square_glossy
		regionsMenu[9] = new TextureRegion(Menu, 85, 370, 386, 67); // settings
																	// texture
																	// en
		regionsMenu[10] = new TextureRegion(Menu, 85, 337, 314, 31); // settings
																		// texture
																		// en
		regionsMenu[11] = new TextureRegion(Menu, 85, 304, 270, 31); // settings
																		// texture
																		// en
		regionsMenu[12] = new TextureRegion(Menu, 707, 803, 208, 68); // settings
																		// texture
																		// en
		regionsMenu[13] = new TextureRegion(Menu, 489, 660, 190, 45); // settings
																		// texture
																		// en
		regionsMenu[14] = new TextureRegion(Menu, 85, 247, 167, 55); // settings
																		// texture
																		// en
		regionsMenu[15] = new TextureRegion(Menu, 707, 746, 161, 55); // settings
																		// texture
																		// en
		regionsMenu[16] = new TextureRegion(Menu, 85, 214, 136, 31); // settings
																		// texture
																		// en
		regionsMenu[17] = new TextureRegion(Menu, 1, 101, 64, 64); // settings
																	// texture
																	// en
		regionsMenu[18] = new TextureRegion(Menu, 1, 35, 64, 64); // settings
																	// texture
																	// en
		regionsMenu[19] = new TextureRegion(Menu, 707, 925, 300, 98); // buttonNormal
		regionsMenu[20] = new TextureRegion(Menu, 85, 539, 400, 98); // buttonNormal

		regionsMenu[21] = new TextureRegion(Menu, 705, 894, 962, 923); // buttonNormal

	regionsMenu[22] = new TextureRegion(Menu, 189, 717, 463, 750); // buttonNormal

		
		grajSprite = new Sprite(regionsMenu[12]);
		grajSprite.setPosition(140, 485);
		grajSprite.setScale(0.70f);

		ustawienia2Sprite = new Sprite(regionsMenu[8]);
		ustawienia2Sprite.setPosition(-52, 375);
		ustawienia2Sprite.setScale(0.615f);

		exitSprite = new Sprite(regionsMenu[15]);// MEMO-BOXES
		exitSprite.setScale(0.9f);
		exitSprite.setPosition(210, 280);

		regions[0] = new TextureRegion(memoBoxesPack1, 525, 218, 42, 802); // #3
		regions[1] = new TextureRegion(memoBoxesPack1, 609, 218, 42, 802);
		regions[2] = new TextureRegion(memoBoxesPack1, 958, 895, 41, 38);
		regions[4] = new TextureRegion(memoBoxesPack1, 958, 934, 48, 37);
		regions[5] = new TextureRegion(memoBoxesPack1, 958, 971, 49, 49);
		regions[6] = new TextureRegion(memoBoxesPack1, 652, 871, 304, 151);
		regions[7] = new TextureRegion(memoBoxesPack1, 650, 598, 189, 21);
		regions[8] = new TextureRegion(memoBoxesPack1, 651, 775, 321, 94);
		regions[9] = new TextureRegion(memoBoxesPack1, 444, 20, 387, 193);
		regions[10] = new TextureRegion(memoBoxesPack1, 922, 0, 72, 72);
		regions[11] = new TextureRegion(memoBoxesPack1, 650, 708, 248, 65);
		regions[12] = new TextureRegion(memoBoxesPack2, 0, 366, 514, 55);
		regions[13] = new TextureRegion(memoBoxesPack2, 515, 390, 400, 107);
		regions[14] = new TextureRegion(memoBoxesPack2, 87, 0, 87, 116);
		// 15 background cards
		regions[15] = new TextureRegion(memoBoxesPack2, 0, 238, 437, 127);
		regions[16] = new TextureRegion(memoBoxesPack1, 0, 6, 442, 212);

		regions[17] = new TextureRegion(memoBoxesPack2, 216, 40, 24, 18); // 0
																			// stopni
		regions[18] = new TextureRegion(memoBoxesPack2, 241, 40, 18, 20); // 90
																			// stopni

		// combo x
		regions[19] = new TextureRegion(memoBoxesPack2, 441, 20, 380, 69);
		// no combo
		regions[20] = new TextureRegion(memoBoxesPack2, 555, 20, 305, 69);
		regions[21] = new TextureRegion(memoBoxesPack2, 443, 95, 201, 92);

		// 15 i 15 R
		regions[22] = new TextureRegion(memoBoxesPack2, 687, 105, 43, 21);
		regions[23] = new TextureRegion(memoBoxesPack2, 758, 107, 43, 21);
		// 30 i 30 R
		regions[24] = new TextureRegion(memoBoxesPack2, 687, 136, 43, 21);
		regions[25] = new TextureRegion(memoBoxesPack2, 758, 137, 43, 21);
		// 70 i 70 R
		regions[26] = new TextureRegion(memoBoxesPack2, 687, 163, 42, 18);
		regions[27] = new TextureRegion(memoBoxesPack2, 758, 164, 42, 18);

		regions[28] = new TextureRegion(memoBoxesPack2, 0, 118, 398, 43);

		regions[29] = new TextureRegion(memoBoxesPack2, 953, 5, 32, 32);
		regions[30] = new TextureRegion(memoBoxesPack2, 953, 39, 32, 32);
		regions[31] = new TextureRegion(memoBoxesPack2, 953, 74, 32, 32);
		regions[32] = new TextureRegion(memoBoxesPack2, 953, 109, 32, 32);
		regions[33] = new TextureRegion(memoBoxesPack2, 885, 159, 128, 24);

		wyjscieSprite = new Sprite(regionsMenu[21]);// MEMO-BOXES
		wyjscieSprite.setScale(0.9f);
		wyjscieSprite.setPosition(165, 285);

		wskaznik = new Texture("znaczek.png");// MEMO-BOXES
		wskaznik.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		elementBlue = new Texture("gemElement.png");// MEMO-BOXES
		elementBlue.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		najlepszyWynik = new Texture("najlepszyWynik.png");// MEMO-BOXES
		najlepszyWynik.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		najlepszySprite = new Sprite(najlepszyWynik);
		rozegraneSprite = new Sprite(regionsMenu[10]);
		najlepszySprite.setPosition(65, 77);
		rozegraneSprite.setPosition(76, 155);

		gemRed = new Sprite(regionsMenu[2]);
		gemBlue = new Sprite(regionsMenu[0]);

		// tile1 = new Texture("tile_20.png");//MEMO-BOXES
		// tile1.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		// tile1Sprite = new Sprite(tile1);
		// tile1Sprite.setScale(0.8f);

		pasek = new Texture("pasek.png");// MEMO-BOXES
		pasek.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		grey = new Texture("grey.png");// MEMO-BOXES
		grey.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		// win1 = new Texture("polowaWinScreen.png");//MEMO-BOXES
		// win1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		win2 = new Texture("polowaWinScreen22.png");// MEMO-BOXES
		win2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		sWin2 = new Sprite(win2);

		spritePodloze = new Sprite(regionsMenu[3]);
		spritePodloze.setRotation(90);
		cardMystery = new Texture("mysteryCard.png");// MEMO-BOXES
		cardMystery.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		collectedEN = new Texture("collectedEN.png");// MEMO-BOXES
		collectedEN.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		boxExplosive = new Texture("boxExplosive.png");// MEMO-BOXES
		boxExplosive.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		starS = new Texture("star_silver.png");// MEMO-BOXES
		starS.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		starG = new Texture("star_gold.png");// MEMO-BOXES
		starG.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//
		lovely = new Texture("lovely.png");// MEMO-BOXES
		lovely.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		nice = new Texture("nice.png");// MEMO-BOXES
		nice.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		great = new Texture("great.png");// MEMO-BOXES
		great.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		amazing = new Texture("amazing.png");// MEMO-BOXES
		amazing.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		lovelySprite = new Sprite(lovely);
		niceSprite = new Sprite(nice);
		greatSprite = new Sprite(great);
		amazingSprite = new Sprite(amazing);

		coolT = new Texture("cool.png");// MEMO-BOXES
		coolT.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		cool = new Sprite(coolT);

		starSil = new Sprite(starS);
		starGol = new Sprite(starG);

		//
		blueGem = new Texture("gemBlueBig.png");// MEMO-BOXES
		blueGem.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spriteBlueGem = new Sprite(blueGem);
		spriteBlueGem.setPosition(185, 200);
		//

		circleObramowanie = new Texture("circleObramowanie.png");// MEMO-BOXES
		circleObramowanie.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		laserMachine = new Texture("laserSwitchBlueOff.png");
		laserMachine.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		if (rozegranoTutorial == false) {
			helloENTex = new Texture("helloEN.png");
			helloENTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN2Tex = new Texture("hello2EN.png");
			helloEN2Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN3Tex = new Texture("hello3EN.png");
			helloEN3Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN4Tex = new Texture("hello4EN.png");
			helloEN4Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN5Tex = new Texture("hello5EN.png");
			helloEN5Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN6Tex = new Texture("hello6EN.png");
			helloEN6Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN7Tex = new Texture("hello7EN.png");
			helloEN7Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN8Tex = new Texture("hello8EN.png");
			helloEN8Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN9Tex = new Texture("hello9EN.png");
			helloEN9Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN10Tex = new Texture("hello10EN.png");
			helloEN10Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN11Tex = new Texture("hello11EN.png");
			helloEN11Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN12Tex = new Texture("hello12EN.png");
			helloEN12Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN13Tex = new Texture("hello13EN.png");
			helloEN13Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN14Tex = new Texture("hello14EN.png");
			helloEN14Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN15Tex = new Texture("hello15EN.png");
			helloEN15Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN16Tex = new Texture("hello16EN.png");
			helloEN16Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN17Tex = new Texture("hello17EN.png");
			helloEN17Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN18Tex = new Texture("hello18EN.png");
			helloEN18Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN19Tex = new Texture("hello19EN.png");
			helloEN19Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN20Tex = new Texture("hello20EN.png");
			helloEN20Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloEN21Tex = new Texture("hello21EN.png");
			helloEN21Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			//

			helloPL = new Texture("helloPL.png");
			helloPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL2Tex = new Texture("hello2PL.png");
			helloPL2Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL3Tex = new Texture("hello3PL.png");
			helloPL3Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL4Tex = new Texture("hello4PL.png");
			helloPL4Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL5Tex = new Texture("hello5PL.png");
			helloPL5Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL6Tex = new Texture("hello6PL.png");
			helloPL6Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL7Tex = new Texture("hello7PL.png");
			helloPL7Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL8Tex = new Texture("hello8PL.png");
			helloPL8Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL9Tex = new Texture("hello9PL.png");
			helloPL9Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL10Tex = new Texture("hello10PL.png");
			helloPL10Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL11Tex = new Texture("hello11PL.png");
			helloPL11Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL12Tex = new Texture("hello12PL.png");
			helloPL12Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL13Tex = new Texture("hello13PL.png");
			helloPL13Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL14Tex = new Texture("hello14PL.png");
			helloPL14Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL15Tex = new Texture("hello15PL.png");
			helloPL15Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL16Tex = new Texture("hello16PL.png");
			helloPL16Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL17Tex = new Texture("hello17PL.png");
			helloPL17Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL18Tex = new Texture("hello18PL.png");
			helloPL18Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL19Tex = new Texture("hello19PL.png");
			helloPL19Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL20Tex = new Texture("hello20PL.png");
			helloPL20Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			helloPL21Tex = new Texture("hello21PL.png");
			helloPL21Tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		// laserBeam = new Texture("laserBlueHorizontal.png");
		// laserBeam.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		laserMachineSprite = new Sprite(laserMachine);

		circleObramowanie2 = new Texture("circleObramowanie2.png");// MEMO-BOXES
		circleObramowanie2
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		justScore = new Texture("justScore.png");// MEMO-BOXES
		justScore.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		askEN = new Texture("askEN.png");// MEMO-BOXES
		askEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		askPOL = new Texture("askPL.png");// MEMO-BOXES
		askPOL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		tutorialEN = new Texture("tutorialEN.png");// MEMO-BOXES
		tutorialEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		tutorialPL = new Texture("tutorialPOL.png");// MEMO-BOXES
		tutorialPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		tutorialENSprite = new Sprite(tutorialEN);
		tutorialENSprite.setScale(4);
		tutorialENSprite.setPosition(60, 515);
		tutorialENSprite.setColor(1, 1, 1, 0);

		tutorialPOLSprite = new Sprite(tutorialPL);
		tutorialPOLSprite.setScale(4);
		tutorialPOLSprite.setPosition(42, 515);
		tutorialPOLSprite.setColor(1, 1, 1, 0);

		spriteAskEN = new Sprite(askEN);
		spriteAskPOL = new Sprite(askPOL);

		spriteAskEN.setScale(0);
		spriteAskEN.setPosition(32, 500);

		spriteAskPOL.setScale(0);
		spriteAskPOL.setPosition(38, 500);

		yesEN = new Texture("yesEN.png");// MEMO-BOXES
		yesEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		noEN = new Texture("noENG.png");// MEMO-BOXES
		noEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		yesPL = new Texture("yesPOL.png");// MEMO-BOXES
		yesPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		noPL = new Texture("noPOL.png");// MEMO-BOXES
		noPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		wskaz = new Texture("this.png");// MEMO-BOXES
		wskaz.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		spriteWskaz = new Sprite(wskaz);
		spriteWskaz.setAlpha(0);
		spriteYesEN = new Sprite(yesEN);
		spriteNoEN = new Sprite(noEN);

		spriteYesPL = new Sprite(yesPL);
		spriteNoPL = new Sprite(noPL);

		spriteYesPL.setPosition(140, 350);
		spriteYesPL.setScale(0);
		spriteNoPL.setPosition(75, 180);
		spriteNoPL.setScale(0);

		spriteYesEN.setPosition(140, 350);
		spriteYesEN.setScale(0);
		spriteNoEN.setPosition(75, 180);
		spriteNoEN.setScale(0);

		// game.batch.draw(game.yesEN,140,350);
		// game.batch.draw(game.noEN,75,180);

		recommendedEN = new Texture("recommendedEN.png");// MEMO-BOXES
		recommendedEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		recommendedPL = new Texture("recommendedPOL.png");// MEMO-BOXES
		recommendedPL.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		spriteRecommendedEN = new Sprite(recommendedEN);
		spriteRecommendedEN.setPosition(105, 331);
		spriteRecommendedEN.setScale(0);

		spriteRecommendedPL = new Sprite(recommendedPL);
		spriteRecommendedPL.setPosition(105, 331);
		spriteRecommendedPL.setScale(0);

		beamHoles = new Texture("beamHoles.png");// MEMO-BOXES
		beamHoles.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		boxExplosiveSprite = new Sprite(boxExplosive);
		// boxExplosiveSprite.setScale(0.6f);

		DIGITS[0] = new Texture(Gdx.files.internal("number0.png"));
		DIGITS[1] = new Texture(Gdx.files.internal("number1.png"));
		DIGITS[2] = new Texture(Gdx.files.internal("number2.png"));
		DIGITS[3] = new Texture(Gdx.files.internal("number3.png"));
		DIGITS[4] = new Texture(Gdx.files.internal("number4.png"));
		DIGITS[5] = new Texture(Gdx.files.internal("number5.png"));
		DIGITS[6] = new Texture(Gdx.files.internal("number6.png"));
		DIGITS[7] = new Texture(Gdx.files.internal("number7.png"));
		DIGITS[8] = new Texture(Gdx.files.internal("number8.png"));
		DIGITS[9] = new Texture(Gdx.files.internal("number9.png"));

		for (int a = 0; a < 10; a++) {
			DIGITS[a].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		//
		DIGITSHUD[0] = new Texture(Gdx.files.internal("hud_0.png"));
		DIGITSHUD[1] = new Texture(Gdx.files.internal("hud_1.png"));
		DIGITSHUD[2] = new Texture(Gdx.files.internal("hud_2.png"));
		DIGITSHUD[3] = new Texture(Gdx.files.internal("hud_3.png"));
		DIGITSHUD[4] = new Texture(Gdx.files.internal("hud_4.png"));
		DIGITSHUD[5] = new Texture(Gdx.files.internal("hud_5.png"));
		DIGITSHUD[6] = new Texture(Gdx.files.internal("hud_6.png"));
		DIGITSHUD[7] = new Texture(Gdx.files.internal("hud_7.png"));
		DIGITSHUD[8] = new Texture(Gdx.files.internal("hud_8.png"));
		DIGITSHUD[9] = new Texture(Gdx.files.internal("hud_9.png"));

		for (int a = 0; a < 10; a++) {
			DIGITSHUD[a].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

		// Czwartkowe tekstury - ladowanie i filtrowanie
		flagUk = new Texture("flagUk.png"); // Done
		flagPol = new Texture("flagPol.png"); // Done
		blueTick = new Texture("blueTick.png");// Done
		blueBox = new Texture("blueBox.png");// Done

		spritesheetAura = new Texture("spritesheetAura.png");// Done
		spritesheetAura.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		repeatOrderEN = new Texture("repeatOrderEN.png");
		repeatOrderEN.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		back = new Texture("back.png");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		r1 = new Texture("r1.png");
		r1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r2 = new Texture("r2.png");
		r2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r3 = new Texture("r3.png");
		r3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r4 = new Texture("r5.png");
		r4.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r5 = new Texture("r4.png");
		r5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r6 = new Texture("r6.png");
		r6.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		r10 = new Texture("r7.png");
		r10.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r11 = new Texture("r9.png");
		r11.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r12 = new Texture("r8.png");
		r12.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		r13 = new Texture("r10.png");
		r13.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r14 = new Texture("r11.png");
		r14.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r15 = new Texture("r12.png");
		r15.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		r16 = new Texture("r13.png");
		r16.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r17 = new Texture("r14.png");
		r17.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		r18 = new Texture("r15.png");
		r18.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		r13Sprite = new Sprite(r13);
		r14Sprite = new Sprite(r14);
		r15Sprite = new Sprite(r15);

		r16Sprite = new Sprite(r16);
		r17Sprite = new Sprite(r17);
		r18Sprite = new Sprite(r18);

		r1Sprite = new Sprite(r1);
		r2Sprite = new Sprite(r2);
		r3Sprite = new Sprite(r3);
		r4Sprite = new Sprite(regionsMenu[2]);
		r5Sprite = new Sprite(regionsMenu[1]);
		r6Sprite = new Sprite(regionsMenu[0]);
		r7Sprite = new Sprite(r4);
		r8Sprite = new Sprite(r5);
		r9Sprite = new Sprite(r6);
		r10Sprite = new Sprite(r10);
		r11Sprite = new Sprite(r11);
		r12Sprite = new Sprite(r12);

		ustawieniaMenu = new Sprite(textSettingsPL);
		settingsMenu = new Sprite(regionsMenu[9]);
		ustawieniaMenu.setPosition(39, 385);
		settingsMenu.setPosition(-5, 380);

		ustawieniaMenu.setScale(0.70f);

		settingsMenu.setScale(0.74f);

		spriteSound = new Sprite(soundEN);

		spriteMusic = new Sprite(musicEN);

		spriteLanguage = new Sprite(language);

		spriteVibrations = new Sprite(textVibrationsEN);

		spriteSound.setPosition(70, 560);
		spriteMusic.setPosition(295, 560);
		spriteLanguage.setPosition(128, 210);
		spriteVibrations.setPosition(120, 430);

		flagUk.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		flagPol.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		blueTick.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		blueBox.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		hudCoin = new Texture("hud_coins.png");// Done
		hudCoin.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		hudGem = new Texture("hud_gem_blue.png");// Done
		hudGem.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		hudGem2 = new Texture("hud_gem_blue2.png");// Done
		hudGem2.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		lightGreen = new Texture("lightGreen.png");// Done
		lightGreen.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		darkGreen = new Texture("darkGreen.png");// Done
		darkGreen.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		lightBlue = new Texture("lightBlue.png");// Done
		lightBlue.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		//
		lightGreenSprite = new Sprite(regionsMenu[4]);
		darkGreenSprite = new Sprite(regionsMenu[5]);

		lightGreenSprite.setRotation(90);
		darkGreenSprite.setRotation(90);

		//

		darkBlue = new Texture("darkBlue.png");// Done
		darkBlue.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cardsText = new Texture("cardsText.png");// Done
		cardsText.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		//
		backButtonShop = new Button();
		backButtonShop.setButtonPropeties(80, 80, back, 45, -100);
		backButtonShop.szybkiPrzycisk = true;

		gem = new Sprite(regionsMenu[1]);

		// czarny = new Texture("czarny.png");

		spriteUk = new Sprite(flagUk);
		spriteUk.setPosition(258, 130);
		spritePol = new Sprite(flagPol);
		spritePol.setPosition(138, 130);

		starGold = new Texture("starGold.png");
		starGold.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		// groundSnow = new Texture("groundRock.png");
		// groundSnow.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		bestScore = new Texture("bestScore2.png");
		bestScore.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		red2T = new Texture("red2.png");
		red2T.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		przyciemnionyPasekPiksel = new Texture("pasekPrzyciemnionyPiksel.png");
		przyciemnionyPasekPiksel.setFilter(TextureFilter.Linear,
				TextureFilter.Linear);

		przyciemnionyPasekPikselSprite = new Sprite(przyciemnionyPasekPiksel);

		// Przyciski, ich tekstury i filtrowanie (filtrowanie tekstur przyciskow
		// odbywa sie w ich funkcji setButtonProperties

		// textureHard = new Texture("buttonHard.png");

		message = new Texture("message.png");
		message.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		// textureNormalClicked = new Texture("buttonNormalPressed.png");

		// textureNormalClicked.setFilter(TextureFilter.Linear,
		// TextureFilter.Linear);

		s1 = new ShopItem(regionsMenu[13], 60, -175, true, true);
		s2 = new ShopItem(regionsMenu[13], 35, -255, false, false);
		s3 = new ShopItem(regionsMenu[13], 60, -333, false, false);
		s4 = new ShopItem(regionsMenu[13], 35, -410, false, false);
		s5 = new ShopItem(regionsMenu[13], 60, -485, false, false);
		s6 = new ShopItem(regionsMenu[13], 35, -560, false, false);

		// textureHard.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		spriteCart = new Sprite(regionsMenu[18]);
		spriteCart.setPosition(360, 380);

		spriteInfo = new Sprite(regionsMenu[17]);
		spriteInfo.setPosition(52, 275);


coinsParticle = new ParticleEffect();
gemsParticle = new ParticleEffect();
iceParticle = new ParticleEffect();

coinsParticle.load(Gdx.files.internal("coins"), //particlex
        Gdx.files.internal(""));


	iceParticle.load(Gdx.files.internal("gemene"), //particlex
	        Gdx.files.internal(""));

gemsParticle.load(Gdx.files.internal("gemRedEffect"), //particlex
        Gdx.files.internal(""));

coinsParticle.allowCompletion();
gemsParticle.allowCompletion();
iceParticle.allowCompletion();


		buttonNormal = new Button();
		buttonNormal.setButtonPropeties(400, 98, regionsMenu[20], 41, 465);
		buttonNormal.buttonImage.setScale(1f, 1f);

		buttonYes = new Button();
		buttonYes.setButtonPropeties(400, 98, regionsMenu[20], 41, 365);
		buttonYes.buttonImage.setScale(0f, 0f);
		// 1,1 f
		buttonNo = new Button();
		buttonNo.setButtonPropeties(400, 98, regionsMenu[20], 41, 175);
		buttonNo.buttonImage.setScale(0f, 0f);
		// 1,1.55f

		buttonHard = new Button();
		buttonHard.setButtonPropeties(300, 98, regionsMenu[19], 40, 360);

		button3 = new Button();
		button3.setButtonPropeties(300, 99, regionsMenu[19], 143, 255);

		buttonShop = new Button();
		buttonShop.setButtonPropeties(200, 99, regionsMenu[19], 246, 360);
		buttonShop.buttonImage.setScale(0.3f, 1);

		buttonInfo = new Button();
		buttonInfo.setButtonPropeties(190, 100, regionsMenu[19], -64, 255);
		buttonInfo.buttonImage.setScale(0.3f, 1);

		buttonTick.setButtonPropeties(100, 100, blueTick, 516, 75); // 260,45
		buttonCross.setButtonPropeties(100, 100, blueBox, -38, 75); // 160,45
		spritePlay = new Sprite(regionsMenu[14]);
		spritePlay.setPosition(160, 490);
		buttonSprite = new Sprite(regionsMenu[19]);

		logo = new Sprite(regionsMenu[7]);

		spriteMessage = new Sprite(message);
		spriteMessage.setScale(1);
		spriteMessage.setPosition(70, -700);

		fire.load(70, 263, 725,fireIcon,  circleObramowanie, circleObramowanie2);
		wind.load(15,  143, 725, weatherIcon,circleObramowanie,
				circleObramowanie2);
		ice.load(30,  203, 725,iceIcon, circleObramowanie, circleObramowanie2);

		levelText = new Texture("levelTexture.png");
		levelText.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		spriteBestScore = new Sprite(bestScore);
		spriteGamesPlayed = new Sprite(regionsMenu[11]);
		spriteLogoBackground = new Sprite(regionsMenu[6]);
		spriteBestScore.setPosition(145, 77);
		spriteGamesPlayed.setPosition(110, 155);

		spriteSettings = new Sprite(regionsMenu[9]);
		spriteSettings.setPosition(40, 700);
		//
		spriteSoundPL = new Sprite(textSoundPL);
		spriteSoundPL.setPosition(50, 560);
		spriteMusicPL = new Sprite(textMusicPL);
		spriteMusicPL.setPosition(260, 560);
		spriteLanguagePL = new Sprite(textLanguagePL);
		spriteLanguagePL.setPosition(168, 210);
		spriteVibrationsPL = new Sprite(textVibrationsPL);
		spriteVibrationsPL.setPosition(135, 430);
		/*
		 * coinParticle = new ParticleEffect(); colourParticle = new
		 * ParticleEffect(); gemene = new ParticleEffect(); //
		 * coinParticle.load(Gdx.files.internal("coins"), //particlex
		 * Gdx.files.internal(""));
		 * 
		 * gemene.load(Gdx.files.internal("gemene"), //particlex
		 * Gdx.files.internal(""));
		 * 
		 * colourParticle.load(Gdx.files.internal("gemRedEffect"), //particlex
		 * Gdx.files.internal(""));
		 * 
		 * coinParticle.allowCompletion(); gemene.allowCompletion();
		 * colourParticle.allowCompletion(); //
		 */
		gem1 = new Sprite(regions[30]);
		gem2 = new Sprite(regions[29]);
		gem3 = new Sprite(regions[31]);
		gem4 = new Sprite(regions[32]);

		gemFrozen = new Sprite(boxExplosive);
		gemFrozen.setScale(1.3f);
		gem1.setScale(1.3f);
		gem2.setScale(1.3f);
		gem3.setScale(1.3f);
		gem4.setScale(1.3f);

		//

		spawnParticleLeft = new ParticleEffect();
		spawnParticleLeft.load(Gdx.files.internal("spawnParticle"), // particlex
				Gdx.files.internal(""));

		spawnParticleLeft.allowCompletion();

		spawnParticleRight = new ParticleEffect();
		spawnParticleRight.load(Gdx.files.internal("spawnParticle"), // particlex
				Gdx.files.internal(""));

		spawnParticleRight.allowCompletion();

		tutorialParticles1 = new ParticleEffect();
		tutorialParticles1.load(Gdx.files.internal("particleTutorial1"), // particlex
				Gdx.files.internal(""));

		tutorialParticles1.allowCompletion();
		//

		flashParticle = new ParticleEffect();
		flashParticle.load(Gdx.files.internal("particleFlash"), // particlex
				Gdx.files.internal(""));

		flashParticle.allowCompletion();
		flashParticle.setPosition(185, 110);

		/*
		 * flashParticleLeft = new ParticleEffect();
		 * flashParticleLeft.load(Gdx.files.internal("particleFlashLeft"),
		 * //particlex Gdx.files.internal(""));
		 * 
		 * flashParticleLeft.allowCompletion(); flashParticleLeft.setPosition(0,
		 * 420);
		 * 
		 * 
		 * flashParticleRight = new ParticleEffect();
		 * flashParticleRight.load(Gdx.files.internal("particleFlashRight"),
		 * //particlex Gdx.files.internal(""));
		 * 
		 * flashParticleRight.allowCompletion();
		 * flashParticleRight.setPosition(480, 420);
		 */


		
		
		flashParticleDown = new ParticleEffect();
		flashParticleDown.load(Gdx.files.internal("particleFlashDown"), // particlex
				Gdx.files.internal(""));

		flashParticleDown.allowCompletion();
		flashParticleDown.setPosition(180, 670);
		//

		tutorialParticles2 = new ParticleEffect();
		tutorialParticles2.load(Gdx.files.internal("particleTutorial2"), // particlex
				Gdx.files.internal(""));

		tutorialParticles2.allowCompletion();

		tutorialParticles1.setPosition(0, 650);
		tutorialParticles2.setPosition(480, 650);

		//
		starsYellow = new ParticleEffect();
		starsYellow.load(Gdx.files.internal("starsGoodYellow"), // particlex
				Gdx.files.internal(""));

		starsYellow.allowCompletion();

		// starsGreen = new ParticleEffect();
		// starsGreen.load(Gdx.files.internal("starsGoodYellow"), //particlex
		// Gdx.files.internal(""));

		// starsGreen.allowCompletion();

		// starsGreen.setPosition(240,0);
		starsYellow.setPosition(240, 0);

		starsOrange = new ParticleEffect();
		starsOrange.load(Gdx.files.internal("starsGoodYellow180"), // particlex
				Gdx.files.internal(""));

		starsOrange.allowCompletion();

		starsOrange.setPosition(240, 800);

		leafParticles = new ParticleEffect();
		leafParticles.load(Gdx.files.internal("leafParticle"), // particlex
				Gdx.files.internal(""));

		leafParticles.allowCompletion();

		leafParticles.setPosition(480, 50);

		leafParticles2 = new ParticleEffect();
		leafParticles2.load(Gdx.files.internal("leafParticle"), // particlex
				Gdx.files.internal(""));

		leafParticles2.allowCompletion();

		leafParticles2.setPosition(480, 200);

		leafParticles3 = new ParticleEffect();
		leafParticles3.load(Gdx.files.internal("leafParticle"), // particlex
				Gdx.files.internal(""));

		leafParticles3.allowCompletion();

		leafParticles3.setPosition(480, 350);

		//
		 migacz = new Blinker(regions[33], 166, 680, 1.6f);
		 miganie3 = new Blinker(regions[33], 166, 680, 1.6f);
		miganie2 = new Blinker(regions[33], 166, 680, 1.6f);
		

		//
		// System.out.println("Skin to:" + ktorySkin);
		if (ktorySkin == 1)
			Green.button_texture_notClicked = cardGreen;
		if (ktorySkin == 2)
			Green.button_texture_notClicked = cardGreen2;
		if (ktorySkin == 3)
			Green.button_texture_notClicked = cardGreen3;
		if (ktorySkin == 4)
			Green.button_texture_notClicked = cardGreen4;
		if (ktorySkin == 5)
			Green.button_texture_notClicked = cardGreen5;
		if (ktorySkin == 6)
			Green.button_texture_notClicked = cardGreen6;

		Green.button_texture_notClicked.setFilter(TextureFilter.Nearest,
				TextureFilter.Nearest);
		Green.buttonImage = new Sprite(Green.button_texture_notClicked);

		if (ktorySkin == 1)
			Red.button_texture_notClicked = cardRed;
		if (ktorySkin == 2)
			Red.button_texture_notClicked = cardRed2;
		if (ktorySkin == 3)
			Red.button_texture_notClicked = cardRed3;
		if (ktorySkin == 4)
			Red.button_texture_notClicked = cardRed4;
		if (ktorySkin == 5)
			Red.button_texture_notClicked = cardRed5;
		if (ktorySkin == 6)
			Red.button_texture_notClicked = cardRed6;

		Red.button_texture_notClicked.setFilter(TextureFilter.Nearest,
				TextureFilter.Nearest);
		Red.buttonImage = new Sprite(Red.button_texture_notClicked);
		gemBlueSprite = new Sprite(blueGem);
		if (ktorySkin == 1)
			Blue.button_texture_notClicked = cardBlue;
		if (ktorySkin == 2)
			Blue.button_texture_notClicked = cardBlue2;
		if (ktorySkin == 3)
			Blue.button_texture_notClicked = cardBlue3;
		if (ktorySkin == 4)
			Blue.button_texture_notClicked = cardBlue4;
		if (ktorySkin == 5)
			Blue.button_texture_notClicked = cardBlue5;
		if (ktorySkin == 6)
			Blue.button_texture_notClicked = cardBlue6;
		Blue.button_texture_notClicked.setFilter(TextureFilter.Nearest,
				TextureFilter.Nearest);
		Blue.buttonImage = new Sprite(Blue.button_texture_notClicked);

		Red.width = 140;
		Red.height = 190;

		Green.width = 140;
		Green.height = 190;

		Blue.width = 140;
		Blue.height = 190;

		//

		walkSheet = new Texture("spritesheetAura.png");// Done

		walkSheet.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight()
						/ FRAME_ROWS); // #10
		walkFrames = new TextureRegion[22];
		int index = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 11; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}
		walkAnimation = new Animation(0.005f, walkFrames); // #11

		currentFrameSprite = new Sprite(walkAnimation.getKeyFrame(0, true));
		currentFrameSprite.setScale(2);

		// batch.draw(game.textSettingsPL,40,700);
		// game.ustawienia2Sprite.setPosition(0, 700);
		// game.ustawienia2Sprite.setScale(0.82f);
		// game.ustawienia2Sprite.setColor(Color.PINK);

		//
		kartonator = new Card();

		for (int a = 0; a < 5; a++) {
			kartonator.skaleKart[a] = 1f;
		}

		if (ktorySkin == 1) {
			kartonator.spriteGreen = new Sprite(cardGreen);
			kartonator.spriteRed = new Sprite(cardBlue);
			kartonator.spriteBlue = new Sprite(cardRed);
		}

		if (ktorySkin == 2) {
			kartonator.spriteGreen = new Sprite(cardGreen2);
			kartonator.spriteRed = new Sprite(cardBlue2);
			kartonator.spriteBlue = new Sprite(cardRed2);
		}
		if (ktorySkin == 3) {
			kartonator.spriteGreen = new Sprite(cardGreen3);
			kartonator.spriteRed = new Sprite(cardBlue3);
			kartonator.spriteBlue = new Sprite(cardRed3);
		}
		if (ktorySkin == 4) {
			kartonator.spriteGreen = new Sprite(cardGreen4);
			kartonator.spriteRed = new Sprite(cardBlue4);
			kartonator.spriteBlue = new Sprite(cardRed4);
		}
		if (ktorySkin == 5) {
			kartonator.spriteGreen = new Sprite(cardGreen5);
			kartonator.spriteRed = new Sprite(cardBlue5);
			kartonator.spriteBlue = new Sprite(cardRed5);
		}
		if (ktorySkin == 6) {
			kartonator.spriteGreen = new Sprite(cardGreen6);
			kartonator.spriteRed = new Sprite(cardBlue6);
			kartonator.spriteBlue = new Sprite(cardRed6);
		}

		kartonator.spriteGreen.setSize(140, 190);
		kartonator.spriteRed.setSize(140, 190);
		kartonator.spriteBlue.setSize(140, 190);

 jukebox = new Jukebox(poziomMuzyki, poziomDzwieku, soundClick, track1);
		this.setScreen(new LogoScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {

	}

	// public void zaladujWszystko(){

	public void updateKasa(int kasa) {
		doWypisywania = Integer.toString(kasa);
	}

	public void wypiszCzas(Batch batch, int kasa, int posX, int posY,
			float skala, float r, float g, float b, float alfa) {
		if (doPorownywaniaCzas != kasa) {
			doPorownywaniaCzas = kasa;

			doWypisywaniaCzas = Integer.toString(kasa);
		}
		int pozycja = posX;
		pozycja -= 20 * doWypisywaniaCzas.length();

		for (int a = 0; a < doWypisywaniaCzas.length(); a++) {

			int x = Character.getNumericValue(doWypisywaniaCzas.charAt(a));

			s = new Sprite(DIGITS[x]);

			// s.setTexture(DIGITS[x]);
			s.setScale(skala - 0.3f);
			s.setSize(37, 76);
			s.setPosition(pozycja, posY);

			s.setColor(r, g, b, alfa);

			s.draw(batch);

			// batch.draw(DIGITS[x],pozycja,posY);
			pozycja += 35;
		}
	}

	public void WypiszPieniadze(Batch batch, int kasa, int posX, int posY,
			float skala, float r, float g, float b, float alfa) {
		if (doPorownywania != kasa) {
			doPorownywania = kasa;

			doWypisywania = Integer.toString(kasa);
		}
		int pozycja = posX;
		pozycja -= 20 * doWypisywania.length();

		for (int a = 0; a < doWypisywania.length(); a++) {

			int x = Character.getNumericValue(doWypisywania.charAt(a));

			s = new Sprite(DIGITS[x]);

			// s.setTexture(DIGITS[x]);
			s.setScale(skala - 0.3f);
			s.setSize(37, 76);
			s.setPosition(pozycja, posY);

			s.setColor(r, g, b, alfa);

			s.draw(batch);

			// batch.draw(DIGITS[x],pozycja,posY);
			pozycja += 35;
		}
	}

	public void WypiszPieniadzeHUD(Batch batch, int kasa, int posX, int posY,
			float skala, float r, float g, float b) {

		if (doPorownywania != kasa) {
			doPorownywania = kasa;

			doWypisywania = Integer.toString(kasa);
		}
		int pozycja = posX;

		for (int a = 0; a < doWypisywania.length(); a++) {

			int x = Character.getNumericValue(doWypisywania.charAt(a));

			s = new Sprite(DIGITSHUD[x]);

			// s.setTexture(DIGITS[x]);
			s.setScale(skala - 0.3f);
			s.setSize(37, 76);
			s.setPosition(pozycja, posY);

			s.setColor(r, g, b, 1);

			s.draw(batch);

			// batch.draw(DIGITS[x],pozycja,posY);
			pozycja += 20;
		}
	}

	public void wypiszPunkty(Batch batch, int kasa, int posX, int posY,
			float skala, float r, float g, float b, float alfa) {

		if (doPorownywaniaPunkty != kasa) {
			doPorownywaniaPunkty = kasa;

			doWypisywaniaPunkty = Integer.toString(kasa);
		}
		int pozycja = posX;

		for (int a = 0; a < doWypisywaniaPunkty.length(); a++) {

			int x = Character.getNumericValue(doWypisywaniaPunkty.charAt(a));

			s = new Sprite(DIGITSHUD[x]);

			// s.setTexture(DIGITS[x]);
			s.setScale(skala - 0.3f);
			s.setSize(37, 76);
			s.setPosition(pozycja, posY);

			s.setColor(r, g, b, alfa);

			s.draw(batch);

			// batch.draw(DIGITS[x],pozycja,posY);
			pozycja += 20;
		}
	}

	public void wypiszGP(Batch batch, int kasa, int posX, int posY,
			float skala, float r, float g, float b, float alfa) {

		if (doPorownywaniaGP != kasa) {
			doPorownywaniaGP = kasa;
			// System.out.println("doporoGP");
			doWypisywaniaGP = Integer.toString(kasa);
		}
		int pozycja = posX;

		for (int a = 0; a < doWypisywaniaGP.length(); a++) {

			int x = Character.getNumericValue(doWypisywaniaGP.charAt(a));

			s = new Sprite(DIGITS[x]);

			// s.setTexture(DIGITS[x]);
			s.setScale(skala - 0.3f);
			s.setSize(37, 76);
			s.setPosition(pozycja, posY);

			s.setColor(r, g, b, alfa);

			s.draw(batch);

			// batch.draw(DIGITS[x],pozycja,posY);
			pozycja += 20;

		}
	}

	public void wypiszBS(Batch batch, int kasa, int posX, int posY,
			float skala, float r, float g, float b, float alfa) {
		// System.out.println(doWypisywaniaBS);
		if (doPorownywaniaBS != kasa) {
			doPorownywaniaBS = kasa;

			doWypisywaniaBS = Integer.toString(kasa);
		}
		int pozycja = posX;

		for (int a = 0; a < doWypisywaniaBS.length(); a++) {

			int x = Character.getNumericValue(doWypisywaniaBS.charAt(a));

			s = new Sprite(DIGITS[x]);

			// s.setTexture(DIGITS[x]);
			s.setScale(skala - 0.3f);
			s.setSize(37, 76);
			s.setPosition(pozycja, posY);

			s.setColor(r, g, b, alfa);

			s.draw(batch);

			// batch.draw(DIGITS[x],pozycja,posY);
			pozycja += 20;
		}
	}

	public void wypiszMana(Batch batch, int kasa, int posX, int posY,
			float skala, float r, float g, float b, float alfa) {

		if (doPorownywaniaMana != kasa) {
			doPorownywaniaMana = kasa;

			doWypisywaniaMana = Integer.toString(kasa);
		}
		int pozycja = posX;

		for (int a = 0; a < doWypisywaniaMana.length(); a++) {

			int x = Character.getNumericValue(doWypisywaniaMana.charAt(a));

			s = new Sprite(DIGITSHUD[x]);

			// s.setTexture(DIGITS[x]);
			s.setScale(skala - 0.3f);
			s.setSize(37, 76);
			s.setPosition(pozycja, posY);

			s.setColor(r, g, b, alfa);

			s.draw(batch);

			// batch.draw(DIGITS[x],pozycja,posY);
			pozycja += 20;
		}
	}

}
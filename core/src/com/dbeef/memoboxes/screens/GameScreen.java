package com.dbeef.memoboxes.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.dbeef.memoboxes.Main;
import com.dbeef.memoboxes.graphics.Gem;
import com.dbeef.memoboxes.graphics.Laser;
import com.dbeef.memoboxes.ui.Button;

public class GameScreen implements Screen {
	public double skalaTick = 1;

	double timerOrange = 0;
	double timerWind = 0;

	Sprite currentFrameSprite;
	float stateTime;

	public boolean pokazReklame = false;
	public double skalaCool = 1.5f;
	public double laserTimer = 0;

	public boolean stopPOW = false;
	public double timerPOW = 0;

	public int posWstazka = 901;
	public int posJustScore = -70;
	public int posScore = 481;

	boolean czyLeafes = false;

	public boolean czyRysowacCircle = false;
	public int circleX = 0;
	public int circleY = 0;
	public Iterator<Gem> iterGems;
	public Iterator<Body> iterBodies;
	public int collected3 = -30;
	public boolean czyPowiekszacCircle = true;
	public double powiekszanieCircle = 0.3f;
	public int doPorownywania;
	public double zwiekszajacaLasers = 2;
	public boolean czyPowiekszac = false;
	public Body body2;
	public Gem gemini2 = new Gem();

	public double skalaGwiazdy2 = 0;
	public double timerySpawnery = 0;

	public int posLewySpawnerX = 55;
	public int posPrawySpawnerX = 355;
	public boolean prawoLewo = false;
	public double timerPrzesuniecieSpawnerow = 0;
	public double timerPrzesuniecieSpawnerow2 = 0;

	int ilePunktow = 0;
	int ilePunktowBufor = 0;
	int pomPunkty = 0;
	double timerPunkty = 0;

	int pozycjeBackground[];

	boolean leftSpawnerReady = true;
	boolean rightSpawnerReady = false;
	boolean czyReady = false;
	public int manaBufor = 0;
	public double timerKasa = 0;

	Laser laserLeft;
	Laser laserRight;
	
	public double timerZoomKoniec = 1;
	public int posYspawnery = 698;
	public double timerBlue2 = 0;
	public double randomZoom;
	public double timerZoomRandom = 0;
	public double scaleZoom = 1;
	public int ktorePion1 = 1;
	public int ktorePion2 = 1;
	public int ktore = 1;
	public String doWypisywania = new String();
	double timerSpawn = -0.4f;

	public double timerKtorePion = 0;
	public double timerKtore = 0;

	public Array<Gem> gems = new Array();
	public Array<Body> bodies = new Array();

	int pozycje[] = new int[5];
	public int mana = 155;//15
	int status = 0;
	int statusMiganie;
	double rMiganie = 1;
	double gMiganie = 1;
	double bMiganie = 1;
	double timerMiganie = 0;
	double r = 1;
	double g = 1;
	public double timerKolory = 0;
	double b = 1;
	public int ileCombo = 0;

	double timerKoniec = 0;
	int tablicaPustych[] = new int[5];
	public int posLewe = -1;
	public int posPrawe = 464;
	public double timerOdejmijBary = 0;
	FPSLogger log = new FPSLogger();
	public int posBeamHoles = 708;
	public int laserPosY;
	public int posNajlepszyWynik = 481;

	public double skalaBad = 0;
	public double skalaGood = 0;

	double timerSkala = 0;

	public double zmiennaZielony = 1;
	public double zmiennaCzerwony = 0;
	public double zmiennaNiebieski = 0;

	boolean rotatecamera = false;
	public boolean czyRed = false;
	public double timerRed = 1;
	public double timerGreen = 1;
	public double timerBlue = 1;
	public int ilePunktow2;
	public int ilePunktowBufor2;
	boolean booleanCzyPowiekszac = true;
	double timerBcg = 0;
	double timerWypiszKlawiature = 0;
	double timerWypiszKlawiatureAlfa = 0;
	int ileCzasu = 6;
	public double odejmujacaWstazka = 10;
	double posRepeatOrder = -700;
	double licznikCzasu = ileCzasu;
	int ileCzasu2 = 6;
	public boolean czyBlue = false;
	public int goodTimes = 0;
	public int badTimes = 0;
	public boolean miganieCool = false;
	public boolean czyZniszczone = false;
	public double manaTimer = 0;
	boolean czyGraSieRozpoczela = false;
	boolean czyPrzegrana = false;
	boolean czyWygrana = false;
	double timerKlawiatury = 0;
	boolean dotkniety = false;
	double timerWin = 0;
	int posWinX1 = -350;
	int posWinX2 = 480;
	public boolean czyDodano = false;
	int posYwstazka = 800;
	double skala = 1f;
	Button backButton;
	public double skalaCzcionka = 0;
	public int collected1 = -217;
	public int collected2 = 481;
	public double timerZoom = 0;
	boolean czyPrzyciemnienie = true;
	boolean czyPrzyciemnij = false;
	boolean booleanMiganie = false;
	double timerPrzyciemnienie = 1;
	double timerTest = 0;
	boolean czyKoniec = false;
	public double timerPoczatkowy = 0;
	public boolean czyShake = false;
	boolean czyWypisacWynik = false;
	int levelTextX = 481;
	int levelTextY = 400;
	public boolean pojedyncze = false;
	double timerLevelText = 0;
	int odejmujaca = 8;

	public double skalaRandomTekst = 0;
	public double alfaRandomTekst = 1;
	public boolean czyZmniejszacRandomTekst = false;

	public boolean czyZielony = true;
	public boolean czyCzerwony = false;
	public boolean czyZolty = false;

	public boolean czyNowyTekst = false;
	public int wyborTekstu = 1;
	int odejmujaca2 = 1;
	double timertimer = 0;
	public int zebraneGemy = 0;
	public double deltatime;
	int odejmujaca3 = 1;
	int odejmujaca4 = 1;
	int odejmujaca5 = 2;
	public boolean fireClicked = false;
	public double timerFire = 0;
	public boolean czyKoniecRotating = false;
	int posXg;
	public int posBestScore = -120;
	int posYg;
	float angleg;
	boolean getReadyBoolean = false;
	boolean pokazacKlawiature = false;
	public double lastStateTime = 0;
	int ktore2 = 1;
	double odejmujacyTimer = 0.2;
	int posReadyY = 801;
	int levelNumberX = -51;
	int levelNumberY = 340;
	double timerLevel2 = 0;
	double timerReady = 0;
	double skalaLewy = 1.6f;
	double skalaPrawy = 1.6f;
	boolean czyNowyLevel = true;
	boolean nieWypisaneKarty = false;
	final Main game;
	Sprite mysteryCards[];
	public double skalaGwiazdy = 0;
	int tablicaKart[];
	public boolean konieckoniec = false;
	public double deltaTime;
	int pozycjeKart[];
	public int globalX = 0;
	public int posMiganie1;
	public boolean iceClicked = false;
	public double timerIce = 0;
	public boolean koniecGry = false;

	public GameScreen(final Main main) {
		game = main;
		game.doWypisywaniaPunkty = "0";

		game.logo.setPosition(-80, 375);
		game.spriteLogoBackground.setPosition(-120, 350);
		game.prefs.putInteger("ileGier", game.prefs.getInteger("ileGier") + 1);
		game.prefs.flush();

		game.particleStart = false;

		if (game.ileKart > 3)
			czyPrzyciemnienie = false;
		game.flashParticle.start();
		game.flashParticleDown.start();
		pozycjeBackground = new int[14];
		for (int a = 0, b = 0; a < 560; a++) {
			pozycjeBackground[b] = a;
			b++;
			a += 39;
		}
		mysteryCards = new Sprite[game.ileKart];
		tablicaKart = new int[game.ileKart];
		pozycjeKart = new int[game.ileKart];
		pozycje[0] = -85;
		pozycje[1] = -208;
		pozycje[2] = -180;
		pozycje[3] = 482;
		pozycje[4] = 657;

		for (int a = 0; a < 5; a++) {
			tablicaPustych[a] = 0;
		}

		for (int a = 0; a < game.ileKart; a++) {
			tablicaKart[a] = MathUtils.random(1, 3);
		}
		for (int a = 0, b = -150; a < game.ileKart; a++) {
			pozycjeKart[a] = b;
			b += 300;
		}

		backButton = new Button();
		game.Green.x = -170;
		game.Green.y = 350;
		game.Green.buttonImage.setPosition(-170, 350);

		game.Red.x = 170;
		game.Red.y = 801;
		game.Red.buttonImage.setPosition(170, 801);

		game.Blue.x = 510;
		game.Blue.y = 350;
		game.Blue.buttonImage.setPosition(510, 350);

		game.Red.czySzybki = true;
		game.Green.czySzybki = true;
		game.Blue.czySzybki = true;

		stateTime = 0f;
		currentFrameSprite = new Sprite();

		for (int a = 0, b = 20; a < game.ileKart; a++) {

			mysteryCards[a] = new Sprite(game.cardMystery, 140, 190);
			mysteryCards[a].setPosition(b, 10);

			b += 80;
		}

		game.buttonTick.x = 461;
		game.buttonCross.x = -63;

		ilePunktowBufor2 = game.ileGier;
		ilePunktow2 = 0;

		game.batch = new SpriteBatch(5460);
		game.camera = new OrthographicCamera();
		game.camera.setToOrtho(false, 480, 800);
		game.batch.setProjectionMatrix(game.camera.combined);

		backButton.setButtonPropeties(80, 80, game.back, 190, -90);
		backButton.szybkiPrzycisk = true;

		game.buttonTick.czySzybki = true;
		game.buttonCross.czySzybki = true;
		game.world = new World(new Vector2(0, -70f), false);
		game.bodies.clear();
		game.spriteTypes.clear();
		game.limit = 0;
	
		laserLeft = new Laser(game.walkSheet,50,0,90,game.laserMachineSprite.getTexture());
		laserRight = new Laser(game.walkSheet,330,0,270,game.laserMachineSprite.getTexture());

		
		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.position.set(0, 34);
		Body groundBody = game.world.createBody(groundBodyDef);

		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(480, 14f);

		groundBody.createFixture(groundBox, 0.0f);

		BodyDef groundBodyDefLeft = new BodyDef();
		groundBodyDefLeft.position.set(-18, 0);
		Body groundBodyLeft = game.world.createBody(groundBodyDefLeft);

		PolygonShape groundBoxLeft = new PolygonShape();
		groundBoxLeft.setAsBox(14f, 1000f);

		groundBodyLeft.createFixture(groundBoxLeft, 0.0f);

		BodyDef groundBodyDefRight = new BodyDef();
		groundBodyDefRight.position.set(593, 0);
		Body groundBodyRight = game.world.createBody(groundBodyDefRight);

		PolygonShape groundBoxRight = new PolygonShape();
		groundBoxRight.setAsBox(140f, 1000f);

		groundBodyRight.createFixture(groundBoxRight, 0.0f);
	}

	@Override
	public void render(float delta) {
		deltatime = delta;
		computeBackgroundColor();
		if (iceClicked == false)
			game.world.step(1 / 60f, 6, 2);

		timerSpawn += deltatime;
		if (timerSpawn > 0.40f) {
			timerSpawn = 0;
			if (iceClicked == false && czyZniszczone == false)
				spawnBody();

		}

		takeInput();
		timerPunkty += deltatime;
		if (timerPunkty > 0.02f) {
			przeliczPunkty();
			timerPunkty = 0;
		}
		for (int a = 0, b = 0; a < game.ileKart; a++) {

			if (pozycjeKart[a] < 840) {
				game.migacz.changeColor(tablicaKart[a]);
				if (pozycjeKart[a] < 450)
					b++;
			}

			// if (b > game.ileKart - 1)
			// game.migacz.czworeczka = true;

		}

		for (int a = 0; a < game.ileKart; a++) {
			pozycjeKart[a] += 6;
		}
		if (czyPrzyciemnienie == true && czyPrzyciemnij == false) {
			timerPrzyciemnienie -= deltatime * 5;

		}
		if (timerPrzyciemnienie < 0) {
			czyPrzyciemnienie = false;
			timerPrzyciemnienie = 0;
		}

		if (czyPrzyciemnij == true) {
			timerPrzyciemnienie += deltatime * 3;
			if (timerPrzyciemnienie > 1) {
				timerPrzyciemnienie = 1;
				game.czyOdciemnic = true;
				koniecGry = false;
				game.setScreen(new MenuScreen(game));
			}
		}

		if (ileCzasu2 < 0 || koniecGry == true) {
			czyPrzegrana = true;
			czyKoniec = true;
		}

		timerKasa += deltatime;
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		setZoom();
		setRedColour();
		if (koniecGry == true) {
			timerOdejmijBary += deltatime;
			if (timerOdejmijBary > 0.01f) {
				timerOdejmijBary = 0;
				if (posWstazka > 510)
					posWstazka -= odejmujacaWstazka;
				if (posWstazka > 510)
					posWstazka -= 10;

				odejmujacaWstazka -= 0.01f;

				if (posJustScore < 150)
					posJustScore += odejmujacaWstazka;
				if (posBestScore < 90)
					posBestScore += odejmujacaWstazka;
				if (collected1 < 68)
					collected1 += odejmujacaWstazka;
				if (collected2 > 310)
					collected2 -= odejmujacaWstazka;
				if (collected3 < 205)
					collected3 += odejmujacaWstazka;
				if (posScore > 300)
					posScore -= odejmujacaWstazka;
				if (posNajlepszyWynik > 320)
					posNajlepszyWynik -= odejmujacaWstazka;

				if (backButton.y < 180)
					backButton.setButtonPropeties(80, 80, game.back,
							190,
							backButton.y += odejmujacaWstazka);

				timerOdejmijBary = 0;

			}
		}
		if (czyZielony == true) {
			if (zmiennaZielony < 1)
				zmiennaZielony += deltatime;
			if (zmiennaZielony > 1)
				zmiennaZielony = 1;
			if (zmiennaCzerwony > 0)
				zmiennaCzerwony -= deltatime;
			if (zmiennaCzerwony < 0)
				zmiennaCzerwony = 0;
			if (zmiennaNiebieski > 0)
				zmiennaNiebieski -= deltatime;
			if (zmiennaNiebieski < 0)
				zmiennaNiebieski = 0;
		}
		if (czyCzerwony == true) {
			if (zmiennaCzerwony < 1)
				zmiennaCzerwony += deltatime;
			if (zmiennaCzerwony > 1)
				zmiennaCzerwony = 1;
			if (zmiennaZielony > 0)
				zmiennaZielony -= deltatime;
			if (zmiennaZielony < 0)
				zmiennaZielony = 0;
			if (zmiennaNiebieski > 0)
				zmiennaNiebieski -= deltatime;
			if (zmiennaNiebieski < 0)
				zmiennaNiebieski = 0;
		}
		if (czyZolty == true) {
			if (zmiennaCzerwony < 1)
				zmiennaCzerwony += deltatime;
			if (zmiennaCzerwony > 1)
				zmiennaCzerwony = 1;
			if (zmiennaZielony < 1)
				zmiennaZielony += deltatime;
			if (zmiennaZielony > 1)
				zmiennaZielony = 1;
			if (zmiennaNiebieski > 0)
				zmiennaNiebieski -= deltatime;
			if (zmiennaNiebieski < 0)
				zmiennaNiebieski = 0;
		}

		game.batch.begin();

		timerPoczatkowy += deltatime;

		if (czyPowiekszacCircle == true) {
			powiekszanieCircle += deltatime;
			if (powiekszanieCircle > 0.65f) {
				czyPowiekszacCircle = false;
				powiekszanieCircle = 0.65f;
			}
		} else {
			powiekszanieCircle -= deltatime;
			if (powiekszanieCircle < 0.3f) {
				czyPowiekszacCircle = true;
				powiekszanieCircle = 0.3f;
			}
		}
		drawBackground();

		czyShake = false;
		if (fireClicked == true) {
			drawLasers();
			czyShake = true;
			czyRed = true;
			timerFire += deltatime;
		}

		if (iceClicked == true) {
			czyBlue = true;
		}

		drawPhysics(delta);
		if (game.particleStart == true) {
			game.starsYellow.draw(game.batch, delta);
			game.starsOrange.draw(game.batch, delta);
		}
		game.leafParticles.draw(game.batch, delta);
		game.leafParticles2.draw(game.batch, delta);
		game.leafParticles3.draw(game.batch, delta);

		game.flashParticle.draw(game.batch, delta);
		game.flashParticleDown.draw(game.batch, delta);

		game.spawner.draw(game.batch);
		game.spawner2.draw(game.batch);

		game.spawnParticleLeft.draw(game.batch, delta);
		game.spawnParticleRight.draw(game.batch, delta);

		game.spawner.setPositionX(posLewySpawnerX);
		game.spawner2.setPositionX(posPrawySpawnerX);

		if (game.numerPoziomu == 1 && czyReady == false) {
			wypiszGetReady();
		}

		if (game.numerPoziomu > 1) {
			czyReady = true;
			getReadyBoolean = true;
		}

		if (czyNowyLevel == true && czyReady == true && koniecGry == false) {
			wypiszLevel();
		}

		if (nieWypisaneKarty == true && czyReady == true) {
			if (koniecGry == false)
				wypiszKarty();
		}
		if (pokazacKlawiature == true) {
			wypiszKlawiature(delta);
			game.buttonTick.button_display(game.batch);
			game.buttonCross.button_display(game.batch);
		}
		if (czyWypisacWynik == true)
			wypiszWynik();

		game.batch.setColor(1, 1, 1, 1);
		for (int a = 0; a < 42; a++) {

			game.batch.draw(game.regions[18], posLewe, 48 + a * 18);
			game.batch.draw(game.regions[18], posPrawe, 48 + a * 18);

			if (a < 8) {
				if (a == 1 || a == 0)
					game.batch.draw(game.regions[10], a * 70 - 6, posBeamHoles);

				if (a == 4 || a == 5)
					game.batch
							.draw(game.regions[10], a * 70 + 50, posBeamHoles);
			}

		}
		for (int a = 0; a < 27; a++) {

			game.batch.draw(game.regions[17], a * 18, 46);

		}

		game.batch.draw(game.regions[12], -20, -9);

		game.batch.draw(game.regions[21], 129, 711);

		game.batch.draw(game.regions[21], 129, 0);

		game.migacz.updateTimers();

		game.migacz.blinkingBar.draw(game.batch);

		game.miganie2.updateTimers();
		game.miganie2.blinkingBar.draw(game.batch);

		game.miganie2.blinkingBar.setPosition(165, 70);
		game.miganie2.blinkingBar.setRotation(180);
		game.miganie2.changeColor(game.migacz.blinkingColor);

		game.miganie3.changeColor(game.migacz.blinkingColor);
		game.miganie3.updateTimers();

		game.miganie3.blinkingBar.setScale(1.6f);
		game.miganie3.blinkingBar.setRotation(90);
		game.miganie3.blinkingBar.setPosition(-48, 435);
		game.miganie3.blinkingBar.draw(game.batch);

		game.miganie3.blinkingBar.setPosition(400, 435);
		game.miganie3.blinkingBar.setRotation(270);
		game.miganie3.blinkingBar.draw(game.batch);

		game.miganie3.blinkingBar.setScale(1f);
		game.miganie3.blinkingBar.setScale(1f, 2.2f);
		game.miganie3.blinkingBar.setRotation(90);
		game.miganie3.blinkingBar.setPosition(-54, 215);
		game.miganie3.blinkingBar.draw(game.batch);

		game.miganie3.blinkingBar.setScale(0.56f, 1.2f);
		game.miganie3.blinkingBar.setPosition(-54, 620);

		game.miganie3.blinkingBar.draw(game.batch);
		game.miganie3.blinkingBar.setPosition(405, 620);
		game.miganie3.blinkingBar.setRotation(270);

		game.miganie3.blinkingBar.draw(game.batch);
		game.miganie3.blinkingBar.setScale(1f, 2.2f);

		game.miganie3.blinkingBar.setPosition(407, 215);
		game.miganie3.blinkingBar.setRotation(270);
		game.miganie3.blinkingBar.draw(game.batch);

		game.miganiePusteSprite.setPosition(167, 70);
		game.miganiePusteSprite.draw(game.batch);

		timerPrzesuniecieSpawnerow += deltatime;
		if (timerPrzesuniecieSpawnerow > 0.05) {
			if (prawoLewo == false) {
				if (posLewySpawnerX > 20)
					posLewySpawnerX -= 1;
				if (posPrawySpawnerX < 390)
					posPrawySpawnerX += 1;
			}

			else {
				if (posLewySpawnerX < 390)
					posLewySpawnerX += 1;
				if (posPrawySpawnerX > 20)
					posPrawySpawnerX -= 1;
			}
			timerPrzesuniecieSpawnerow = 0;
		}
		timerPrzesuniecieSpawnerow2 += deltatime;

		if (timerPrzesuniecieSpawnerow2 > 7.9f) {
			if (prawoLewo == true)
				prawoLewo = false;
			else {
				prawoLewo = true;
			}

			timerPrzesuniecieSpawnerow2 = 0;
		}

		if (rightSpawnerReady == false) { // PRAWO
			timerySpawnery += deltatime;
			if (timerySpawnery > 0.1) {
				timerySpawnery = 0;
				skalaPrawy += 0.009f;
			}
			if (skalaLewy > 1.6f)
				skalaLewy -= 0.009f;
			if (skalaLewy < 1.6f)
				skalaLewy = 1.6f;

		} else if (leftSpawnerReady == true) // LEWO
		{
			timerySpawnery += deltatime;

			if (timerySpawnery > 0.1) {
				skalaLewy += 0.009f;
				timerySpawnery = 0;
			}
			if (skalaPrawy > 1.6f)
				skalaPrawy -= 0.009f;
			if (skalaPrawy < 1.6f)
				skalaPrawy = 1.6f;

		}
		if (manaBufor > 0) {
			if (mana >= 180)
				manaBufor = 0;
			manaTimer += deltatime;
			if (manaTimer > 0.1) {
				manaBufor--;
				mana++;
				manaTimer = 0;
			}
		}

		if (doPorownywania != mana) {
			doPorownywania = mana;

			doWypisywania = Integer.toString(mana);
		}

		if (game.fire.clicked == false && game.fire.clickedBefore == true) {
			mana -= 70;
		}
		if (game.wind.clicked == false && game.wind.clickedBefore == true) {
			mana -= 15;
			czyLeafes = true;
			timerWind += 3;
		}
		if (game.ice.clicked == false && game.ice.clickedBefore == true) {
			mana -= 30;
			iceClicked = true;
		}
		if (czyLeafes == true) {
			czyLeafes = false;
			game.leafParticles.start();
			game.leafParticles2.start();
			game.leafParticles3.start();
		}
		if (iceClicked == true) {
			timerIce += deltatime;
			if (timerIce > 5) {
				iceClicked = false;
				timerIce = 0;
			}
		}

		if (timerFire > 2.5f) {
			timerFire = 0;
			fireClicked = false;
			czyNowyTekst = true;
		}
		if (game.fire.clicked == true) {
			fireClicked = true;

		}
		if (fireClicked == false) {
			laserPosY = -20;
			zwiekszajacaLasers = 2;
		}
		if (game.wind.clicked == true) {
			iterGems = gems.iterator();
			iterBodies = game.bodies.iterator();
			//
			while (iterBodies.hasNext() && iterGems.hasNext()) {
				body2 = iterBodies.next();
				gemini2 = iterGems.next();

				// body2.applyLinearImpulse(impulseX, impulseY, pointX, pointY,
				// wake);
				// body2.applyLinearImpulse(0, -500, 1, 1, true);
				body2.applyLinearImpulse(-900, -400, 10, 10, true);
				// body2.applyForce(400, 400, 1, 1, true);
				// body2.applyTorque(600, true);
			}

		}

		game.wypiszPunkty(game.batch, ilePunktow, 195, 1, 0.8f, 1, 1f, 1, 1);
		//

		//
		//

		//
		// game.batch.draw(game.blueGem,230,7);
		game.batch.draw(game.regions[5], 150, 7);
		game.batch.draw(game.regions[7], 136, 777);
		game.batch.draw(game.hudGem, 136, 777, 0, 0, mana, 20);
		// bitmapFont.setColor(Color.WHITE);
		// bitmapFont.draw(game.batch, doWypisywania, 217, 794);
		if (mana <= 9) {
			game.wypiszMana(game.batch, mana, 212, 764, 0.55f, 1, 1, 1, 1);
		}
		if (mana >= 10 && mana <= 99) {
			game.wypiszMana(game.batch, mana, 202, 764, 0.55f, 1, 1, 1, 1);
		}
		if (mana >= 100) {
			game.wypiszMana(game.batch, mana, 193, 764, 0.55f, 1, 1, 1, 1);
		}

		// bitmapFont.draw(game.batch,
		// Integer.toString(Gdx.graphics.getFramesPerSecond()), 217, 794);
		// bitmapFont.draw(game.batch, "fps:"+Gdx.graphics.getFramesPerSecond(),
		// 217, 794);
		//

		//

		for (int a = 0; a < 5; a++) {

			// game.barYellowSprite.setRotation(90);

			if (a < 4) {
				// game.barYellowSprite.setPosition(127, a*18 - 9);
				// game.barYellowSprite.draw(game.batch);
				// game.barYellowSprite.setPosition(313, a*18 - 9);
				// game.barYellowSprite.draw(game.batch);
				game.batch.draw(game.regions[18], 127, a * 18 - 10);
				game.batch.draw(game.regions[18], 313, a * 18 - 10);

			}
			// game.barYellowSprite.setPosition(128, a*18 +710);
			// game.barYellowSprite.draw(game.batch);
			// game.barYellowSprite.setPosition(313, a*18 + 710);
			// game.barYellowSprite.draw(game.batch);
			game.batch.draw(game.regions[18], 128, a * 18 + 710);
			game.batch.draw(game.regions[18], 314, a * 18 + 710);

		}

		game.fire.draw(game.batch, mana);
		game.ice.draw(game.batch, mana);
		game.wind.draw(game.batch, mana);

		if (mana < 15)
			// game.WypiszPieniadzeHUD(game.batch, 15, 140, 695, 0.55f, 1, 0.3f,
			// 0.3f);
			game.batch.draw(game.regions[23], 143, 702);
		else
			// game.WypiszPieniadzeHUD(game.batch, 15, 140, 695, 0.55f, 1, 1f,
			// 1f);
			game.batch.draw(game.regions[22], 143, 702);
		if (mana < 30)
			// game.WypiszPieniadzeHUD(game.batch, 30, 200, 695, 0.55f, 1, 0.3f,
			// 0.3f);
			game.batch.draw(game.regions[25], 203, 701);
		else
			// game.WypiszPieniadzeHUD(game.batch, 30, 200, 695, 0.55f, 1, 1,
			// 1);
			game.batch.draw(game.regions[24], 203, 701);
		if (mana < 70)
			// game.WypiszPieniadzeHUD(game.batch, 70, 260, 695, 0.55f, 1, 0.3f,
			// 0.3f);
			game.batch.draw(game.regions[27], 263, 704);
		else
			// game.WypiszPieniadzeHUD(game.batch, 70, 260, 695, 0.55f, 1, 1,
			// 1f);
			game.batch.draw(game.regions[26], 263, 704);

		if (koniecGry == true) {
			// game.batch.draw(game.wstazka,65,posWstazka);
			game.batch.draw(game.justScore, posJustScore, 410);
			game.batch.draw(game.bestScore, posBestScore, 350);
			game.batch.draw(game.collectedEN, collected1, 290);
			game.batch.draw(game.regions[4], collected2, 287);
			game.WypiszPieniadzeHUD(game.batch, ilePunktow, posScore, 395, 1,
					1, 1, 1);
			game.WypiszPieniadzeHUD(game.batch, ilePunktow2, posNajlepszyWynik,
					335, 1, 1, 1, 1);
			game.WypiszPieniadzeHUD(game.batch, zebraneGemy, collected2 + 50,
					275, 1, 1, 1, 1);

			if (pokazReklame == false) {
				// game.adsController.showBannerAd();
				pokazReklame = true;
			}
			//

			game.badTextSprite.setScale((float) skalaBad);
			game.goodTextSprite.setScale((float) skalaGood);

			if (skalaBad < 0.4f)
				skalaBad += deltatime;
			if (skalaBad > 0.4f)
				skalaBad = 0.4f;
			if (skalaGood < 0.4f)
				skalaGood += deltatime;
			if (skalaGood > 0.4f)
				skalaGood = 0.4f;
			if (skalaCzcionka < 0.7f)
				skalaCzcionka += deltatime;
			game.badTextSprite.setPosition(45, 125);
			game.goodTextSprite.setPosition(85, 90);

			game.WypiszPieniadzeHUD(game.batch, badTimes, 295, 135,
					(float) skalaCzcionka, 1, 1, 1);
			game.WypiszPieniadzeHUD(game.batch, goodTimes, 280, 96,
					(float) skalaCzcionka, 1, 1, 1);

			game.badTextSprite.draw(game.batch);
			game.goodTextSprite.draw(game.batch);
			//

			if (skalaGwiazdy < 2)
				skalaGwiazdy += 3 * deltatime;
			if (skalaGwiazdy > 2)
				skalaGwiazdy = 2;

			if (skalaGwiazdy2 < 2 && skalaGwiazdy == 2) {
				skalaGwiazdy2 += 3 * deltatime;
				if (skalaGwiazdy2 > 2)
					skalaGwiazdy2 = 2;
			}

			game.starSil.setRotation(0);
			game.starSil.setPosition(210, 510);
			game.starSil.setScale((float) skalaGwiazdy);
			game.starSil.draw(game.batch);
			game.starSil.setRotation(-45);
			game.starSil.setPosition(140, 490);
			game.starSil.draw(game.batch);
			game.starSil.setRotation(45);
			game.starSil.setPosition(280, 490);
			game.starSil.draw(game.batch);

			if (ilePunktow > 0 && ilePunktow < 100) {
				game.starGol.setRotation(-45);
				game.starGol.setPosition(140, 490);
				game.starGol.setScale((float) skalaGwiazdy2);
				game.starGol.draw(game.batch);
			}
			if (ilePunktow >= 100 && ilePunktow < 1000) {
				game.starGol.setRotation(-45);
				game.starGol.setPosition(140, 490);
				game.starGol.setScale((float) skalaGwiazdy2);
				game.starGol.draw(game.batch);

				game.starGol.setRotation(0);
				game.starGol.setPosition(210, 510);
				game.starGol.setScale((float) skalaGwiazdy2);
				game.starGol.draw(game.batch);

			}
			if (ilePunktow >= 1000) {
				game.starGol.setRotation(0);
				game.starGol.setPosition(210, 510);
				game.starGol.setScale((float) skalaGwiazdy2);
				game.starGol.draw(game.batch);
				game.starGol.setRotation(-45);
				game.starGol.setPosition(140, 490);
				game.starGol.draw(game.batch);
				game.starGol.setRotation(45);
				game.starGol.setPosition(280, 490);
				game.starGol.draw(game.batch);

			}

			if (skalaGwiazdy < 1.5f)
				game.cool.setScale((float) skalaGwiazdy);
			else
				miganieCool = true;

			game.cool.setPosition(120, 570);
			game.cool.draw(game.batch);

			if (miganieCool == true) {
				game.cool.setScale((float) skalaCool);

				if (czyPowiekszac == true) {

					if (skalaCool < 1.6f)
						skalaCool += deltatime / 3f;
					if (skalaCool > 1.6f) {
						skalaCool = 1.6f;
						czyPowiekszac = false;
					}

				}
				if (czyPowiekszac == false) {

					if (skalaCool >= 1.5f)
						skalaCool -= deltatime / 3f;
					if (skalaCool < 1.5f) {
						skalaCool = 1.5f;
						czyPowiekszac = true;
					}
				}
			}
		}

		if (game.ileKart == 3)
			game.batch.setColor(1f, 1f, 1f, (float) timerPrzyciemnienie);
		if (backButton.y > 0)
			backButton.button_display(game.batch);
		if (game.ileKart == 3)
			game.batch.draw(game.czarny, 0, 0);
		// game.batch.setColor(1f,1f,1f,1);

		wypiszRandomTekst();

		game.batch.end();
		// rayHandler.updateAndRender();

	}

	// ////////////////////////////////////////
	void wypiszWynik() {
		timerKoniec += deltatime;
		if (czyPrzegrana == true) {
			ileCombo = 0;
			if (koniecGry == false) {
				timerWin += deltatime;
				game.batch.draw(game.regions[9], posWinX1, 345);
				game.batch.draw(game.regions[13], posWinX2, 175);
				game.batch.draw(game.regions[8], posWinX1 + 20, 370);
				game.batch.draw(game.regions[19], posWinX1 + 10, 185);
			}
			// game.batch.draw(game.wstazka,70,posYwstazka);

			if (timerWin > 0.01) {
				if (posWinX1 < 40) {
					posWinX1 += odejmujaca5;
				}
				if (posWinX2 > 50)
					posWinX2 -= odejmujaca5;
				posYwstazka -= odejmujaca5;
				if (odejmujaca5 < 7)
					odejmujaca5 *= odejmujaca5;

			}
			if (timerKoniec > 1.5f) {
				posWinX1 += odejmujaca5;

				posWinX2 -= odejmujaca5;
			}
			if (timerKoniec > 3) {
				{
					// game.migacz.czworeczka = false;
					game.migacz.timer = 0;
					if (game.ileKart < 5)
						game.ileKart++;
					game.numerPoziomu++;
					//
					// kartonator = new Card();
					czyReady = false;
					timerSpawn = 0;
					status = 0;
					r = 1;
					g = 1;
					b = 1;
					timerKoniec = 0;
					// timerBackground = 0;
					timerSkala = 0;
					booleanCzyPowiekszac = true;
					timerWypiszKlawiature = 0;
					posRepeatOrder = -700;
					timerWypiszKlawiatureAlfa = 0;
					ileCzasu = 6;
					licznikCzasu = ileCzasu;
					ileCzasu2 = 6;
					czyGraSieRozpoczela = false;
					czyPrzegrana = false;
					czyWygrana = false;
					timerKlawiatury = 0;
					dotkniety = false;
					timerWin = 0;
					posWinX1 = -350;
					posWinX2 = 480;
					posYwstazka = 800;
					skala = 1f;
					czyPrzyciemnienie = true;
					czyPrzyciemnij = false;
					timerPrzyciemnienie = 1;
					timerTest = 0;
					czyKoniec = false;
					czyWypisacWynik = false;
					levelTextX = 481;
					levelTextY = 400;
					timerLevelText = 0;
					odejmujaca = 8;
					odejmujaca2 = 1;
					odejmujaca3 = 1;
					odejmujaca4 = 1;
					odejmujaca5 = 2;
					getReadyBoolean = false;
					pokazacKlawiature = false;
					odejmujacyTimer = 0.2;
					posReadyY = 801;
					levelNumberX = -51;
					levelNumberY = 340;
					// int numerPoziomu = 1;
					timerLevel2 = 0;
					timerReady = 0;
					czyNowyLevel = true;
					nieWypisaneKarty = false;
					// b
					badTimes += 1;
					mysteryCards = new Sprite[game.ileKart];
					tablicaKart = new int[game.ileKart];
					pozycjeKart = new int[game.ileKart];
					pozycje[0] = -85;
					pozycje[1] = -208;
					pozycje[2] = -180;
					pozycje[3] = 482;
					pozycje[4] = 657;

					for (int a = 0; a < 5; a++) {
						tablicaPustych[a] = 0;
					}

					for (int a = 0; a < game.ileKart; a++) {
						tablicaKart[a] = MathUtils.random(1, 3);
					}

					for (int a = 0, b = 100 * game.ileKart; a < game.ileKart; a++) {
						pozycjeKart[a] = b;
						b += 300;
					}

					for (int a = 0, b = 20; a < game.ileKart; a++) {

						mysteryCards[a] = new Sprite(game.cardMystery, 140, 190);
						mysteryCards[a].setPosition(b, 10);
				
						b += 80;
					}
					game.buttonTick.x = 481;
					game.buttonCross.x = -73;

					game.Green.changePosition(-170, 350);
					game.Red.changePosition(170, 801);
					game.Blue.changePosition(510,350);

					
					game.Red.czySzybki = true;
					game.Green.czySzybki = true;
					game.Blue.czySzybki = true;

					game.buttonTick.czySzybki = true;
					game.buttonCross.czySzybki = true;
					
					game.limit = 0;

				}
			}

		}
		// ///////////////////////////////////////////////////////////////////////////////////////////////
		if (czyWygrana == true) {
			// drawLasers();
			if (ileCombo < 3 && czyDodano == false) {
				czyDodano = true;
				ileCombo++;
			}
			timerWin += deltatime;
			game.batch.draw(game.regions[9], posWinX1, 345);
			game.batch.draw(game.regions[13], posWinX2, 175);
			game.batch.draw(game.regions[6], posWinX1 + 30, 370);
			game.batch.draw(game.regions[20], posWinX2 + 20, 185);
			timerKolory += deltatime;
			if (timerKolory < 0.25f) {
				game.WypiszPieniadze(game.batch, ileCombo, posWinX2 + 350, 190,
						1, 1, 1, 0, 1);
			}
			if (timerKolory >= 0.25f && timerKolory < 0.5f) {
				game.WypiszPieniadze(game.batch, ileCombo, posWinX2 + 350, 190,
						1, 0, 1, 1, 1);
			}
			if (timerKolory >= 0.5f && timerKolory < 0.75f) {
				game.WypiszPieniadze(game.batch, ileCombo, posWinX2 + 350, 190,
						1, 1, 0, 1, 1);
			}
			if (timerKolory >= 0.75f && timerKolory < 1f) {
				game.WypiszPieniadze(game.batch, ileCombo, posWinX2 + 350, 190,
						1, 1, 0, 0, 1);
			}
			if (timerKolory >= 1f && timerKolory < 1.25f) {
				game.WypiszPieniadze(game.batch, ileCombo, posWinX2 + 350, 190,
						1, 0, 0, 1, 1);
			}

			if (timerKolory > 1.25f)
				timerKolory = 0;
			if (game.particleStart == false) {// game.starsGreen.start();
				game.starsYellow.start();
				game.particleStart = true;
				game.starsOrange.start();

			}

			// game.batch.draw(game.wstazka,70,posYwstazka);
			// game.WypiszPieniadze(game.batch, 100, posWinX1+150, 200, 1, 0.5f,
			// 0.5f, 1);
			if (timerWin > 0.01) {
				if (posWinX1 < 40) {
					posWinX1 += odejmujaca5;
				}
				if (posWinX2 > 50)
					posWinX2 -= odejmujaca5;
				posYwstazka -= odejmujaca5;
				if (odejmujaca5 < 7)
					odejmujaca5 *= odejmujaca5;

			}

			if (timerKoniec > 1.5f) {
				posWinX1 += odejmujaca5;
				posWinX2 -= odejmujaca5;
				posYwstazka -= odejmujaca5;
				if (posWinX1 > 700) {
					// if(timerPrzyciemnienie<1)timerPrzyciemnienie+=deltatime*2;
					// if(timerPrzyciemnienie>1)timerPrzyciemnienie = 1f;
					// if(timerPrzyciemnienie == 1){if(game.ileKart
					// <5)game.ileKart++;game.numerPoziomu++;game.setScreen(new
					// GameScreen(game));
					{
						// game.migacz.czworeczka = false;
						game.migacz.timer = 0;
						if (game.ileKart < 5)
							game.ileKart++;
						game.numerPoziomu++;
						//
						// kartonator = new Card();
						czyReady = false;

						timerSpawn = 0;
						game.particleStart = false;
						status = 0;
						r = 1;
						g = 1;
						b = 1;
						timerKoniec = 0;
						manaBufor += 40;
						// if(mana > 187)mana = 187;

						// timerBackground = 0;

						timerSkala = 0;
						booleanCzyPowiekszac = true;
						posRepeatOrder = -700;
						timerWypiszKlawiature = 0;
						timerWypiszKlawiatureAlfa = 0;
						ileCzasu = 6;
						licznikCzasu = ileCzasu;
						ileCzasu2 = 6;
						czyGraSieRozpoczela = false;
						czyPrzegrana = false;
						czyWygrana = false;
						//
						// laserPosY = 0;
						// zwiekszajacaLasers = 2;
						timerKlawiatury = 0;
						dotkniety = false;
						timerWin = 0;
						posWinX1 = -350;
						posWinX2 = 480;
						posYwstazka = 800;
						skala = 1f;

						czyPrzyciemnienie = true;
						czyPrzyciemnij = false;
						timerPrzyciemnienie = 1;
						timerTest = 0;

						czyKoniec = false;
						czyWypisacWynik = false;

						levelTextX = 481;
						levelTextY = 400;
						timerLevelText = 0;
						odejmujaca = 8;
						odejmujaca2 = 1;

						odejmujaca3 = 1;
						odejmujaca4 = 1;
						skalaTick = 1;
						odejmujaca5 = 2;

						getReadyBoolean = false;
						pokazacKlawiature = false;
						odejmujacyTimer = 0.2;
						posReadyY = 801;
						levelNumberX = -51;
						levelNumberY = 340;
						// int numerPoziomu = 1;
						timerLevel2 = 0;
						goodTimes += 1;
						timerReady = 0;

						czyNowyLevel = true;

						nieWypisaneKarty = false;
						//
						mysteryCards = new Sprite[game.ileKart];
						tablicaKart = new int[game.ileKart];
						pozycjeKart = new int[game.ileKart];
						pozycje[0] = -85;
						pozycje[1] = -208;
						pozycje[2] = -180;
						pozycje[3] = 482;
						pozycje[4] = 657;
						// laserPosY = 0;
						// zwiekszajacaLasers = 2;
						for (int a = 0; a < 5; a++) {
							tablicaPustych[a] = 0;
						}

						for (int a = 0; a < game.ileKart; a++) {
							tablicaKart[a] = MathUtils.random(1, 3);
						}

						for (int a = 0, b = 100 * game.ileKart; a < game.ileKart; a++) {
							pozycjeKart[a] = b;
							b += 300;
						}

						// backButton = new Button();
						for (int a = 0, b = 20; a < game.ileKart; a++) {

							mysteryCards[a] = new Sprite(game.cardMystery, 140,
									190);
							mysteryCards[a].setPosition(b, 10);
							// mysteryCards[a].setScale(0.5f);

							b += 80;
						}
						game.buttonTick.x = 481;
						game.buttonCross.x = -73;
						// kartonator = new Card();

						// backButton.setButtonPropeties(80, 80, game.back, 10,
						// 670);
						// backButton.szybkiPrzycisk = true;
						if (game.ktorySkin == 1) {
							game.Green.setButtonPropeties(140, 190,
									game.cardGreen, -170, 350);
							game.Red.setButtonPropeties(140, 190,
									game.cardRed, 170, 801);
							game.Blue.setButtonPropeties(140, 190,
									game.cardBlue, 510, 350);
						}
						if (game.ktorySkin == 2) {
							game.Green.setButtonPropeties(140, 190,
									game.cardGreen2, -170, 350);
							game.Red.setButtonPropeties(140, 190,
									game.cardRed2, 170, 801);
							game.Blue.setButtonPropeties(140, 190,
									game.cardBlue2, 510, 350);
						}
						if (game.ktorySkin == 3) {
							game.Green.setButtonPropeties(140, 190,
									game.cardGreen3, -170, 350);
							game.Red.setButtonPropeties(140, 190,
									game.cardRed3, 170, 801);
							game.Blue.setButtonPropeties(140, 190,
									game.cardBlue3, 510, 350);
						}
						if (game.ktorySkin == 4) {
							game.Green.setButtonPropeties(140, 190,
									game.cardGreen4, -170, 350);
							game.Red.setButtonPropeties(140, 190,
									game.cardRed4, 170, 801);
							game.Blue.setButtonPropeties(140, 190,
									game.cardBlue4, 510, 350);
						}
						if (game.ktorySkin == 5) {
							game.Green.setButtonPropeties(140, 190,
									game.cardGreen5, -170, 350);
							game.Red.setButtonPropeties(140, 190,
									game.cardRed5, 170, 801);
							game.Blue.setButtonPropeties(140, 190,
									game.cardBlue5, 510, 350);
						}
						if (game.ktorySkin == 6) {
							game.Green.setButtonPropeties(140, 190,
									game.cardGreen6, -170, 350);
							game.Red.setButtonPropeties(140, 190,
									game.cardRed6, 170, 801);
							game.Blue.setButtonPropeties(140, 190,
									game.cardBlue6, 510, 350);
						}

						game.Red.czySzybki = true;
						game.Green.czySzybki = true;
						game.Blue.czySzybki = true;
						game.buttonTick.czySzybki = true;
						game.buttonCross.czySzybki = true;
						game.limit = 0;
						// kartonator.ustaw(game.cardGreen, game.cardRed,
						// game.cardBlue);

						//
					}
				}

			}
		}
	}

	void wypiszKlawiature(float delta) {
		timerTest += deltatime;
		if (timerTest > 0.2) {
			// spawnGem();
			timerTest = 0;

		}

		if (czyKoniec == false) {
			timerWypiszKlawiature += deltatime;
			if (timerWypiszKlawiatureAlfa < 0.98f)
				timerWypiszKlawiatureAlfa += deltatime;
			else
				czyGraSieRozpoczela = true;

			// if(czyGraSieRozpoczela)licznikCzasu -= deltatime;
			// ileCzasu = (int)licznikCzasu;
			game.batch.setColor(1f, 1f, 1f, (float) timerWypiszKlawiatureAlfa);
			// game.WypiszPieniadze(game.batch, ileCzasu, 200, 700);
			// Wypisac poziom
			// game.batch.draw(game.backgroundCards,22,165);

			// game.batch.draw(game.backgroundButtons,20,340);
			wypiszCzas();

			// game.batch.setColor(1f, 1f, 1f,1f);
			game.batch.draw(game.regions[28], (int) posRepeatOrder, 300);

			if (game.Green.x > -100) {
				game.Green.button_display(game.batch);
			}
			game.Red.button_display(game.batch);
			game.Blue.button_display(game.batch);

			// game.batch.draw(game.cardMystery,pozycje[0],170);
			// game.batch.draw(game.cardMystery,pozycje[1],170);
			// game.batch.draw(game.cardMystery,197,pozycje[2]);
			// game.batch.draw(game.cardMystery,pozycje[3],170);
			// game.batch.draw(game.cardMystery,pozycje[4],170);

			for (int a = 0; a < 5; a++) {
				if (a == 2) {
					if (tablicaPustych[a] == 3) {
						if (game.ktorySkin == 1)
							game.batch.draw(game.cardGreenS, 197, pozycje[a]);
						if (game.ktorySkin == 2)
							game.batch.draw(game.cardGreenS2, 197, pozycje[a]);
						if (game.ktorySkin == 3)
							game.batch.draw(game.cardGreenS3, 197, pozycje[a]);
						if (game.ktorySkin == 4)
							game.batch.draw(game.cardGreenS4, 197, pozycje[a]);
						if (game.ktorySkin == 5)
							game.batch.draw(game.cardGreenS5, 197, pozycje[a]);
						if (game.ktorySkin == 6)
							game.batch.draw(game.cardGreenS6, 197, pozycje[a]);
					}
					if (tablicaPustych[a] == 2) {
						if (game.ktorySkin == 1)
							game.batch.draw(game.cardRedS, 197, pozycje[a]);
						if (game.ktorySkin == 2)
							game.batch.draw(game.cardRedS2, 197, pozycje[a]);
						if (game.ktorySkin == 3)
							game.batch.draw(game.cardRedS3, 197, pozycje[a]);
						if (game.ktorySkin == 4)
							game.batch.draw(game.cardRedS4, 197, pozycje[a]);
						if (game.ktorySkin == 5)
							game.batch.draw(game.cardRedS5, 197, pozycje[a]);
						if (game.ktorySkin == 6)
							game.batch.draw(game.cardRedS6, 197, pozycje[a]);

					}
					if (tablicaPustych[a] == 1) {
						if (game.ktorySkin == 1)
							game.batch.draw(game.cardBlueS, 197, pozycje[a]);
						if (game.ktorySkin == 2)
							game.batch.draw(game.cardBlueS2, 197, pozycje[a]);
						if (game.ktorySkin == 3)
							game.batch.draw(game.cardBlueS3, 197, pozycje[a]);
						if (game.ktorySkin == 4)
							game.batch.draw(game.cardBlueS4, 197, pozycje[a]);
						if (game.ktorySkin == 5)
							game.batch.draw(game.cardBlueS5, 197, pozycje[a]);
						if (game.ktorySkin == 6)
							game.batch.draw(game.cardBlueS6, 197, pozycje[a]);

					}

					if (tablicaPustych[a] == 0)
						game.batch.draw(game.regions[14], 197, pozycje[a]);
					b += 85;
				} else {
					if (tablicaPustych[a] == 3) {
						if (game.ktorySkin == 1)
							game.batch.draw(game.cardGreenS, pozycje[a], 170);
						if (game.ktorySkin == 2)
							game.batch.draw(game.cardGreenS2, pozycje[a], 170);
						if (game.ktorySkin == 3)
							game.batch.draw(game.cardGreenS3, pozycje[a], 170);
						if (game.ktorySkin == 4)
							game.batch.draw(game.cardGreenS4, pozycje[a], 170);
						if (game.ktorySkin == 5)
							game.batch.draw(game.cardGreenS5, pozycje[a], 170);
						if (game.ktorySkin == 6)
							game.batch.draw(game.cardGreenS6, pozycje[a], 170);

					}
					if (tablicaPustych[a] == 2) {
						if (game.ktorySkin == 1)
							game.batch.draw(game.cardRedS, pozycje[a], 170);
						if (game.ktorySkin == 2)
							game.batch.draw(game.cardRedS2, pozycje[a], 170);
						if (game.ktorySkin == 3)
							game.batch.draw(game.cardRedS3, pozycje[a], 170);
						if (game.ktorySkin == 4)
							game.batch.draw(game.cardRedS4, pozycje[a], 170);
						if (game.ktorySkin == 5)
							game.batch.draw(game.cardRedS5, pozycje[a], 170);
						if (game.ktorySkin == 6)
							game.batch.draw(game.cardRedS6, pozycje[a], 170);

					}
					if (tablicaPustych[a] == 1) {
						if (game.ktorySkin == 1)
							game.batch.draw(game.cardBlueS, pozycje[a], 170);
						if (game.ktorySkin == 2)
							game.batch.draw(game.cardBlueS2, pozycje[a], 170);
						if (game.ktorySkin == 3)
							game.batch.draw(game.cardBlueS3, pozycje[a], 170);
						if (game.ktorySkin == 4)
							game.batch.draw(game.cardBlueS4, pozycje[a], 170);
						if (game.ktorySkin == 5)
							game.batch.draw(game.cardBlueS5, pozycje[a], 170);
						if (game.ktorySkin == 6)
							game.batch.draw(game.cardBlueS6, pozycje[a], 170);

					}

					if (tablicaPustych[a] == 0)
						game.batch.draw(game.regions[14], pozycje[a], 170);
					b += 85;
				}
			}

			if (timerWypiszKlawiature > 0.01) {
				timerWypiszKlawiature = 0;
				if (game.Green.x < 30) {
					game.Green.x += odejmujaca3;
				}
				if (game.Red.y > 350) {
					game.Red.y -= odejmujaca4;
					posRepeatOrder += odejmujaca3 + 29.5f;
				}
				if (game.Blue.x > 310)
					game.Blue.x -= odejmujaca3;

				if (game.buttonTick.x > 360)
					game.buttonTick.x -= odejmujaca3;
				if (game.buttonCross.x < 25)
					game.buttonCross.x += odejmujaca3;

				odejmujaca3 = 10;
				if (pozycje[0] < 25)
					pozycje[0] += odejmujaca3;
				if (pozycje[1] < 112)
					pozycje[1] += odejmujaca3;
				if (pozycje[2] < 170)
					pozycje[2] += odejmujaca3;
				if (pozycje[3] > 282)
					pozycje[3] -= odejmujaca3;
				if (pozycje[4] > 367)
					pozycje[4] -= odejmujaca3;

				if (pozycje[0] >= 25 && pozycje[0] < 27)
					pozycje[0]++;

				odejmujaca3 = 10;
				odejmujaca4 = 25;
			}
		} else {

			timerWypiszKlawiature += deltatime;

			if (timerWypiszKlawiatureAlfa > 0.05f)
				timerWypiszKlawiatureAlfa -= deltatime * 2;
			if (timerWypiszKlawiatureAlfa < 0.05)
				timerWypiszKlawiatureAlfa = 0;

			game.batch.setColor(1f, 1f, 1f, (float) timerWypiszKlawiatureAlfa);
			// game.WypiszPieniadze(game.batch, ileCzasu, 200, 700);
			// Wypisac poziom
			game.batch.draw(game.regions[15], 22, 165);

			game.batch.draw(game.regions[16], 20, 340);
			wypiszCzas();

			game.batch.setColor(1f, 1f, 1f, 1f);
			if (game.Green.x > -50) {
				game.Green.button_display(game.batch);
			}
			if (game.Red.y < 700) {
				game.Red.button_display(game.batch);
			}
			if (game.Blue.x < 455) {
				game.Blue.button_display(game.batch);
			}
			game.batch.draw(game.regions[28], (int) posRepeatOrder, 300);

			for (int a = 0; a < 5; a++) {
				if (a == 2) {
					if (tablicaPustych[a] == 3)
						game.batch.draw(game.cardGreenS, 197, pozycje[a]);
					if (tablicaPustych[a] == 2)
						game.batch.draw(game.cardRedS, 197, pozycje[a]);
					if (tablicaPustych[a] == 1)
						game.batch.draw(game.cardBlueS, 197, pozycje[a]);
					if (tablicaPustych[a] == 0)
						game.batch.draw(game.regions[14], 197, pozycje[a]);
					b += 85;
				} else {
					if (tablicaPustych[a] == 3)
						game.batch.draw(game.cardGreenS, pozycje[a], 170);
					if (tablicaPustych[a] == 2)
						game.batch.draw(game.cardRedS, pozycje[a], 170);
					if (tablicaPustych[a] == 1)
						game.batch.draw(game.cardBlueS, pozycje[a], 170);
					if (tablicaPustych[a] == 0)
						game.batch.draw(game.regions[14], pozycje[a], 170);
					b += 85;
				}
			}

			// System.out.println(Green.x);
			// game.camera.rotate(180);
			if (timerWypiszKlawiature > 0.01) {
				timerWypiszKlawiature = 0;
				if (game.Green.x > -200)
					game.Green.x -= odejmujaca3;
				if (game.Red.y > -350) {
					game.Red.y += odejmujaca4;
					posRepeatOrder += 20;
				}
				if (game.Blue.x > -310)
					game.Blue.x += odejmujaca3;

				if (game.buttonTick.x > -260)
					game.buttonTick.x -= odejmujaca3;
				if (game.buttonCross.x < 560)
					game.buttonCross.x += odejmujaca3;

				odejmujaca3 = 10;
				if (pozycje[0] > -125)
					pozycje[0] -= odejmujaca4;
				if (pozycje[1] > -112)
					pozycje[1] -= odejmujaca4;
				if (pozycje[2] > -170)
					pozycje[2] -= odejmujaca3;
				if (pozycje[3] < 682)
					pozycje[3] += odejmujaca4;
				if (pozycje[4] < 667)
					pozycje[4] += odejmujaca4;

				if (pozycje[0] >= 25 && pozycje[0] < 27)
					pozycje[0]++;

				if (pozycje[1] <= -112) {
					czyWypisacWynik = true;
				}

				odejmujaca3 = 10;
				odejmujaca4 = 25;
			}

		}
		/*
		 * buttonTick.setButtonPropeties(40, 40, blueTick,blueTick,481, 45);
		 * //260,45 buttonCross.setButtonPropeties(40, 40, blueBox, blueBox, -1,
		 * 45); //160,45
		 */
	}

	void wypiszGetReady() {

		if (getReadyBoolean == false) {
			timerReady += deltatime * 1.3;
		} else
			timerReady -= deltatime * 1.3;

		if (timerReady < 0.01f) {
			czyReady = true;
		}

		if (czyReady == false) {
			if (timerReady > 0.99f)
				getReadyBoolean = true;
			if (timerReady > 0.99f)
				timerReady = 0.97f;

			game.batch.setColor(1f, 1f, 1f, (float) timerReady);
			game.batch.draw(game.getReady, 40, 215);
		}
	}

	void wypiszKarty() {

		timerLevel2 += deltatime;
		int maxPos = game.ileKart * 400 * -1;
		if (pokazacKlawiature == false) {
			for (int a = 0; a < game.ileKart; a++) {
				if (tablicaKart[a] == 1) {
					// game.batch.draw(game.cardBlue,160,pozycjeKart[a]);
					if (pozycjeKart[a] > -200 && pozycjeKart[a] < 800)
						game.kartonator.narysuj(160, pozycjeKart[a], 1,
								game.batch, a);
				}
				if (tablicaKart[a] == 2) {
					if (pozycjeKart[a] > -200 && pozycjeKart[a] < 800)
						game.kartonator.narysuj(160, pozycjeKart[a], 2,
								game.batch, a);
					// game.batch.draw(game.cardRed,160,pozycjeKart[a]);
				}
				if (tablicaKart[a] == 3) {
					if (pozycjeKart[a] > -200 && pozycjeKart[a] < 800)
						game.kartonator.narysuj(160, pozycjeKart[a], 3,
								game.batch, a);
					// game.batch.draw(game.cardGreen,160,pozycjeKart[a]);

				}
			}

		}
		if (timerLevel2 > odejmujacyTimer) {
			timerLevel2 = 0;
			if (odejmujaca < 3)
				odejmujaca += 1;
		}

		for (int a = 0; a < game.ileKart; a++) {
			pozycjeKart[a] -= odejmujaca + 5;
		}

		if (pozycjeKart[game.ileKart - 1] < maxPos + 970) {
			nieWypisaneKarty = false;
			pokazacKlawiature = true;
			odejmujaca = 1;
			odejmujaca2 = 1;
			levelTextX = 681;
			levelTextY = 600;
			levelNumberX = -51;
			levelNumberY = 540;
			status = 4;
			game.kartonator.status = 4;
		}

	}

	// /////////////////////
	void wypiszCzas() {
		// if(czyKoniec == true)levelNumberX = 224;
		if (czyKoniec == false)
			timerLevel2 += deltatime;
		if (timerLevel2 < 1) {
			timerLevelText += deltatime;
			if (timerLevelText > 0.01) {
				timerLevelText = 0;
				if (czyKoniec)
					levelNumberY += odejmujaca;
				//
				// System.out.println(levelNumberX);
				odejmujaca += 1;
				odejmujaca2 += 1;
			}
			if (levelTextX > 140) {
				levelTextX -= odejmujaca;

			}

			if (levelNumberX < 220) {
				levelNumberX += odejmujaca2;
				// timerSkala = 0;
				booleanCzyPowiekszac = true;
				timerSkala = 0;
			}
		} else {

			timerSkala += deltatime;

			if (timerSkala < 0.1f && booleanCzyPowiekszac == true) {
				skala += 0.04f;
			} else
				booleanCzyPowiekszac = false;

			if (booleanCzyPowiekszac == false && timerSkala < 0.28f)
				skala -= 0.02f;

			// timerSkala
			// booleanCzyPowiekszac

			if (odejmujaca > 26)
				odejmujaca = 0;
			if (odejmujaca2 > 26)
				odejmujaca2 = 0;
			// if(skala < 1.5f)skala+=0.1f;
			//
			timerLevelText += deltatime;
			if (timerLevelText > 0.01) {
				timerLevelText = 0;
				odejmujaca += 1;
				odejmujaca2 += 1;
				levelTextX -= odejmujaca;
				levelNumberX += odejmujaca2;
			}

			if (levelNumberX > 600) {
				czyNowyLevel = false;
				odejmujaca = 10;
				nieWypisaneKarty = true;
				timerLevel2 = 0;
				if (czyKoniec == false) {
					if (ileCzasu > 0)
						ileCzasu--;
					ileCzasu2--;

					//
				}
				if (ileCzasu == 0)
					czyPrzegrana = true;
			}
		}

		// game.batch.draw(levelText, levelTextX, levelTextY);
		game.batch.setColor(1, (float) ileCzasu / 9, (float) ileCzasu / 9, 1);
		if (ileCzasu2 < 0 == false)
			game.wypiszCzas(game.batch, ileCzasu, levelNumberX,
					levelNumberY + 60, (float) skala, 1f, 1f, 1f, 1);
		game.batch.setColor(1, 1, 1, 1);
	}

	void wypiszLevel() {
		czyDodano = false;

		timerLevel2 += deltatime;
		if (timerLevel2 < 1) {
			timerLevelText += deltatime;
			if (timerLevelText > 0.01) {
				timerLevelText = 0;
				odejmujaca += 1;
				odejmujaca2 += 1;
			}
			if (levelTextX > 140) {
				levelTextX -= odejmujaca;

			}

			if (levelNumberX < 240) {
				levelNumberX += odejmujaca2;
			}
		} else {
			if (odejmujaca > 26)
				odejmujaca = 0;
			if (odejmujaca2 > 26)
				odejmujaca2 = 0;

			timerLevelText += deltatime;
			if (timerLevelText > 0.01) {
				timerLevelText = 0;
				odejmujaca += 1;
				odejmujaca2 += 1;
				levelTextX -= odejmujaca;
				levelNumberX += odejmujaca2;

			}

			if (levelNumberX > 600) {
				czyNowyLevel = false;
				odejmujaca = 10;
				nieWypisaneKarty = true;
				timerLevel2 = 0;
			}
		}

		game.batch.draw(game.regions[11], levelTextX, levelTextY - 185);
		game.wypiszCzas(game.batch, game.numerPoziomu, levelNumberX,
				levelNumberY - 185, 1, 1, 1, 1, 1);

	}
	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

		// game.rainMusic.play(); game.cipher.stop();
		// game.wallpaper.stop();

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

	void spawnBody() {
		
		if (leftSpawnerReady == true) {
			leftSpawnerReady = false;
			rightSpawnerReady = true;
		} else if (rightSpawnerReady == true) {
			rightSpawnerReady = false;
			leftSpawnerReady = true;
		}

		int x = 0;
		
		if (leftSpawnerReady == true) {
			x = posLewySpawnerX + 21;

			game.spawner.setJustSpawned(true);
			game.spawnParticleLeft.setPosition(posLewySpawnerX + 26, 680);
			game.spawnParticleLeft.start();
		}
		if (rightSpawnerReady == true) {
			x = posPrawySpawnerX + 22;

			game.spawner2.setJustSpawned(true);
			game.spawnParticleRight.setPosition(posPrawySpawnerX + 26, 680);
			game.spawnParticleRight.start();
		}
		
		Body body;
		BodyDef bodyDef = new BodyDef();
		
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(x, 670);
		bodyDef.angle = 0 * MathUtils.degreesToRadians;
		body = game.world.createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(20f, 20f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 0.01f;
		body.createFixture(fixtureDef);
		globalX = x;

		body.setAngularVelocity(MathUtils.random(0, 0.1f));
		game.bodies.add(body);

		int type = MathUtils.random(1, 4);
	
		Gem gemini= new Gem(type,x, gems.size + 1, 0);
		gems.add(gemini);

		shape.dispose();
	}

	void takeInput() {
		if (dotkniety == true) {
			timerKlawiatury += deltatime;
			if (timerKlawiatury > 0.15f) {
				dotkniety = false;
				timerKlawiatury = 0;
			}
		}

		if (game.fire.clicked == true)
			game.fire.clicked = !game.fire.clicked;
		if (game.wind.clicked == true)
			game.wind.clicked = !game.wind.clicked;
		if (game.ice.clicked == true)
			game.ice.clicked = !game.ice.clicked;
			
		
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			
			game.camera.unproject(touchPos);

			if (backButton.button_mouse_collision(touchPos.x, touchPos.y) == true) {
				if (ilePunktow > game.prefs.getInteger("highscore")) {
					game.prefs.putInteger("highscore", ilePunktow);
					game.prefs.flush();
				}

				game.prefs.putInteger("ileGemow", game.ileGemow);
				game.prefs.flush();

				backButton.clicked = true;
				czyPrzyciemnij = true;

			} else
				backButton.clicked = false;

			if (game.wind.clicked == false && game.ice.clicked == false
					&& miganieCool == false)
				game.fire.checkCollision((int) touchPos.x, (int) touchPos.y,
						mana);

			if (game.fire.clicked == false && game.ice.clicked == false
					&& miganieCool == false)
				game.wind.checkCollision((int) touchPos.x, (int) touchPos.y,
						mana);

			if (game.wind.clicked == false && game.fire.clicked == false
					&& miganieCool == false)
				game.ice.checkCollision((int) touchPos.x, (int) touchPos.y,
						mana);

			circleX = (int) touchPos.x - 131;
			circleY = (int) touchPos.y - 124;

			if (game.Green.button_mouse_collision(touchPos.x, touchPos.y) == true
					&& dotkniety == false) {
				game.Green.clicked = true;
				for (int a = 0; a < 5; a++) {
					if (tablicaPustych[a] == 0) {
						tablicaPustych[a] = 3;
						break;
					}
				}
				dotkniety = true;
			} else
				game.Green.clicked = false;

			if (game.Red.button_mouse_collision(touchPos.x, touchPos.y) == true
					&& dotkniety == false) {
				game.Red.clicked = true;
				for (int a = 0; a < 5; a++) {
					if (tablicaPustych[a] == 0) {
						tablicaPustych[a] = 2;
						break;
					}
				}
				dotkniety = true;
			} else
				game.Red.clicked = false;

			if (game.Blue.button_mouse_collision(touchPos.x, touchPos.y) == true
					&& dotkniety == false) {
				game.Blue.clicked = true;
				for (int a = 0; a < 5; a++) {
					if (tablicaPustych[a] == 0) {
						tablicaPustych[a] = 1;
						break;
					}
				}
				dotkniety = true;
			} else
				game.Blue.clicked = false;

			if (game.buttonTick.button_mouse_collision(touchPos.x, touchPos.y) == true
					&& dotkniety == false) {
				game.buttonTick.clicked = true;
				for (int a = 0; a < game.ileKart; a++) {
					if (tablicaPustych[a] != tablicaKart[a]) {
						czyPrzegrana = true;

						break;
					}

				}
				for (int a = 0; a < game.ileKart; a++) {
					if ((game.ileKart) < 5 && tablicaPustych[game.ileKart] != 0) {
						czyPrzegrana = true;

					}
				}

				if (czyPrzegrana == false)
					czyWygrana = true;
				// System.out.println(czyPrzegrana);
				dotkniety = true;
				czyKoniec = true;
			} else
				game.buttonTick.clicked = false;

			if (game.buttonCross.button_mouse_collision(touchPos.x, touchPos.y) == true
					&& dotkniety == false) {
				game.buttonCross.clicked = true;
				int ostatnie = 0;
				for (int a = 0; a < 5; a++) {
					if (tablicaPustych[a] != 0) {
						ostatnie = a;
					}

				}
				tablicaPustych[ostatnie] = 0;

				dotkniety = true;
			} else
				game.buttonCross.clicked = false;


		}
		if (Gdx.input.isTouched() == false) {
			backButton.clicked = false;
			game.buttonTick.clicked = false;
			game.buttonCross.clicked = false;
			game.Blue.clicked = false;
			game.Red.clicked = false;
			game.Green.clicked = false;
		}

	}

	void computeBackgroundColor() {
		if (game.kartonator.status != 4)
			status = game.kartonator.status;
		if (status == 2) { // RED
			if (g > 0.5f)
				g -= deltatime;
			if (b > 0.5f)
				b -= deltatime;
			if (r < 1) {
				r += deltatime;

				if (r > 1)
					r = 1;
			}
		}
		if (status == 4) { // RED
			if (r < 1) {
				r += deltatime;

				if (r > 1)
					r = 1;
			}
			if (g < 1) {
				g += deltatime;

				if (g > 1)
					g = 1;
			}
			if (b < 1) {
				b += deltatime;

				if (b > 1)
					b = 1;

			}
		}
		if (status == 3) { // GREEN
			if (r > 0.5f)
				r -= deltatime;
			if (b > 0.5f)
				b -= deltatime;
			if (g < 1) {
				g += deltatime;

				if (g > 1)
					g = 1;
			}
		}
		if (status == 1) { // BLUE
			if (r > 0.5f)
				r -= deltatime;
			if (g > 0.5f)
				g -= deltatime;
			if (b < 1) {
				b += deltatime;

				if (b > 1)
					b = 1;
			}
		}
	}

	/*
	 * void makeTransparentLines(){
	 * 
	 * if(game.migacz.czworeczka == false){ timerKtore += deltatime;
	 * if(timerKtore > 0.01){ timerKtore = 0; ktore+= 5; float r = 0f; for(int
	 * a=324,b = ktore;a>0;a--){ if(b > 0 && tablicaAlfa[a] < 0.3f - r){
	 * tablicaAlfa[a] += 0.005f; } if(tablicaAlfa[a] > 0.3f - r)tablicaAlfa[a] =
	 * 0.3f- r; b--;
	 * 
	 * 
	 * r+= 0.0006f; } r = 0f; for(int a=325,b = ktore;a<750;a++){ if(b > 0 &&
	 * tablicaAlfa[a] < 0.3f- r){ tablicaAlfa[a] += 0.005f; } if(tablicaAlfa[a]
	 * > 0.3f- r)tablicaAlfa[a] = 0.3f- r;; b--; r+= 0.0006f;
	 * 
	 * }
	 * 
	 * ktore2 = 1; } for(int a=0;a<750;a++){
	 * 
	 * game.blackPixel.setScale(135, 1); game.blackPixel.setColor(1, 1, 1,
	 * tablicaAlfa[a]); game.blackPixel.setPosition(228, a+30);
	 * game.blackPixel.draw(game.batch); } } else { timerKtore += deltatime;
	 * if(timerKtore > 0.01){ timerKtore = 0; ktore2+= 5;
	 * 
	 * float r = 0f; for(int a=324,b = ktore2;a>0;a--){ if(b > 0 &&
	 * tablicaAlfa[a] > 0){ tablicaAlfa[a] -= 0.005f; } if(tablicaAlfa[a] < 0.0f
	 * )tablicaAlfa[a] = 0; b--;
	 * 
	 * 
	 * r+= 0.0006f; } r = 0f; for(int a=325,b = ktore2;a<750;a++){ if(b > 0 &&
	 * tablicaAlfa[a] > 0.0f){ tablicaAlfa[a] -= 0.005f; } if(tablicaAlfa[a] <
	 * 0.0f)tablicaAlfa[a] = 0;; b--; r+= 0.0006f;
	 * 
	 * }
	 * 
	 * ktore = 1; } for(int a=0;a<750;a++){
	 * 
	 * game.blackPixel.setScale(135, 1); game.blackPixel.setColor(1, 1, 1,
	 * tablicaAlfa[a]); game.blackPixel.setPosition(228, a+30);
	 * game.blackPixel.draw(game.batch); } }
	 * 
	 * 
	 * // if(game.migacz.czworeczka == true){ timertimer+=deltatime; } else{
	 * timertimer = 0; timerKtorePion += deltatime; if(timerKtorePion > 0.01){
	 * timerKtorePion = 0; ktorePion2+= 5;
	 * 
	 * float r = 0f; for(int a=239,b = ktorePion2;a>0;a--){ if(b > 0 &&
	 * tablicaAlfaPion[a] > 0){ tablicaAlfaPion[a] -= 0.01f; }
	 * if(tablicaAlfaPion[a] < 0 )tablicaAlfaPion[a] = 0; b--;
	 * 
	 * r+= 0.0014f; } r = 0f; for(int a=240,b = ktorePion2;a<480;a++){ if(b > 0
	 * && tablicaAlfaPion[a] > 0){ tablicaAlfaPion[a] -= 0.01f; }
	 * if(tablicaAlfaPion[a] < 0f)tablicaAlfaPion[a] = 0; b--; r+= 0.0014f;
	 * ktorePion1 = 1; }
	 * 
	 * } } if(timertimer > 2.0f) { ktorePion2 = 1; timerKtorePion += deltatime;
	 * if(timerKtorePion > 0.01){ timerKtorePion = 0; ktorePion1+= 5; } float r
	 * = 0f; for(int a=239,b = ktorePion1;a>0;a--){ if(b > 0 &&
	 * tablicaAlfaPion[a] < 0.3f - r){ tablicaAlfaPion[a] += 0.005f; }
	 * if(tablicaAlfaPion[a] > 0.3f - r)tablicaAlfaPion[a] = 0.3f- r; b--;
	 * 
	 * r+= 0.0014f; } r = 0f; for(int a=240,b = ktorePion1;a<480;a++){ if(b > 0
	 * && tablicaAlfaPion[a] < 0.3f- r){ tablicaAlfaPion[a] += 0.005f; }
	 * if(tablicaAlfaPion[a] > 0.3f- r)tablicaAlfaPion[a] = 0.3f- r;; b--; r+=
	 * 0.0014f;
	 * 
	 * } }
	 * 
	 * for(int a=0;a<480;a++){
	 * 
	 * game.blackPixel.setScale(1, 200); game.blackPixel.setColor(1, 1, 1,
	 * tablicaAlfaPion[a]); game.blackPixel.setPosition(a, 442);
	 * game.blackPixel.draw(game.batch);
	 * 
	 * game.blackPixel.setScale(1, 120); game.blackPixel.setColor(1, 1, 1,
	 * tablicaAlfaPion[a]); game.blackPixel.setPosition(a, 225);
	 * game.blackPixel.draw(game.batch);
	 * 
	 * } }
	 */
	void computePhysics() {
		iterGems = gems.iterator();
		iterBodies = game.bodies.iterator();
		//
		while (iterBodies.hasNext() && iterGems.hasNext()) {
			body2 = iterBodies.next();
			gemini2 = iterGems.next();
			if (gemini2.Y < laserPosY) {
				gemini2.isDead = true;
				if (game.wibracje == true)
					Gdx.input.vibrate(10);

			}
			if (iceClicked == true)
				gemini2.isFrozen = true;
			else
				gemini2.isFrozen = false;

			if (gemini2.timerDispose >= 0.5f) {

				if (gemini2.getGemType() == 4) {
					if (koniecGry == false) {
						game.ileGemow++;
						zebraneGemy++;
					}
				}
				game.world.destroyBody(body2);
				iterBodies.remove();
				iterGems.remove();

				ilePunktowBufor += 1 * ileCombo;
			}

			if (gemini2.Y > 780) {
				koniecGry = true;
			}
			//

		}

	}

	void drawPhysics(float delta) {

		iterGems = gems.iterator();
		iterBodies = game.bodies.iterator();
		if (gems.size == 0) {
			czyZielony = true;
			czyCzerwony = false;
			czyZolty = false;
		}

		while (iterBodies.hasNext() && iterGems.hasNext()) {
			body2 = iterBodies.next();
			gemini2 = iterGems.next();
			if (gemini2.spawn == true) {
				gemini2.spawn = false;
				body2.setTransform(globalX, 670, 0);
				body2.setLinearVelocity(0, -9000);

			}
			if (gemini2.isDead == true) {

				game.currentFrameSprite = new Sprite(
						game.walkAnimation.getKeyFrame(gemini2.stateTime, true));
				// game.currentFrameSprite.setScale(2);

			}
			posXg = (int) body2.getPosition().x;
			posYg = (int) body2.getPosition().y;
			angleg = body2.getAngle();

			gemini2.rotation = angleg;
			gemini2.X = posXg;
			gemini2.Y = posYg;
			if (gemini2.type == 1) {
				game.gem1.setPosition(posXg, posYg);
				game.gem1.setAlpha((float) (1 - gemini2.timerDispose * 2));
				game.gem1.setRotation(angleg * MathUtils.radiansToDegrees);
				game.gem1.draw(game.batch);
			}
			if (gemini2.type == 2) {
				game.gem2.setPosition(posXg, posYg);
				game.gem2.setAlpha((float) (1 - gemini2.timerDispose * 2));
				game.gem2.setRotation(angleg * MathUtils.radiansToDegrees);
				game.gem2.draw(game.batch);
			}
			if (gemini2.type == 3) {
				game.gem3.setPosition(posXg, posYg);
				game.gem3.setAlpha((float) (1 - gemini2.timerDispose * 2));
				game.gem3.setRotation(angleg * MathUtils.radiansToDegrees);
				game.gem3.draw(game.batch);
			}
			if (gemini2.type == 4) {
				game.gem4.setPosition(posXg, posYg);
				game.gem4.setAlpha((float) (1 - gemini2.timerDispose * 2));
				game.gem4.setRotation(angleg * MathUtils.radiansToDegrees);
				game.gem4.draw(game.batch);
			}
			if (gemini2.isFrozen == true) {

				game.gemFrozen.setPosition(posXg, posYg);
				game.gemFrozen.setAlpha((float) (1 - gemini2.timerDispose * 2));
				game.gemFrozen.setRotation(angleg * MathUtils.radiansToDegrees);
				game.gemFrozen.draw(game.batch);
			}

			// gemini2.draw(game.batch, delta);

			if (gemini2.isFrozen == false)
				gemini2.isFreezeParticleActive = false;

			if (gemini2.isDead == true) {
				//
				if (gemini2.particleStart == false && czyZniszczone == false) {
					gemini2.destroyParticle.start();
					gemini2.particleStart = true;

				}
				if (gemini2.particleStart == true) {
					gemini2.destroyParticle.setPosition(gemini2.X, gemini2.Y);
					gemini2.destroyParticle.draw(game.batch, delta);
				}
				//
				gemini2.stateTime += deltatime; // #15

				game.currentFrameSprite.setPosition(gemini2.X - 30,
						gemini2.Y + 46);
				game.currentFrameSprite.draw(game.batch);

				gemini2.timerDispose += deltatime;
				// gemini2.jedynka.setPosition(gemini2.X , gemini2.Y + 46 +
				// gemini2.dodawacz);
				// gemini2.dodawacz+=4;
				// gemini2.jedynka.setAlpha(1-(stateTime*1.75f));
				// gemini2.jedynka.draw(game.batch);
			}
			if (gemini2.timerDispose > 0.5) {
				gemini2.timerDispose = 0.5;
			}

			if (gemini2.isFrozen == true) {
				//
				if (gemini2.isFreezeParticleActive == false) {
					gemini2.freezeParticle.start();
					gemini2.isFreezeParticleActive = true;
				}
				if (gemini2.isFreezeParticleActive == true) {
					gemini2.freezeParticle.setPosition(gemini2.X, gemini2.Y);
					gemini2.freezeParticle.draw(game.batch, delta);
				}

			}

			if (gemini2.Y < laserPosY) {
				gemini2.isDead = true;
				if (game.wibracje == true)
					Gdx.input.vibrate(10);

			}
			if (iceClicked == true)
				gemini2.isFrozen = true;
			else
				gemini2.isFrozen = false;

			if (gemini2.timerDispose >= 0.5f) {

				if (gemini2.getGemType() == 4) {
					if (koniecGry == false) {
						game.ileGemow++;
						zebraneGemy++;
					}
				}

				game.world.destroyBody(body2);
				gemini2.dispose();
				iterBodies.remove();
				iterGems.remove();

				if (koniecGry == false)
					ilePunktowBufor += 1;
			}

			if (posYg <= 300 && gemini2.ostatniaPozycjaY == posYg) {

				czyZolty = false;
				czyZielony = true;
				czyCzerwony = false;

			}
			if (posYg > 300 && posYg < 420 && gemini2.ostatniaPozycjaY == posYg) {

				czyZolty = true;
				czyZielony = false;
				czyCzerwony = false;

			}
			if (posYg > 420 && gemini2.ostatniaPozycjaY == posYg) {

				czyZolty = false;
				czyZielony = false;
				czyCzerwony = true;

			}

			if (posYg > 565 && gemini2.ostatniaPozycjaY == posYg
					&& czyBlue == false && timerPoczatkowy > 8
					&& game.wind.loadingAbilityTime > 56) {
				koniecGry = true;

				// game.setScreen(new EndScreen(game));
				if (czyZniszczone == false)
					zniszczGemy();
			} else
				gemini2.ostatniaPozycjaY = posYg;
			//

		}

	}

	void drawBackground() {
		// timerBlue2
		// czyBlue
		if (czyBlue == true)
			timerBlue2 += deltatime;
		if (timerBlue2 > 1.1f)
			czyBlue = false;
		if (czyBlue == false)
			timerBlue2 -= deltatime;
		if (timerBlue2 < 0)
			timerBlue2 = 0;

		// game.batch.setColor((float)r,(float)g,(float)b,1f);
		// game.batch.draw(game.screen,game.a,0);
		// game.batch.draw(game.screen,game.b,0);
		// game.batch.setColor(1,(float)timerGreen,(float)timerBlue,1f);
		// game.batch.setColor(0.6f,0.6f,1,1);
		timerBcg += deltatime;
		if (timerBcg > 0.02) {
			for (int a = 0; a < 14; a++) {
				pozycjeBackground[a] -= 2;

			}
		}
		for (int a = 1; a < 15; a++) {
			if (pozycjeBackground[a - 1] > -40
					&& pozycjeBackground[a - 1] < 480) {
				if (a % 2 == 0) {

					game.batch.setColor(1, (float) timerGreen,
							(float) timerBlue, 1f);

					game.batch.draw(game.regions[0], pozycjeBackground[a - 1],
							0);
					if (timerBlue2 > 0.70f)
						game.batch.setColor(1, 1, 1, 0.70f);
					else
						game.batch.setColor(1, 1, 1, (float) timerBlue2);

					game.batch.draw(game.darkBlue, pozycjeBackground[a - 1], 0);
					// game.batch.setColor(1, 1, 1, 1);
					// game.batch.draw(game.red1T,pozycjeBackground[a-1],545);
					if (timerOrange > 0) {
						game.batch.setColor(1, 1, 1, (float) timerOrange);
						game.batch.draw(game.lightOrange,
								pozycjeBackground[a - 1], 0);
						// game.batch.setColor(1,1,1,1);
					}
				} else {

					game.batch.setColor(1, (float) timerGreen,
							(float) timerBlue, 1f);

					game.batch.draw(game.regions[1], pozycjeBackground[a - 1],
							0);
					if (timerBlue2 > 0.70f)
						game.batch.setColor(1, 1, 1, 0.70f);
					else
						game.batch.setColor(1, 1, 1, (float) timerBlue2);
					game.batch.draw(game.darkBlue, pozycjeBackground[a - 1], 0);

					game.batch
							.setColor((float) zmiennaCzerwony,
									(float) zmiennaZielony,
									(float) zmiennaNiebieski, 1);
					game.batch.draw(game.regions[2], pozycjeBackground[a - 1],
							555);

					// game.batch.setColor(1, 1, 1, 1);
					if (timerOrange > 0) {
						game.batch.setColor(1, 1, 1, (float) timerOrange);
						game.batch.draw(game.darkOrange,
								pozycjeBackground[a - 1], 0);
						// game.batch.setColor(1, 1, 1, 1);
					}
				}
			}
		}
		if (pozycjeBackground[0] == -78) {
			for (int a = 0, b = 0; a < 560; a++) {
				pozycjeBackground[b] = a;
				b++;
				a += 39;
			}
		}
		// game.bw.draw(game.batch);
		// game.spriteLogoBackground.draw(game.batch);
		// game.logo.draw(game.batch);
		if (timerWind > 0) {
			timerWind -= Gdx.graphics.getDeltaTime();
			if (timerWind < 0)
				timerWind = 0;
			if (timerOrange < 1)
				timerOrange += Gdx.graphics.getDeltaTime();
			if (timerOrange > 1)
				timerOrange = 1;

		} else if (timerOrange > 0) {
			//

			//
			timerOrange -= Gdx.graphics.getDeltaTime();
			if (timerOrange < 0)
				timerOrange = 0;
		}
		game.batch.setColor(1, 1, 1, 1);
	}

	void przeliczPunkty() {

		if (ilePunktowBufor > 0) {
			ilePunktow += pomPunkty;
			ilePunktowBufor -= pomPunkty;
			pomPunkty = 1;
		}

		if (ilePunktowBufor < 0)
			ilePunktowBufor = 0;

		//

		if (ilePunktowBufor2 > 0 && pojedyncze == false) {
			ilePunktow2 += 5;
			ilePunktowBufor2 -= 5;
		}
		if (ilePunktowBufor2 < 0) {
			ilePunktowBufor2 *= -1;
			// ilePunktow2 -= ilePunktowBufor2;
			// ilePunktowBufor2 = 0;
			pojedyncze = true;
		}
		if (pojedyncze == true && ilePunktowBufor2 > 0) {
			ilePunktow2++;
			ilePunktowBufor2--;
		}
		pomPunkty = 1;

		if (ilePunktowBufor < 0)
			ilePunktowBufor = 0;

	}

	void drawLasers() {
		
		laserLeft.draw(game.batch);
		laserRight.draw(game.batch);
		/*
		stateTime += deltatime; // #15
		currentFrameSprite = new Sprite(game.walkAnimation.getKeyFrame(
				stateTime, true));
		currentFrameSprite.setColor(Color.RED);
		currentFrameSprite.setPosition(50, laserPosY - 65);
		currentFrameSprite.setRotation(90);
		currentFrameSprite.draw(game.batch);
		currentFrameSprite.setPosition(450 - 120, laserPosY - 65);
		currentFrameSprite.setRotation(270);
		currentFrameSprite.draw(game.batch);

		game.laserMachineSprite.setRotation(0);
		game.laserMachineSprite.setPosition(0, laserPosY);
		game.laserMachineSprite.draw(game.batch);
		game.laserMachineSprite.setRotation(180);
		game.laserMachineSprite.setPosition(410, laserPosY);
		game.laserMachineSprite.draw(game.batch);
		
		laserTimer += deltatime;
		if (laserTimer > 0.01) {
			laserTimer = 0;
			laserPosY += zwiekszajacaLasers;
			zwiekszajacaLasers += 0.1;
		}
		*/

	}

	public void setRedColour() {
		if (czyRed == true) {
			timerRed += deltatime;
			if (timerRed > 1.25f) {
				czyRed = false;
				timerRed = 0;
			}
			if (timerGreen > 0)
				timerGreen -= deltatime;
			if (timerGreen < 0)
				timerGreen += deltatime;
			if (timerBlue > 0)
				timerBlue -= deltatime;
			if (timerBlue < 0)
				timerBlue += deltatime;
		} else {
			if (timerGreen < 1)
				timerGreen += deltatime;
			if (timerGreen > 1)
				timerGreen = 1;
			if (timerBlue < 1)
				timerBlue += deltatime;
			if (timerBlue > 1)
				timerBlue = 1;

		}
	}

	public void setZoom() {
		timerZoom += deltatime;
		timerZoomRandom += deltatime;

		if (czyShake == true) {
			if (timerZoomRandom > 0.05f) {
				timerZoomRandom = 0;
				randomZoom = MathUtils.random(0.955f, 1);
			}
			if (timerZoom > 0.01) {
				timerZoom = 0;
				if (scaleZoom > randomZoom) {
					scaleZoom -= 0.003;
				}
				if (scaleZoom < randomZoom) {
					scaleZoom += 0.003;
				}
				if (rotatecamera == true) {
					game.camera.rotate(-1);
					rotatecamera = false;
				} else if (rotatecamera == false) {
					game.camera.rotate(1);
					rotatecamera = true;
				}
			}
			game.camera.zoom = (float) scaleZoom;
			konieckoniec = true;
			// game.camera.update();
		} else {
			if (timerZoom > 0.05) {
				if (scaleZoom < 1)
					scaleZoom += 0.003;
				timerZoom = 0;
			}
			game.camera.zoom = (float) scaleZoom;
			if (konieckoniec == true) {
				if (rotatecamera == true)
					game.camera.rotate(-1);
				// else game.camera.rotate(1);
				konieckoniec = false;

				rotatecamera = false;
			}
		}

		game.camera.update();
		// if(koniecGry == true){
		// if(timerZoomKoniec 0.5) timerZoomKoniec -= deltatime;
		// game.camera.zoom = (float)timerZoomKoniec;
		// game.camera.update();/
		// }

	}

	public void zniszczGemy() {

		iterGems = gems.iterator();
		iterBodies = game.bodies.iterator();
		//
		while (iterBodies.hasNext() && iterGems.hasNext()) {
			body2 = iterBodies.next();
			gemini2 = iterGems.next();

			gemini2.isDead = true;
		}

		czyZniszczone = true;
	}

	//
	public void wypiszRandomTekst() {
		// public double skalaRandomTekst = 5;
		// public double alfaRandomTekst = 0 ;
		// public boolean czyZmniejszacRandomTekst = false;
		// stopPOW
		// timerPOW
		if (czyNowyTekst == true) {
			czyNowyTekst = false;
			wyborTekstu = MathUtils.random(1, 4);
			alfaRandomTekst = 0;
			stopPOW = false;
			timerPOW = 0;
			skalaRandomTekst = 5;
		}
		if (skalaRandomTekst <= 1f && timerPOW == 0)
			stopPOW = true;
		if (stopPOW == true) {
			timerPOW += deltatime;
		}
		if (timerPOW > 1)
			stopPOW = false;

		if (skalaRandomTekst > 0 && stopPOW == false)
			skalaRandomTekst -= 5 * deltatime;
		if (skalaRandomTekst < 0)
			skalaRandomTekst = 0;
		if (alfaRandomTekst < 1)
			alfaRandomTekst += deltatime;
		if (alfaRandomTekst > 1)
			alfaRandomTekst = 1;
		// System.out.println(alfaRandomTekst);
		// System.out.println(skalaRandomTekst);

		if (alfaRandomTekst != 0 && skalaRandomTekst != 0) {
			// System.out.println("asd");
			if (wyborTekstu == 1) {
				game.amazingSprite.setAlpha((float) alfaRandomTekst);
				game.amazingSprite.setScale((float) skalaRandomTekst);
				game.amazingSprite.setPosition(10, 580);
				game.amazingSprite.draw(game.batch);
			}
			if (wyborTekstu == 2) {
				game.niceSprite.setAlpha((float) alfaRandomTekst);
				game.niceSprite.setScale((float) skalaRandomTekst);
				game.niceSprite.setPosition(100, 580);
				game.niceSprite.draw(game.batch);
			}
			if (wyborTekstu == 3) {
				game.greatSprite.setAlpha((float) alfaRandomTekst);
				game.greatSprite.setScale((float) skalaRandomTekst);
				game.greatSprite.setPosition(70, 580);
				game.greatSprite.draw(game.batch);
			}
			if (wyborTekstu == 4) {
				game.lovelySprite.setAlpha((float) alfaRandomTekst);
				game.lovelySprite.setScale((float) skalaRandomTekst);
				game.lovelySprite.setPosition(60, 580);
				game.lovelySprite.draw(game.batch);
			}
		}
	}
	//
}
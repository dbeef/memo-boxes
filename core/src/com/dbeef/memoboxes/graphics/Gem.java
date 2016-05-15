package com.dbeef.memoboxes.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

public class Gem {

	public ParticleEffect destroyParticle;
	public ParticleEffect freezeParticle;

	public boolean isFreezeParticleActive = false;
	public int type;
	public boolean spawn = true;
	public boolean particleStart = false;

	public boolean isFrozen = false;
	public boolean destroyed = false;

	public double destroyTimer = 0;

	public double timerDispose = 0;
	public boolean isDead = false;

	public float stateTime;

	public int X;
	public int Y = 670;
	public int ostatniaPozycjaY;

	int gemNumber;

	public float rotation;

	public Gem() {
	};

	public Gem(int t, int posX, int number, float rot) {

		type = t;

		freezeParticle = new ParticleEffect();
		destroyParticle = new ParticleEffect();

		if (type != 4) {
			destroyParticle.load(Gdx.files.internal("coins"),
					Gdx.files.internal(""));
		} else {
			destroyParticle.load(Gdx.files.internal("gemene"),
					Gdx.files.internal(""));

		}
		destroyParticle.allowCompletion();

		freezeParticle = new ParticleEffect();
		freezeParticle.load(Gdx.files.internal("gemRedEffect"),
				Gdx.files.internal(""));
		freezeParticle.allowCompletion();

		ostatniaPozycjaY = 669;
		X = posX;
		gemNumber = number;
		rotation = rot;

		stateTime = 0f;

	}

	public void takeCharacteristics(int posX, int posY, int number, float rot) {
		ostatniaPozycjaY = posY - 1;
		X = posX;
		Y = posY;
		gemNumber = number;
		rotation = rot;

		stateTime = 0f;
	}

	public int getGemType() {
		return type;
	}

	public void dispose() {
	}
}
package com.dbeef.memoboxes.sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Jukebox {

	// Slider X position (displayed on SettingsScreen)
	// 215 max for sound
	// 57 min for sound
	// 437 max for music
	// 279 min for music

	static int maxSliderPositionSound = 215;
	static int maxSliderPositionMusic = 437;

	static int minSliderPositionSound = 57;
	static int minSliderPositionMusic = 279;

	Sound click;
	Music mainTheme;

	boolean justClicked = false;
	float musicVolume;
	float soundsVolume;
	long id;
	float timeFromLastClick = 0;

	public Jukebox(float mV, float sV, Sound c, Music mT) {
		click = c;
		musicVolume = mV - 57;
		soundsVolume = sV - 57;
		mainTheme = mT;
		mainTheme.setLooping(true);
	}

	public void updateTimers() {
		if (justClicked == true) {
			timeFromLastClick += Gdx.graphics.getDeltaTime();
		}
		if (timeFromLastClick > 0.3f) {
			timeFromLastClick = 0;
			justClicked = false;
		}
	}

	public void playClick() {
		if (justClicked == false) {
			click.play(soundsVolume / maxSliderPositionSound);
			justClicked = true;
		}
	}

	public void changeVolume(float mV, float sV) {
		musicVolume = mV - minSliderPositionMusic;
		soundsVolume = sV - minSliderPositionSound;
		mainTheme.setVolume(musicVolume / maxSliderPositionMusic);
	}

	public void playMusic() {
		mainTheme.setVolume(musicVolume / maxSliderPositionMusic);
		mainTheme.play();
	}
}
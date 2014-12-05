package com.morgenmiddag.planes;

import com.badlogic.gdx.Game;
import com.morgenmiddag.planes.screens.GameScreen;

public class PlaneGame extends Game {
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}

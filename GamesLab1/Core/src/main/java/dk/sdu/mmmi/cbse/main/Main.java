package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
	
	public static void main(String[] args) {

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Asteroids");
		config.setWindowSizeLimits(1000,500,1000,400);

		new Lwjgl3Application(new Game(), config);
	}
	
}

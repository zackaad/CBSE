package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve the required services from the Spring container
		IEntityProcessingService entityProcessingService = context.getBean(IEntityProcessingService.class);
		IGamePluginService gamePluginService = context.getBean(IGamePluginService.class);

		// Set up the game configuration
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Asteroids");
		config.setWindowSizeLimits(1000, 500, 1000, 400);

		// Instantiate the Game class with the required services injected
		Game game = new Game(entityProcessingService, gamePluginService);

		// Start the game
		new Lwjgl3Application(game, config);
	}

}
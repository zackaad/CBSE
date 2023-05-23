package main;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.main.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    IEntityProcessingService entityProcessingService;
    IGamePluginService gamePluginService;
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");




    @Test
    public void testGameInitialization() {
        // Retrieve the required services from the Spring container
        entityProcessingService = (IEntityProcessingService) context.getBean("entityProcessor", IEntityProcessingService.class);
        gamePluginService = (IGamePluginService) context.getBean("gamePlugin", IGamePluginService.class);


        Game g = new Game(entityProcessingService, gamePluginService);
        assertNotNull(g);
    }
}
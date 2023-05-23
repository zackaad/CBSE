package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public class EntityProcessingServiceImpl implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        // Iterate over the entities in the world
        for (Entity entity : world.getEntities()) {
            System.out.println(entity.getID());

            // Example: Perform any other relevant processing for the entity

            // ...
        }

    }
}
package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public class GamePluginServiceImpl implements IGamePluginService{
    @Override
    public void start(GameData gameData, World world) {
        System.out.println("Game started!");
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity entity: world.getEntities()){
            world.removeEntity(entity);
        }
        System.out.println("Game stopped");
    }
}

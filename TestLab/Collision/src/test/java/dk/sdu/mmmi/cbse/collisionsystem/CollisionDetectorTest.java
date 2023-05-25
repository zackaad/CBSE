package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author jcs
 */
class CollisionDetectorTest {
    private CollisionDetector collisionDetector;
    @BeforeEach
    void setUp() {
        collisionDetector = new CollisionDetector();
    }
    @Test
    public void testEntitiesCollide() {

        //Position of entity
        Entity entity1 = createEntity(0.0f, 0.0f, 10.0f, 5);
        Entity entity2 = createEntity(5.0f, 5.0f, 8.0f, 5);

        //Mock data
        World world = mock(World.class);
        GameData gameData = mock(GameData.class);


        world.addEntity(entity1);
        world.addEntity(entity2);

        //Process data
        collisionDetector.process(gameData, world);

        //Returns true if entities collide
        assertTrue(collisionDetector.collides(entity1,entity2));

    }

    private Entity createEntity(float x, float y, float radians, float radius) {
        Entity entity = new Entity();
        entity.add(new PositionPart(x, y, radians));
        entity.setRadius(radius);
        entity.add(new LifePart(1));
        return entity;

    }
}
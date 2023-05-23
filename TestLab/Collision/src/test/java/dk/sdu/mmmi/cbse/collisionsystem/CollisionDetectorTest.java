package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.EntityPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CollisionDetectorTest {
    // Create mock entities
    Entity e1 = mock(Entity.class);
    Entity e2 = mock(Entity.class);

    // Create mock PositionPart instances
    PositionPart positionPart1 = mock(PositionPart.class);
    PositionPart positionPart2 = mock(PositionPart.class);

    LifePart lifePart1 = mock(LifePart.class);
    LifePart lifePart2 = mock(LifePart.class);


    GameData gameData = mock(GameData.class);
    World world = mock(World.class);


    @Test
    public void testCollisionDetection() {

        // Create an instance of CollisionDetection
        CollisionDetector collisionDetector = new CollisionDetector();



        when(lifePart2.getLife()).thenReturn(1);
        when(lifePart1.getLife()).thenReturn(1);

        // Set up the behavior of the mocked entities
        when(e1.getPart(PositionPart.class)).thenReturn(positionPart1);
        when(e2.getPart(PositionPart.class)).thenReturn(positionPart2);
        when(e1.getID()).thenReturn("Player");
        when(e2.getID()).thenReturn("Enemy");

        when(e1.getRadius()).thenReturn(10.0f);
        when(e1.getRadius()).thenReturn(8.0f);


        // Set up the behavior of the mocked PositionPart instances
        when(positionPart1.getX()).thenReturn(0.0f);
        when(positionPart1.getY()).thenReturn(0.0f);
        when(positionPart1.getRadians()).thenReturn(10.0f);



        when(positionPart2.getX()).thenReturn(5.0f);
        when(positionPart2.getY()).thenReturn(5.0f);
        when(positionPart2.getRadians()).thenReturn(8.0f);





        //Creates world and gamedata

        world.addEntity(e1);
        world.addEntity(e2);
        collisionDetector.process(gameData, world);


        collisionDetector.collides(e1,e2);

        int i = lifePart1.getLife();
        int i2 = lifePart2.getLife();

        assertTrue(collisionDetector.collides(e1,e2));

    }
}
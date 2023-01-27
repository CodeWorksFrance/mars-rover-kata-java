package com.technologyconversations.kata.marsrover;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Chars;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverTest {

    @Property
    boolean shouldVerifyThatDoingTwiceTheCmdIsDoingTheCmdTwice(@ForAll @Chars(value = {'F', 'B', 'L', 'R'}) String command) throws Exception {
        Point x = new Point(1, 9);
        Point y = new Point(2, 9);
        List<Obstacle> obstacles = new ArrayList<>();

        Coordinates roverCoordinates = new Coordinates(x, y, Direction.NORTH, obstacles);
        Rover rover = new Rover(roverCoordinates);

        Rover roverBis = new Rover(roverCoordinates);

        rover.receiveCommands(command);
        rover.receiveCommands(command);
        roverBis.receiveCommands(command+command);

        return roverBis.getCoordinates().equals(rover.getCoordinates()) ;
    }



}

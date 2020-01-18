REA Group Toy Robot Simulator

SETUP INSTRUCTIONS:

    1. Install JDK 1.8, maven, and setup environment variables on your machine.

    2. In a command line / terminal, change the directory to the root folder of the application (toy-robot).

        cd toy-robot

    3. Run maven to compile the source, run the unit tests, and package the application into a jar file.

        mvn install

    4. After the successful build process, the executable jar file is created in the target folder.

    5. Run the application using the following command:

        java -jar target/ToyRobotSimulator-1.0.jar


The developer has chosen standard input as input. Some test data/input are saved in the file toy-robot/test-input/TestInput1





DESIGN AND APPROACH

ApplicationMain is the entry point to run the application and runs the main class of the simulator - the ToyRobotSimulator class.

ToyRobotSimulator

The ToyRobotSimulator class is the main class of the simulator. It starts the actual simulation and calls the CommandManager. The startSimulation() method is where the application asks the user input for commands. The CommandManager is assigned for this task of reading the user's input, validation and execution of the commands.

TableMap

For the table, each table square is assigned to have a specific x and y index. The first square block, which is located at the south west most part of the table, has an x index of 0 and a y index of 0. The y index increases as you move to the next square up. Likewise, the x index also increases as you move to the right.

Here is an example of the x and y index coordinates for a table with 5 rows and 5 columns:

[0,4], [1,4], [2,4], [3,4], [4,4],

[0,3], [1,3], [2,3], [3,3], [4,3],

[0,2], [1,2], [2,2], [3,2], [4,2],

[0,1], [1,1], [2,1], [3,1], [4,1],

[0,0], [1,0], [2,0], [3,0], [4,0]

The coordinates are stored in a HashMap with the x index and y index as key. Any key not found in the HashMap is considered out of the boundaries of the table.

ToyRobot

The ToyRobot class represents the robot that moves around the table. It has x and y index fields to determine the current location of the toy robot on the table, and also a direction field to determine where it is currently facing. The ToyRobot class also has methods to turn left, turn right, and move its coordinates on the table.

Command / CommandFactory
The CommandFactory is used to create instances of either a LeftCommand, RightCommand, MoveCommand, PlaceCommand, ReportCommand, and QuitCommand.

Exceptions

There are two exceptions created for the application to handle errors encountered during the simulation: AttemptToNavigateBeyondBoundaryException, and FactoryException.

The exceptions AttemptToNavigateBeyondBoundaryException is thrown whenever the user has tried to go beyond the table.

The FactoryException on the other hand, is thrown whenever an error is encountered during instantiation of a Command. An example of when the FactoryException might be thrown is when the user input entered an invalid command or parameter.


package test.com.reagroup.app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.com.reagroup.app.model.ToyRobotTest;
import test.com.reagroup.app.factory.FactoryProviderTest;
import test.com.reagroup.app.model.DirectionTest;
import test.com.reagroup.app.model.command.RightCommandTest;
import test.com.reagroup.app.model.command.LeftCommandTest;
import test.com.reagroup.app.model.command.QuitCommandTest;
import test.com.reagroup.app.model.command.MoveCommandTest;
import test.com.reagroup.app.model.command.PlaceCommandTest;
import test.com.reagroup.app.model.command.CommandFactoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    FactoryProviderTest.class,
    ToyRobotTest.class,
    DirectionTest.class,
    MoveCommandTest.class,
    PlaceCommandTest.class,
    LeftCommandTest.class,
    RightCommandTest.class,
    QuitCommandTest.class,
    CommandFactoryTest.class
})

public class AllTests {

}

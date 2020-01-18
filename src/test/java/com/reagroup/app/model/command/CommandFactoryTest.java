package test.com.reagroup.app.model.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.reagroup.app.exception.FactoryException;
import com.reagroup.app.model.command.MoveCommand;
import com.reagroup.app.model.command.CommandFactory;
import com.reagroup.app.model.command.LeftCommand;
import com.reagroup.app.model.command.QuitCommand;
import com.reagroup.app.model.command.RightCommand;
import com.reagroup.app.model.command.PlaceCommand;
import com.reagroup.app.model.command.ReportCommand;

public class CommandFactoryTest {

    private CommandFactory commandFactory = null;

    @Before
    public void initialize() {
        commandFactory = new CommandFactory();
    }

    @Test
    public void testCreateMethod_whenCommandIsValid() throws FactoryException {
        Object returnObject1 = commandFactory.create("move");
        Object returnObject2 = commandFactory.create("left");
        Object returnObject3 = commandFactory.create("right");
        Object returnObject4 = commandFactory.create("quit");
        Object returnObject5 = commandFactory.create("report");
        Object returnObject6 = commandFactory.create(new String[]{"place", "1,1,south"});

        assertTrue("testCreateMethod_whenCommandIsValid", returnObject1 instanceof MoveCommand);
        assertTrue("testCreateMethod_whenCommandIsValid", returnObject2 instanceof LeftCommand);
        assertTrue("testCreateMethod_whenCommandIsValid", returnObject3 instanceof RightCommand);
        assertTrue("testCreateMethod_whenCommandIsValid", returnObject4 instanceof QuitCommand);
        assertTrue("testCreateMethod_whenCommandIsValid", returnObject5 instanceof ReportCommand);
        assertTrue("testCreateMethod_whenCommandIsValid", returnObject6 instanceof PlaceCommand);
    }

    @Test(expected = FactoryException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasNoCountParam() throws FactoryException {
        commandFactory.create("place");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasInvalidCountParam() throws FactoryException {
        commandFactory.create(new String[]{"place", "1"});
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasNullCountParam() throws FactoryException {
        commandFactory.create(new String[]{"place", ",,"});
    }

    @Test(expected = FactoryException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasNegativeParam() throws FactoryException {
        commandFactory.create(new String[]{"place", "-1"});
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasZeroAsParam() throws FactoryException {
        commandFactory.create(new String[]{"place", "0"});
    }

    @Test(expected = FactoryException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasInvalidIndexParam() throws FactoryException {
        commandFactory.create(new String[]{"place", "a,b,south"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasInvalidDirectionParam() throws FactoryException {
        commandFactory.create(new String[]{"place", "1,2,soth"});
    }

    @Test(expected = FactoryException.class)
    public void testCreateMethod_whenCommandIsInvalid_PlaceHasIndexOutOfBoundsParam() throws FactoryException {
        commandFactory.create(new String[]{"place", "5,5,north"});
    }

    @Test(expected = FactoryException.class)
    public void testCreateMethod_whenCommandIsInvalid() throws FactoryException {
        String invalidCommandType = "X";
        commandFactory.create(invalidCommandType);
    }

    @Test
    public void validatePlaceParameterCount_whenLengthIsValid() throws FactoryException {
        String[] parameter = {"Y", "Z"};
        commandFactory.validatePlaceParameterCount(parameter);
    }

    @Test(expected = FactoryException.class)
    public void validatePlaceParameterCount_whenLengthIsLessThanTwo() throws FactoryException {
        String[] parameter = {"Z"};
        commandFactory.validatePlaceParameterCount(parameter);
    }

    @Test(expected = FactoryException.class)
    public void validatePlaceParameterCount_whenLengthIsMoreThanTwo() throws FactoryException {
        String[] parameter = {"X", "Y", "Z"};
        commandFactory.validatePlaceParameterCount(parameter);
    }

    @Test
    public void parseIndexParameter_whenParameterIsValid_MinimumPlaceParameter() throws Exception {
        String parameter = "0";
        int expected = 0;
        int actual = commandFactory.parseIndexParameter(parameter);
        assertEquals("parseIndexParameter_whenParameterIsValid_MinimumPlaceParameter", expected, actual);
    }

    @Test
    public void parseIndexParameter_whenParameterIsValid_RandomNumber() throws Exception {
        String parameter = "3";
        int expected = 3;
        int actual = commandFactory.parseIndexParameter(parameter);
        assertEquals("parseIndexParameter_whenParameterIsValid", expected, actual);
    }

    @Test(expected = FactoryException.class)
    public void parseIndexParameter_whenParameterIsNegative() throws Exception {
        String parameter = "-1";
        commandFactory.parseIndexParameter(parameter);
    }

    @Test(expected = FactoryException.class)
    public void parseIndexParameter_whenNumberFormatExceptionOccurred() throws Exception {
        String parameter = "s";
        commandFactory.parseIndexParameter(parameter);
    }

    @Test(expected = FactoryException.class)
    public void parseIndexParameter_whenParameterIsEmpty() throws Exception {
        String parameter = " ";
        commandFactory.parseIndexParameter(parameter);
    }

    @Test(expected = FactoryException.class)
    public void parseIndexParameter_whenParameterIsNull() throws Exception {
        String parameter = null;
        commandFactory.parseIndexParameter(parameter);
    }

    @Test(expected = FactoryException.class)
    public void parseIndexParameter_whenParameterIsInvalid() throws Exception {
        String parameter = "     4";
        commandFactory.parseIndexParameter(parameter);
    }
}

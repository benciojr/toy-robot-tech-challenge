package test.com.reagroup.app.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.reagroup.app.factory.FactoryProvider;
import com.reagroup.app.model.command.CommandFactory;

public class FactoryProviderTest {

    @Test
    public void testGetFactoryMethod_whenChoiceIsInvalid() {
        String invalidChoice = "InvalidChoice";
        Object actualObject2 = FactoryProvider.getFactory(invalidChoice);
        assertEquals("The getFactory() method returned null", null, actualObject2);
    }

    @Test
    public void testGetFactoryMethod_whenReturnIsACommandFactory() {
        String choice = "Command";
        Object actualObject1 = FactoryProvider.getFactory(choice);
        assertEquals("The returned object is an instance of CommandFactory", true, actualObject1 instanceof CommandFactory);
    }
}

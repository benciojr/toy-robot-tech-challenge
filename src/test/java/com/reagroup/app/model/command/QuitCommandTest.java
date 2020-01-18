package test.com.reagroup.app.model.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.reagroup.app.model.command.QuitCommand;

public class QuitCommandTest {
    private QuitCommand quit = null;

    @Before
    public void initialize() {
        quit = new QuitCommand();
    }

}

package command;

import command.desccription.Command;
import command.desccription.CommandDescription;
import command.desccription.Option;
import command.parser.CommandHandler;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by dznor on 13.03.2017.
 */
public class CommandHandlerTest {
    @Test
    public void createCommandCommandDescriptionOptionsAndHandleThey() throws NoSuchFieldException, IllegalAccessException {
        Set<Option> testOptions = new HashSet<>();
        testOptions.add(new Option("test", true, "testDiscription"));
        CommandDescription commandDescription = new CommandDescription("test", "testDiscr", new TestCommand(), testOptions);

        Set<CommandDescription> set = new HashSet<>();
        set.add(commandDescription);

        CommandHandler commandHandler = new CommandHandler(set);
        Map<String, Object> result = commandHandler.handle(new String[] {"test", "--test=test"} );
        assertTrue(result.get("result").equals("test"));

    }

    private class TestCommand implements Command {

        private String test;

        @Override
        public Map<String, Object> execute() {
            Map<String, Object> result = new HashMap<>();
            result.put("result", test);
            return result;
        }
    }
}

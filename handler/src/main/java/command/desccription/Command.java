package command.desccription;

import java.util.Map;

/**
 * Created by dznor on 28.02.2017.
 */
public interface Command {
    Map<String, Object> execute();
}

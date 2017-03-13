package command.desccription;

import java.util.Collection;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandDescription implements Command {

    private String name;
    private String description;
    private Collection<Option> options;

    private Command command;

    public CommandDescription(String name, String description, Command command, Collection<Option> options) {
        this.name = name;
        this.description = description;
        this.command = command;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Option> getOptions() {
        return options;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }
}

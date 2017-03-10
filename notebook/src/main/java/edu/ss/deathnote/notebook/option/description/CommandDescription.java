package edu.ss.deathnote.notebook.option.description;

import edu.ss.deathnote.option.Option;
import edu.ss.deathnote.option.command.AbstractCommand;

import java.util.Collection;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandDescription {

    private String name;
    private String description;
    private Collection<Option> options;
    private AbstractCommand command;

    public CommandDescription(String name, String description, AbstractCommand command, Collection<Option> options) {
        this.name = name;
        this.description = description;
        this.command = command;
        this.options = options;
    }

    public void execute() {
        command.execute();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AbstractCommand getCommand() {
        return command;
    }

    public Collection<Option> getOptions() {
        return options;
    }
}

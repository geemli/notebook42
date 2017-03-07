package edu.ss.deathnote.option.command;

import edu.ss.deathnote.option.Option;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dznor on 23.02.2017.
 */
public abstract class AbstractCommand implements Command {

    protected Collection<Option> globalOptions;

    public AbstractCommand() {
        globalOptions = new HashSet<>();
        globalOptions.add(new Option("file", false, "SELECT FILE TO CRUD"));
        globalOptions.add(new Option("charset", false, "charset"));
    }

    @Override
    abstract public void execute();

    public Collection<Option> getOptions() {
        return globalOptions;
    }

    public void setOptions(Collection<Option> options) {
        this.globalOptions = options;
    }
}

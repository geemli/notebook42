package edu.ss.deathnote.factory;

import command.desccription.CommandDescription;
import command.desccription.Option;
import edu.ss.deathnote.option.command.CreateCommand;
import edu.ss.deathnote.option.command.DeleteCommand;
import edu.ss.deathnote.option.command.ReadCommand;
import edu.ss.deathnote.option.command.UpdateCommand;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dznor on 13.03.2017.
 */
public class NotebookOptionsFactory {

    public static Set<CommandDescription> getNotebookCommands() {
        CommandDescription createCommandDescription = new CommandDescription("create", "add note", new CreateCommand(), getCreateArgs());
        CommandDescription readCommandDescription = new CommandDescription("read", "read note", new ReadCommand(), getReadArgs());
        CommandDescription updateCommandDescription = new CommandDescription("update", "update note", new UpdateCommand(), getUpdateArgs());
        CommandDescription deleteCommandDescription = new CommandDescription("delete", "delete note", new DeleteCommand(), getDeleteArgs());
//        CommandDescription sortCommandDescription = new CommandDescription("sort", "sort note", new SortCommand(), sortOptions);

        Set<CommandDescription> commands = new HashSet<>();
        commands.add(createCommandDescription);
        commands.add(readCommandDescription);
        commands.add(updateCommandDescription);
        commands.add(deleteCommandDescription);
//        commands.add(sortCommandDescription);
        return commands;
    }

    public static Set getCreateArgs() {
        Set<Option> createOptions = new HashSet<>();
        createOptions.add(new Option("name", true, "user's name"));
        createOptions.add(new Option("number", true, "user's number"));
        createOptions.add(new Option("date", false, "date of created"));
        return createOptions;
    }

    public static Set getReadArgs() {
        Set<Option> readOptions = new HashSet<>();
        readOptions.add(new Option("number", true, "number"));
        return readOptions;
    }

    public static Set getUpdateArgs() {
        Set<Option> updateOptions = new HashSet<>();
        updateOptions.add(new Option("number", true, "user's number"));
        updateOptions.add(new Option("name", true, "user's name"));
        updateOptions.add(new Option("date", false, "date of created"));
        return updateOptions;
    }

    public static Set getDeleteArgs() {
        Set<Option> deleteOptions = new HashSet<>();
        deleteOptions.add(new Option("number", true, "user's number"));
        return deleteOptions;
    }

    public static Set getGlobalArgs() {
        Set<Option> globalOptions = new HashSet<>();
        globalOptions.add(new Option("file", false, "SELECT FILE TO CRUD"));
        globalOptions.add(new Option("charset", false, "charset"));
        return globalOptions;
    }
}

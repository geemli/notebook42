package edu.ss.deathnote.main;

import command.desccription.CommandDescription;
import command.desccription.Option;
import command.parser.CommandHandler;
import edu.ss.deathnote.factory.NotebookOptionsFactory;

import java.util.Set;

/**
 * Created by dznor on 23.02.2017.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        args = new String[]{"create", "--name=dima", "--number=666"};
        if (args.length > 0) {
            /**
             * Describe arguments
             */
            Set<Option> globalOptions = NotebookOptionsFactory.getGlobalArgs();
            Set<CommandDescription> commands = NotebookOptionsFactory.getNotebookCommands();

            CommandHandler handler = new CommandHandler(globalOptions, commands);
            handler.handle(args);
        } else {
            throw new IllegalArgumentException("no parameters");
        }
    }

}
package command.parser;


import command.desccription.CommandDescription;
import command.desccription.Option;

import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandHandler {

    private Set<Option> globalOptions;
    private Set<CommandDescription> commands;

    public CommandHandler(Set<Option> globalOptions, Set<CommandDescription> commands) {
        this.globalOptions = globalOptions;
        this.commands = commands;
    }

    public CommandHandler(Set<CommandDescription> commands) {
        this.commands = commands;
    }

    public void handle(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Collection<String> arguments = new ArrayList<>(Arrays.asList(args));
        handle(arguments);
    }

    public void handle(Collection<String> args) throws NoSuchFieldException, IllegalAccessException {

        CommandDescription command = selectCommand(args);
        Collection<Option> commandOptions = command.getOptions();

        ValidatorAndCreator validatorAndCreator = new ValidatorAndCreator();
        Map<String, String> argsMap = validatorAndCreator.createCommandArgsMap(commandOptions, args);

        Class c = command.getCommand().getClass();
        argsMap.entrySet().forEach(entry -> {
            try {
                Field temp = c.getDeclaredField(entry.getKey());
                temp.setAccessible(true);
                temp.set(command.getCommand(), entry.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

//            System.out.println(entry.getKey() + entry.getValue());
        });

        if (command == null) {
            throw new IllegalStateException("command is null. sorry ;(");
        }

        command.execute();
    }

    public CommandDescription selectCommand(Collection<String> args) {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("no arguments");
        }
        for (String arg : args) {
            if (Pattern.matches("\\w+", arg)) {
                for (CommandDescription cd : commands) {
                    if (cd.getName().toLowerCase().equals(arg)) {
                        args.remove(arg);
                        return cd;
                    }
                }
                throw new IllegalArgumentException("command " + arg + " is not exists. Try " + commands);
            }
        }
        return null;
    }
}

//                        Class c = cd.getCommand().getClass();
//                        for (String arg2 : args) {
//                            if (Pattern.matches("--\\w+=\\w+", arg2)) {
//                                String prefix = "--";
//                                String equals = "=";

//                                String expressionWithOutPrefix = arg2.substring(arg2.indexOf(prefix) + prefix.length());

//                                String argument = expressionWithOutPrefix.split("=")[0];
//                                String value = expressionWithOutPrefix.split("=")[1];
//                                System.out.println("**********" + argument + "   " + value);
//                                Field field = c.getDeclaredField(argument);
//                                field.setAccessible(true);
//                                field.set(cd.getCommand(), value);
//                                System.out.println("set " + field.getName() + "=" + field.get(cd.getCommand()));

//                            реестр: рефлекшеном по интерфейсу или класс
//                            фабрику команд сделать. с методом() createcommand factory. патерн команда.
//                      СДЕЛАТЬ ВАЛИДАТОР+СОЗДАТЕЛЬ MAP<>. НА ВХОДЕ КОММАНД ДИСКРИПШН И КОЛЛЕКЦИЯ ОПШИНСОВ. ВЫБРАТЬ ОБЩЕЕ

//                            }
//                        }
//                    Field[] publicFields = c.getDeclaredFields();
//                    for (Field field : publicFields) {
//                        Class fieldType = field.getType();
//                        System.out.println("Имя: " + field.getName());
//                        System.out.println("Тип: " + fieldType.getName());
//                    }

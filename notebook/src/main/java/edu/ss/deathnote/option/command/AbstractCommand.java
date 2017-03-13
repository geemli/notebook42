package edu.ss.deathnote.option.command;

import command.desccription.Command;
import edu.ss.deathnote.notebook.Notebook;
import edu.ss.deathnote.notebook.NotebookImpl;

/**
 * Created by dznor on 23.02.2017.
 */
public abstract class AbstractCommand implements Command {

    Notebook notebook = new NotebookImpl();

    protected String file;
    protected String charset;

}

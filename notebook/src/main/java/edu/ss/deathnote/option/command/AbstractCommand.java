package edu.ss.deathnote.option.command;

import command.desccription.Command;
import edu.ss.deathnote.notebook.Notebook;
import edu.ss.deathnote.notebook.NotebookImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by dznor on 23.02.2017.
 */
public abstract class AbstractCommand implements Command {

    protected String file;
    protected String charset;

    Notebook notebook;

    protected OutputStream os;

    public AbstractCommand() {
        notebook = new NotebookImpl();
        if (file == null) {
            os = System.out;
        } else {
            try {
                os = new FileOutputStream(new File(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

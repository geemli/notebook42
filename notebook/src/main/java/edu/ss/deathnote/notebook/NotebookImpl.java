package edu.ss.deathnote.notebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dznor on 23.02.2017.
 */
public class NotebookImpl implements Notebook {

    private static NotebookImpl notebook2 = new NotebookImpl();
    private NotebookImpl() {}
    public static NotebookImpl getInstance() {
        return notebook2;
    }

    List<Entry> notebook = new ArrayList<>();

    @Override
    public void create(Entry entry) {
        notebook.add(entry);
    }

    @Override
    public Entry readName(String name) {
        for (Entry entry : notebook) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Entry readNumber(String number) {
        for (Entry entry : notebook) {
            if (entry.getNumber().equals(number)) {
                return entry;
            }
        }
        return null;
    }


    @Override
    public void update(Entry entry, Entry newEntry) {
        notebook.remove(entry);
        notebook.add(newEntry);
    }

    @Override
    public void delete(Entry entry) {
        notebook.remove(entry);
    }

    @Override
    public void sort() {
        Collections.sort(notebook);
    }

    public List<Entry> getNotebook() {
        return notebook;
    }
}

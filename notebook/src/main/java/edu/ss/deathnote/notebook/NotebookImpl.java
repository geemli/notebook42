package edu.ss.deathnote.notebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dznor on 23.02.2017.
 */
public class NotebookImpl implements Notebook {

    List<Entry> notebook = new ArrayList<>();

    @Override
    public void create(Entry entry) {
        notebook.add(entry);
    }

    @Override
    public Entry read(String name) {
        for (Entry entry : notebook) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public void update(Entry entry, Entry newEntry) {
        notebook.remove(entry);
        notebook.add(entry);
    }

    @Override
    public void delete(Entry entry) {
        notebook.remove(entry);
    }

    @Override
    public void sort() {
        Collections.sort(notebook);
    }
}

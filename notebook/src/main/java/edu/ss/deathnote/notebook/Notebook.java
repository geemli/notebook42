package edu.ss.deathnote.notebook;

/**
 * Created by dznor on 23.02.2017.
 */
public interface Notebook {
    void create(Entry entry);

    Entry readName(String name);

    Entry readNumber(String name);

    void update(Entry entry, Entry newEntry);

    void delete(Entry entry);

    void sort();
}

package edu.ss.deathnote.notebook;

/**
 * Created by dznor on 13.03.2017.
 */
public class Entry implements Comparable<Entry> {
    private String name;
    private String number;

    public Entry(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public int compareTo(Entry o) {
        return this.name.compareTo(o.getName());
    }
}

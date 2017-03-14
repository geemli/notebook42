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

    public int compareTo(Entry o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!name.equals(entry.name)) return false;
        return number.equals(entry.number);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }
}

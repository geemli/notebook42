package notebook;

import edu.ss.deathnote.notebook.Entry;
import edu.ss.deathnote.notebook.Notebook;
import edu.ss.deathnote.notebook.NotebookImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dznor on 14.03.2017.
 */

public class NotebookImplTest {


    public static final String NAME = "DMITRY";
    public static final String NUMBER = "3600666";

    public static final String NAME_NEW = "DIMITRIUS";
    public static final String NUMBER_NEW = "1234567";

    NotebookImpl notebook = new NotebookImpl();

    @Test
    public void create() {
        Entry entry = new Entry(NAME, NUMBER);
        assertFalse(notebook.getNotebook().contains(entry));
        notebook.create(entry);
        assertTrue(notebook.getNotebook().contains(entry));
    }

    @Test
    public void readName() {
        Entry entry = new Entry(NAME, NUMBER);
        notebook.create(entry);
        Entry entry1 = notebook.readName(NAME);
        assertEquals(entry.getName(), entry1.getName());
        assertEquals(entry.getNumber(), entry1.getNumber());
    }

    @Test
    public void readNumber() {
        Entry entry = new Entry(NAME, NUMBER);
        notebook.create(entry);
        Entry entry1 = notebook.readNumber(NUMBER);
        assertEquals(entry.getName(), entry1.getName());
        assertEquals(entry.getNumber(), entry1.getNumber());
    }

    @Test
    public void update() {
        Entry entry1 = new Entry(NAME, NUMBER);
        Entry entry2 = new Entry(NAME_NEW, NUMBER_NEW);
        notebook.update(entry1, entry2);
        assertTrue(notebook.getNotebook().contains(entry2));
        assertFalse(notebook.getNotebook().contains(entry1));
    }

    @Test
    public void delete() {
        Entry entry1 = new Entry(NAME, NUMBER);
        notebook.create(entry1);
        assertTrue(notebook.getNotebook().contains(entry1));
        notebook.delete(entry1);
        assertFalse(notebook.getNotebook().contains(entry1));
    }

    @Test
    public void sort() {
        Entry entry1 = new Entry(NAME, NUMBER);
        Entry entry2 = new Entry(NAME_NEW, NUMBER_NEW);
        Entry entry3 = new Entry(NAME, NUMBER);
        Entry entry4 = new Entry(NAME_NEW, NUMBER_NEW);
        notebook.create(entry1);
        notebook.create(entry2);
        notebook.create(entry3);
        notebook.create(entry4);
        notebook.sort();

        List<Entry> list = new ArrayList<>(notebook.getNotebook());
        Collections.sort(list);
        assertTrue(notebook.getNotebook().equals(list));
    }

}

package edu.ss.deathnote.option.command;

import edu.ss.deathnote.notebook.Entry;

import java.io.*;

/**
 * Created by dznor on 23.02.2017.
 */
public class ReadCommand extends AbstractCommand {

    private String name;
    private String number;

    private OutputStream os;

    @Override
    public void execute() {

        if (file == null) {
            os = System.out;
        } else {
            try {
                os = new FileOutputStream(new File(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Entry entry;
        if (name != null) {
            entry = notebook.readName(name);
        } else if (number != null) {
            entry = notebook.readNumber(number);
        } else {
            throw new IllegalArgumentException();
        }

        if (entry != null) {
            try {
                os.write(entry.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        System.out.println("ReadCommand execute");
//        String file = "C:\\Users\\dznor\\1.txt";
//        FileInputStream fis;
//        ObjectInputStream ois;
//        List<Record> newList = new ArrayList<>();
//
//        try {
//            fis = new FileInputStream(new File(file));
//            ois = new ObjectInputStream(fis);
//
//            Record tempRepord;
//            while (true) {
//                newList.add((Record) ois.readObject());
//            }
//        } catch (EOFException e) {
//            list = newList;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            ois.close;
//            fis.close;
    }

}

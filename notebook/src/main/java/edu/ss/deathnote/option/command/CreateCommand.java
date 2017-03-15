package edu.ss.deathnote.option.command;

import edu.ss.deathnote.notebook.Entry;

import java.util.Map;

public class CreateCommand extends AbstractCommand {

    private String name;
    private String number;

    @Override
    public Map<String, Object> execute() {
        Entry entry = new Entry(name, number);
        notebook.create(entry);
//        if (file == null || file.isEmpty()) {
//            file = "1.txt";
//        }
//
//        if (charset == null || charset.isEmpty()) {
//            charset = "UTF-8";
//        }
//
//        System.out.println("CreateCommand execute() with param: name = " + name + " and number = " + number);
////        System.out.println(file + "   " + charset);
//
//        try {
//            FileOutputStream fos = new FileOutputStream(new File(file));
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//            oos.writeChars(name);
//            oos.writeChars(number);
//
//            oos.close();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return null;
    }
}

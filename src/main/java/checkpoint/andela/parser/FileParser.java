package checkpoint.andela.parser;

import java.io.*;
import java.util.ArrayList;


/**
 * A file parser class for reading and parsing a file.
 */
public class FileParser implements Runnable{
    /**
     * A Filereader.
     */
    private Filereader filereader;
    /**
     * The file to be read.
     */
    private String file;

    /**
     * creates a new file parser
     * @param file the file to be parsed.
     */
    public FileParser(String file) {
        this.file = file;
        filereader = new Filereader(file);
    }

    /**
     * parses a large Record of key-Value objects into smaller records
     * @param record the record to parse
     * @return returns an arraylist of records
     */
    public ArrayList<Record> parse(Record record) {

        Record rec = new Record();

        ArrayList<Record> records = new ArrayList<>();

        do{
            KeyValue kv = record.getKeyValue();

            if (kv.getKey().startsWith("UNIQUE-ID")) {
                records.add(rec);
                rec = new Record();
            }

            rec.addNewKeyValue(kv);

        }while (!record.isEmpty());

        records.remove(0);

       return records;
    }

    /**
     * Parses the content of a large file into key-value pairs and stores them in a large record
     * @return returns the a large collection containing all key value-pairs.
     * @throws IOException
     */
    public Record parseFile() throws IOException {

        Record record =new Record();

        BufferedReader bf = filereader.createReader();

        String line = null;

        while ((line = filereader.readFile(bf)) !=null){

            if (!filereader.isComment(line) &&!filereader.isNewLine(line) && !filereader.invalid(line)){
                line = filereader.replace(line);
                line = filereader.remove(line);
                 String[] arr = line.trim().split(filereader.delimiter(" - "));

                record.addNewKeyValue(createKeyValue(arr));

            }
        }

    return record;

    }

    /**
     * splits aline into key-value pairs
     * @param arr
     * @return
     */
    private KeyValue createKeyValue(String[] arr) {

        KeyValue kv = new KeyValue();

//        for (int i = 0; i < arr.length-1; i++) {
//
//            kv.setKey(arr[i]);
//
//            kv.setValue(arr[i + 1]);
//
//            }
        kv.setKey(arr[0]);
        kv.setValue(arr[1]);

        return kv;
    }

    @Override
    public void run() {

    }

    /**
     * A class that handles the reading of a file
     */
    private class Filereader {
        /**
         * the file to be read
         */
        private String file;

        private BufferedReader bufferedReader;


        public Filereader(String file) {

            this.file = file;

        }
        /**
         * creates a new <code>BufferedReader</code>
         * @return a <code>BufferedReader</code>
         * @throws FileNotFoundException
         */
        public BufferedReader createReader() throws FileNotFoundException {
            return bufferedReader = new BufferedReader(new FileReader(file));

        }
        /**
         * reads the given file
         * @param bufferedReader a <code>BufferedReader</code>
         * @return a line from the file.
         * @throws IOException
         */
        public String readFile(BufferedReader bufferedReader) throws IOException {
            String line = null;
            return line = bufferedReader.readLine();
        }
        /**
         * checks if a line is a comment
         * @param lineToRead
         * @return
         */
        public boolean isComment(String lineToRead) {
            return lineToRead.trim().startsWith("#");
        }

        /**
         * checks if a line is the begining of a newline
         * @param lineToRead the line to check
         * @return
         */
        public boolean isNewLine(String lineToRead) {
            return lineToRead.trim().startsWith("//");
        }

        /**
         * checks if a line is not to be read
         * @param lineToRead line to check
         * @return
         */
        public boolean invalid(String lineToRead) {
            return lineToRead.trim().startsWith("/");
        }

        /**
         * A line delimiter
         * @param delimiter the line delimiter
         * @return the delimiter
         */
        public String delimiter(String delimiter) {
            return delimiter;
        }

        /**
         * adds double backslash to a single quote ina line
         */
        public  String replace( String line) {
            return line.replace("'", "\\'");
        }

        /**
         * removes spacees form a line
         */
        public String remove(String line) {
            return line.replace("CobA [ambiguous - ", "CobA [ambiguous-");
        }
    }



}

package checkpoint.andela.parser;

import java.io.*;



/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class FileParser {

    private Filereader filereader;
    private String file;

    public FileParser(String file) {
        this.file = file;
        filereader = new Filereader(file);
    }


    public Record parseFile() throws IOException {
        Record record =new Record();
        BufferedReader bf = filereader.createReader();
        String line = null;
        while ((line = filereader.readFile(bf)) !=null){
            if (!filereader.isComment(line) &&!filereader.invalid(line)){
                 String[] arr = line.trim().split(filereader.delimetier(" - "));
                record.addnewKeyValue(ceateKeyValue(arr));

            }
        }
    return record;
    }

    public KeyValue ceateKeyValue(String[] arr) {
        KeyValue kv = new KeyValue();
        for (int i = 0; i < arr.length-1; i++) {
            kv.setKey(arr[i]);
            kv.setValue(arr[i + 1]);
            }
        return kv;
    }

    public static class Filereader {

        private String file;

        private BufferedReader bufferedReader;

        public Filereader(String file) {

            this.file = file;

        }

        public BufferedReader createReader() throws FileNotFoundException {

            return bufferedReader = new BufferedReader(new FileReader(file));

        }

        public String readFile(BufferedReader bufferedReader) throws IOException {
            String line = null;
            return line = bufferedReader.readLine();
        }

        public boolean isComment(String lineToRead) {
            return lineToRead.trim().startsWith("#");
        }

        public boolean isNewLine(String lineToRead) {
            return lineToRead.trim().startsWith("//");
        }

        public boolean invalid(String lineToRead) {
            return lineToRead.trim().startsWith("/");
        }

        public String delimetier(String delimeter) {
            return delimeter;
        }
    }
}

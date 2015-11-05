package checkpoint.andela.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class FileParser {



    public static class Filereader {
        private String file;
        private BufferedReader bufferedReader;

        public Filereader(String file) {
            this.file = file;
        }
        public BufferedReader createReader() throws FileNotFoundException{
            return bufferedReader = new BufferedReader(new FileReader(file));
        }

        public boolean isComment(String lineToRead) {
            return lineToRead.trim().startsWith("#");
        }

        public boolean isNewLine(String lineToRead) {
            return lineToRead.trim().startsWith("//");
        }

        public String delimetier(String delimeter) {
            return delimeter;
        }
    }
}

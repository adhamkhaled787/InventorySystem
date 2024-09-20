package backend;

import backend.Record;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Database <A extends Record> {
    String filename;
    ArrayList<A> records;
    public Database(String filename)
    {
        this.filename = filename;
        this.records = new ArrayList<>();
    }
   public void readFromFile() {
    try (Scanner fileScanner = new Scanner(new File(filename))) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (!line.isEmpty()) {
                A record = createRecordFrom(line);
                records.add(record);
            }
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (NoSuchElementException e) {
        // Handle or log the exception
        // This is for debugging, you might want to handle it differently in production
        
    }
}


    abstract A   createRecordFrom (String line);

        public     ArrayList<A>  returnAllRecords ()
            {
                return new ArrayList<>(records);

            }
   public boolean contains(String key) {
        for (A record : records) {
            if (key.equals(record.getSearchKey())) {
                return true;
            }
        }
        return false;
    }
    public A getRecord(String key) {
                for (A record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }

        return null;

    }
            void insertRecord (A record)
            {
                records.add(record);
            }
    void deleteRecord(String key) {
        Iterator<A> iterator = records.iterator();
        while (iterator.hasNext()) {
            A record = iterator.next();
            if (key.equals(record.getSearchKey())) {
                iterator.remove();
            }
        }
    }

  void saveToFile() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
        for (A record : records) {
            writer.append(record.lineRepresentation());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}

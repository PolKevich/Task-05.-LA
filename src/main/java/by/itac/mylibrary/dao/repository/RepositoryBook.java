package by.itac.mylibrary.dao.repository;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class RepositoryBook {
    private static final RepositoryBook repositoryBook = new RepositoryBook();

    private static final Map<Integer, Book> temporaryStorage = new HashMap<>();

    private static File file = new File("db-home-library.txt");
    private static boolean flag = false;
    private static int id = 1;

    private RepositoryBook() {

    }

    public synchronized static RepositoryBook getRepository() throws DAOException {

        update();
        countID();

        return repositoryBook;
    }


    public void addRepositoryBook(Book book) throws DAOException {

        if (flag) {

            temporaryStorage.put(id, book);

        } else {
            addFile();
            throw new DAOException("TemporaryStorage not full!");
        }

        addFile();
    }

    public Book find(int id) throws DAOException {

        Book book = null;

        if (flag) {

            book = temporaryStorage.get(id);

        } else {
            addFile();
            throw new DAOException("TemporaryStorage not full!");
        }

        addFile();

        return book;
    }

    public void delete(int id) throws DAOException {

        if (flag) {

            try {
                if (!temporaryStorage.get(id).equals(null)) {

                    temporaryStorage.remove(id);
                }
            } catch (NullPointerException e) {
                throw new DAOException("File not created!", e);
            } finally {
                addFile();
            }
        } else {
            addFile();
            throw new DAOException("TemporaryStorage not full!");
        }
    }

    public static void update() throws DAOException {

        Book book;
        FileReader reader = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(file, true);
            fw.write("");
            reader = new FileReader(file);

            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {

                String strLine = scanner.nextLine();
                if (strLine != null && !strLine.equals("")) {

                    int indexStartAuthor = strLine.indexOf('[') + 1;
                    int indexEndAuthor = strLine.indexOf(']');
                    String author = strLine.substring(indexStartAuthor, indexEndAuthor);

                    int indexStartTitleBook = strLine.indexOf('{') + 1;
                    int indexEndTitleBook = strLine.indexOf('}');
                    String titleBook = strLine.substring(indexStartTitleBook, indexEndTitleBook);

                    int indexStartYear = strLine.indexOf('-') + 2;
                    String year = strLine.substring(indexStartYear);

                    book = new Book(author, titleBook, year);

                    temporaryStorage.put(id, book);
                    id++;
                }
            }


        } catch (IOException e) {
            throw new DAOException(e);
        } finally {
            try {
                reader.close();
                fw.close();
            } catch (IOException | NullPointerException e) {
                throw new DAOException(e);
            }
        }
        flag = true;
        removeFile();
    }


    private static void removeFile() throws DAOException {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)))) {
            pw.print("");
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    private static void countID() throws DAOException {

        boolean b = false;

        while (!b) {
            if (temporaryStorage.containsKey(id)) {
                id++;
            } else b = true;
        }
    }

    private void addFile() throws DAOException {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            temporaryStorage.forEach((key, value) -> pw.println(key + "" + value));

        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}

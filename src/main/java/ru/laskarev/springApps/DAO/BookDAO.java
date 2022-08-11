package ru.laskarev.springApps.DAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.laskarev.springApps.Model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {

    private static Connection CONNECTION;

    public BookDAO(@Value("${db_URL}") String db_url,
                   @Value("${POSTGRES.USERNAME}") String username,
                   @Value("${POSTGRES.PASSWORD}") String password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            CONNECTION = DriverManager.getConnection(db_url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> index(){
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM Books";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Book book = new Book();

                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setYearOfPublished(resultSet.getInt("yearOfPublished"));
                book.setYearOfPublished(resultSet.getInt("yearOfWritten"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book show(int id){
        Book result = null;
        try {
            PreparedStatement statement =
                    CONNECTION.prepareStatement("SELECT * from books where id = ?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            result = new Book();
            result.setId(resultSet.getInt("id"));
            result.setTitle(resultSet.getString("title"));
            result.setAuthor(resultSet.getString("author"));
            result.setYearOfPublished(resultSet.getInt("yearofpublished"));
            result.setYearOfWritten(resultSet.getInt("yearofwritten"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(Book book){
        try {
            PreparedStatement statement =
                    CONNECTION.prepareStatement("INSERT INTO books values(1,?,?,?,?)");

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYearOfPublished());
            statement.setInt(4, book.getYearOfWritten());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Book book){
        try {
            PreparedStatement statement =
                    CONNECTION.prepareStatement(
                "UPDATE books SET title=?, author=?, yearofpublished=?, yearofwritten=? where id = ?"
                    );
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYearOfPublished());
            statement.setInt(4, book.getYearOfWritten());
            statement.setInt(5, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            PreparedStatement statement =
                    CONNECTION.prepareStatement(
                            "DELETE FROM books WHERE id = ?"
                    );
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

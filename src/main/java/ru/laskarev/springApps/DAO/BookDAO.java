package ru.laskarev.springApps.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.laskarev.springApps.Model.Book;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM books WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO books VALUES (1, ?, ?, ?, ?)",
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublished(),
                book.getYearOfWritten()
        );
    }

    public void update(int id, Book book){
        jdbcTemplate.update("UPDATE books SET title=?, author=?, yearofpublished=?, yearofwritten=? where id = ?",
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublished(),
                book.getYearOfWritten(),
                id
        );
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}

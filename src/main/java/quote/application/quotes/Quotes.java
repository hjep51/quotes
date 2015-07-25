package quote.application.quotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @author hjep
 */
public class Quotes {
    public static final Logger log = LoggerFactory.getLogger(Quotes.class);
    private final String DB_PATH = "jdbc:sqlite::resource:quotes.db";

    public Quotes(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            log.error("No SQLite drive found. " + e);
        }
    }

    public QuoteDAO getFirstQuote(){
        QuoteDAO quoteDAO = new QuoteDAO();
        try (Connection con = DriverManager.getConnection(DB_PATH)) {
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM quotes ORDER BY id LIMIT 1");

            if (res.next()){
                quoteDAO.setId(res.getInt("id"));
                quoteDAO.setQuote(res.getString("quote"));
                quoteDAO.setAuthor(res.getString("author"));
                quoteDAO.setCategory(res.getString("category"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quoteDAO;
    }

    public QuoteDAO getRandomQuote(){
        QuoteDAO quoteDAO = new QuoteDAO();
        try (Connection con = DriverManager.getConnection(DB_PATH)) {
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1");

            if (res.next()){
                quoteDAO.setId(res.getInt("id"));
                quoteDAO.setQuote(res.getString("quote"));
                quoteDAO.setAuthor(res.getString("author"));
                quoteDAO.setCategory(res.getString("category"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quoteDAO;
    }
}

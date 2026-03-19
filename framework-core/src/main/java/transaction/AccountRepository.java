package transaction;


import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbc;

    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @PostConstruct
    public void init() {
        jdbc.execute("CREATE TABLE IF NOT EXISTS account (id INT PRIMARY KEY, balance INT)");
        jdbc.update("INSERT INTO account (id, balance) VALUES (1, 1000)");
        jdbc.update("INSERT INTO account (id, balance) VALUES (2, 500)");
    }

    public void debit(int id, int amount) {
        try {
            System.out.println(jdbc.getDataSource().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbc.update("UPDATE account SET balance = balance - ? WHERE id = ?", amount, id);
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW) ->
    // if it needs to perform as a new transaction when invoked
    public void credit(int id, int amount) {
        try {
            System.out.println(jdbc.getDataSource().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbc.update("UPDATE account SET balance = balance + ? WHERE id = ?", amount, id);
    }

    public List<Account> getAll() {
        try {
            System.out.println(jdbc.getDataSource().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        final String sql = "SELECT id, balance FROM account";
        return jdbc.query(sql, (rs, rowNum) -> new Account(
                rs.getInt("id"),
                rs.getInt("balance")
        ));
    }
}

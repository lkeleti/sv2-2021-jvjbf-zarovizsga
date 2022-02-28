package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement("INSERT INTO products(product_name, price, stock) values (?,?,?);",
                                    Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, productName);
                    ps.setLong(2, price);
                    ps.setLong(3, stock);
                    return ps;
                }, keyHolder
        );
        return keyHolder.getKey().longValue();
    }

    public Product findProductById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id=?;",
                (rs, numRows) -> new Product(
                        rs.getLong("id"),
                        rs.getString("product_name"),
                        rs.getInt("price"),
                        rs.getInt("stock")
                ), id
        );
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("UPDATE products set stock = stock - ? WHERE id = ?;", amount, id);
    }
}

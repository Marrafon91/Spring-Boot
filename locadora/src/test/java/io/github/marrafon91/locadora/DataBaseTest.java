package io.github.marrafon91.locadora;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseTest {

    static Connection connection;

    @BeforeAll
    static void setUpDataBase() throws Exception {
        connection = DriverManager
                .getConnection("jdbc:h2:mem:testdb", "sa", "");
        connection.createStatement().execute("CREATE TABLE users (id INT, name VARCHAR(255))");
    }

    @BeforeEach
    void insertUserTest() throws  Exception {
        connection.createStatement().execute("INSERT into users (id, name) values (1, 'Maria')");
    }

    @Test
    // @Disabled desabilita o test
    void testUserExists() throws Exception {
        var result = connection
                .createStatement()
                .executeQuery("SELECT * FROM users WHERE id = 1");
        Assertions.assertTrue(result.next());
    }

    @AfterAll
    static void closeDataBase() throws Exception {
        connection.close();
    }
}

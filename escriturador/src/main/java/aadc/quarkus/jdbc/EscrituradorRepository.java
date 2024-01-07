package aadc.quarkus.jdbc;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


@ApplicationScoped
public class EscrituradorRepository {


    // DriverManager is a simple and straightforward way to obtain database connections,
    // but...DataSource is often preferred in enterprise applications for its additional features such as connection pooling,
    // improved performance, and better support for managing database connections in a multi-threaded environment.
    @Inject
    DataSource dataSource;

    public void persist(Escriturador escriturador) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "INSERT INTO t_escrituradores (id, nome) VALUES (?, ?)";

        escriturador.setId(Math.abs(new Random().nextLong()));

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, escriturador.getId());
            preparedStatement.setString(2, escriturador.getNome());

            preparedStatement.executeUpdate();
        }

        connection.close();

    }

    public Escriturador findById (Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "SELECT id, nome FROM t_escrituradores WHERE id = ?";

        Escriturador escriturador = new Escriturador();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                escriturador.setId(resultSet.getLong(1));
                escriturador.setNome(resultSet.getString(2));
            }
        }
        connection.close();
        return escriturador;

    }

}

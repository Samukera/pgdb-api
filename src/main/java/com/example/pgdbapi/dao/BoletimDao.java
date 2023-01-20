package com.example.pgdbapi.dao;

import com.example.pgdbapi.model.Boletim;
import com.example.pgdbapi.model.Votos;
import org.hibernate.dialect.Database;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoletimDao {

    private String sql;
    private String status = "";

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public BoletimDao() {
    }

    public String saveBoletim(Boletim boletim) throws SQLException {

        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            if (boletim != null ) {
                this.sql = " INSERT INTO boletim (aptos, comparecimento, faltosos, local_votacao, secao, " +
                        " valido, zona, usuario_id) " +
                        " VALUES (?,?,?,?,?,?,?,?) ";
                preparedStatement = connection.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1,boletim.getAptos());
                preparedStatement.setInt(2,boletim.getComparecimento());
                preparedStatement.setInt(3,boletim.getFaltosos());
                preparedStatement.setString(4,boletim.getLocal_votacao());
                preparedStatement.setInt(5,boletim.getSecao());
                preparedStatement.setBoolean(6,boletim.isValido());
                preparedStatement.setInt(7,boletim.getZona());
                preparedStatement.setLong(8,boletim.getUsuario().getId());
                preparedStatement.execute();
                resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                if (resultSet.getInt(1) > 0) {
                    List<Votos> votos = boletim.getVotos();
                    if (!votos.isEmpty()) {
                        this.sql = " INSERT INTO votos (data, qtd_votos, boletim_id, candidato_id) VALUES (?,?,?,?) ";
                        preparedStatement = connection.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
                        votos.forEach(voto -> {
                            try {
                                preparedStatement.setString(1, voto.getData());
                                preparedStatement.setInt(2,voto.getQtd_votos());
                                preparedStatement.setLong(3, resultSet.getInt(1));
                                preparedStatement.setLong(4, voto.getCandidato().getId());
                                preparedStatement.execute();
                                resultSet = preparedStatement.getGeneratedKeys();
                                resultSet.next();
                                if (resultSet.getInt(1) <= 0) {
                                    this.status = "";
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        this.status = "OK";
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.status;
    }
}

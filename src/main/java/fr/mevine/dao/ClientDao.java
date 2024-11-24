package fr.mevine.dao;

import fr.mevine.models.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao extends BaseDao<Client> {

    @Override
    protected String getTableName() {
        return "Client";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Client (cli_num_secu_social, cli_date_naissance, mut_ID) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Client client) throws SQLException {
        pstmt.setString(1, client.getNumSecuSocial());
        pstmt.setDate(2, java.sql.Date.valueOf(client.getDateNaissance()));
        pstmt.setInt(3, client.getMutuelle().getId());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Client SET cli_num_secu_social = ?, cli_date_naissance = ?, mut_ID = ? WHERE cli_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Client client) throws SQLException {
        pstmt.setString(1, client.getNumSecuSocial());
        pstmt.setDate(2, java.sql.Date.valueOf(client.getDateNaissance()));
        pstmt.setInt(3, client.getMutuelle().getId());
        pstmt.setInt(4, client.getCliId());
    }

    @Override
    protected Client mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("cli_ID"),
                rs.getString("cli_num_secu_social"),
                rs.getDate("cli_date_naissance").toLocalDate()
        );
    }
}


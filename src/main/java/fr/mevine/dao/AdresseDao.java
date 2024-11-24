package fr.mevine.dao;

import fr.mevine.models.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseDao extends BaseDao<Adresse> {

    @Override
    protected String getTableName() {
        return "Adresse";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Adresse (adr_rue, adr_code_postal, adr_ville) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Adresse adresse) throws SQLException {
        pstmt.setString(1, adresse.getRue());
        pstmt.setString(2, adresse.getCodePostal());
        pstmt.setString(3, adresse.getVille());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Adresse SET adr_rue = ?, adr_code_postal = ?, adr_ville = ? WHERE adr_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Adresse adresse) throws SQLException {
        pstmt.setString(1, adresse.getRue());
        pstmt.setString(2, adresse.getCodePostal());
        pstmt.setString(3, adresse.getVille());
        pstmt.setInt(4, adresse.getAdrId());
    }

    @Override
    protected Adresse mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Adresse(
                rs.getInt("adr_ID"),
                rs.getString("adr_rue"),
                rs.getString("adr_code_postal"),
                rs.getString("adr_ville")
        );
    }
}


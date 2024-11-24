package fr.mevine.dao;

import fr.mevine.models.Medecin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedecinDao extends BaseDao<Medecin> {

    @Override
    protected String getTableName() {
        return "Medecin";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Medecin (med_num_agrement, uti_ID) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Medecin medecin) throws SQLException {
        pstmt.setString(1, medecin.getNumeroAgrement());
        pstmt.setInt(2, medecin.getUtiId());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Medecin SET med_num_agrement = ?, uti_ID = ? WHERE med_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Medecin medecin) throws SQLException {
        pstmt.setString(1, medecin.getNumeroAgrement());
        pstmt.setInt(2, medecin.getUtiId());
//        pstmt.setInt(3, medecin.getUtiId());
    }

    @Override
    protected Medecin mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Medecin(
                rs.getInt("med_ID"),
                rs.getString("med_num_agreement"),
                rs.getInt("uti_ID")
        );
    }
}


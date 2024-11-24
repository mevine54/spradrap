package fr.mevine.dao;

import fr.mevine.models.Specialiste;
import fr.mevine.enums.TypeSpecialite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialisteDao extends BaseDao<Specialiste> {

    @Override
    protected String getTableName() {
        return "Specialiste";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Specialiste (spe_nom, spe_specialite) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Specialiste specialiste) throws SQLException {
        pstmt.setString(1, specialiste.getNom());
        pstmt.setString(2, specialiste.getTypeSpecialite().name());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Specialiste SET spe_nom = ?, spe_specialite = ? WHERE spe_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Specialiste specialiste) throws SQLException {
        pstmt.setString(1, specialiste.getNom());
        pstmt.setString(2, specialiste.getTypeSpecialite().name());
        pstmt.setInt(3, specialiste.getId());
    }

    @Override
    protected Specialiste mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Specialiste(
                rs.getInt("spe_ID"),
                rs.getString("spe_nom"),
                TypeSpecialite.valueOf(rs.getString("spe_specialite"))
        );
    }
}


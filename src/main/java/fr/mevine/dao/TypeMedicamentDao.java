package fr.mevine.dao;

import fr.mevine.models.TypeMedicament;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeMedicamentDao extends BaseDao<TypeMedicament> {

    @Override
    protected String getTableName() {
        return "TypeMedicament";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO TypeMedicament (typ_med_nom) VALUES (?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, TypeMedicament typeMedicament) throws SQLException {
        pstmt.setString(1, typeMedicament.getNom());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE TypeMedicament SET typ_med_nom = ? WHERE typ_med_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, TypeMedicament typeMedicament) throws SQLException {
        pstmt.setString(1, typeMedicament.getNom());
        pstmt.setInt(2, typeMedicament.getTypeMedId());
    }

    @Override
    protected TypeMedicament mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new TypeMedicament(
                rs.getInt("typ_med_ID"),
                rs.getString("typ_med_nom")
        );
    }
}


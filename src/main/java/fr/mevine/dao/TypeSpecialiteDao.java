package fr.mevine.dao;

import fr.mevine.models.TypeSpecialite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeSpecialiteDao extends BaseDao<TypeSpecialite> {

    @Override
    protected String getTableName() {
        return "TypeSpecialite";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO TypeSpecialite (typ_spe_nom) VALUES (?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, TypeSpecialite typeSpecialite) throws SQLException {
        pstmt.setString(1, typeSpecialite.getNom());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE TypeSpecialite SET typ_spe_nom = ? WHERE typ_spe_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, TypeSpecialite typeSpecialite) throws SQLException {
        pstmt.setString(1, typeSpecialite.getNom());
        pstmt.setInt(2, typeSpecialite.getTypeSpeId());
    }

    @Override
    protected TypeSpecialite mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new TypeSpecialite(
                rs.getInt("typ_spe_ID"),
                rs.getString("typ_spe_nom")
        );
    }
}


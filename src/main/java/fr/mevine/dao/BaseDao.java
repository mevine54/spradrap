package fr.mevine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {

    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    protected abstract String getTableName();

    protected abstract String getInsertQuery();

    protected abstract void setInsertParameters(PreparedStatement pstmt, T entity) throws SQLException;

    protected abstract String getUpdateQuery();

    protected abstract void setUpdateParameters(PreparedStatement pstmt, T entity) throws SQLException;

    public void create(Connection connection, T entity) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(getInsertQuery())) {
            setInsertParameters(pstmt, entity);
            pstmt.executeUpdate();
        }
    }

    public void update(Connection connection, T entity) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(getUpdateQuery())) {
            setUpdateParameters(pstmt, entity);
            pstmt.executeUpdate();
        }
    }

    public void delete(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public T findById(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        }
        return null;
    }

    public List<T> findAll(Connection connection) throws SQLException {
        String query = "SELECT * FROM " + getTableName();
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            List<T> results = new java.util.ArrayList<>();
            while (rs.next()) {
                results.add(mapResultSetToEntity(rs));
            }
            return results;
        }
    }
}


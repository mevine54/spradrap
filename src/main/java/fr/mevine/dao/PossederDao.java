package fr.mevine.dao;

import fr.mevine.models.Adresse;
import fr.mevine.models.Posseder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.mevine.utilities.Singleton.getConnection;

public class PossederDao extends BaseDao<Posseder> {

    @Override
    public Adresse create(Posseder obj) {
        String query = "INSERT INTO Posseder (uti_ID, adr_ID) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getUtiId());
            ps.setInt(2, obj.getAdrId());
            ps.executeUpdate();

            // Récupérer l'objet Adresse inséré
            String selectQuery = "SELECT * FROM Adresse WHERE adr_ID = ?";
            try (PreparedStatement selectPs = connection.prepareStatement(selectQuery)) {
                selectPs.setInt(1, obj.getAdrId());
                try (ResultSet rs = selectPs.executeQuery()) {
                    if (rs.next()) {
                        Adresse adresse = new Adresse();
                        adresse.setAdrId(rs.getInt("adr_ID"));
                        adresse.setAdrRue(rs.getString("adr_rue"));
                        adresse.setAdrCodePostal(rs.getString("adr_code_postal"));
                        adresse.setAdrVille(rs.getString("adr_ville"));
                        return adresse;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retourner null en cas d'échec
    }

    @Override
    public boolean delete(long id) {
        // La méthode delete attend un long id, mais nous avons besoin de deux ids (utiId et adrId)
        // Pour contourner cela, nous pouvons passer un objet Posseder à la méthode delete
        return false;
    }

    public boolean delete(int utiId, int adrId) {
        String query = "DELETE FROM Posseder WHERE uti_ID = ? AND adr_ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, utiId);
            ps.setInt(2, adrId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Posseder obj) {
        // La mise à jour n'est pas nécessaire si la table ne contient que des clés étrangères
        return false;
    }

    @Override
    public Posseder getById(int id) {
        // La méthode getById attend un int id, mais nous avons besoin de deux ids (utiId et adrId)
        // Pour contourner cela, nous pouvons passer un objet Posseder à la méthode getById
        return null;
    }

    public List<Adresse> findById(int utiId) {
        String query = "SELECT a.* FROM Adresse a " +
                "JOIN Posseder p ON a.adr_ID = p.adr_ID " +
                "WHERE p.uti_ID = ?";
        List<Adresse> adresses = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, utiId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Adresse adresse = new Adresse();
                adresse.setAdrId(rs.getInt("adr_ID"));
                adresse.setAdrRue(rs.getString("adr_rue"));
                adresse.setAdrCodePostal(rs.getString("adr_code_postal"));
                adresse.setAdrVille(rs.getString("adr_ville"));
                adresses.add(adresse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adresses;
    }

    @Override
    public List<Posseder> getAll() {
        String query = "SELECT * FROM Posseder";
        List<Posseder> posseders = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Posseder posseder = new Posseder();
                posseder.setUtiId(rs.getInt("uti_ID"));
                posseder.setAdrId(rs.getInt("adr_ID"));
                posseders.add(posseder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posseders;
    }
}

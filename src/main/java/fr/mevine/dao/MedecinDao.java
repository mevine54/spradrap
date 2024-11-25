package fr.mevine.dao;

import fr.mevine.models.Medecin;
import fr.mevine.models.Adresse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MedecinDao extends BaseDao<Medecin> {

    private final AdresseDao adresseDao = new AdresseDao();
    private final UtilisateurDao utilisateurDao = new UtilisateurDao();


    @Override
    public Adresse create(Medecin obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Medecin obj) {
        return false;
    }

    @Override
    public Medecin getById(int id) {
        return null;
    }

    @Override
    public List<Medecin> getAll() {
        return List.of();
    }
}

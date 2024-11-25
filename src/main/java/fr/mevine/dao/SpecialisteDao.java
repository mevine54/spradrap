package fr.mevine.dao;

import fr.mevine.models.Specialiste;
import fr.mevine.models.Adresse;
import fr.mevine.enums.TypeSpecialite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpecialisteDao extends BaseDao<Specialiste> {


    @Override
    public Adresse create(Specialiste obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Specialiste obj) {
        return false;
    }

    @Override
    public Specialiste getById(int id) {
        return null;
    }

    @Override
    public List<Specialiste> getAll() {
        return List.of();
    }
}

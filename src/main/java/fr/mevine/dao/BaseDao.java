package fr.mevine.dao;

import fr.mevine.models.Adresse;

import java.util.List;

public abstract class BaseDao<T> {
    public abstract Adresse create(T obj);
    public abstract boolean delete(long id);
    public abstract boolean update(T obj);
    public abstract T getById(int id);
    public abstract List<T> getAll();
}

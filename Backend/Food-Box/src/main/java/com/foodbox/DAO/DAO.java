package com.foodbox.DAO;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();

    T getOneById(int id);

    T add(T t);
}
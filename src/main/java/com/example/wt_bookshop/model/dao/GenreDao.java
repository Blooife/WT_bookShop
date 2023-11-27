package com.example.wt_bookshop.model.dao;

import com.example.wt_bookshop.model.entities.genre.Genre;
import com.example.wt_bookshop.model.exceptions.DaoException;

import java.util.List;

/**
 * @author nekit
 * @version 1.0
 */
public interface GenreDao {
    /**
     * Extract Colors from dataBase
     *
     * @param id - id of phone
     * @return List of colors
     * @throws DaoException throws when there is some errors during dao method execution
     */
    List<Genre> getColors(Long id) throws DaoException;
}

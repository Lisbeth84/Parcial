/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.autor.daoImpl;

import com.example.autor.dao.AutorDao;
import com.example.autor.model.Autor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lisbeth
 */
@Repository
public class AutorDaoImpl implements AutorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Autor autor) {
        String SQL = "INSERT INTO autor(nombres, apellidos, correo) VALUES(?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{autor.getNombres(), autor.getApellidos(), autor.getCorreo()});
    }

    @Override
    public int update(Autor autor) {
        String SQL = "UPDATE autor SET nombres=?,apellidos=?, correo=? WHERE idautor=?";
        return jdbcTemplate.update(SQL, new Object[]{autor.getNombres(), autor.getApellidos(), autor.getCorreo(), autor.getIdautor()});
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM autor WHERE idautor=?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Autor read(int id) {
        String SQL = "SELECT *FROM autor WHERE idautor=?";
        try {
            Autor autor = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Autor.class), id);
            return autor;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Autor> readAll() {
        String SQL = "SELECT idautor, nombres, apellidos, correo FROM autor ORDER BY idautor ASC";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Autor.class));
    }

}

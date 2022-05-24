/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.autor.serviceImpl;

import com.example.autor.dao.AutorDao;
import com.example.autor.model.Autor;
import com.example.autor.service.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lisbeth
 */
@Service

public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorDao autorDao;
    @Override
    public int create(Autor autor) {
        return autorDao.create(autor);
    }

    @Override
    public int update(Autor autor) {
        return autorDao.update(autor);
    }

    @Override
    public int delete(int id) {
        return autorDao.delete(id);
    }

    @Override
    public Autor read(int id) {
        return autorDao.read(id);
    }

    @Override
    public List<Autor> readAll() {
        return autorDao.readAll();
    }
    
}

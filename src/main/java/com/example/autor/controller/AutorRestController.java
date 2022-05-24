/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.autor.controller;


import com.example.autor.model.Autor;
import com.example.autor.service.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lisbeth
 */
@RestController
@RequestMapping("/autor")
public class AutorRestController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/all")
    public List<Autor> getAutor() {
        return autorService.readAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutor (@PathVariable int id) {
        Autor autor = autorService.read(id);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    public int deleteAutor (@PathVariable int id){
        return autorService.delete(id);
    }
    

    @PostMapping("/add")
    public int addAutor(@RequestBody Autor autor) {
        System.out.println(autor.getNombres());
        return autorService.create(autor);
    }

    @PutMapping("/edit")
    public int editAutor(@RequestBody Autor autor) {
        Autor aut = new Autor(autor.getIdautor(),autor.getNombres(), autor.getApellidos(),autor.getCorreo());
        System.out.println(autor.getIdautor()+" , "+autor.getNombres()+" , "+autor.getApellidos()+" , "+autor.getCorreo());
        return autorService.update(autor);
    }
}

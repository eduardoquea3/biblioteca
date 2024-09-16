package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Libros;
import com.sise.biblioteca.repository.ILibrosRepository;
import com.sise.biblioteca.service.ILibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ILibrosServiceImpl implements ILibrosService {

    @Autowired
    private final ILibrosRepository librosRepository;


    public ILibrosServiceImpl(ILibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }
    @Override
    public List<Libros>getAll(){
        return librosRepository.findAll();
     }

     @Override
     public Libros getById(Integer idLibros){
        return null;
    }

     @Override
     public Libros add(Libros libros){
        return null;
     }

     @Override
     public Libros edit(Integer idLibros){
        return null;
     }
     @Override
     public void remove(Integer idLibros){

     }




}

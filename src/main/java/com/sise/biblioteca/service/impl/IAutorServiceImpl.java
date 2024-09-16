package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.repository.IAutorRespository;
import com.sise.biblioteca.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAutorServiceImpl  implements IAutorService {

    @Autowired
    private  final IAutorRespository  iAutorRespository;


    public IAutorServiceImpl(IAutorRespository iAutorRespository) {
        this.iAutorRespository = iAutorRespository;
    }

    @Override
    public List<Autor> getAll(){
        return null;
    }

    @Override
    public Autor getById(Integer idAutor){
        return null;
    }

    @Override
    public Autor add(Autor autor){
        return null;
    }

    @Override
    public Autor edit(Integer idAutor){
        return null;
    }
    @Override
    public void remove(Integer idAutor){

    }
}

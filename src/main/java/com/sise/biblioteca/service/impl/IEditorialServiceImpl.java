package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Editorial;
import com.sise.biblioteca.repository.IEditorialRepository;
import com.sise.biblioteca.service.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IEditorialServiceImpl implements IEditorialService {

    @Autowired
    private final IEditorialRepository iEditorialRepository;

    public IEditorialServiceImpl(IEditorialRepository iEditorialRepository) {
        this.iEditorialRepository = iEditorialRepository;
    }

    @Override
    public List<Editorial>getAll(){
        return  null;
    }
    @Override
    public Editorial getById(Integer idEditorial){
        return  null;

    }
    @Override
    public Editorial add(Editorial editorial){
        return null;
    }
    @Override
    public Editorial edit(Integer IdEditorial){
        return  null;
    }

    @Override
    public void remove(Integer IdEditorial){

    }
}

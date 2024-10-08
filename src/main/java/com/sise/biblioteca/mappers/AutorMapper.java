package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Autor.CreateAutorDTO;
import com.sise.biblioteca.entities.Autor;

public class AutorMapper {
    public static Autor createDtoToAutor(CreateAutorDTO dto){
        Autor autor = new Autor();
        autor.setNombre(dto.getNombre());
        return autor;
    }
}

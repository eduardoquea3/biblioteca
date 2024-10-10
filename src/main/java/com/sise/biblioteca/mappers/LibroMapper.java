package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Libro.CreateLibroDTO;
import com.sise.biblioteca.dto.Libro.UpdateLibroDTO;
import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.entities.Categoria;
import com.sise.biblioteca.entities.Editorial;
import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.entities.Libro;
import com.sise.biblioteca.entities.SubGenero;

public class LibroMapper {
  public static Libro createDtoToLibro(CreateLibroDTO dto) {
    Libro libro = new Libro();

    libro.setSerialNumber(dto.getSerialNumber());
    libro.setNombre(dto.getNombre());

    // Crear las entidades relacionadas solo con los IDs
    Autor autor = new Autor();
    autor.setIdAutor(dto.getIdAutor());
    libro.setAutor(autor);

    Idioma idioma = new Idioma();
    idioma.setIdIdioma(dto.getIdIdioma());
    libro.setIdioma(idioma);

    Editorial editorial = new Editorial();
    editorial.setIdEditorial(dto.getIdEditorial());
    libro.setEditorial(editorial);

    Categoria categoria = new Categoria();
    categoria.setIdCategoria(dto.getIdCategoria());
    libro.setCategoria(categoria);

    SubGenero subGenero = new SubGenero();
    subGenero.setIdSubgenero(dto.getIdSubgenero());
    libro.setSubGenero(subGenero);

    libro.setAnio(dto.getAnio());
    libro.setUnidades(dto.getUnidades());
    libro.setCantidadPaginas(dto.getCantPaginas());
    libro.setUrlImagen(dto.getUrlImagen());

    return libro;
  }

  public static Libro updateDtoToLibro(UpdateLibroDTO dto) {
    Libro libro = new Libro();
    libro.setNombre(dto.getNombre());

    Autor autor = new Autor();
    autor.setIdAutor(dto.getIdAutor());
    libro.setAutor(autor);

    Idioma idioma = new Idioma();
    idioma.setIdIdioma(dto.getIdIdioma());
    libro.setIdioma(idioma);

    Editorial editorial = new Editorial();
    editorial.setIdEditorial(dto.getIdEditorial());
    libro.setEditorial(editorial);

    Categoria categoria = new Categoria();
    categoria.setIdCategoria(dto.getIdCategoria());
    libro.setCategoria(categoria);

    SubGenero subGenero = new SubGenero();
    subGenero.setIdSubgenero(dto.getIdSubgenero());
    libro.setSubGenero(subGenero);

    libro.setAnio(dto.getAnio());
    libro.setUnidades(dto.getUnidades());
    libro.setCantidadPaginas(dto.getCantPaginas());
    libro.setUrlImagen(dto.getUrlImagen());

    return libro;
  }
}

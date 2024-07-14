package com.alura.literalura.models;

import com.alura.literalura.data.Genres;
import com.alura.literalura.models.records.DataBook;
import com.alura.literalura.models.records.Media;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long libroId;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Author autor;
    @Enumerated(EnumType.STRING)
    private Genres genero;
    private String idioma;
    private String imagen;
    private Long cantidadDescargas;

    public Libro() {
    }

    public Libro(DataBook datosLibro) {
        this.libroId = datosLibro.libroId();
        this.titulo = datosLibro.titulo();
        if (datosLibro.autor() != null && !datosLibro.autor().isEmpty()) {
            this.autor = new Author(datosLibro.autor().get(0));
        } else {
            this.autor = null;
        }
        this.genero =  generoModificado(datosLibro.genero());
        this.idioma = idiomaModificado(datosLibro.idioma());
        this.imagen = imagenModificada(datosLibro.imagen());
        this.cantidadDescargas = datosLibro.cantidadDescargas();
    }

    public Libro(Libro libro) {
    }

    private Genres generoModificado(List<String> generos) {
        if (generos == null || generos.isEmpty()) {
            return Genres.DESCONOCIDO;
        }
        Optional<String> firstGenero = generos.stream()
                .map(g -> {
                    int index = g.indexOf("--");
                    return index != -1 ? g.substring(index + 2).trim() : null;
                })
                .filter(Objects::nonNull)
                .findFirst();
        return firstGenero.map(Genres::fromString).orElse(Genres.DESCONOCIDO);
    }

    private String idiomaModificado(List<String> idiomas) {
        if (idiomas == null || idiomas.isEmpty()) {
            return "Desconocido";
        }
        return idiomas.get(0);
    }

    private String imagenModificada(Media media) {
        if (media == null || media.imagen().isEmpty()) {
            return "Sin imagen";
        }
        return media.imagen();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Genres getGenero() {
        return genero;
    }
    public void setGenero(Genres genero) {
        this.genero = genero;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Long getLibroId() {
        return libroId;
    }
    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Author getAutores() {
        return autor;
    }
    public void setAutores(Author autores) {
        this.autor = autores;
    }


    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }



    public Long getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Long cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    @Override
    public String toString() {
        return
                "  \nid=" + id +
                "  \nLibro id=" + libroId +
                ", \ntitulo='" + titulo + '\'' +
                ", \nauthors=" + (autor != null ? autor.getNombre() : "N/A")+
                ", \ngenero=" + genero +
                ", \nidioma=" + idioma +
                ", \nimagen=" + imagen +
                ", \ncantidadDescargas=" + cantidadDescargas;
    }
}

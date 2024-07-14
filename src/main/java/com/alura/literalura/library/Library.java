package com.alura.literalura.library;

import com.alura.literalura.config.GutendexApiConsumer;
import com.alura.literalura.config.DataConverter;
import com.alura.literalura.models.ResquestApiBook;
import com.alura.literalura.models.records.DataBook;
import com.alura.literalura.models.Author;
import com.alura.literalura.models.Libro;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class Library {

    private final Scanner sc = new Scanner(System.in);
    private final GutendexApiConsumer apiConsumer = new GutendexApiConsumer();
    private final DataConverter converter = new DataConverter();
    private static final String API_BASE = "https://gutendex.com/books/?search=";
    private final BookRepository bookR;
    private final AuthorRepository authorR;

    public Library(BookRepository bookR, AuthorRepository authorR) {
        this.bookR = bookR;
        this.authorR = authorR;
    }

    protected Libro getDataBook() {
        System.out.println("Ingrese el nombre del libro: ");
        var nameBook = sc.nextLine().toLowerCase();
        var json = apiConsumer.dataRequest(API_BASE + nameBook.replace(" ", "%20"));
        ResquestApiBook data = converter.convertJsonToJava(json, ResquestApiBook.class);

        if (data != null && data.getResultadoLibros() != null && !data.getResultadoLibros().isEmpty()) {
            DataBook theBook = data.getResultadoLibros().get(0);
            return new Libro(theBook);
        } else {
            System.out.println("No hay resultados.");
            return null;
        }
    }

    protected void searchBook() {
        Libro book = getDataBook();
        if (book == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        try {
            boolean liveBook = bookR.existsByTitulo(book.getTitulo());
            if (liveBook) {
                System.out.println("Ya esta registrado");
            } else {
                bookR.save(book);
                System.out.println(book);
            }
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println("Acceso invalido");
        }
    }

    @Transactional(readOnly = true)
    protected void listRegisteredBooks() {
        List<Libro> books = bookR.findAll();
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados");
        } else {
            System.out.println("Libros registrados: ");
            for (Libro book : books) {
                System.out.println(book.toString());
            }
        }
    }

    @Transactional(readOnly = true)
    protected void listRegisteredAuthors() {
        List<Author> authors = authorR.findAll();
        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados");
        } else {
            System.out.println("Autores registrados:");
            for (Author author : authors) {
                System.out.println(author.getNombre());
            }
        }
    }

    @Transactional(readOnly = true)
    protected void listLiveAuthors() {
        System.out.println("Escriba el año: ");
        var yearSearch = sc.nextInt();
        sc.nextLine();

        List<Author> liveAuthors = authorR.findByCumpleaniosLessThanOrFechaFallecimientoGreaterThanEqual(yearSearch, yearSearch);
        if (liveAuthors.isEmpty()) {
            System.out.println("No se encontraron autores.");
        } else {
            System.out.println("Autores vivos:");
            Set<String> uniqueAuthors = new HashSet<>();
            for (Author author : liveAuthors) {
                if (uniqueAuthors.add(author.getNombre())) {
                    System.out.println("Autor: " + author.getNombre());
                }
            }
        }
    }

    @Transactional(readOnly = true)
    protected void listByLanguage() {
        System.out.println("Ingrese el idioma para buscar los libros: ");
        System.out.println("es - español\nen - inglés\nfr - francés\npt - portugués\n");

        var language = sc.nextLine();
        List<Libro> languageBook = bookR.findByIdioma(language);

        if (languageBook.isEmpty()) {
            System.out.println("No hay libros registrados");
        } else {
            System.out.println("Libros registrados:");
            for (Libro libro : languageBook) {
                System.out.println(libro.toString());
            }
        }
    }
}

package com.alura.literalura.repository;
import com.alura.literalura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findAll();


    List<Author> findByCumpleaniosLessThanOrFechaFallecimientoGreaterThanEqual(int anioBuscado, int anioBuscado1);

    Optional<Author> findFirstByNombreContainsIgnoreCase(String escritor);
}

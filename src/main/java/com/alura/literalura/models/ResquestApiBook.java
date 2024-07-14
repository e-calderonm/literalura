package com.alura.literalura.models;
import com.alura.literalura.models.records.DataBook;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResquestApiBook {

    @JsonAlias("results")
    List<DataBook> resultadoLibros;

    public List<DataBook> getResultadoLibros() {
        return resultadoLibros;
    }

    public void setResultadoLibros(List<DataBook> resultadoLibros) {
        this.resultadoLibros = resultadoLibros;
    }
}

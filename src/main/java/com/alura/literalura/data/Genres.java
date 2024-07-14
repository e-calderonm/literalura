package com.alura.literalura.data;

public enum Genres {
    ACCION ("Action"),
    AVENTURA ("Adventure"),
    CRIMEN ("Crime"),
    COMEDIA ("Comedy"),
    DESCONOCIDO("Desconocido"),
    DRAMA ("Drama"),
    FICCION ("Fiction"),
    ROMANCE ("Romance") ;

    private final String genre;

    Genres(String genreGutendex) {
        this.genre = genreGutendex;
    }

    public static Genres fromString(String text){
        for (Genres genreEnum: Genres.values()){
            if (genreEnum.genre.equals(text)){
                return genreEnum;
            }
        }
        return Genres.DESCONOCIDO;
    }

}
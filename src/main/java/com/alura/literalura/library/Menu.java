package com.alura.literalura.library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void showMenu() {
        var opcion = -1;
        while (opcion != 0) {
            String menu =
                    "       LiterAlura\n" +
                            "      By: Daniel C\n" +
                            "Elija la opción a través de su número:\n" +
                            "1- buscar libros por título\n" +
                            "2- listar libros registrados\n" +
                            "3- listar autores registrados\n" +
                            "4- listar autores vivos en un determinado año\n" +
                            "5- listar libros por idioma\n" +
                            "0- salir\n" +
                            "Ingrese una opción: ";

            try {
                System.out.println(menu);
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número válido: ");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    library.searchBook();
                    break;
                case 2:
                    library.listRegisteredBooks();
                    break;
                case 3:
                    library.listRegisteredAuthors();
                    break;
                case 4:
                    library.listLiveAuthors();
                    break;
                case 5:
                    library.listByLanguage();
                    break;
                case 0:
                    System.out.println("Gracias por usar LiterAlura.");
                    break;
                default:
                    System.out.println("Opción incorrecta. Intente con una nueva opción.");
                    break;
            }
        }
    }
}

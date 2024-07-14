package com.alura.literalura.library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void showMenu() {
        var opcion = -1;
        while (opcion != 0) {
            String menu =
                    """
                                   LiterAlura
                                  By: Daniel C
                            Elija la opción a través de su número:
                            1- buscar libros por título
                            2- listar libros registrados
                            3- listar autores registrados
                            4- listar autores vivos en un determinado año
                            5- listar libros por idioma
                            0- salir
                            Ingrese una opción:\s""";

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


# Biblioteca de Libros de Literatura

Este proyecto es una aplicación Java que interactúa con la API Gutendex para buscar libros y gestionar una base de datos local de una biblioteca.

## Funcionalidades

- **Buscar Libros:** Permite buscar libros por título utilizando la API Gutendex y guardarlos localmente.
- **Listar Libros Registrados:** Muestra todos los libros actualmente guardados en la base de datos local.
- **Listar Autores Registrados:** Muestra todos los autores actualmente guardados en la base de datos local.
- **Listar Autores Vivos en un Año Específico:** Recupera autores que estuvieron vivos durante un año específico.
- **Listar Libros por Idioma:** Recupera libros basados en el idioma especificado.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Hibernate (JPA)
- PostgreSQL 
- API Gutendex para datos de libros

## Configuración

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/tuusuario/biblioteca-libros-literatura.git
   cd biblioteca-libros-literatura
   ```

2. **Configurar la Base de Datos:**
   - Asegúrate de tener PostgreSQL instalado y en ejecución.
   - Actualiza `application.properties` con tus credenciales y configuraciones de base de datos.
   - Crea una base de datos en PostgrSQL llamada 'interalura'

3. **Ejecutar la Aplicación:**
   - Abre el proyecto en tu IDE preferido (IntelliJ IDEA, Eclipse, etc.).
   - Compila y ejecuta la aplicación.

4. **Uso:**
   - Al ejecutar, la aplicación mostrará un menú con varias opciones.
   - Elige una opción ingresando el número correspondiente y sigue las indicaciones.

![demo1](https://drive.google.com/file/d/1gsmCVsbffV7WgF5yB8DlYiYDH33nsdOE/view?usp=sharing)
![demo2](https://drive.google.com/file/d/1yL3gw0Zgayx8xCfgvYHZs9Znv-HGA_33/view?usp=sharing)  



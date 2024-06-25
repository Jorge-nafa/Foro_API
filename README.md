# Aplicación de Foros en Java

Esta aplicación de Java permite realizar operaciones CRUD (Create, Read, Update, Delete) en foros y está diseñada para guardar los datos en una base de datos. Además, utiliza Spring Security para controlar el acceso a las funciones mediante la generación de tokens JWT (JSON Web Tokens).

## 🖥️ Características 🖥️

- **Operaciones CRUD:** La aplicación permite crear, leer, actualizar y eliminar foros.
  - **POST:** Crear un nuevo foro.
  - **GET:** Obtener detalles de los foros.
  - **PUT:** Actualizar la información de un foro existente.
  - **DELETE:** Eliminar un foro.
- **Base de Datos:** Los foros se guardan en una base de datos para persistencia.
- **Spring Security:** Implementación de seguridad para controlar el acceso a las funciones de la aplicación.
  - **JWT Tokens:** Uso de tokens JWT para la autenticación y autorización de usuarios.

## 📚 Tecnologías Utilizadas 📚 

- **Java:** Lenguaje de programación principal.
- **Spring Boot:** Framework para la creación de aplicaciones Java.
- **Spring Security:** Framework de seguridad para proteger las aplicaciones.
- **JWT:** Tokens para la autenticación segura.
- **JPA/Hibernate:** Para el acceso y manejo de la base de datos.
- **H2/MySQL/PostgreSQL:** Bases de datos soportadas.

 ## ⭐Funciones del proyecto ⭐

  `Menú de Funciones`: Mi aplicación permite las siguientes opciones 
  
  ![Captura de pantalla 2024-06-25 104626](https://github.com/Jorge-nafa/Foro_API/assets/162073905/00200d00-4cce-481c-a7a7-057b99441e22)

  `Crear Usuario`:La aplicación requiere autenticación para usar las funciones CRUD. Es necesario crear un usuario para poder acceder a las funciones del foro. La contraseña se guardará en formato bcrypt y se almacenará en la base de datos.
  
  ![Captura de pantalla 2024-06-25 105237](https://github.com/Jorge-nafa/Foro_API/assets/162073905/08e38e18-7e48-4c92-ac24-bbdde35b7b26)

  `Login Usuario`: La función de login proporcionará un token JWT que permitirá acceder a las funciones del foro siempre y cuando el usuario esté registrado.
  
  ![Captura de pantalla 2024-06-25 105651](https://github.com/Jorge-nafa/Foro_API/assets/162073905/c01435a4-db21-46f1-9c6e-f56086a959c0)

  `Crear Foro`: La función crea un foro cuando recibe todos los parámetros indicados y lo guarda en la base de datos.
  
  ![Captura de pantalla 2024-06-25 110255](https://github.com/Jorge-nafa/Foro_API/assets/162073905/ec8de9e6-62e4-4549-902e-b26c37d05f10)

  `Listar Foros`: La función muestra todos los foros que se han creado, utilizando el formato de paginación y ordenándolos alfabéticamente.
  
  ![Captura de pantalla 2024-06-25 110557](https://github.com/Jorge-nafa/Foro_API/assets/162073905/fee484c6-3199-4f1f-8de0-15092266e8fa)

  `Modificar Foro`: La función modifica uno o más elementos del foro seleccionado, enviándole los elementos a modificar junto con el ID del foro. Muestra el foro modificado.
  
  ![Captura de pantalla 2024-06-25 111058](https://github.com/Jorge-nafa/Foro_API/assets/162073905/897bd7ec-dabf-48b8-855b-04fab0821852)

  `Eliminar Foro`: La función permite la eliminación lógica de un foro, enviando el ID del foro a eliminar.
  
  ![Captura de pantalla 2024-06-25 111358](https://github.com/Jorge-nafa/Foro_API/assets/162073905/a0b6268a-bedf-4ede-a582-c9a0a3281799)

  `Buscar Foro`:  La función busca un foro por su ID y lo muestra.

  ![Captura de pantalla 2024-06-25 111738](https://github.com/Jorge-nafa/Foro_API/assets/162073905/8d39176e-58a7-4785-94cc-13744ca215e6)

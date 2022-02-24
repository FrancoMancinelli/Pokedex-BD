# Pokedex con Base de Datos 	:computer:
## Información general :page_with_curl:
El repositorio cuenta con el código de una _Pokedex_ realizada en **Java Swing** vinculada a una **Base de Datos**. La misma cuenta con 3 Pokemones introducidos por defecto 🍃 🔥 💧 (Bulbasaur, Charmander y Squirtle).
Además cuenta con **5 vistas distintas**, todas ellas interactivas y vinculadas entre si. A continuación se señala cada una y sus funciones generales.
### 1️⃣ _LoginView_ 🔐
Esta es la ventana de inicio, desde donde podrás acceder a la Pokedex. Incluye 2 posibles interacciones:
- **Ingresar a la Pokedex** (Creara una PokedexView)
- **Registrar una cuenta nueva** (Creara un RegistroView) 
### 2️⃣ _RegistrarView_ 📝
La view de registro solo es accesible por medio del LoginView, sirve para registrar nuevos usuarios. Esta ventana cuenta con 2 interacciones:
- **Volver atrás** (Vuelve al LoginView)
- **Confirmar registro** (Creara un usuario en la base de datos y volvera a la LoginView)
### 3️⃣ _PokedexView_ 🖼️
Esta es la view principal del programa donde se encuentra lo relevante: Los Pokemones y sus Stats introducidos en un ArrayList, pero representados individualmente. En esta vista contaremos con 7 interacciones :
- **Borrar** (Borrará el Pokemon que se muestre en pantalla)
- **Actualizar** (Permitirá actualizar las Stats del Pokemon, exceptuando su imagen, nombre y número)
- **Crear** (Abrirá una CrearView, donde podremos crear un Pokemon nuevo y añadirlo)
- **Avanzar de pagina** (Mostrará el siguiente Pokemon almacenado en la Pokedex)
- **Retroceder de pagina** (Mostrará el anterior Pokemon almacenado en la Pokedex)
- **Salir** (Saldrá de la Pokedex y volverá al LoginView)
- **Gestion de cuenta** (Abrirá una ConfigView que permitirá al usuario cambiar sus datos e incluso borrar su cuenta)
### 4️⃣ _CrearView_ 🖌️
Aquí es donde podrás crear tantos Pokemones como desees. Aún no es posible ingresar una imagen de esté, por lo que se representará con una seleccionada por defecto). Esta view cuenta con 2 posibles interacciones
- **Crear** (Creara y añadirá un nuevo Pokemon a la base de datos y posterior a ello devolverá a la PokedexView)
- **Volver** (Volverá a la PokedexView sin guardar cambios)
### 5️⃣ _ConfigView_ ⚙️
Dicha vista, es donde se podrá gestionar la cuenta del usuario, desde cambiar sus datos hasta eliminar la misma. Cuenta con 4 interacciones:
- **Cambiar Nombre** (Permitirá al usuario cambiar su nombre por otro siempre que este no exista y cuente con los requisitos. Posterior a hacer el cambio volverá a la PokedexView)
- **Cambiar Password** (Permitirá al usuario cambiar su contraseña por otra siempre que cumpla con los requisitos. Posterior a hacer el cambio volverá a la PokedexView)
- **Borrar Cuenta** (Preguntará al usuario si esta seguro de la decisión, de ser así, eliminará la cuenta y volverá a la LoginView)
- **Volver** (Volverá a la PokedexView)

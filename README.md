# Pokedex con Base de Datos 	:computer:
## Información general :page_with_curl:
El repositorio cuenta con el código de una _Pokedex_ realizada en **Java Swing** vinculada a una **Base de Datos**. La misma cuenta con 3 Pokemones introducidos por defecto 🍃 🔥 💧 (Bulbasaur, Charmander y Squirtle).
Además cuenta con **5 vistas distintas**, todas ellas interactivas y vinculadas entre si. A continuación se señala cada una y sus funciones generales.
### 1️⃣ _LoginView_ 🔐
Esta es la ventana de inicio, desde donde podrás acceder a la Pokedex. Incluye 2 posibles interacciones:
- **Ingresar a la Pokedex** (Creara una PokedexView) [^1]
- **Registrar una cuenta nueva** (Creara un RegistroView) 
### 2️⃣ _RegistrarView_ 📝
La view de registro solo es accesible por medio del LoginView, sirve para registrar nuevos usuarios. Esta ventana cuenta con 2 interacciones:
- **Confirmar registro** (Creara un usuario en la base de datos y volvera a la LoginView) [^2]
- **Volver atrás** (Vuelve al LoginView)
### 3️⃣ _PokedexView_ 🖼️
Esta es la view principal del programa donde se encuentra lo relevante: Los Pokemones y sus Stats introducidos en un ArrayList, pero representados individualmente. En esta vista contaremos con 7 interacciones :
- **Borrar** (Borrará el Pokemon que se muestre en pantalla) [^3]
- **Actualizar** (Permitirá actualizar las Stats del Pokemon, exceptuando su imagen, nombre y número) 
- **Crear** (Abrirá una CrearView, donde podremos crear un Pokemon nuevo y añadirlo) [^4]
- **Avanzar y Retroceder de pagina** (Mostrará el siguiente o anterior Pokemon almacenado en la Pokedex) [^5]
- **Salir** (Saldrá de la Pokedex y volverá al LoginView)
- **Gestion de cuenta** (Abrirá una ConfigView que permitirá al usuario cambiar sus datos e incluso borrar su cuenta)
### 4️⃣ _CrearView_ 🖌️
Aquí es donde podrás crear tantos Pokemones como desees. Aún no es posible ingresar una imagen de esté, por lo que se representará con una seleccionada por defecto). Esta view cuenta con 2 posibles interacciones
- **Crear** (Creara y añadirá un nuevo Pokemon a la base de datos y posterior a ello devolverá a la PokedexView)  [^4]
- **Volver** (Volverá a la PokedexView sin guardar cambios)
### 5️⃣ _ConfigView_ ⚙️
Dicha vista, es donde se podrá gestionar la cuenta del usuario, desde cambiar sus datos hasta eliminar la misma. Cuenta con 4 interacciones:
- **Cambiar Nombre** (Permitirá al usuario cambiar su nombre por otro siempre que este no exista y cuente con los requisitos. Posterior a hacer el cambio volverá a la PokedexView) [^6]
- **Cambiar Password** (Permitirá al usuario cambiar su contraseña por otra siempre que cumpla con los requisitos. Posterior a hacer el cambio volverá a la PokedexView)
- **Borrar Cuenta** (Preguntará al usuario si esta seguro de la decisión, de ser así, eliminará la cuenta y volverá a la LoginView) [^7]
- **Volver** (Volverá a la PokedexView)

[^1]: El login comprobará que la información introducida en los campos coincida con los datos en la base de datos
[^2]: Al registrar un usuario, el nombre tendrá como requisito no contener espacios y estar compuesto por más de 4 caracteres como mínimo. Lo mismo aplica a la contraseña. Además el nombre de usuario deberá ser único.
[^3]: Al borrar un Pokemon, en caso de que la Pokedex quede vacia, se deshabilitará este botón y mostrará la Pokedex sin contenido
[^4]: Al crear o actualizar un Pokemon, el nombre de este no podrá estar ocupado por otro Pokemon y es requerido que la altura y peso sean números (permite decimales)
[^5]: Cuando la pagina llegue al último Pokemon, si se desea continuar a la pagina siguiente, volverá al primer Pokemon, generando así una rotación circular
[^6]: Al cambiar el nombre de usuario comprobará varios parametros antes de hacerlo, como que el nuevo nombre no sea igual al anterior, que no contenga espacios, que tenga una longitud mayor a 4 caracteres y que no este ocupado por otra persona. Con la contraseña aplicará condiciones similares, exceptuando la unicidad, ya que varios usuarios pueden poseer la misma contraseña. 
[^7]: Al seleccionar el borrado de cuenta, a la vez que sale un anuncio de confirmación, se mostrará un Pikachu triste a modo de meme.



# Centro_Pokemon

## Table Of Contents:
[Acerca de Centro Pokemon]()

[Instalación]()

[Uso]()

[limitaciones]()

## Acerca de Centro Pokemon
*Centro Pokemon* es la primera aplicación que desarrollé. El propósito de este proyecto fue implementar una GUI básica para manipular datos de Pokémon almacenados en la misma aplicación. Alrededor del proyecto se puede observar el uso de arreglos, matrices, coponentes visuales de JavaSwing y algunas otras librerias básicas de Java.

La aplicación esta diseñada con una arquitectura **Model–view–controller**(conocida usualmente como **MVC**). Donde el usuario interactua a través del GUI y proporciona instrucciones al controlador. El controlador después se encarga de modificar la informacíon de la *entidad* que representa (también llamada *modelo*). Finalmente se actualiza la *vista* con los nuevos datos para que el usuario pueda observarlos.

  ![](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/MVC-Process.svg/1200px-MVC-Process.svg.png "MVC model")
  
 ## Instalación

1. Descarga e instala [Java](https://www.java.com/)
2. Descarga el repositorio, ya sea que lo descargues o lo clones via Git o descargues Centro_Pokemon-master via GitHub.
3. Ejecuta el archivo `RUN.jar`

## Uso 

### Inicio

Al Abrir el programa, la primera ventana que observarás es la siguiente:

  ![](https://i.imgur.com/FO903cg.png "primera pantalla")
 
Aquí podrás rellenar algunos datos acerca del Centro Pokémon en específico. El programa usa los datos que proporciones aquí para generar una entidad representativa dentro de la aplicación. Una vez que hayan prorcionado la información necesaria, puedes continuar y presionar el botón *accept*.

### Pantalla Principal

  ![](https://i.imgur.com/QEcDxmw.png "panel principal")
  
Una vez dentro del sistema, la interfaz te proporciona: un panel en el que se muestran graficamente los objetos en una *caja* de Pokémon; dos etiquetas que te proporcionan información acerca del entrenador seleccionado actualmente; 8 botones para interactuar con el programa, de los cuales destacamos cuatro:

* make a Pokemon Inquiry:

  Esta opción te muestra una ventana desde la cual puedes acceder a toda la información acerca del Centro Pokemon. La ventana contiene 3 botones y una caja de texto. 

  El primer botón, *Print All Pokemon for Trainer* despliega una lista de todos los Pokémon del entrenador seleccionado, esto será particularmente útil a la hora de querer borrar Pokémon del usuario, pues necesitamos el nombre y apodo de aquel que queramos eliminar.

  El segundo botón imprime el nombre de todos los entrenadores registrados en el *Centro Pokémon*. Esto nos sirve para la siguiente funcionalidad de la pantalla principal.

  El tercer botón es un simple boton de regreso para volver a la pantalla principal.


* Change trainer

⋅⋅⋅Al presionar este botón abriras una ventana, la de *change trainer*. Aquí podras generar un nuevo entrenador si así lo deseas marcando la casilla *new trainer*. Si solo deseas visualizar los Pokémon de otro entrenador diferente al seleccionado actualmente, escribe su nombre en esta nueva ventana y presiona *Accept*.





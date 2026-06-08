aquí iré comentando lo que se hace en cada versión

bitacora del profe: estoy subiendo todos los cambios a github, así pueden ir chequeando todo

v2: 
se añade la clase cristal en sable, de esta manera se puede ver que se pueden seguir comunicando entre clases, además de que el buscar por jedi ahora si tiene sentido
esto ya que ahora hay un método que lo hace y no es un llamado de un for a la rápida.
también se editó el service de jedi que ahora recibe un objeto, además de que se creo el archivo SableExternoDTO que precisamente trae ese
objeto nuevo, ahora pueden recibir y modificar objetos de otros microservicios en su microservicio actual
también hay una v2 de la base de datos de sables, ya que sea agrega la nueva clase y se debe actualizar todo.

v3:
Se cambia el clásico application.properties por application.yml, este sigue el estándar de yaml, además de agregar perfiles, tanto dev
(desarrollo), test y prod (producción), tiene sus variables globales y nos permite estár listos para mantener nuestros microservicios andando.

v4:
Tomando en cuenta que nadie querrá iniciar los microservicios uno a uno, hice los siguientes script:
- iniciar-todo.bat : este se ejecuta en windows, se hace doble click y con eso ya ejecuta ambos microservicios 
- iniciar-todo.sh: este es para mac/linux, antes de usarlo hay que ejecutar chmod +x iniciar-todo.sh y luego ./iniciar.sh y así en la terminal se inician ambos códigos


# devops
Objetivo: El objetivo de este trabajo práctico es que los alumnos apliquen los conceptos y herramientas aprendidas en el curso de DevOps para crear un proceso de integración continua, entrega continua y despliegue automatizado[opcional] de una aplicación utilizando herramientas y prácticas de DevOps.

Parte 1: Creación de la Aplicación Crea una aplicación web simple en el lenguaje de programación de tu elección (por ejemplo, Node.js, Python, Go, etc). La aplicación debe tener al menos una página que muestre "Hola Mundo" o información similar. Asegúrate de que la aplicación tenga un sistema de pruebas unitarias (1 test unitario al menos). Armar Dockerfile para el lenguaje de programación elegido. Armar docker-compose y que levante el Dockerfile previo.
![image](https://github.com/bluscher/devops-up/assets/31459856/94fe9acd-cd51-46f4-9a28-ec3b1a61d030)


Parte 2: Configuración del Repositorio y CI: Crea un repositorio en GitHub (de preferencia GitHub) para la aplicación. Genera un archivo de configuración -dependiendo del CI que hayan elegido- que realice lo siguiente: Instale las dependencias de la aplicación. Ejecuta las pruebas unitarias. Ejecutar un build (caso que sea un lenguaje que no se buildee, puede ser un lint en vez de build) Correr el build del Dockerfile y subir la imagen a Docker Hub.
![image](https://github.com/bluscher/devops-up/assets/31459856/c9fbca7b-9ce6-48f2-9f32-f6737e396502)


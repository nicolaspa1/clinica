# Documentacion o Apuntes del Proyecto

## Arquitectura orientada al dominio

Esta adaptación de DDD principalmente se basa en tres capas:

La capa del **Dominio** que es nuestra lógica de negocio o todo lo que tenga que ver con nuestro negocio o nuestro
dominio del problema por ahí el nombre.

La capa de **Persistencia** que es la que va a contener toda nuestra conexión a base de datos a DAOs o a servicios
externos que almacenen nuestra data a nuestro repositorio no necesariamente son base de datos también puede ser con
algún tipo de otro tipo de guardado.

La capa de **Web** qué va a hacer todo nuestro punto de entrada y conexiones externas en este caso pues va a ser nuestro
punto de entrada a nuestros controladores y también podremos conectarnos a diversos microservicios si se usara spring
cloud.

### Flujo

**Web -> Persistencia -> Dominio**

### Verbos HTTP

| Verbo  |     Descripcion      |
|:-------|:--------------------:|
| Get    |  Obtiene un recurso  | 
| Post   |   Crea un recurso    | 
| Put    | Actualiza un recurso | 
| Delete |  Elimina un recurso  | 

**Clientes:** Para consumir el servicio se puede crear un front o usar postman,insomnia etc.

**Controlador:** Punto de entrada y retorno de datos que por medio de endpoints se va conectar a los servicios.Nos ayuda a interactuar con el sistema por medio de los verbo Http.En pocas palabras son los metodos o servicios que expone el sistema.

Buena Practica en el controlador hacer uso del ResponseEntity

**Servicio:** Es aqui donde esta toda la logica del negocio de nuestra aplicacion.

**Repositorios:** Son nuestro acceso a datos(enviar y recibir) a traves de los daos o repositorys



@Transactional: Define que los metodos sean atomicos y si en algun punto del metodo pasa algo inesperado realice rollback y hace que toda accion que se haya realizado se deshaga.

Diferencia entre un modelo y una entidad,la entidad es quien se va conectar con la base de datos,repositorio o almacenamiento de datos,Dynamo,NoSQL,GraphQL,React DB y que vaya a persistir nuestra informacion.El modelo es una clase instancia los atributos de las entidades,con el fin de no exponer la entidad ya que esto expondria nuestra base de datos y seria una mala practica.

Los modelos no necesariamente deben ser una representacion igual a las entidades si se quiere se pueden añadir **atributos de proyecccion**.
Modelo se usaria para mapear con la entidad

**Error:** Donde se manejan las excepciones de forma personalizada.Seria como un controlador de excepciones.

## Anotaciones
https://mvitinnovaciontecnologica.wordpress.com/2020/02/06/guia-de-anotaciones-de-spring-framework/

## Properties
https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html

## Importar archivo postman que se encuentra en el proyecto
\clinica\Clinica.postman_collection.json
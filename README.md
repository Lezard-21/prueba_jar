# Backend_Veterinaria :smiley_cat: :rage2: :skull:

Esta es una aplicación creada con maven, con el proposito de crear un backend de una pagina web, a continuacion se muestran las maneras para mandar las llamadas a la api mediante curl.

## Curl

#### clientes

El cliente es la cuenta con la que se autentica

##### obtener todos los clientes
    curl -X GET localhost:4567/api/clientes/get

##### obtener clientes por id
    curl -X GET localhost:4567/api/clientes/getbyId?id=[id del cliente]

##### agregar un cliente
    curl -X POST -d {nombre:" ",password:" "} localhost:4567/api/clientes/add

##### Modificar cliente
    curl -X PUT -d {id:"[id del cliente]",nombre:" ",password=" "} localhost:4567/api/clientes/modify

##### Eliminar cliente
    curl -X DELETE localhost:4567/api/clientes/remove/[id del cliente]

#### dueños 
    Se utilizo la palabra owners debido a que spark no reconoce la palabra dueños.

##### obtener todos los dueños
    curl -X GET localhost:4567/api/owners/get

##### obtener dueño por su id
    curl -X GET localhost:4567/api/owners/getbyId?id=[id del dueño]

##### agregar dueño
    curl -X POST -d {nombre:" ",telefono:" "} localhost:4567/api/clientes/add

##### modificar dueño
    curl -X PUT -d {id:"[id del dueño]",nombre:" ",telefono:" "} localhost:4567/api/owners/change

##### Eliminar dueño
    curl -X DELETE localhost:4567/api/owners/remove/ [id del dueño]

#### Animal 

Los animales son las mascotas

##### obtener todos los animales
    curl -X GET localhost:4567/api/animales/get

##### obtener animal por su id
    curl -X GET localhost:4567/api/animales/getbyId?id= [el id del animal]

##### agregar animal
    curl -X POST -d {especie="",nombre:"",id_dueño:"[id del dueño]"} localhost:4567/api/animales/add

##### modificar animal
    curl -X PUT -d {id:"[id del animal]",especie:"",nombre:"",id_dueño:"[id del dueño]"} localhost:4567/api/animales/change

##### Eliminar animal
    curl -X DELETE localhost:4567/api/animales/remove/ [el id del animal]

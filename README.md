Here's the documentation for the provided model and controller:

## How to use
In order to use the API you must have to instal MySql and MySqlWorkbench, also install JDK Java 17 in your PC.

# Database backup
In this link you will find the database backup: https://drive.google.com/drive/folders/1BNiIvHlgqOVqZVFOSLGqHvuujO1QX16r?usp=sharing 

# Updates
To generate recibos of pagares now you have the ```PUT``` endpoint ```pagare/printpagare/{id}``` this receives the id of the pagare that you want to generate and automatically it persist the RecibosGen related to the pagare,
# When you save a Prestamo it generates the Pagares related to it
## Ojo a tener en cuenta si se fijan en el diagrama de la base de datos notaran que al crearse un prestamo los pagares relacionados a ese prestamo el API los creara de manera automatica tomando en cuenta los datos que suministren en el body del request, cada pagare tendra un campo que se llama id_recibo_gen este campo sera nulo siempre y cuando el pagare no se haya generado o en otras palabras impreso con el siguiente ENDPOINT: 

```
/pagare/printpagare/{idPagare}

Este endpoint generara un registro en la tabla registro_gen que estara relacionado al pagare que acaba de generar y entonces el campo id_recibo_gen deja de ser null lo que significa que el pagare ha sido saldado, si tienen algun inconveniente con esta funcionalidad me dejan saber
```


# Consideraciones
### Cada controlador tiene los mismos endpoints a diferencia de los creados para ciertas operaciones que se definen mas abajo, tenga en cuenta que los endpoints principales siempre seran los siguientes presididos del nombre de la tabla ejemplo (/cliente/save), (/empresa/list), etc. Recordando que los enpoint /save/, /update/ y otros necesitan un json en su cuerpo, pero estos JSOn estaran detallados mas abajo en esta documentacion
```
/save: This endpoint creates a new object
/list: This endpoint lists all object.
/get/{id}: This endpoint gets a object by its ID.
/update/{id}: This endpoint updates a object by its ID.
/delete/{id}: This endpoint deletes a object by its ID.

```

## API Documentation:

### Model: Empresa

This are the endpoints to the empresa controller ```/empresa/(here goes the endpoint)```

```
In order to save /empresa/save
POST /save
{
  "nombre": "Acme Corporation",
  "direccion": "123 Main Street",
  "telefono": "123-456-7890",
  "email": "acme@example.com"
}

In order to get a list of empresas use /empresa/list
GET /list

In order to get a specific empresa use /empresa/get/{idEmpresa}
GET /get/1

PUT /update/1
In order to update an empresa use /empresa/update/{idEmpresa} and the following json structure
{
  "nombre": "Acme Corporation 2.0",
  "direccion": "456 Elm Street",
  "telefono": "555-678-9012",
  "email": "acme2@example.com"
}

To delete use /empresa/delete/{idEmpresa}
DELETE /delete/1 

```

### Model: User

| Field          | Type       | Description                    |
|----------------|------------|--------------------------------|
| idUsuario      | Long       | Unique identifier for the user  |
| usuario        | String     | User name                       |
| password       | String     | User password                   |
| estatus        | int        | User status                     |
| rol            | Rol        | User role                       |
| empresa        | Empresa    | User's associated company       |
| cobrador       | Cobrador   | User's associated cobrador      |


### Controllers

#### UserController

| HTTP Method | Endpoint        | Description                                                                                     |
|-------------|-----------------|-------------------------------------------------------------------------------------------------|
| POST        | usuario/login          | Logs in a user by verifying the provided username and password. Returns the user if successful. |
| POST        | usuario/save           | Saves a new user in the system.                                                                  |
| GET         | usuario/list           | Retrieves a list of all users.  |
| GET         | usuario/{id}           | Retrieves a user by their ID.   |
| PUT         | usuario/update/{id}    | Updates an existing user by their ID. |
| DELETE      | usuario/delete/{id}    | Deletes a user by their ID.           |

##### Method Details

###### POST /login

Logs in a user by verifying the provided username and password.

Request Body: `UsuarioLoginDTO`

| Field       | Type   | Description                   |
|-------------|--------|-------------------------------|
| usuario     | String | User name                     |
| password    | String | User password                 |

```
{
    "usuario":"carl01",
    "password": "123456"
}
```

Response:

- Returns `200 OK` with the user details if the login is successful.
- Returns `404 Not Found` if the login fails.

###### POST /save

Saves a new user in the system.

Request Body: `Usuario`

| Field       | Type       | Description                   |
|-------------|------------|-------------------------------|
| usuario     | String     | User name                     |
| password    | String     | User password                 |
| estatus     | int        | User status                   |
| rol         | Rol        | User role                     |
| empresa     | Empresa    | User's associated company     |
| cobrador    | Cobrador   | User's associated cobrador    |

```
{
  "usuario": "mustafa01",
  "password": "123456",
  "estatus": 1,
  "rol":{
      "idRol": 2
  },
  "empresa":{
      "idEmpresa":1
  },
  "cobrador":{
      "nombre":"Mustafa",
      "apellido":"Calimete",
      "cedula":"40422332223",
      "direccion":"Calle genral #41",
      "telefono":"8901221111",
      "fechaIngreso":"2023-05-23T13:01:03Z"
  }
} 

```

Response:

- Returns `200 OK` with the saved user details if the user is successfully created.
- Returns `200 OK` with an error message if the user already exists.

###### GET /list

Retrieves a list of all users.

Response:

- Returns `200 OK` with an array of `Usuario` objects representing all the users.

###### GET /{id}

Retrieves a user by their ID.

Path Parameter:

- id (Long): The unique identifier of the user.

Response:

- Returns `200 OK` with the `Usuario` object representing the user if found.
- Returns `404 Not Found` if the user is not found.

###### PUT /update/{id}

Updates an existing user by their ID.

Path Parameter:

- id (Long): The unique identifier of the user.

Request Body: `Usuario`

| Field       | Type       | Description                   |
|-------------|------------|-------------------------------|
|

 usuario     | String     | User name                     |
| password    | String     | User password                 |
| estatus     | int        | User status                   |
| rol         | Rol        | User role                     |
| empresa     | Empresa    | User's associated company     |
| cobrador    | Cobrador   | User's associated cobrador    |


Response:

- Returns `200 OK` with the updated user details if the update is successful.
- Returns `200 OK` with an error message if the user already exists.

###### DELETE /delete/{id}

Deletes a user by their ID.

Path Parameter:

- id (Long): The unique identifier of the user.

Response:

- Returns `200 OK` if the user is successfully deleted.


### Model: Ruta

| Field         | Type       | Description                        |
|---------------|------------|------------------------------------|
| idRuta        | Long       | Unique identifier for the route     |
| nombre        | String     | Name of the route                   |
| dia           | String     | Day of the route                    |
| zona          | Zona       | Zone associated with the route      |
| clientes      | List       | List of clients associated with the route |
| cobrador      | Cobrador   | Cobrador associated with the route  |


### Controllers

#### RutaController

| HTTP Method | Endpoint        | Description                                                                                     |
|-------------|-----------------|-------------------------------------------------------------------------------------------------|
| POST        | ruta/save           | Saves a new route in the system.                                                                 |
| GET         | ruta/list           | Retrieves a list of all routes.                                                                  |
| GET         | ruta/{id}           | Retrieves a route by its ID.                                                                     |
| PUT         | ruta/update/{id}    | Updates an existing route by its ID.                                                             |
| DELETE      | ruta/delete/{id}    | Deletes a route by its ID.                                                                       |

##### Method Details

###### POST /save

Saves a new route in the system.

Request Body: `Ruta`

| Field       | Type       | Description                        |
|-------------|------------|------------------------------------|
| nombre      | String     | Name of the route                   |
| dia         | String     | Day of the route                    |
| zona        | Zona       | Zone associated with the route      |
| clientes    | List       | List of clients associated with the route |
| cobrador    | Cobrador   | Cobrador associated with the route  |

```
{
    "nombre":"Matancita",
    "dia":"LUNES",
    "zona":{
        "idZona":1
    },
    "cobrador":{
        "idCobrador":3
    }

}
```

Response:

- Returns `200 OK` with the saved route details.

###### GET /list

Retrieves a list of all routes.

Response:

- Returns `200 OK` with an array of `Ruta` objects representing all the routes.

###### GET /{id}

Retrieves a route by its ID.

Path Parameter:

- id (Long): The unique identifier of the route.

Response:

- Returns `200 OK` with the `Ruta` object representing the route if found.
- Returns `404 Not Found` if the route is not found.

###### PUT /update/{id}

Updates an existing route by its ID.

Path Parameter:

- id (Long): The unique identifier of the route.

Request Body: `Ruta`

| Field       | Type       | Description                        |
|-------------|------------|------------------------------------|
| nombre      | String     | Name of the route                   |
| dia         | String     | Day of the route                    |
| zona        | Zona       | Zone associated with the route      |
| clientes    | List       | List of clients associated with the route |
| cobrador    | Cobrador   | Cobrador associated with the route  |

Response:

- Returns `200 OK` with the updated route details.

###### DELETE /delete/{id}

Deletes a route by its ID.

Path Parameter:

- id (Long): The unique identifier of the route.

Response:

- Returns `200 OK` if the route is successfully deleted.

Here's the documentation for the third module:

### Model: Cliente

| Field             | Type              | Description                                |
|-------------------|-------------------|--------------------------------------------|
| idCliente         | Long              | Unique identifier for the client            |
| nombre            | String            | First name of the client                    |
| apellido          | String            | Last name of the client                     |
| cedula            | String            | Identification number of the client         |
| direccion         | String            | Address of the client                       |
| fechaNacimiento   | LocalDateTime    | Date of birth of the client                 |
| lugarTrabajo      | String            | Workplace of the client                     |
| telTrabajo        | String            | Work phone number of the client             |
| celular           | String            | Cellphone number of the client              |
| telResidencia     | String            | Home phone number of the client             |
| email             | String            | Email address of the client                 |
| ocupacion         | String            | Occupation of the client                    |
| recomendado       | String            | Recommended by                             |
| observaciones     | String            | Observations or notes about the client      |
| fechaIngreso      | LocalDateTime    | Date of client's registration               |
| estatus           | int               | Client status (active, inactive, etc.)      |
| prestamos         | List              | List of loans associated with the client    |
| ruta              | Ruta              | Route associated with the client            |


### Controllers

#### ClienteController

| HTTP Method | Endpoint        | Description                                                                                     |
|-------------|-----------------|-------------------------------------------------------------------------------------------------|
| POST        | cliente/save           | Saves a new client in the system.                                                                 |
| GET         | cliente/list           | Retrieves a list of all clients.                                                                 |
| GET         | cliente/{id}           | Retrieves a client by its ID.                                                                    |
| PUT         | cliente/update/{id}    | Updates an existing client by its ID.                                                            |
| DELETE      | cliente/delete/{id}    | Deletes a client by its ID.                                                                      |

##### Method Details

###### POST /save

Saves a new client in the system.

Request Body: `Cliente`

| Field           | Type            | Description                                |
|-----------------|-----------------|--------------------------------------------|
| nombre          | String          | First name of the client                    |
| apellido        | String          | Last name of the client                     |
| cedula          | String          | Identification number of the client         |
| direccion       | String          | Address of the client                       |
| fechaNacimiento | LocalDateTime  | Date of birth of the client                 |
| lugarTrabajo    | String          | Workplace of the client                     |
| telTrabajo      | String          | Work phone number of the client             |
| celular         | String          | Cellphone number of the client              |
| telResidencia   | String          | Home phone number of the client             |
| email           | String          | Email address of the client                 |
| ocupacion       | String          | Occupation of the client                    |
| recomendado     | String          | Recommended by                             |
| observaciones   | String          | Observations or notes about the client      |
| fechaIngreso    | LocalDateTime  | Date of client's registration               |
|

 estatus         | int             | Client status (active, inactive, etc.)      |
| prestamos       | List            | List of loans associated with the client    |
| ruta            | Ruta            | Route associated with the client            |

```
{
  "nombre": "John",
  "apellido": "Doe",
  "cedula": "123456789",
  "direccion": "123 Main St",
  "fechaNacimiento": "2023-05-24T10:30:00",
  "lugarTrabajo": "ABC Company",
  "telTrabajo": "555-123-456",
  "celular": "555-987-654",
  "telResidencia": "555-789-123",
  "email": "john.doe@example.com",
  "ocupacion": "Engineer",
  "recomendado": "Jane Smith",
  "observaciones": "Some observations",
  "fechaIngreso": "2023-05-24T12:00:00",
  "estatus": 1,
  "prestamos": [],
  "ruta": {
    "idRuta": 4
  }
}
```

###### GET /list

Retrieves a list of all clients.

Response: List of `Cliente`

###### GET /{id}

Retrieves a client by its ID.

Path Parameters:

| Parameter | Type | Description         |
|-----------|------|---------------------|
| id        | Long | ID of the client    |

Response: `Cliente`

###### PUT /update/{id}

Updates an existing client by its ID.

Path Parameters:

| Parameter | Type | Description         |
|-----------|------|---------------------|
| id        | Long | ID of the client    |

Request Body: `Cliente`

| Field           | Type            | Description                                |
|-----------------|-----------------|--------------------------------------------|
| nombre          | String          | First name of the client                    |
| apellido        | String          | Last name of the client                     |
| cedula          | String          | Identification number of the client         |
| direccion       | String          | Address of the client                       |
| fechaNacimiento | LocalDateTime  | Date of birth of the client                 |
| lugarTrabajo    | String          | Workplace of the client                     |
| telTrabajo      | String          | Work phone number of the client             |
| celular         | String          | Cellphone number of the client              |
| telResidencia   | String          | Home phone number of the client             |
| email           | String          | Email address of the client                 |
| ocupacion       | String          | Occupation of the client                    |
| recomendado     | String          | Recommended by                             |
| observaciones   | String          | Observations or notes about the client      |
| fechaIngreso    | LocalDateTime  | Date of client's registration               |
| estatus         | int             | Client status (active, inactive, etc.)      |
| prestamos       | List            | List of loans associated with the client    |
| ruta            | Ruta            | Route associated with the client            |

Response: Updated `Cliente`

###### DELETE /delete/{id}

Deletes a client by its ID.

Path Parameters:

| Parameter | Type | Description         |
|-----------|------|---------------------|
| id        | Long | ID of the client    |

Response: Success message

Here's the documentation for the fourth module:

### Model: Prestamo

| Field        | Type            | Description                                |
|--------------|-----------------|--------------------------------------------|
| idPrestamo   | Long            | Unique identifier for the loan              |
| fecha        | LocalDateTime  | Date of the loan                           |
| monto        | double          | Loan amount                                |
| tipoPrestamo | String          | Type of loan                               |
| vencimiento  | LocalDateTime  | Loan due date                              |
| interes      | double          | Loan interest rate                         |
| cuotas       | int             | Number of installments                      |
| estado       | int             | Loan status (anulled, active, etc.)         |
| pagares      | List            | List of promissory notes associated with the loan |
| cliente      | Cliente         | Client associated with the loan            |


### Controllers

#### PrestamoController

| HTTP Method | Endpoint        | Description                                                                                       |
|-------------|-----------------|---------------------------------------------------------------------------------------------------|
| POST        | prestamo/save           | Saves a new loan in the system.                                                                    |
| GET         | prestamo/list           | Retrieves a list of all loans.                                                                    |
| GET         | prestamo/{id}           | Retrieves a loan by its ID.                                                                       |
| PUT         | prestamo/update/{id}    | Updates an existing loan by its ID.                                                               |
| DELETE      | prestamo/delete/{id}    | Deletes a loan by its ID.                                                                         |

##### Method Details

###### POST /save

Saves a new loan in the system.

Request Body: `Prestamo`

| Field           | Type            | Description                                |
|-----------------|-----------------|--------------------------------------------|
| fecha           | LocalDateTime  | Date of the loan                           |
| monto           | double          | Loan amount                                |
| tipoPrestamo    | String          | Type of loan                               |
| vencimiento     | LocalDateTime  | Loan due date                              |
| interes         | double          | Loan interest rate                         |
| cuotas          | int             | Number of installments                      |
| anulado         | int             | Loan status (anulled, active, etc.)         |
| pagares         | List            | List of promissory notes associated with the loan |
| cliente         | Cliente         | Client associated with the loan            |


```
{
  "fecha": "2023-05-24T10:30:00",
  "monto": 3000,
  "tipoPrestamo": "SEMANAL_13",
  "vencimiento": "2023-06-24T10:30:00",
  "interes": 900,
  "cuotas": 13,
  "estado": 0,
  "pagares": [],
  "cliente":{
      "idCliente":1
  }
}

```

Response: Saved `Prestamo`

###### GET /list

Retrieves a list of all loans.

Response: List of `Prestamo`

###### GET /{id}

Retrieves a loan by its ID.

Path Parameters:

| Parameter | Type | Description    |
|-----------|------|----------------|
| id        | Long | ID of the loan |

Response: `Prestamo`

###### PUT /update/{id}

Updates an existing loan by its ID.

Path Parameters:

| Parameter | Type | Description    |
|-----------|------|----------------|
| id        | Long | ID of the loan |

Request Body: `Prestamo`

| Field           | Type           | Description                                |
|-----------------|----------------|--------------------------------------------|
| fecha           | LocalDateTime  | Date of the loan                           |
| monto           | double         | Loan amount                                |
| tipoPrestamo    | String         | Type of loan                               |
| vencimiento     | LocalDateTime  | Loan due date                              |
| interes         | double         | Loan interest rate                         |
| cuotas          | int            | Number of installments                      |
| anulado         | int            | Loan status (anulled, active, etc.)         |
| pagares         | List           | List of promissory notes associated with the loan |
| cliente         | Cliente        | Client associated with the loan            |

Response: Updated `Prestamo`

###### DELETE /delete/{id}

Deletes a loan by its ID.

Path Parameters:

| Parameter | Type | Description    |
|-----------|------|----------------|
| id        | Long | ID of the loan |

Response: Success message




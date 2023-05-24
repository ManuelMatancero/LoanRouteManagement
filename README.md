Here's the documentation for the provided model and controller:

## API Documentation:

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

| Field           | Type            | Description                                |
|-----------------|-----------------|--------------------------------------------|
| idPrestamo      | Long            | Unique identifier for the loan              |
| fecha           | LocalDateTime  | Date of the loan                           |
| monto           | double          | Loan amount                                |
| tipoPrestamo    | String          | Type of loan                               |
| vencimiento     | LocalDateTime  | Loan due date                              |
| interes         | double          | Loan interest rate                         |
| cuotas          | int             | Number of installments                      |
| anulado         | int             | Loan status (anulled, active, etc.)         |
| pagares         | List            | List of promissory notes associated with the loan |
| cliente         | Cliente         | Client associated with the loan            |


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
  "anulado": 0,
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




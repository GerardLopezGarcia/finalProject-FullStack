# finalProject-FullStack


![image](https://user-images.githubusercontent.com/72072309/205083754-e000dd47-8302-4cf8-9791-33826d9d9bf9.png)

> Este proyecto cuenta con  Backend + Microservice + Frontend y  ha sido desarrollado con Java, MySQL, Spring y Vue3!🐱‍💻



## UML del Proyecto

![image](https://user-images.githubusercontent.com/72072309/211335405-31b2ed5f-b4e3-404c-921c-8f70affa27f0.png)


## Diagrama de Clases

![image](https://user-images.githubusercontent.com/72072309/211338765-7eaed921-ad26-4f9d-92b1-b2796ff94ad7.png)

## Rutas del proyecto

Rutas disponibles para postman

| roles  | ruta | metodo |roles  | ruta | metodo |
| ------------- | ------------- | ------------- |------------- | ------------- | ------------- |
| -   | "/users"  | GET  | -   | "/houses/{id}"  | GET  |
| -  | "/guestusers" | GET  | -   | "/houses/{tag}"" | GET  |
| -  | "/admins" | GET  | -   | "/houses/{price}""  | GET  |
| -  | "/guestusers/{name}" | GET  | -   | "/houses/{score}""  | GET  |
| -  | "/users" | POST  | -   | "/houses/{guest_user}""  | GET  |
| -  | "/guestusers" | POST  | - | "/houses/{country}""  | GET  |
| - | "/admins" | POST  | -| "/houses/{houseAddress}""  | GET  |
| -| "/guestusers/{name}" | DELETE  |- | "/houses"  | POST  |
| -  | "/admins/{name}" | DELETE  | - | "/houses/{id}" | DELETE  |
| -  | "/users/{name}" | DELETE  | -   | "/houses/{id}"  | PATCH  |
| -  | "/guestusers/{name}" | PATCH  |
| -  | "/houses" | GET  | 

## Bonus

Proyecto desplegado en los servidores de *Supabase*
Para acceder hay que añadir en los headers:

>  apikey = eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imd2b21zZmlueXhmcm1jc2N4eW5kIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzMzMzk2NTAsImV4cCI6MTk4ODkxNTY1MH0.Bw1RQX8h386Yldtyc2YPL9WlZN9X68nIKU-jpDrr0VU

> Authorization = Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imd2b21zZmlueXhmcm1jc2N4eW5kIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzMzMzk2NTAsImV4cCI6MTk4ODkxNTY1MH0.Bw1RQX8h386Yldtyc2YPL9WlZN9X68nIKU-jpDrr0VU

Y podremos acceder a toda la base de datos , se añade como ejemplo las siguientes rutas:

GET

'https://gvomsfinyxfrmcscxynd.supabase.co/rest/v1/house?select=*'   | GET '/houses'
'https://gvomsfinyxfrmcscxynd.supabase.co/rest/v1/user?select=*'    | GET '/users'
'https://gvomsfinyxfrmcscxynd.supabase.co/rest/v1/user?select=name' | GET '/users/{name}'

POST

'https://gvomsfinyxfrmcscxynd.supabase.co/rest/v1/house'   | POST '/house'

DELETE
'https://gvomsfinyxfrmcscxynd.supabase.co/rest/v1/house?some_column=eq.someValue'  | DELETE '/house/{id}

![image](https://user-images.githubusercontent.com/72072309/211518416-0c82b923-f875-4c64-81e1-163b1abf6b15.png)


Usuarios
Listado de contraseñas y cuentas para acceder 

| Usuario  | Contraseña | 
| ------------- | ------------- | 
| mujerilusionada | ironhack1  | 
| padresconhijos | ironhack2  |
| grupodeamigos  | ironhack3  | 
| estudianteindeciso  | ironhack4 | 
| reciencasados  | ironhack  | 



## Setup

- Fork this repo
- Clone this repo


## Autor
El proyecto ha sido realizado por:

(☞ﾟヮﾟ)☞   [Gerard López](https://github.com/GerardLopezGarcia)   ☜(ﾟヮﾟ☜)


# inditex-manuel-martin


### ***Para poder visualizar correctamente el proyecto, se debe descargar el plugin de Lombok en el IDE.***

Librearias utilizadas:
- Spring Boot.
- Spring Data.
- StructMap.
- Lombok
- Junit 5
- H2
- Flyaway



***El formato de fecha debe ser el siguiente:***  
> yyyy-MM-dd HH:mm:ss

## **Curl de prueba en consola:**

``` curl -G http://localhost:8080/brand/1/product/35455 --data-urlencode "date=2020-06-15 21:00:00" ```

## **Curl de prueba en Postman:**

``` http://localhost:8080/brand/1/product/35455?date=2020-06-15 21:00:00 ```


### ***Posibles respuestas:***

**200 OK:**
```
{
    "productId": 35455,
    "brandId": 1,
    "price": 38.95,
    "priceList": 4
}
```
**400 BAD REQUEST:**

***Si el formato de fecha enviado es inválido:***
```
{
    "message": "Formato de fecha invalido, yyyy-MM-dd HH:mm:ss",
    "httpStatus": "BAD_REQUEST",
    "zonedDateTime": "2021-10-10T19:14:43.309Z"
}
```

***Si la fecha enviada no se encuentra en la base de datos:***
```
{
    "message": "No se encontro el producto.",
    "httpStatus": "BAD_REQUEST",
    "zonedDateTime": "2021-10-10T19:16:12.878Z"
}
```





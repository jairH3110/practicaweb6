package org.uv.DSWebPractica06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsWebPractica06Application {

	public static void main(String[] args) {
		SpringApplication.run(DsWebPractica06Application.class, args);
	}

}

/*

Consulta en postgresql:

SELECT * FROM public.empleado
ORDER BY id ASC

Consulta en postman:

post http://localhost:8080/api/empleado/
body
{
    "nombre": "mayra",
    "direccion":"av. 4",
    "telefono":"5555"
}

return with id assigned.


*/
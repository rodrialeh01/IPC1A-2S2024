Proceso Ingreso_nota_estudiantes
	Definir contador_estudiantes Como Entero;
	Definir nombre Como Cadena;
	Definir carnet Como Cadena;
	Definir nota Como Entero;
	contador_estudiantes <- 1;
	Mientras contador_estudiantes <= 4 Hacer
		Escribir "Ingrese el nombre del estudiante";
		Leer nombre;
		Escribir "Ingrese el carnet del estudiante";
		Leer carnet;
		Escribir "Ingrese la nota del estudiante";
		Leer nota;
		Si nota >=61 Entonces
			Escribir "EL ESTUDIANTE ", nombre ," APROBÓ EL CURSO";
		SiNo
			Escribir "EL ESTUDIANTE ", nombre ," REPROBÓ EL CURSO";
		FinSi
		contador_estudiantes <- contador_estudiantes + 1;
	FinMientras
FinProceso
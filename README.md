# mutantes
Ejecicio de Mutantes para ML

## Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Installation](#installation)
4. [Collaboration](#collaboration)
5. [FAQs](#faqs)
## General Info
***
Es el proyecto para Mutantes con rest Api, donde se debe indicar si el ADN es de Humano o Mutante y las estatisticas de los mismos.

Se creo con Netbeans las Rest APi y se trabajo principalmente el una clase MutantResource.java  de recursos que contenia los metodos mas importantes.
entre los que estan:

postJson() para el punto 1  y 2
estos con notacion rest asi en el proyecto Local.

http://localhost:8080/MutantApiRestDNA/webresources/mutant/mutant

stats() para el punto 3.
http://localhost:8080/MutantApiRestDNA/webresources/mutant/stats
sobre el que se realizaron pruebas SOAPIU. (https://drive.google.com/file/d/1BSkjwIgV6OBQI2EuUXln-GApBmlbfBNs/view?usp=sharing) o ver el word en esta ruta

Se realizaron pruebas unitaris Junit en el archivo 

dnatest.java
queriendo tener covertura de codigo de mas del 80%

Nota: Punto 1: el metodo isMutant() valida si es mutante y devuelte true si lo es y Falso si es Humano.
este metodo utiliza una validacionHorizontal(), con expresion regular de AAAA o CCCC o GGGG o TTTT

para verificar verticalmente se hace una trasnposicion o conversion a horizontaly se vuelve a reutilizar validacionHorizontal()

Finalmente la validacionDiagonal se realiza convirtiendo a una matriz de caracteres.

si alguna de estas es true se considera gen Mutante.



## Technologies
***
Una Lista de tecnologia usadas en el proyecto.
* [J2EE](https://www.java.com/download/ie_manual.jsp): Version 1.8.0.291 
* [Apache NetBeans IDE 12.3](https://netbeans.apache.org/): Version 12.3
* [Jboss servidor de aplicaciones Red Hat JBoss Enterprise Application Platform - Version 7.4.0.Beta](https://developers.redhat.com/products/eap/download): Version 7.4.0
* [Postgresql como base de datos con JTA](https://www.postgresql.org): Version postgresql-42.2.18
* [SOAP UI 5.6. 0para prueba con JSON](http://www.soapui.org ): Version 5.6.0
## Installation
***
Se debe desplegar el WAR en un Jboss con base de datos postgres.
se dejo el source compartido con el War. No se dejo el proyectos de Netbeans porque excedia los 100 Archivos.

```

```
Se utilizo aws beantalk para dejar alli este punto war y hacerlo accesible al publico, pero no paso las configuraciones iniciales.
ver documento en el siguiente link. (https://drive.google.com/file/d/1BSkjwIgV6OBQI2EuUXln-GApBmlbfBNs/view?usp=sharing) o ver el word en esta ruta
tambien se intento con Apigateway una funcion lambda java que utilizara la clase de MutantResource pero no pudo encontrarla.

Adicionalmente se incluye la carpeta del proyecto en netbeans en el siguiente link. (https://drive.google.com/drive/folders/18GYb6cg9P8XHm4jsYXiSQnH_yWXbves4?usp=sharing)
## Collaboration
***

## FAQs
***


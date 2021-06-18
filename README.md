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
sobre el que se realizaron pruebas SOAPIU. (https://drive.google.com/file/d/1BSkjwIgV6OBQI2EuUXln-GApBmlbfBNs/view?usp=sharing)



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
ver documento en el siguiente link. (https://drive.google.com/file/d/1BSkjwIgV6OBQI2EuUXln-GApBmlbfBNs/view?usp=sharing)

Adicionalmente se incluye la carpeta del proyecto en netbeans en el siguiente link. (https://drive.google.com/drive/folders/18GYb6cg9P8XHm4jsYXiSQnH_yWXbves4?usp=sharing)
## Collaboration
***

## FAQs
***
A list of frequently asked questions
1. **This is a question in bold**
Answer of the first question with _italic words_. 
2. __Second question in bold__ 
To answer this question we use an unordered list:
* First point
* Second Point
* Third point
3. **Third question in bold**
Answer of the third question with *italic words*.
4. **Fourth question in bold**
| Headline 1 in the tablehead | Headline 2 in the tablehead | Headline 3 in the tablehead |
|:--------------|:-------------:|--------------:|
| text-align left | text-align center | text-align right |

@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n10_mapaCiudad
REM Autor: Daniel Francisco Romero Acero - 25-ene-2006
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

REM ---------------------------------------------------------
REM Ejecucion del programa
REM ---------------------------------------------------------

cd..
java -ea -classpath ./lib/mapaCiudad.jar uniandes.cupi2.mapaCiudad.interfaz.InterfazMapaCiudad
cd bin
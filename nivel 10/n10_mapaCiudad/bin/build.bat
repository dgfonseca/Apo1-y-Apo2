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
REM Asegura la creación de los directorios classes y lib
REM ---------------------------------------------------------

cd ..
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directorio source
REM ---------------------------------------------------------
cd source
javac -d ../classes/ uniandes/cupi2/mapaCiudad/mundo/*.java
javac -d ../classes/ uniandes/cupi2/mapaCiudad/interfaz/*.java

REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ..
cd classes
jar cf ../lib/mapaCiudad.jar uniandes/*

cd ../bin

pause

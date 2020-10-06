@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogota - Colombia)
REM Departamento de Ingeniería de Sistemas y Computacion
REM Todos los derechos reservados 2005
REM
REM Proyecto Cupi2
REM Ejercicio: partitura
REM Autor: Diana Puentes - 29-Jul-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

SET CLASSPATH=
REM ---------------------------------------------------------
REM Asegura la creación de los directorios classes y lib
REM ---------------------------------------------------------

cd ..
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directotio source
REM ---------------------------------------------------------

cd source
javac -target 1.5 -source 1.5 -nowarn -d ../classes/ uniandes/cupi2/partitura/mundo/*.java
javac -target 1.5 -source 1.5 -nowarn -d ../classes/ uniandes/cupi2/partitura/interfaz/*.java


REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ..
cd classes
jar cf ../lib/partitura.jar uniandes/*

cd ..\bin

pause

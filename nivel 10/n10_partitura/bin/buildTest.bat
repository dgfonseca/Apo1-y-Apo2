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

cd ../test
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directotio test/source
REM ---------------------------------------------------------

cd ..\test\source

javac -classpath ../../lib/partitura.jar;../lib/junit.jar -d ../classes/ uniandes/cupi2/partitura/test/*.java

REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ..\classes

jar cf ../lib/partituraTest.jar uniandes/* -C ../data .

cd ..\..\bin

pause

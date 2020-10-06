@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n
REM Todos los derechos reservados 2005
REM
REM Proyecto Cupi2
REM Ejercicio: n10_paint
REM Autor: Mario S�nchez - 07-octubre-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/


REM ---------------------------------------------------------
REM Asegura la creaci�n de los directorios classes y lib
REM ---------------------------------------------------------

cd ..
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directotio source
REM ---------------------------------------------------------

cd source
javac -target 1.4 -source 1.4 -nowarn -d ../classes/ uniandes/cupi2/paint/mundo/*.java
javac -target 1.4 -source 1.4 -nowarn -d ../classes/ uniandes/cupi2/paint/interfaz/*.java


REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ..
cd classes
jar cf ../lib/paint.jar uniandes/*

cd ..\bin

pause

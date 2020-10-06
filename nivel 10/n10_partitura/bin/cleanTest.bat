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

REM ---------------------------------------------------------
REM Borra todos los archivos generados por el build
REM ---------------------------------------------------------

cd ..\test
del classes\* /s /q 
del lib\partituraTest.jar /s /q 

cd ..\bin

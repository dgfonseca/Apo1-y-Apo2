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
REM Ejecucion de la prueba
REM Archivo de ejecucion: partituraTest.jar
REM ---------------------------------------------------------

cd..

java -classpath ./lib/partitura.jar;./test/lib/partituraTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.partitura.test.PartituraTest
java -classpath ./lib/partitura.jar;./test/lib/partituraTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.partitura.test.NotaTest

cd bin

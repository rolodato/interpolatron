Interpolatrón
=============

Trabajo Práctico de Matemática Superior, UTN Regional Buenos Aires.

Es una calculadora de polinomios interpoladores utilizando el método de Newton-Gregory de diferencias divididas
progresivas y regresivas.

Integrantes
-----------

* Tomás Gropper ([tomasgropper](http://github.com/tomasgropper))
* Rodrigo López Dato ([rolodato](http://github.com/rolodato))
* Cristian García ([cristiann91](http://github.com/cristiann91))

Requisitos
----------

Puede correrse en cualquier plataforma que tenga instalado un entorno Java.

Instalación
-----------

Ejecutar `mvn install` para generar un archivo .exe para Windows y un .jar ejecutable en cualquier plataforma.

Para ejecutar el .jar directamente:

    java -Djava.system.class.loader=com.uqbar.apo.APOClassLoader -jar interpolatron*shaded.jar
    
Tecnologías utilizadas
----------------------

* Scala
* Maven (con [maven-shade-plugin](http://maven.apache.org/plugins/maven-shade-plugin/) y [launch4j](http://launch4j.sourceforge.net/))
* [Arena UI](http://code.google.com/p/uqbar-arena/)

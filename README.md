# Proyecto con ejemplos de proyecciones en Java Spring Boot

## Descripción

Este proyecto contiene ejemplos de proyecciones en Java Spring Boot y Gradle.

## Ejecución

Para ejecutar el proyecto, es necesario tener instalado Java 8 y Gradle. Luego, ejecutar el siguiente comando:

```bash
gradle bootRun
```

## Uso de Querys

```bash
http://localhost:8080/subastas/2?projection=persona
```

```bash
http://localhost:8080/subastas/2?projection=metodosDePago
```

```bash
http://localhost:8080/subastas/2?projection=simple
```

```bash
http://localhost:8080/subastas/2?projection=detailed
```
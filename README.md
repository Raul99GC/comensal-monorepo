# Comensal

Plataforma de microservicios para medir la satisfacción del servicio de comedor en empresas: tablets en modo kiosco capturan encuestas (también sin conexión), un panel administra las preguntas y un servicio de analítica entrega estadísticas y alertas.

Proyecto de portafolio. Todos los nombres, datos y URLs son ficticios.

## Stack base

| Componente   | Versión           |
| ------------ | ------------------ |
| Java         | 21                 |
| Spring Boot  | 4.1.1              |
| Spring Cloud | 2025.1.3 (Oakwood) |
| Maven        | 3.9 o superior     |

## Estructura

```text
comensal/
├─ pom.xml              POM padre (versiones y BOM de Spring Cloud)
├─ libs/                Librerías compartidas (comensal-commons)
├─ infra-services/      config-server, discovery-server, api-gateway
├─ services/            Microservicios de negocio
├─ frontend/            admin-web y kiosco-pwa
├─ infra/               docker, keycloak, grafana, k8s
└─ docs/                adr, api, diagramas
```

## Convenciones de nombres

| Elemento        | Regla                                                          | Ejemplo                                       |
| --------------- | -------------------------------------------------------------- | --------------------------------------------- |
| groupId         | Igual para todos los módulos                                  | `io.github.tuusuario.comensal`              |
| artifactId      | kebab-case, igual a la carpeta y a `spring.application.name` | `organizacion-service`                      |
| Paquete         | groupId + palabra corta del módulo                            | `io.github.tuusuario.comensal.organizacion` |
| Clase principal | PascalCase + `Application`                                   | `OrganizacionServiceApplication`            |
| Versión        | SemVer, heredada del padre al inicio                           | `0.1.0-SNAPSHOT`                            |

## Agregar un módulo

1. Generar el servicio en Spring Initializr con el groupId, artifactId y paquete de la tabla anterior (Java 21, YAML).
2. Copiarlo dentro de `services/` (o `infra-services/`).
3. En su `pom.xml`, cambiar el `<parent>` a `comensal-parent` con `<relativePath>../../pom.xml</relativePath>` y quitar `java.version` y la versión de Spring Cloud.
4. Agregar el módulo en la sección `<modules>` del padre.

## Compilar

```bash
mvn clean verify
```

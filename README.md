# Cuestionario: Fundamentos de Java (Paquetes, Imports y Documentación)

Este repositorio contiene las respuestas consolidadas sobre conceptos esenciales en Java: organización mediante paquetes, directivas de importación, estructura de directorios y estándares de documentación con Javadoc.

---

## 👥 Integrantes

* **Rafael Domínguez Jiménez**
* **Diego Torres Cartas**

📅 **Fecha:** 06/10/2026

---

## 📝 Preguntas y Respuestas

### 1. ¿Para qué sirve `package`?
Agrupa clases e interfaces relacionadas dentro de un mismo espacio de nombres. Cumple dos funciones clave:
* **Evitar conflictos de nombres:** Permite que dos clases tengan el mismo nombre sin colisionar, siempre que pertenezcan a paquetes distintos.
* **Control de acceso:** Gestiona los niveles de visibilidad a nivel de paquete (*package-private* y *protected*).

---

### 2. ¿Para qué sirve `import`?
Permite hacer referencia a clases, interfaces o miembros estáticos de otros paquetes utilizando únicamente su nombre simple (por ejemplo, `Scanner` o `List`), evitando la necesidad de escribir su nombre plenamente calificado en cada uso (por ejemplo, `java.util.Scanner`). Actúa como un atajo sintáctico para el compilador; no carga código adicional en tiempo de ejecución.

---

### 3. ¿Qué relación existe entre paquete y directorio?
Existe una **correspondencia directa y obligatoria** impuesta por el compilador y la máquina virtual de Java (JVM):
* La jerarquía declarada en el paquete debe reflejarse fielmente en la estructura de carpetas en el sistema de archivos.
* **Ejemplo:** Una clase con la cabecera `package com.app.model;` debe residir físicamente en la ruta `.../com/app/model/NombreClase.java`.

---

### 4. ¿Qué es Javadoc?
Es la herramienta estándar integrada en el JDK (Java Development Kit) que analiza el código fuente y procesa los comentarios estructurados para **generar automáticamente documentación técnica en formato HTML**, estandarizando la consulta de APIs, clases y métodos.

---

### 5. ¿Qué diferencia hay entre `//` y `/** ... */`?

| Característica | `//` | `/** ... */` |
| :--- | :--- | :--- |
| **Tipo de comentario** | Línea simple | Multilínea estructurado (Javadoc) |
| **Destinatario** | Exclusivamente desarrolladores (notas internas de implementación) | Usuarios y desarrolladores que consultan la API |
| **Procesamiento** | Ignorado totalmente por el compilador y herramientas de documentación | Analizado por la utilidad `javadoc` para generar documentación HTML |
| **Soporte de etiquetas** | No admite etiquetas | Admite etiquetas estándar (`@param`, `@return`, `@author`, `@throws`, `@version`, etc.) |

---

## 🚀 Requisitos del Entorno
* Java Development Kit (JDK) 8 o superior.
* Herramienta de compilación estándar (`javac`) y generación de documentación (`javadoc`).
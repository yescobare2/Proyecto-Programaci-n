# Campus Lite

Sistema de gestión académica desarrollado en Java Swing como proyecto integrador del curso de Programación.

---

## Integrantes

* Yesmy Darlery
* Oscar Norbey
* Daniel Méndez

---

## Descripción

Campus Lite es una aplicación de escritorio desarrollada en Java que permite administrar información académica mediante una interfaz gráfica amigable.

El sistema permite gestionar estudiantes, cursos, inscripciones y evaluaciones, además de generar reportes académicos y almacenar la información mediante archivos CSV.

---

## Funcionalidades

### Gestión de estudiantes

* Crear estudiantes.
* Actualizar estudiantes.
* Eliminar estudiantes.
* Validación de campos obligatorios.
* Validación de nombres y apellidos (solo letras).
* Generación automática de correo institucional.

### Gestión de cursos

* Crear cursos.
* Actualizar cursos.
* Eliminar cursos.
* Administración de créditos.
* Administración de cupo.

### Gestión de inscripciones

* Inscribir estudiantes en cursos.
* Evitar inscripciones duplicadas.
* Desinscribir estudiantes.
* Actualización automática de datos relacionados.

### Gestión de evaluaciones

* Registrar evaluaciones.
* Registrar notas.
* Manejar distintos tipos de evaluación.
* Calcular contribución de cada evaluación.

### Reportes

* Consulta de estudiantes inscritos.
* Consulta de cursos.
* Visualización de resultados académicos.

---

## Tecnologías utilizadas

* Java
* Java Swing
* Eclipse IDE
* Git
* GitHub
* Archivos CSV

---

## Requisitos

* JDK 17 o superior.
* Eclipse IDE (recomendado).

---

## Ejecución

1. Clonar el repositorio.
2. Abrir el proyecto en Eclipse.
3. Ejecutar la clase:

```text
com.campuslite.main.Main
```

4. Utilizar la interfaz gráfica.

---

## Estructura del proyecto

```text
src/

└── com.campuslite

    ├── domain
    │   ├── Course
    │   ├── Enrollment
    │   ├── Evaluation
    │   ├── GradeRecord
    │   ├── Laboratory
    │   ├── Person
    │   ├── ProjectEvaluation
    │   ├── Student
    │   └── WrittenExam
    │
    ├── logic
    │   ├── CourseManager
    │   ├── EnrollmentManager
    │   ├── EvaluationManager
    │   ├── ReportManager
    │   ├── StudentManager
    │   └── ValidationUtils
    │
    ├── persistence
    │   ├── CourseCSVRepository
    │   ├── EnrollmentCSVRepository
    │   ├── EvaluationCSVRepository
    │   ├── FilePaths
    │   └── StudentCSVRepository
    │
    ├── ui
    │   ├── CoursesPanel
    │   ├── EnrollmentsPanel
    │   ├── EvaluationsPanel
    │   ├── MainFrame
    │   ├── ModernButton
    │   ├── ModernTable
    │   ├── ReportsPanel
    │   ├── StudentsPanel
    │   ├── UIStyles
    │   └── logo.png
    │
    └── main
        └── Main

data/

├── students.csv
├── courses.csv
├── enrollments.csv
└── evaluations.csv

images/

├── home-screen.png
└── students-screen.png
```

---

## Programación Orientada a Objetos

### Encapsulamiento

Las entidades utilizan atributos privados y acceso controlado mediante getters y setters con validaciones.

### Herencia

```text
Person
└── Student

Evaluation
├── WrittenExam
├── Laboratory
└── ProjectEvaluation
```

### Clases abstractas

* Person
* Evaluation

### Sobrescritura

Las subclases implementan métodos abstractos mediante `@Override`.

Ejemplo:

```java
getTypeName()

calculateContribution()
```

### Polimorfismo

Las evaluaciones se manejan mediante referencias del tipo:

```java
Evaluation
```

permitiendo trabajar de forma uniforme con:

* WrittenExam
* Laboratory
* ProjectEvaluation

### Sobrecarga

Se utilizan constructores sobrecargados, por ejemplo en la clase Person.

---

## Persistencia

La información se almacena mediante archivos CSV.

Archivos utilizados:

* students.csv
* courses.csv
* enrollments.csv
* evaluations.csv

Los datos permanecen almacenados después de cerrar la aplicación.

---

## Capturas de pantalla de maqueta UI

### Menú principal

![Menú principal](images/home-screen.png)

### Gestión de estudiantes

![Gestión de estudiantes](images/students-screen.png)

---

## Decisiones de diseño

El proyecto utiliza una arquitectura por capas:

* domain → entidades del sistema.
* logic → reglas de negocio.
* persistence → almacenamiento de datos.
* ui → interfaz gráfica.

Esta separación permite mantener el código organizado, reutilizable y fácil de mantener.

---

## Control de versiones

El proyecto utiliza Git y GitHub con commits semánticos.

Ejemplos:

```text
feat(students): add clear button

feat(enrollments): add unenroll feature

fix(ui): reset table selection after clear
```

---

## Estado del proyecto

Versión académica funcional desarrollada para el proyecto integrador de Programación.

---

## Licencia

Proyecto desarrollado con fines educativos.

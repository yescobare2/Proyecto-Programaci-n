# Informe de Diseño – Campus Lite

## 1. Introducción

Campus Lite es una aplicación de escritorio desarrollada en Java utilizando Swing como interfaz gráfica. El objetivo del sistema es administrar estudiantes, cursos, inscripciones y evaluaciones académicas, permitiendo registrar información, generar reportes y mantener los datos almacenados mediante archivos CSV.

El proyecto fue desarrollado aplicando los principios de Programación Orientada a Objetos vistos durante el curso, incluyendo encapsulamiento, herencia, abstracción, polimorfismo y sobrecarga.

---

# 2. Arquitectura del Proyecto

El proyecto está organizado en paquetes según su responsabilidad:

## com.campuslite.domain

Contiene las entidades principales del sistema:

* Person
* Student
* Course
* Enrollment
* Evaluation
* WrittenExam
* Laboratory
* ProjectEvaluation
* GradeRecord

## com.campuslite.logic

Contiene la lógica de negocio:

* StudentManager
* CourseManager
* EnrollmentManager
* EvaluationManager
* ReportManager
* ValidationUtils

## com.campuslite.persistence

Responsable de la persistencia en archivos CSV:

* StudentCSVRepository
* CourseCSVRepository
* EnrollmentCSVRepository
* EvaluationCSVRepository
* FilePaths

## com.campuslite.ui

Contiene toda la interfaz gráfica desarrollada con Swing:

* MainFrame
* StudentsPanel
* CoursesPanel
* EnrollmentsPanel
* EvaluationsPanel
* ReportsPanel
* ModernButton
* ModernTable
* UIStyles

## com.campuslite.main

Punto de entrada de la aplicación:

* Main

---

# 3. Aplicación de Programación Orientada a Objetos

## 3.1 Encapsulamiento

Todas las clases utilizan atributos privados y acceso mediante métodos getter y setter.

Ejemplo:

```java
private String firstName;

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    if(firstName == null || firstName.trim().isEmpty()) {
        throw new IllegalArgumentException();
    }
    this.firstName = firstName;
}
```

Además, las validaciones se realizan dentro de los setters y de las clases de lógica para garantizar la integridad de los datos.

---

## 3.2 Herencia

La clase abstracta Person funciona como superclase de Student.

```java
public abstract class Person
```

```java
public class Student extends Person
```

De esta manera, Student hereda atributos comunes como:

* id
* firstName
* lastName
* email

---

## 3.3 Abstracción

El proyecto utiliza dos clases abstractas:

### Person

Define el comportamiento común de las personas.

```java
public abstract String getFullInfo();
```

### Evaluation

Representa cualquier tipo de evaluación académica.

```java
public abstract String getTypeName();

public abstract double calculateContribution();
```

Estas clases no pueden instanciarse directamente y obligan a las subclases a implementar métodos específicos.

---

## 3.4 Polimorfismo

El polimorfismo se aplica mediante la jerarquía de Evaluation.

Las clases:

* WrittenExam
* Laboratory
* ProjectEvaluation

heredan de Evaluation e implementan sus propios comportamientos.

Ejemplo:

```java
List<Evaluation> evaluations
```

La aplicación puede almacenar distintos tipos de evaluaciones dentro de una misma colección y ejecutar métodos como:

```java
evaluation.calculateContribution();
```

Java determinará automáticamente qué implementación utilizar según el objeto real.

---

## 3.5 Sobrescritura (Override)

Las clases hijas sobrescriben métodos abstractos utilizando @Override.

Ejemplo:

```java
@Override
public String getTypeName() {
    return "Examen Escrito";
}
```

```java
@Override
public double calculateContribution() {
    return getScore() * getPercentage() / 100;
}
```

---

## 3.6 Sobrecarga

El proyecto incluye constructores sobrecargados.

Ejemplo:

```java
public Person() {
}
```

```java
public Person(String id,
              String firstName,
              String lastName,
              String email) {
}
```

Esto permite crear objetos con distintos niveles de información según sea necesario.

---

# 4. Persistencia de Datos

La aplicación utiliza archivos CSV para almacenar la información.

Archivos utilizados:

* students.csv
* courses.csv
* enrollments.csv
* evaluations.csv

Estos archivos se encuentran dentro de la carpeta:

```text
data/
```

La persistencia se implementó mediante clases Repository especializadas para cada entidad.

Al iniciar la aplicación se cargan los datos desde los archivos y al realizar operaciones CRUD se actualizan automáticamente.

---

# 5. Interfaz Gráfica

La interfaz fue desarrollada completamente con Java Swing.

Componentes utilizados:

* JFrame
* JPanel
* JButton
* JTable
* JScrollPane
* JComboBox
* JTextField
* JOptionPane
* JTabbedPane
* GridBagLayout
* BorderLayout

Pantallas principales:

* Menú Principal
* Gestión de Estudiantes
* Gestión de Cursos
* Gestión de Evaluaciones
* Gestión de Inscripciones
* Reportes

---

# 6. Validaciones Implementadas

Entre las validaciones desarrolladas se encuentran:

## Estudiantes

* Carnet obligatorio.
* Nombre obligatorio.
* Apellido obligatorio.
* Nombre solo permite letras.
* Apellido solo permite letras.
* Carnet único.

## Cursos

* Código obligatorio.
* Nombre obligatorio.
* Créditos numéricos.
* Cupo numérico.
* Código único.

## Evaluaciones

* Nombre obligatorio.
* Nota entre 0 y 100.
* Porcentaje entre 1 y 100.
* Porcentajes máximos por inscripción.

## Inscripciones

* No permite inscripciones duplicadas.
* No permite inscribir estudiantes inexistentes.
* No permite inscribir cursos inexistentes.

---

# 7. Problemas Encontrados y Soluciones

## Problema 1

Las tablas no se actualizaban automáticamente cuando se modificaban estudiantes o cursos.

### Solución

Se implementaron eventos mediante Runnable para notificar cambios entre paneles y refrescar los datos en tiempo real.

---

## Problema 2

Las evaluaciones quedaban asociadas a inscripciones eliminadas.

### Solución

Se agregó sincronización entre inscripciones y evaluaciones para actualizar los datos almacenados.

---

## Problema 3

Los formularios mantenían estados inconsistentes después de utilizar el botón Limpiar.

### Solución

Se agregó:

```java
table.clearSelection();
```

en todos los formularios para reiniciar correctamente la selección.

---

## Problema 4

Existían errores al ingresar texto en campos numéricos.

### Solución

Se implementaron validaciones utilizando ValidationUtils antes de convertir cadenas a números.

---

# 8. Conclusiones

Durante el desarrollo de Campus Lite se aplicaron los conceptos fundamentales de Programación Orientada a Objetos y desarrollo de interfaces gráficas con Swing.

El proyecto permitió integrar herencia, abstracción, polimorfismo, persistencia de datos y validaciones en una aplicación funcional. Además, se fortalecieron habilidades relacionadas con Git, GitHub, trabajo colaborativo y organización del código mediante una arquitectura por capas.

Como resultado se obtuvo una aplicación académica completa capaz de gestionar estudiantes, cursos, inscripciones, evaluaciones y reportes, manteniendo la información almacenada entre ejecuciones mediante archivos CSV.

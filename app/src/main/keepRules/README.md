# 📱 TaskManager Pro - Gestor de Tareas Android

## 📖 Descripción

TaskManager Pro es una aplicación móvil desarrollada en Java para Android que permite gestionar tareas mediante una base de datos local SQLite.

La aplicación implementa las operaciones CRUD (Crear, Consultar, Actualizar y Eliminar), permitiendo administrar tareas y controlar su estado de avance.

---

## 🎯 Objetivo del Proyecto

Desarrollar una aplicación Android que permita gestionar tareas de manera eficiente utilizando SQLite como sistema de almacenamiento local.

---

## 🛠 Tecnologías Utilizadas

* Java
* Android Studio
* SQLite
* XML
* Git
* GitHub

---

## ✨ Funcionalidades

### ➕ Agregar Tarea

Permite registrar nuevas tareas indicando:

* ID
* Título de la tarea
* Estado

### 🔍 Buscar Tarea

Permite consultar una tarea utilizando su ID.

### ✏️ Editar Tarea

Permite actualizar:

* Título
* Estado

### 🗑 Eliminar Tarea

Permite eliminar tareas registradas.

### 📋 Mostrar Tareas

Permite visualizar todas las tareas almacenadas en la base de datos.

---

## 📌 Estados Disponibles

Cada tarea puede tener uno de los siguientes estados:

* Pendiente
* En Proceso
* Terminada

---

## 🗄 Base de Datos SQLite

### Nombre de la Base de Datos

administracion.db

### Tabla

tareas

### Estructura

| Campo  | Tipo    |
| ------ | ------- |
| id     | INTEGER |
| titulo | TEXT    |
| estado | TEXT    |

### Sentencia SQL

```sql
CREATE TABLE tareas(
    id INTEGER PRIMARY KEY,
    titulo TEXT,
    estado TEXT
);
```

---

## 📂 Estructura del Proyecto

```text
TaskManagerPro/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/moviles/
│   │   │   │   ├── MainActivity.java
│   │   │   │   └── AdminSQLiteOpenHelper.java
│   │   │   │
│   │   │   ├── res/layout/
│   │   │   │   └── activity_main.xml
│   │   │   │
│   │   │   ├── res/values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   │   │
│   │   │   └── AndroidManifest.xml
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

---

## 🚀 Instalación

### Requisitos Previos

* Android Studio
* JDK 11 o superior
* Android SDK
* Emulador Android o dispositivo físico

### Pasos

1. Clonar el repositorio:

```bash
git clone URL_DEL_REPOSITORIO
```

2. Abrir Android Studio.

3. Seleccionar:

```text
File → Open
```

4. Abrir la carpeta del proyecto.

5. Esperar la sincronización de Gradle.

6. Ejecutar la aplicación.

---

## 📚 Explicación de Clases

### MainActivity.java

Contiene toda la lógica principal de la aplicación:

* guardar()
* buscar()
* editar()
* eliminar()
* mostrar()
* limpiar()

Gestiona la interacción entre el usuario y la base de datos SQLite.

### AdminSQLiteOpenHelper.java

Clase encargada de:

* Crear la base de datos.
* Crear la tabla tareas.
* Actualizar la estructura de la base de datos cuando sea necesario.

Métodos principales:

* onCreate()
* onUpgrade()

---

## 🔄 Operaciones CRUD

### Create

Registrar nuevas tareas.

### Read

Consultar tareas existentes.

### Update

Actualizar tareas registradas.

### Delete

Eliminar tareas almacenadas.

---

## 📱 Interfaz de Usuario

La aplicación incluye:

* Campo ID
* Campo Título
* Selector de Estado (Spinner)
* Botón Agregar
* Botón Buscar
* Botón Editar
* Botón Eliminar
* Botón Mostrar
* ListView para visualizar tareas

---

## 📸 Capturas de Pantalla

Agregar aquí capturas de la aplicación:

* Pantalla principal
* Registro de tareas
* Consulta de tareas
* Listado de tareas

---

## 🔮 Mejoras Futuras

* Prioridad de tareas (Alta, Media, Baja)
* Fecha de vencimiento
* RecyclerView
* Notificaciones
* Modo oscuro
* Estadísticas de tareas
* Exportación de datos

---

## 👨‍💻 Autor

Juan David Botero

Proyecto desarrollado para la asignatura de Desarrollo de Aplicaciones Móviles.

---

## 📌 Versión

Versión 1.0

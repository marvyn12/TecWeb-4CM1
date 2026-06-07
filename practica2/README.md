# 🏥 Sistema de Gestión Clínica (Práctica 2)

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.X-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

Plataforma web desarrollada para la gestión administrativa de una clínica médica. Permite el control de acceso seguro, la administración de pacientes y la programación de citas, respaldado por un panel de estadísticas en tiempo real. 

Proyecto desarrollado para la materia de Tecnologías Web en la **UPIIZ - IPN**.

## 🚀 Enlaces del Proyecto

* **Despliegue en Vivo (Render):https://practica-2-4sjc.onrender.com/


## ✨ Características Principales

Cumpliendo con los requerimientos de la rúbrica, el sistema incluye:

### 🔐 Seguridad y Acceso
* **Login Seguro:** Validación de credenciales contra la base de datos.
* **Registro de Usuarios:** Validación anti-duplicados de correo electrónico.
* **Recuperación de Contraseña:** Integración con `JavaMailSender` (SMTP de Google) para enviar credenciales reales a la bandeja de entrada del usuario.
* **Control de Sesiones:** Implementación de `HandlerInterceptor` para bloquear el acceso a rutas protegidas mediante URL a usuarios no autenticados.

### 📋 Módulos del Sistema (CRUD)
* **Gestión de Pacientes (Tabla Principal):** Operaciones completas (Crear, Leer, Actualizar, Eliminar).
* **Gestión de Citas Médicas (Tabla Secundaria):** Vinculada relacionalmente a los pacientes (Borrado en cascada configurado).
* **Interfaz de Usuario:** Diseñada e integrada completamente con la plantilla **AdminLTE** y **Thymeleaf**.

### 📊 Panel de Control (Dashboard)
* Integración de **Chart.js** para renderizar métricas dinámicas extraídas mediante Java Streams.
* Muestra la distribución real de citas por especialidad en una gráfica de dona interactiva.

## ⚙️ Arquitectura y Configuración

El proyecto está diseñado para ser "Cloud-Ready" (listo para la nube), separando la configuración de infraestructura del código fuente:

* **Persistencia:** Conexión remota a un clúster MySQL alojado en **Aiven** vía JDBC.
* **ORM:** Uso de Spring Data JPA e Hibernate con actualización automática del esquema (`ddl-auto=update`).
* **Variables de Entorno:** Las credenciales sensibles (Base de datos y Servidor de Correo) se inyectan en tiempo de ejecución a través del proveedor de nube, evitando exponer secretos en el repositorio.
* **Contenerización:** Se incluye un `Dockerfile` multi-etapa para construir y ejecutar la aplicación de forma agnóstica en plataformas como **Render.com**.


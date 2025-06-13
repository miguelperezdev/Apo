#  TAREA INTEGRADORA 2: Sistema de Gestión y Monitoreo de Movilidad y Seguridad (SGMMS)

##  Contexto

La ciudad de **Palmira** necesita capacitar a sus operadores para gestionar el **SGMMS**: Sistema de Gestión y Monitoreo de Movilidad y Seguridad. 
Para ello, se desarrolló un **simulador interactivo** donde los jugadores asumen el rol de operadores municipales. Su misión es **resolver incidentes en tiempo real**, **asignar vehículos de respuesta** y **mantener el orden y seguridad** de la ciudad.

## 🎯 Objetivos del Simulador

- Asignación de vehículos autónomos para incidentes.
- Gestión dinámica de incidentes (accidentes, robos e incendios).
- Navegación 2D del operador (estilo sandbox).
- Visualización de mapas, zonas y estadísticas en tiempo real.
- Evaluación por eficiencia y estrategia del jugador.

## Tecnologías y Restricciones

- **Lenguaje:** Java 24.0.1 (funciona también con 23.x si se usa correctamente el JavaFX)
- **Interfaz Gráfica:** JavaFX (con `Canvas`, FXML, imágenes e interacción)
- **Arquitectura:** MVC modular, uso de hilos y estructuras de datos
- **Prohibido:** OpenGL, Game Engines, frameworks externos que oculten el uso de hilos o gráficos

> **JavaFX usado en este proyecto:** versión `23.0.1` especificada en el `pom.xml`.  
> Recomendado compilar con **JDK 24**. En pruebas locales, también funciona con JavaFX 24.0.1.

**integrantes :** 
- Luis Fernando Bedoya
- Jhonny Bolaños
- Miguel Perez Ojeda 

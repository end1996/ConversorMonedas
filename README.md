# Conversor de Monedas

Una aplicación Java que permite convertir entre diferentes monedas latinoamericanas y el dólar estadounidense.

## Funcionalidades Principales

### Conversión de Monedas
La aplicación permite convertir entre las siguientes monedas:
- Dólar estadounidense (USD)
- Peso argentino (ARS)
- Real brasileño (BRL)
- Peso colombiano (COP)
- Sol peruano (PEN)

### Interfaz de Usuario
La aplicación cuenta con una interfaz de texto amigable que muestra un menú con opciones claras:
1. Dólar => Peso argentino
2. Peso argentino => Dólar
3. Dólar => Real brasileño
4. Real brasileño => Dólar
5. Dólar => Peso colombiano
6. Peso colombiano => Dólar
7. Dólar => Sol peruano
8. Sol peruano => Dólar
9. Salir

### Historial de Conversiones
- La aplicación mantiene un historial de todas las conversiones realizadas
- El historial se muestra al finalizar el programa
- Las conversiones se guardan automáticamente en un archivo de texto

### Manejo de Errores
- Validación de entrada numérica
- Manejo de errores en la obtención de tasas de cambio
- Mensajes de error claros y descriptivos

## Requisitos
- Java 8 o superior
- Conexión a internet (para obtener las tasas de cambio)

## Ejecución
1. Compilar el proyecto
2. Ejecutar el archivo Main.java
3. Seguir las instrucciones del menú

## Características Técnicas
- Uso de API externa para obtener tasas de cambio en tiempo real
- Manejo de excepciones robusto
- Persistencia de datos mediante archivos
- Diseño modular con separación de responsabilidades

## Estructura del Proyecto
```
src/
├── Main.java           # Punto de entrada del programa
├── Menu.java          # Interfaz de usuario
├── Conversion.java    # Modelo de conversión
├── SaveMovements.java # Persistencia de datos
└── api/              # Manejo de API externa
```

## Notas
- Las tasas de cambio se actualizan en tiempo real
- El historial se guarda automáticamente al salir del programa
- La aplicación es completamente gratuita y de uso libre

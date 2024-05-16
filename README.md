<div align="center">

# Conversor de Monedas

</div>

Este es un conversor de monedas desarrollado en Java, que permite convertir entre diferentes monedas utilizando tasas de cambio en tiempo real. El conversor utiliza la API de ExchangeRate-API para obtener las tasas de cambio más recientes.

## Características
- Conversión en Tiempo Real: Obtén conversiones instantáneas con los tipos de cambio más recientes.
- Amplia Gama de Monedas: Admite una variedad de monedas internacionales.
- Interfaz Intuitiva: Fácil de usar, con una interfaz limpia y simple.
- Historial de conversiones: Registra la actividad del usuario, incluyendo las conversiones realizadas y las fechas correspondientes, para un seguimiento conveniente.

## Requisitos
- Una clave de API válida de ExchangeRate-API (puedes obtenerla registrándote en [ExchangeRate-API](https://www.exchangerate-api.com/))
- La biblioteca Gson de Google agregada a tu proyecto. Puedes descargarla como archivo jar desde [Gson en MVN repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).

## Uso
1. Clona este repositorio en tu máquina local:
```
git clone https://github.com/tu-usuario/Challenge-Two.git
```
2. Abre el proyecto en tu IDE de Java preferido.
3. En la clase Conversor, reemplaza "YOUR-API-KEY" con tu clave de API de ExchangeRate-API en esta línea de código.  
`19 private final String API_KEY = "YOUR-API-KEY";` 
5. Ejecuta la aplicación y comienza a explorarla.

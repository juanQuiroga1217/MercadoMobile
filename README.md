# MercadoMobile - Android App [![Android CI](https://github.com/juanQuiroga1217/MercadoMobile/actions/workflows/android.yml/badge.svg)](https://github.com/juanQuiroga1217/MercadoMobile/actions/workflows/android.yml)


<img src="https://http2.mlstatic.com/D_NQ_NP974268-MLA41149104135_032020-F.jpg" align="left"
width="200" hspace="10" vspace="10">


Reto de programacion para Meli, El objetivo es realizar un aplicativo para la consulta de productos, utilizando las Apis abiertas a la comunidad
se puede realizar la clonacion del proyecto o descargarla desde los artifacts de Actions en el repositorio Workflow Android CI

***
---
---
***

## About

Este proyecto consta de 3 Pantallas principales
1. Search Activity
2. Results Activity
3. Product Details Activity

## Compilación

1. Clona o descarga el proyecto a un directorio local en tu equipo

2. Verifica tener instalado java 1.8 y un IDE que te permita compilar y correr el proyecto y los test unitarios\
* si no tienes instalado un IDE dirigete a [Android Studio](https://developer.android.com/studio)
* si no tienes instalada una version de java dirigete a [Java](https://www.java.com/es/)


3. Abre el proyecto con tu IDE y compila el codigo

### una vez compilado te permetira ejecutar los test unitarios o generar el APK


## APK

## Desde el repositorio
En el repositorio, apartado de actions se genero un workflow con la funcion de compilar y generar un apk del proyecto\
para descargar el APK directamente desde este enlace dirigete a  [APK Mercado Mobile](https://github.com/juanQuiroga1217/MercadoMobile/)
y busca el apartado `Actions` posteriormente dirigete a la accion `Create Main.yml` alli vas a encontrar el artifact **app Mercado Mobile.APK** el cual puedes descargar
e instalar en tu telefono

## Features
Mercado Mobile te permite:
- Conectar directamente con las bases de productos de [Mercado Libre Colombia](https://www.mercadolibre.com.co/) y buscar productos
- Ver informacion de cada producto como su nombre, precio y si el envio es gratuito o no
- Ver los detalles mas especificos de cada producto, sus especificaciones e informacion avanzada
- El repositorio cuenta con Android Continuous Integration, se puede verificar el estado de este en la parte superior del readme
- No requiere de permisos especiales en dispositivos con android 6.0+

## Permisos

En versiones de android previas a 6.0, Mercado Mobile requiere los siguientes permisos:
- Full Network Access.
- View Network Connections.


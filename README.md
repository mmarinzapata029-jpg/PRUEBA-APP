# Mi primer proyecto Android

Proyecto de ejemplo ("Bienvenido / Welcome / Bienvenue / Willkommen") que cumple con:

1. **Soporte multi-idioma**: español (por defecto), inglés, francés y alemán.
2. **Fondo nine-patch redimensionable**: el androide de las nubes no se deforma al cambiar el tamaño de pantalla.
3. **Soporte de múltiples pantallas y orientaciones** (teléfono, tablet 7", tablet/pantalla grande 10"+, portrait y landscape).

## Estructura del proyecto

```
PrimerProyectoAndroid/
├── app/
│   ├── build.gradle
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/primerproyecto/MainActivity.java
│       └── res/
│           ├── values/            strings.xml (es - default), colors.xml, themes.xml, dimens.xml (teléfono)
│           ├── values-en/         strings.xml (inglés)
│           ├── values-fr/         strings.xml (francés)
│           ├── values-de/         strings.xml (alemán)
│           ├── values-sw600dp/    dimens.xml (tablets 7")
│           ├── values-sw720dp/    dimens.xml (tablets/pantallas ≥10")
│           ├── layout/            activity_main.xml (portrait / default)
│           ├── layout-land/       activity_main.xml (landscape)
│           ├── drawable/          button_outline.xml
│           ├── drawable-nodpi/    bg_clouds_android.9.png (fondo nine-patch)
│           └── mipmap-*/          ic_launcher.png (íconos de la app)
├── build.gradle
├── settings.gradle
├── gradle.properties
└── .gitignore
```

## 1) Idiomas

Los textos ("Bienvenido"/"Entrar" y sus equivalentes) viven en `strings.xml`
dentro de cada carpeta `values-XX`. Android elige automáticamente el
recurso correcto según el idioma configurado en el dispositivo; si no
encuentra coincidencia, usa `values/strings.xml` (español) como
predeterminado.

| Carpeta         | Idioma   |
|-----------------|----------|
| `values`        | Español (default) |
| `values-en`     | Inglés |
| `values-fr`     | Francés |
| `values-de`     | Alemán |

Para probarlo: cambia el idioma del sistema en el emulador/dispositivo
(Ajustes > Sistema > Idiomas) y vuelve a abrir la app.

## 2) Fondo nine-patch

`res/drawable-nodpi/bg_clouds_android.9.png` es la imagen de fondo (cielo +
nubes + androide) convertida a formato **nine-patch**:

- El borde negro **superior** marca los tramos horizontales estirables del
  cielo/nubes, dejando **sin marcar** (no estirable) la franja donde está
  dibujado el androide.
- El borde negro **izquierdo** marca los tramos verticales estirables,
  dejando igualmente sin marcar la franja vertical donde está el androide.
- Resultado: al estirar el fondo a cualquier tamaño de pantalla, el cielo y
  las nubes se estiran, pero el androide conserva su tamaño y proporción
  original, sin deformarse.

Este archivo se regeneró a partir de la imagen original con un script en
Python (Pillow) que detecta automáticamente el recuadro del androide y
protege esa región del estiramiento.

## 3) Soporte de múltiples pantallas

- El layout usa `ConstraintLayout` con "bias" porcentual (no posiciones
  fijas en px/dp), por lo que los elementos se mantienen proporcionalmente
  ubicados sin importar el tamaño de pantalla.
- `values-sw600dp/dimens.xml` y `values-sw720dp/dimens.xml` aumentan el
  tamaño de fuente, el logo y los márgenes en tablets, siguiendo las guías
  oficiales de Android para "smallest width".
- `layout-land/activity_main.xml` ajusta el "bias" vertical para
  orientación horizontal, donde hay menos alto disponible.
- El fondo nine-patch se adapta a cualquier tamaño sin pixelarse ni
  deformar al androide (ver punto 2).

## Compilar el proyecto

1. Abre la carpeta `PrimerProyectoAndroid` en Android Studio (Arctic Fox o
   superior).
2. Deja que Gradle sincronice las dependencias.
3. Ejecuta la app (`Run ▶`) en un emulador o dispositivo físico.

## Flujo de trabajo con GitHub

Para versionar y colaborar en este proyecto, sigue el flujo estándar de
GitHub (ver [guía oficial](https://guides.github.com/activities/hello-world/)):

1. **Crear tu repositorio**
   - En GitHub, pulsa "New repository", nómbralo (p. ej. `primer-proyecto-android`)
     y elige si será público o privado.
   - Clónalo localmente:
     ```bash
     git clone https://github.com/<tu-usuario>/primer-proyecto-android.git
     cd primer-proyecto-android
     ```
   - Copia dentro el contenido de esta carpeta `PrimerProyectoAndroid/` y
     haz el primer commit (ver paso 3).

2. **Crear una rama (branch)**
   ```bash
   git checkout -b feature/multi-idioma-nine-patch
   ```
   Trabaja tus cambios en esta rama en lugar de `main`, para no afectar el
   código estable mientras desarrollas.

3. **Hacer un commit**
   ```bash
   git add .
   git commit -m "Agrega soporte multi-idioma, fondo nine-patch y soporte multipantalla"
   git push -u origin feature/multi-idioma-nine-patch
   ```

4. **Hacer una solicitud de extracción (Pull Request)**
   - Entra a tu repositorio en GitHub.
   - Verás un aviso para crear un Pull Request desde la rama recién subida,
     o puedes ir a la pestaña "Pull requests" > "New pull request".
   - Selecciona `base: main` ← `compare: feature/multi-idioma-nine-patch`.
   - Describe los cambios (idiomas soportados, nine-patch, soporte de
     pantallas) para que otros puedan revisar tu trabajo.

5. **Hacer una solicitud de extracción de mezcla (Merge Pull Request)**
   - Una vez aprobada la revisión, pulsa "Merge pull request" en GitHub.
   - Confirma la fusión ("Confirm merge").
   - Opcionalmente, elimina la rama `feature/...` ya fusionada desde la
     misma interfaz de GitHub.
   - Actualiza tu copia local:
     ```bash
     git checkout main
     git pull origin main
     ```

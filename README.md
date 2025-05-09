# Generador de Datos Latam – Java + Maven + JUnit + SQLite + GitHub Actions

Este proyecto genera datos de prueba de usuarios (personas o empresas) con lógica inteligente basada en reglas de negocio, exportando a archivo CSV y base de datos SQLite.


Incluye:

- Orientación a objetos (POO)
  
    Encapsulamiento: Clases Person, Company y User definen atributos private + getters
    Abstracción: Clase abstracta User, que define estructura general y obliga a implementar métodos
    Herencia: Person y Company extienden de User
    Polimorfismo: generateDocument() y getLanguage() son métodos sobrescritos en Person y Company
  
- Patrones de diseño (Factory, Singleton)

    Factory: Clase UserFactory implementa el patrón Factory para crear dinámicamente User
    Singleton: Clase DatabaseManager implementa Singleton para una única instancia de conexión DB

- Principios SOLID (3)

    Single Responsibility: Cada clase tiene una sola responsabilidad (por ejemplo UserFactory, DatabaseManager, App)
    Open/Closed: Las clases User, Person, Company pueden extenderse sin modificar el código base
    Liskov Substitution: Person y Company se pueden usar donde se espera un User

- Test unitarios con JUnit

    Se generan test con Junit para validar las reglas de negocio expuestas en el ejercicio

- Ejecución automatizada desde GitHub Actions mediante workflow

    Se configura pipeline reusable para ejecutar pruebas y correr aplicacion de "generacion de datas" desde GitHub Actions inluyendo la cantidad de datos que se desean generar
  

# Pasos para ejecutar localmente

1. Clona el repositorio con el comando: <br>
git clone https://github.com/yonnii12/GeneradorDataLatam.git

2. Compila el proyecto con el comando: <br>
mvn clean install

3. Ejecuta pruebas con el comando: <br>
mvn clean test

4. Ejecuta el generador con el comando con una cantidad específica de usuarios (ej: 50): <br>
mvn exec:java -Dexec.mainClass="com.latam.App" -Dexec.args="50"

5. Validar creacion del archivo "users.csv" en la raiz del proyecto y creacion de la base de datos local "users.db"

# Pasos para ejecutar desde GitHub Actions

1. Ve al repositorio en GitHub: <br>
git clone https://github.com/yonnii12/GeneradorDataLatam.git

2. Haz clic en la pestaña "Actions"

3. Selecciona el workflow llamado: "Ejecucion de pruebas y archivo csv"

4. Haz clic en el botón "Run workflow"

5. Ingresa el número de registros que deseas generar (ej: 50)

6. Click en Run workflow

7. El pipeline ejecutara la aplicacion y se podra descargar el archivo "users.csv" como artefacto


  

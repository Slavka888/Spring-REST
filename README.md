# Spring-REST

Краткое описание
----------------
Spring-REST — это пример RESTful API, реализованный с использованием Spring. Репозиторий содержит серверную часть с CRUD-операциями, конфигурацией для простого запуска и примерами вызовов API.

Технологии
----------
- Java 21
- Spring Web (REST)
- Spring Data JPA
- БД: MySQL (в зависимости от конфигурации)
- Maven

Быстрый старт
------------
1. Установите Java 17+ и Maven (или Gradle).
2. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Slavka888/Spring-REST.git
   cd Spring-REST
   ```
3. Настройте параметры в `src/main/resources/applicationSecret.properties`
    - Параметры подключения к БД (username, password)
    - Другие нужные свойства

Сборка и запуск
---------------
Maven:
```bash
mvn clean package
java -jar target/<имя-файла>.jar
```



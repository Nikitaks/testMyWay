# Тетовое задание My Way
---

Добавить кнопку и текстовое поле на страницу. По нажатию на кнопку - значение в поле увеличивается на 1. Значение поля можно изменить руками, вписав нужное значение. 

Изменения должны сохраняться в БД автоматически при каждом изменении. 

Необходимо использовать binder и Spring Data. В качестве БД подойдет H2. Остальное Vaadin 24, Java 17, Maven, Spring Boot 3.

#### Используемые инструменты:
1. Spring Boot
2. СУБД H2.
3. Spring Data JPA, Hibernate.
4. Vaadin.
5. Сборщик проектов `maven`.
 
#### Особенности проекта
1. Проект содержит скрипт инициализации БД (`src/main/resources/data.sql`) одной таблицей с одной записью, хранящей значение счетчика. 
 
#### Как запустить проект

1. Импортировать проект в Eclipse IDE, в качестве существующего maven-проекта.
2. Убедиться, что установленная JDK не ниже 17
3. Собрать проект одним из  способов:
- Выполнить команду `mvn clean install`;
- Создать конфигурацию запуска с goals `clean install`, запустить конфигурацию на исполнение.
4. Запустить на исполнение приложение TestApplication.java
7. Перейти на страницу localhost:8080/main с локального компьютера или с компьютера подсети.
8. Установить желаемое значение поля или выполнить нажатия на кнопку Increment.
7. Перейти на страницу localhost:8080/h2-console с локального компьютера или с компьютера подсети, подсоединиться к базе данных с параметрами:
- JDBC URL:	jdbc:h2:mem:testdb
- User Name:	sa
- Password:	password
8. Выполнить запрос `SELECT * FROM COUNTER;` и убедиться в соответсвии значения в текстовом поле значению в базе.

Можно запустить через `IntelliJ IDEA` с соответствующими настройками
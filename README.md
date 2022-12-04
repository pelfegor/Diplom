# Дипломный проект по курсу «Тестировщик ПО»

## Документация 

[План автоматизации ](https://github.com/pelfegor/Diplom/blob/master/documents/Plan.md)


## Запуск приложений

1. Необходимо склонировать репозиторий.
2. Установать и запустить Docker Desktop.

### Запуск
1. Запустить необходимые базы данных (MySQL и PostgreSQL). Параметры для запуска хранятся в файле `docker-compose.yml`. Для запуска необходимо ввести в терминале команду:
```
docker-compose up
```
2. В новой вкладке терминала ввести следующую команду в зависимости от базы данных
- `java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar` - для MySQL
- `java -Dspring.datasource-postgresql.url=jdbc:postgresql://localhost:5432/app -jar artifacts/aqa-shop.jar` - для PostgreSQL

## Запуск тестов
В новой вкладке терминала ввести команду в зависимости от запущенной БД  и нажать enter:
- `gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app` - для MySQL
- `gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app` - для PostgreSQL

## Формирование отчета AllureReport по результатам тестирования
В новой вкладке терминала или нажав двойной Ctrl ввести команду:
```
gradlew allureServe
```
Сгенерированный отчет откроется в браузере автоматически.

# task-service
Сервис для создания, обработки задач

## Переменные окружения
DATABASE_URL - URL подключения к базе данных
POSTGRES_USER - пользователь бд
POSTGRES_PASSWORD - пароль бд
KAFKA_URL - URL подключения к брокеру Kafka
KAFKA_URL - URL подключения к серверу Eureka

## Запуск приложения
Установить значения перемнных окружения и в корневой директории выполнить ./gradlew bootRun.
Для запуска из под Docker/Docker-compose доступен образ caspaze/task-service:0.0.1

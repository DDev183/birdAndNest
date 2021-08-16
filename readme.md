# Сервис birdAndNest
##### Выполняет функции доступа к данным из БД с валидацией входящих значений в формате JSON.
Сервис принимает и отправляет данные в формате JSON.

#Запуск
#### Для того чтобы запустить проект лишь требуется указать данные для подключение к БД(Postgres) в файле application.properties.
#### Перед созданием сущностей типа Bird(птица), требуется создать сущность(-ти) Nest(гнездо) для их дальнейшего "привязывания" к Bird.

# Endpoints:
## Работа с bird
### Просмотр 1 птицы, запрос GET по адресу /api/getBird
#### В качестве параметра в запросе требуется передать id птицы

### Редактирование, запрос POST по адресу /api/editBird
#### В теле запроса требуется передать JSON с полями:
- id (целочисленный тип данных)
- name (текстовый тип данных)
- color (текстовый тип данных)
- nest (тип данных NestEntity)

### Создание, запрос POST по адресу /api/createBird
#### В теле запроса требуется передать JSON с полями:
- name (текстовый тип данных)
- color (текстовый тип данных)
- nest (тип данных NestEntity)

### Удаление, запрос GET по адресу /api/dropBird
#### В качестве параметра в запросе требуется передать id птицы

### Отчёт, запрос GET по адресу /api/getBird
#### Параметры запроса отсутствуют

## Работа с Nest
### Просмотр 1 гнезда, запрос GET по адресу /api/getNest
#### В качестве параметра в запросе требуется передать id гнезда

### Редактирование, запрос POST по адресу /api/editNest
#### В теле запроса требуется передать JSON с полями:
- id (целочисленный тип данных)
- name (текстовый тип данных)
- address (текстовый тип данных)

### Создание, запрос POST по адресу /api/createNest
#### В теле запроса требуется передать JSON с полями:
- name (текстовый тип данных)
- address (текстовый тип данных)

### Удаление, запрос GET по адресу /api/dropNest
#### В качестве параметра в запросе требуется передать id гнезда 
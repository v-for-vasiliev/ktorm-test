# KTORM test application

#### Как создавать базу (ktorm не умеет этого делать, база и таблицы создаются заранее руками)

1. Открываем терминал в директории, в которой создается база, и выполняем команды
2. `sqlite3`
3. Создаем таблицу: `create table t_users (id int primary key, name varchar(30), admin boolean);`
4. Добавляем пользователя: `insert into t_users values(1, 'zaec', 1);`
5. Проверяем: `select * from t_users;`
6. Сохраняем: `.save example.db`
7. Выходим: `.quit`

После этого ее нужно положить в корень проекта
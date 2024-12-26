endpoints, Clients 

GET     http://localhost:8080/clients   Получение списка клиентов 

Запрос:
```json
{}
```
Ответ: 
```json
{
   "id": 1,
   "name": "papanya",
   "email": "vasa1@mail.ru"
} 

{ 

  "id": 2, 
  
  "name": "papanya", 
  
  "email": "vasa1@mail.ru" 

}
```
POST http://localhost:8080/clients Создание клиента

Запрос:
```json
{
    "name":"vasyan",
    "email":"vasa@mail.ru"
}
```
Ответ:
```json
{
    "id": 4,
    "name": "vasyan",
    "email": "vasa@mail.ru"
}
```

GET http://localhost:8080/clients/{id} Получение информации о конкретном клиенте

Запрос:
```json
{}
```
Ответ:
```json
{
    "id": 2,
    "name": "papanya",
    "email": "vasa1@mail.ru"
}
```
PUT http://localhost:8080/clients/{id} Обновление информации о клиенте

Запрос:
```json
{
    "name":"papanya",
    "email":"vasa1@mail.ru"
}
```
Ответ:
```json
{
    "id": 2,
    "name": "papanya",
    "email": "vasa1@mail.ru"
}
```
DEL http://localhost:8080/clients/{id} Удаление клиента

Запрос:
```json
{
}
```
Ответ:
```json
{
}
```

Account

GET     http://localhost:8080/accounts   Получение списка счетов для клиента

Запрос:
```json
{
    "id":3 // id Клиента
}
```
Ответ: 
```json
{
        "id": 10,
        "clientId": {
            "id": 3,
            "name": "papanya",
            "email": "vasa1@mail.ru",
            "hibernateLazyInitializer": {}
        },
        "account_number": 555,
        "balance": 5.0
    },
    {
        "id": 11,
        "clientId": {
            "id": 3,
            "name": "papanya",
            "email": "vasa1@mail.ru",
            "hibernateLazyInitializer": {}
        },
        "account_number": 555,
        "balance": 5.0
    },
    {
        "id": 12,
        "clientId": {
            "id": 3,
            "name": "papanya",
            "email": "vasa1@mail.ru",
            "hibernateLazyInitializer": {}
        },
        "account_number": 555,
        "balance": 5.0
    }
```
POST http://localhost:8080/accounts Создание счета для клиента

Запрос:
```json
{
    "account_number": 555,
    "balance": 5,
    "clientId": {
        "id":4
    }
}
```
Ответ:
```json
{
    "id": 14,
    "clientId": {
        "id": 4,
        "name": null,
        "email": null
    },
    "account_number": 555,
    "balance": 5.0
}
```

GET http://localhost:8080/accounts/{id} Получение информации о конкретном счете

Запрос:
```json
{}
```
Ответ:
```json
{
    "id": 11,
    "clientId": {
        "id": 3,
        "name": "papanya",
        "email": "vasa1@mail.ru",
        "hibernateLazyInitializer": {}
    },
    "account_number": 555,
    "balance": 5.0
}
```
PUT http://localhost:8080/accounts/{id} Обновление информации о счете

Запрос:
```json
{
    "account_number": 555,
    "balance": 5,
    "clientId": {
        "id": 3,
        "name":"vasyan",
        "email":"vasa@mail.ru"
    }
}
```
Ответ:
```json
{
    "id": 13,
    "clientId": {
        "id": 3,
        "name": "vasyan",
        "email": "vasa@mail.ru"
    },
    "account_number": 555,
    "balance": 5.0
}
```
DEL http://localhost:8080/accounts/{id} Удаление счета

Запрос:
```json
{
}
```
Ответ:
```json
{}
```

Transaction

GET     http://localhost:8080/transactions          Получение списка транзакций для счета

Запрос:
```json
{
    "id":3 // id Аккаунта
}
```
Ответ: 
```json
{
        "id": 11,
        "accountId": {
            "id": 10,
            "clientId": {
                "id": 3,
                "name": "papanya",
                "email": "vasa1@mail.ru",
                "hibernateLazyInitializer": {}
            },
            "hibernateLazyInitializer": {},
            "account_number": 555,
            "balance": 5.0
        },
        "amount": 195.0,
        "transaction_date": "2024-12-26T10:15:11.000+00:00"
    },
    {
        "id": 12,
        "accountId": {
            "id": 10,
            "clientId": {
                "id": 3,
                "name": "papanya",
                "email": "vasa1@mail.ru",
                "hibernateLazyInitializer": {}
            },
            "hibernateLazyInitializer": {},
            "account_number": 555,
            "balance": 5.0
        },
        "amount": 195.0,
        "transaction_date": "2024-12-26T10:15:11.000+00:00"
    },
    {
        "id": 13,
        "accountId": {
            "id": 10,
            "clientId": {
                "id": 3,
                "name": "papanya",
                "email": "vasa1@mail.ru",
                "hibernateLazyInitializer": {}
            },
            "hibernateLazyInitializer": {},
            "account_number": 555,
            "balance": 5.0
        },
        "amount": 195.0,
        "transaction_date": "2024-12-26T10:15:11.000+00:00"
    }
```
POST http://localhost:8080/transactions Создание транзакции для счета


Запрос:
```json
{
    "amount": 195,
    "transaction_date": "2024-12-26T10:15:11.000Z",
    "accountId":{
        "id":10
    }
}
```
Ответ:
```json
{
    "id": 13,
    "accountId": {
        "id": 10,
        "clientId": null,
        "account_number": 0,
        "balance": 0.0
    },
    "amount": 195.0,
    "transaction_date": "2024-12-26T10:15:11.000+00:00"
}
```

GET http://localhost:8080/transactions/{id} Получение информации о конкретной транзакции


Запрос:
```json
{}
```
Ответ:
```json
{
    "id": 13,
    "accountId": {
        "id": 10,
        "clientId": {
            "id": 3,
            "name": "papanya",
            "email": "vasa1@mail.ru",
            "hibernateLazyInitializer": {}
        },
        "hibernateLazyInitializer": {},
        "account_number": 555,
        "balance": 5.0
    },
    "amount": 195.0,
    "transaction_date": "2024-12-26T10:15:11.000+00:00"
}
```
PUT http://localhost:8080/transactions/{id} Обновление информации о транзакции


Запрос:
```json
{
    "amount": 150,
    "transaction_date": "2024-11-26T10:15:11.000Z",
    "accountId":{
        "id":11
    }
}
```
Ответ:
```json
{
    "id": 13,
    "accountId": {
        "id": 11,
        "clientId": null,
        "account_number": 0,
        "balance": 0.0
    },
    "amount": 150.0,
    "transaction_date": "2024-11-26T10:15:11.000+00:00"
}
```
DEL http://localhost:8080/transactions/{id} Удаление транзакции

Запрос:
```json
{
}
```
Ответ:
```json
{}
```


postman collection 
https://drive.google.com/file/d/1KBi6FabG5QF9NezNoOb4rfGtDeG1X1ZE/view?usp=sharing

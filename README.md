# B2-iOS-API-NewsFeed
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/safroalex/B1-PostgreSQLAutoServiceERP/blob/main/LICENSE)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/1ae6f06607fa4d6589d49fc326d016fa)](https://app.codacy.com/gh/safroalex/B2-iOS-API-NewsFeed/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
![polykill](https://github.com/safroalex/B2-iOS-API-NewsFeed/assets/105920089/2118d5ce-66d6-4c4b-8750-6e60d496d315)

<!-- https://whimsical.com/c4-model-for-ios-app-with-java-backend-TfVUnyFGDf7ojWucZ39EJR] -->
<img width="1096" alt="image" src="https://github.com/safroalex/B2-iOS-API-NewsFeed/assets/105920089/e306b113-bb4c-4bb7-ae26-5795854eb248">


# Проект Ленты Новостей

## Описание
Проект ленты новостей представляет собой минимально жизнеспособный продукт (MVP), предназначенный для демонстрации основных функций ленты новостей, включая просмотр списка новостей и обновление ленты.

## Технологический стек
- **Frontend**: SwiftUI для iOS приложений, Xcode.
- **Backend**: Java, Spring Boot (Spring Web, Spring Data JPA), PostgreSQL.
- **Документация API**: Swagger.
- **Контейнеризация**: Docker.
- **Тестирование**: JUnit.
- **Развертывание**: Docker, NGINX как балансировщик нагрузки.

Основные функции:

    Регистрация через университетскую почту: Подтверждение принадлежности к университету через отправку кода на университетский email.
    Создание профиля: Выбор уникального логина и пароля после подтверждения почты.
    Публикация заказов: Возможность анонимно размещать заказы на выполнение домашних заданий с указанием предмета, деталей задания и сроков.
    Поиск и фильтрация заказов: Поиск заказов по факультету и направлению.
    Анонимная переписка: Возможность обсуждения деталей заказа через анонимный чат между заказчиком и исполнителем.
    Система рейтингов и отзывов: Оценка качества выполнения заданий для формирования репутации пользователя.

Цели:

    Упрощение поиска исполнителей: Помощь студентам в нахождении исполнителей для домашних заданий в рамках своего университета.
    Анонимность и безопасность: Создание безопасной среды для обмена академическими услугами, где личность пользователей защищена.

это два сервиса, которые можно запустить одновременно на одной машине и один делает RPC запрос к другому чтобы завершить свой

# запуск

терминал 1
```sh
cd hello
./gradlew bootRun
```

терминал 2
```sh
cd world
./gradlew bootRun
```

# тестирование

терминал 3
```sh
firefox http://localhost:8080/full-greeting
```



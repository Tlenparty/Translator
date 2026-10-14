# Translator

Англо-русский словарь для Android. Ищет слово через публичный API
[Skyeng Dictionary](https://dictionary.skyeng.ru/), показывает список значений
с переводами и карточку слова с картинкой, а результаты поиска сохраняет
в историю в локальной базе.

## Возможности

- Поиск слова в нижнем диалоге (BottomSheet)
- Список найденных значений с переводами
- Карточка слова: перевод и изображение, обновление свайпом (SwipeRefreshLayout)
- История поиска (Room)
- Проверка сети и экраны загрузки / ошибки с повтором запроса

## Стек

| Область        | Технологии                                   |
|----------------|----------------------------------------------|
| Язык           | Kotlin                                       |
| Архитектура    | MVVM, Repository / Interactor                |
| DI             | Koin                                         |
| Асинхронность  | Kotlin Coroutines                            |
| Сеть           | Retrofit, OkHttp, Gson                       |
| Хранение       | Room                                         |
| Изображения    | Coil (альтернативные загрузчики на Glide и Picasso в коде) |
| UI             | ViewBinding, Material Components             |
| Сборка         | Gradle, зависимости в `buildSrc` (Kotlin DSL) |

## Структура

```
app/src/main/java/com/tlenparty/translator/
├── data/
│   ├── local/      # Room: база, DAO и сущность истории
│   └── remote/     # Retrofit-интерфейс Skyeng API
├── di/             # Koin-модули
├── interactor/     # бизнес-логика главного экрана и истории
├── model/          # модели данных, источники и репозитории
├── ui/
│   ├── main/       # список результатов
│   ├── search/     # диалог поиска
│   ├── description/# карточка слова
│   └── history/    # история поиска
└── extensions/
buildSrc/           # версии и зависимости
```

## Сборка

Требуется JDK 11–17 и Android SDK 31.

```bash
./gradlew assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.

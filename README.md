# Translator

An English-Russian dictionary for Android. It looks up a word through the public
[Skyeng Dictionary](https://dictionary.skyeng.ru/) API, shows a list of meanings
with translations and a word card with an image, and saves search results
to a history in a local database.

## Features

- Word search in a bottom dialog (BottomSheet)
- List of found meanings with translations
- Word card: translation and image, swipe to refresh (SwipeRefreshLayout)
- Search history (Room)
- Network check and loading / error screens with request retry

## Tech stack

| Area           | Technologies                                 |
|----------------|----------------------------------------------|
| Language       | Kotlin                                       |
| Architecture   | MVVM, Repository / Interactor                |
| DI             | Koin                                         |
| Concurrency    | Kotlin Coroutines                            |
| Networking     | Retrofit, OkHttp, Gson                       |
| Storage        | Room                                         |
| Images         | Coil (alternative Glide and Picasso loaders in the code) |
| UI             | ViewBinding, Material Components             |
| Build          | Gradle, dependencies in `buildSrc` (Kotlin DSL) |

## Project structure

```
app/src/main/java/com/tlenparty/translator/
├── data/
│   ├── local/      # Room: database, DAO and history entity
│   └── remote/     # Retrofit interface for the Skyeng API
├── di/             # Koin modules
├── interactor/     # business logic for the main screen and history
├── model/          # data models, data sources and repositories
├── ui/
│   ├── main/       # results list
│   ├── search/     # search dialog
│   ├── description/# word card
│   └── history/    # search history
└── extensions/
buildSrc/           # versions and dependencies
```

## Build

Requires JDK 11–17 and Android SDK 31.

```bash
./gradlew assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.

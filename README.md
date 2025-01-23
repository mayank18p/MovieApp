# Android Assignment (Movie App)

**Introduction:**

This is a demo application based on the MVVM architectural pattern by using Kotlin language.


**Technologies:**

This Movies App is developed by using the following technologies and tools:

1. Android Studio
2. Kotlin
3. MVVM Architecture
4. Retrofit
5. Data Binding
6. Glide
   

**Features:**

Home: Highlighting top-rated Anime Series on the first page (Home screen), showing: 

● Title

● Number of Episodes

● Rating (e.g., MyAnimeList score)

● Poster Image

**Note:-** Using API Endpoint for showing Top Anime: https://api.jikan.moe/v4/top/anime


Anime Detail Page: When an anime is clicked, open an Anime Detail Page. On this page, display the following information:

● Show poster image of Anime

● Title

● Plot/Synopsis

● Number of Episodes 

● Rating

● Genre(s) -> Not able to show in app, bcoz url is not valid. It does not have image, instead it has web url.

● Main Cast -> Same as above. Not able to show, bcoz url is not valid. It does not have image, instead it has web url.

**Note:-** Using API Endpoint for showing Anime Details: https://api.jikan.moe/v4/anime/{anime_id}


**Usage:**

In order to use Movies App, follow these steps:

1. Open your app.
2. Your Internet should be on before using app. Wait for the results to load. You will be able to see top-rated Anime Series on the first page (Home screen).
3. Click on an Anime to view its details. 
4. You will be able to see Anime Details on the next page (Anime Detail Page)
5. That's it!
   

**Installation:**

To install the Movies App, follow these steps:

1. Clone the repository to your local machine using git clone https://github.com/mayank18p/MovieApp.git
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

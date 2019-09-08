# Android-Kotlin-Dsl
 If you work with big android project, its really common to modularize the app. When it happens, gradle dependencies seems really worst because we have to add repetitive dependencies to all of our module. So why Kotlin DSL comes to the world, it can centralize our dependencies and make it more easy with auto complete (In your gradle file). Then for communication between each modules, I'am using [Deeplink Dispatcher](https://github.com/airbnb/DeepLinkDispatch) from Airbnb.

## Technology
- Kotlin DSL
- Modularize Library
- Deeplink Dispatcher

### Installing
Clone this project, open with and run with Android Studio. If you want to test Deeplink , you can easily do :
1. Open terminal and go to this path file
2. After emulator or another devices start then run this in your terminal `adb shell am start -W -a android.intent.action.VIEW -d "nba//:www.nbageek.com/team/123" com.example.nbageek`
3. Tadaaaa~ you start the activity explicitly



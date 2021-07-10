# UI Performance Testes
#### XML vs By code programmatically vs Compose
The app is a simple experiment to compare the performance of activity while creating the layouts in XML, by code programmatically and using the new jetpack compose.

You can check full details [HERE](https://medium.com/@96.mustafa.basim/performance-comparison-building-android-layout-with-xml-vs-by-code-vs-jetpack-compose-17d79bb9952d)

I didn't exactly know how to measure the views creating time so I added multiple stop points to calculate it, you can check the code to see where I added these stop points.

Note: I tested each one alone then close the app then test the other one, no recent apps in the background, no wifi ( in case some app used it and made the CPU busy a bit ).

The environment :
 - Android Studio Arctic Fox 2020.3.1 beta 3
 - Compose version : 1.0.0-rc01 ( Updated thanks to [Callmepeanut](https://github.com/callmepeanut) contribution )
 - Tested on Galaxy S8 ( SM-G950F, Android 9 )  and Huawei Y5 Prime 2018 ( HUAWEI DRA-LX2, Android 8.1 )
 - I tested it in 10 runs for each method.
  ##
*All the numbers are in milliseconds*
#### Benchmarks for  Galaxy S8 ( SM-G950F )  :
| XML  | Min | Max | Average |
|--|--|--|--|
| onCreate | 21 | 70 | 30|
| onResume| 26| 82| 36|
| viewTreeObserver | 134| 326| 185|
| window.decorView| 141| 337| 191|
| onWindowFocusChanged| 142| 402| 200|
  ####
| By Code | Min | Max | Average |
|--|--|--|--|
| onCreate | 23| 78 | 30|
| onResume| 27| 83 | 36|
| viewTreeObserver | 126| 289| 174|
| window.decorView| 132| 297| 180|
| onWindowFocusChanged| 134| 345| 187|
####
| Jetback Compose | Min | Max | Average |
|--|--|--|--|
| onCreate | 10| 36| 14|
| onResume| 14| 45| 18|
| viewTreeObserver | null | null  | null  |
| window.decorView| 140| 1000| 286|
| onWindowFocusChanged| 199| 1013| 342|

  ##
#### Benchmarks for Huawei Y5 Prime 2018 ( HUAWEI DRA-LX2 )  :
| XML  | Min | Max | Average |
|--|--|--|--|
| onCreate | 71| 152| 100|
| onResume| 88| 179| 121|
| viewTreeObserver | 314| 833| 497|
| window.decorView| 333| 933| 529|
| onWindowFocusChanged| 334| 935| 530|
  ####
| By Code | Min | Max | Average |
|--|--|--|--|
| onCreate | 57| 134| 75|
| onResume| 72| 153| 91|
| viewTreeObserver | 228| 565| 323|
| window.decorView| 244| 588| 343|
| onWindowFocusChanged| 245| 661| 351|
####
| Jetback Compose | Min | Max | Average |
|--|--|--|--|
| onCreate | 22| 41| 27|
| onResume| 35| 67| 43|
| viewTreeObserver | null | null  | null  |
| window.decorView| 352| 1830| 648|
| onWindowFocusChanged| 427| 1833| 735|

  ##
All done with the same identical UI:

<img src="screenshots/ui.jpg" alt="UI used for testing">
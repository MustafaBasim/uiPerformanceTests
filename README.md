
# UI Perfomncace Testes   
#### XML vs By code programmatically vs Compose
The app is a simple experiment to compare the performance of activity while creating the layouts in XML, by code programmatically and using the new jetpack compose.  
  
I didn't exactly know how to measure the views creating time so i added multiple stop points to calculate it.  
  
Note: i noticed the first activity intent of the app is always slower than the other intents in all tested methods, so i tested each one alone then close the app totally then test the other one, no recent apps in the background, no wifi ( in case some app used it and made the cpu busy a bit ).  
  
The environment :  
 - Android Studio 4.1 Canary 7  
 - Compose version : 0.1.0-dev10  
 - Tested on Galaxy S8 ( SM-G950F )  
 - I tested it in 5 runs for each method.  
  
*All the numbers are in milliseconds*  
#### XML  Measurements  
| XML  | Min | Max | Average |  
|--|--|--|--|  
| onCreate | 26 | 70 | 40|  
| onResume| 32| 77 | 48 |  
| viewTreeObserver | 189 | 334 | 265  |  
| window.decorView| 198  | 344 | 275  |  
| onWindowFocusChanged| 241 | 415 | 332 |  
  
#### By Code  Measurements  
| By Code | Min | Max | Average |  
|--|--|--|--|  
| onCreate | 25 | 69 | 38 |  
| onResume| 31 | 75 | 44 |  
| viewTreeObserver | 168 | 294 | 215 |  
| window.decorView| 173 | 304 | 225 |  
| onWindowFocusChanged| 219 | 366 | 276 |  
  
#### Jetback Compose Measurements  
| Jetback Compose | Min | Max | Average |  
|--|--|--|--|  
| onCreate | 32| 130 | 52 |  
| onResume| 38 | 136 | 59 |  
| viewTreeObserver | null | null  | null  |  
| window.decorView| 230| 710| 350 |  
| onWindowFocusChanged| 286 | 726 | 393 |  
  
All done with the same identical UI:  
<img src="screenshots/ui.jpg" alt="UI used for testing">
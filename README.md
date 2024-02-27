## Lotter Web
### _Number lottery game - Spring Boot application (backend project)_
#### Lotto|Web is an online version of the popular number lottery game. To participate, users select six different numbers between 1 and 99 and receive a unique coupon identifier. Once a week, winning numbers are randomly selected, and all submitted coupons are processed to determine winners. In order to win a prize, a user must have at least three numbers that match the winning numbers drawn for that week. Users can check their results at any time using their unique coupon identifier.

#### All user coupons, generated winning numbers, and processed results are stored in a separate database using SpringData with MongoDB. A scheduler has been configured to run the lottery once per week and collect all coupons submitted for the current draw date. The scheduler will then process the coupons according to the game rules and determine all winners and losers. Once processing is complete, users can check their results using their unique coupon ID and claim any prizes they have won.

## Specification

 1.  Spring Boot, web application
 2.  Modular monolith hexagonal architecture
 3.  Facade design pattern
 4.  NoSQL databases (MongoDB) for coupon and results repositories
 5.  There is good test coverage, including both unit tests and "happy path" integration tests.
 6. The controllers have been tested using mockMvc, and the winning numbers service has been stubbed using WireMock.
 7.  Scheduled lottery run and results processing

 ## Tech:
Lotto|Web is developed using following technologies:

Core:

![enter image description here](https://camo.githubusercontent.com/94255ec6b3c759a685d09b160102f6780416030ba75119a1d9d05cd1d2345e5a/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176612d4544384230303f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465)
![enter image description here](https://camo.githubusercontent.com/0c06ba358a6e3ef89bf50d0e3f0f94ee20a2a26d9572e007dc23ffc3fc848fb8/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6170616368655f6d6176656e2d4337314133363f7374796c653d666f722d7468652d6261646765266c6f676f3d6170616368656d6176656e266c6f676f436f6c6f723d7768697465)
![enter image description here](https://camo.githubusercontent.com/2a1686c791f100fd94f85b084f6b4db88ce4e094ea6f19e7665b6d23f07f84de/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f537072696e675f426f6f742d4632463446393f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67)
![](https://camo.githubusercontent.com/4ae569342c64ecd9f0d7e7cbed78fffcca6a0f427e8efb4297c1d357dfb09074/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d6f6e676f44422d3445413934423f7374796c653d666f722d7468652d6261646765266c6f676f3d6d6f6e676f6462266c6f676f436f6c6f723d7768697465)
![](https://camo.githubusercontent.com/bce5c9b25447afefd9c8dc63febce5936fbff659beee51466a130b41a2821a9b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f446f636b65722d3243413545303f7374796c653d666f722d7468652d6261646765266c6f676f3d646f636b6572266c6f676f436f6c6f723d7768697465)

Testing:

![](https://camo.githubusercontent.com/6cf47d9ca3b8d62efb942ad8e9c9335f5bd5196ec76150d42fcc1a65f8486ddf/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a756e6974352d3235413136323f7374796c653d666f722d7468652d6261646765266c6f676f3d6a756e697435266c6f676f436f6c6f723d7768697465)
![](https://camo.githubusercontent.com/d38819e2d4efdc0a84acb94de6e2c94a02997234c5a72e72b1c250bb5a980e6f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d6f636b69746f2d3738413634313f7374796c653d666f722d7468652d6261646765)
![](https://camo.githubusercontent.com/64222af02483697dcb725214353024d87b41710a78ce20af9c9e78b747355169/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f54657374636f6e7461696e6572732d3942343839413f7374796c653d666f722d7468652d6261646765)



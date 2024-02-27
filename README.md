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

![enter image description here](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![enter image description here](https://img.shields.io/badge/Apache%20Maven-C71A36.svg?style=for-the-badge&logo=Apache-Maven&logoColor=white)

![enter image description here](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white) ![enter image description here](https://img.shields.io/badge/MongoDB-47A248.svg?style=for-the-badge&logo=MongoDB&logoColor=white)

![enter image description here](https://img.shields.io/badge/Docker-2496ED.svg?style=for-the-badge&logo=Docker&logoColor=white)

Testing: 

![enter image description here](https://img.shields.io/badge/JUnit5-25A162.svg?style=for-the-badge&logo=JUnit5&logoColor=white) ![enter image description here](https://camo.githubusercontent.com/6677ce19252d9b153201746c53ab0c5c68db012681103ff8b23f94ec85cce666/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d6f636b69746f2d3738413634313f7374796c653d666f722d7468652d6261646765)

![enter image description here](https://camo.githubusercontent.com/a97b9de3bc5420c2cc77a8bc1c39b8e7889315bcd52c5787bc366abf99013466/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f54657374636f6e7461696e6572732d3942343839413f7374796c653d666f722d7468652d6261646765)

![Project lotto](architecture.png)


_#_# How to build the project on your own
#### To build the project:

##### 1. Clone the repository: #####

```bash
git clone https://github.com/GrzegorzHolui/LottoExcelent.git
```
##### 2. Go to the folder with cloned repository #####

##### 3. Run the command: #####

```bash
mvn package -DskipTests
```

##### 4. In folder target you should find a file named: application-{version}-SNAPSHOT.jar #####


#### To build the docker image with Docker Compose: ####

##### 1. Clone the repository: #####
```bash
git clone https://github.com/GrzegorzHolui/LottoExcelent.git
```

##### 2. Go to the folder with cloned repository: #####


##### 3. Run the command: #####
```bash
docker-compose build
```

##### 4. By using #####
```bash
docker images
```





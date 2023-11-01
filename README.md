# courier-tracking

This project is a restful web application with Java and Spring Boot. In this project, which includes couriers and stores, the location information of the couriers is stored.
This project calculates the total distance traveled by couriers.

**Database**
- src/main/resources/json/courier-geolocations.json
- src/main/resources/json/courier.json
- src/main/resources/json/stores.json
- src/main/resources/json/tracking-courier-at-store.json

**Postman Collection**
- src/main/resources/json/TrackingCourier.postman_collection.json

**Controllers**
- Store Controller
- Courier Geolocation Controller


**Store Controller**
- Create Store


**Courier Geolocation Controller**
- Report Courier Geolocation (Notice location information of the courier)
- Total Travel Distance (Calculates the total distance traveled by the courier)

**DesignPattern**
-I used three design patterns. These are Singleton,Builder and Repository.

**Log**
-I used AOP Logging

**Mapper**
-I used mapstruct mapper
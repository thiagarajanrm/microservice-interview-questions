# Test Data
==================

HTTP method: POST
URL: http://localhost:8080/bookFlightTicket

Request Body: 
------------------

```json
{
  "passengerInfo": {
    "name": "test",
    "email": "test@gmail.com",
    "source": "someplace",
    "destination": "BBSR",
    "travelDate": "14-12-2021",
    "pickupTime": "4.0 PM",
    "arrivalTime": "6.0 PM",
    "fare": 10000
  },
  "paymentInfo": {
    "accountNo": "acc1",
    "cardType": "DEBIT"
  }
}
```

Change fare value to test transaction. Also comment @EnableTransactionManagement and @Transactional to test the API.

Response Body:
--------------------

```json
{
    "status": "SUCCESS",
    "totalFare": 10000.0,
    "pnrNo": "67bd9c23",
    "passengerInfo": {
        "name": "test",
        "email": "test@gmail.com",
        "source": "someplace",
        "travelDate": "14-12-2021",
        "pickupTime": "4.0 PM",
        "arrivalTime": "6.0 PM",
        "fare": 10000.0,
        "pid": 6,
        "destination": "BBSR"
    }
}
```

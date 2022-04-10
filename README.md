Installation requirement:
Java JDK 11+ (Recommend Java 17)
Docker latest
Maven latest
RabbitMQ
MySQl
Any IDE that support Java (Recommend Intellij)
-----------------------------------------
RabbitMQ Management login
username: guest
password: guest
------------------------------------------------------------
POST:localhost:8080/api/v1/startPaymentBundle
{
"accountNumber": "06452-126568",
"paymentDate": "2022-04-03",
"currency": "450",
"payments":{
"amount": 1256.56,
"reference": "Philip Mattsson"
 }
}
----------------------------------------
DELETE:localhost:8080/api/v1/endPaymentBundle/{id}
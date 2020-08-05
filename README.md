spring-cloud-gateway-hystrix

url: http://localhost:9092/order/placeOrders

HTTP Method : POST

JSON Request:

{
    "order" : {
    "id": 101,
    "name": "Mobile",
    "quantity": 1,
    "price": 1250.00
    },
    "payment": {}
}

JSON Response:

{
    "order": {
        "id": 101,
        "name": "Mobile",
        "quantity": 1,
        "price": 1250.0
    },
    "transactionId": "7005fd8a-d655-4b63-82c5-eba0b11ac813",
    "price": 1250.0,
    "message": "payment failure"
}

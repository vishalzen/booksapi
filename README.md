## A Spring Boot REST API
## API Specification
## API 1

When the endpoint:

GET [http://localhost:8080/api/external-books?name=:nameOfABook](http://localhost:8080/api/external-books?name=:nameOfABook)

is requested with name = A Game of Thrones, this application query the Ice And Fire API and uses the data received to respond with precisely the following JSON if there are results:

```
{
    "status_code": 200,
    "status": "success",
    "data": [
        {
            "name": "A Game of Thrones",
            "isbn": "978-0553103540",
            "authors": [
                "George R. R. Martin"
            ],
            "number_of_pages": 694,
            "publisher": "Bantam Books",
            "country": "United States",
            "release_date": "United States"
        }
    ]
}
```

or precisely this JSON if the Ice and Fire API returns no results:

```
{
    "status_code": 200,
    "status": "success",
    "data": []
}
```

## API 2

**Create**

When the endpoint:

POST [http://localhost:8080/api/v1/books](http://localhost:8080/api/v1/books)

is requested with the following data:

```
name
isbn
authors
country
number_of_pages
publisher
release_date
```
a book is created in the local MYSQL database and the following response is returned:

```
{
    "status_code": 201,
    "status": "success",
    "data": [
        {
            "book": {
                "name": "My First Book",
                "isbn": "123-000321",
                "authors": [
                    "John Doe"
                ],
                "number_of_pages": 350,
                "publisher": "Acme Books",
                "country": "United States",
                "release_date": "2019-08-01"
            }
        }
    ]
}
```

**Read**

When the endpoint:

GET [http://localhost:8080/api/v1/books](http://localhost:8080/api/v1/books)

is requested, this application returns a list of books from the local database using the following response:

```
{
    "status_code": 200,
    "status": "success",
    "data": [
        {
            "id": 1,
            "name": "My First Book",
            "isbn": "123-000321",
            "authors": [
                "John Doe"
            ],
            "number_of_pages": 350,
            "publisher": "Acme Books",
            "country": "United States",
            "release_date": "2019-08-01"
        }
    ]
}
```
or precisely this JSON if the Books API returns no results:

```
{
    "status_code": 200,
    "status": "success",
    "data": []
}
```
**Update**

When the endpoint:

PATCH http://localhost:8080/api/v1/books/:id

is requested with any of the following form data:

```
name
isbn
authors
country
number_of_pages
publisher
release_date
```

and a specific :id in the URL, where :id is a placeholder variable for an integer (for example 1), the specific book is updated in the database and the following response is returned:

```
{
    "status_code": 200,
    "status": "success",
    "message": "The Book My First Book was updated successfully",
    "data": {
        "id": 4,
        "name": "My First Updated Book",
        "isbn": "123-000321",
        "authors": [
            "John Doe"
        ],
        "number_of_pages": 350,
        "publisher": "Acme Books",
        "country": "United States",
        "release_date": "2019-08-01"
    }
}
```

**Delete**

When the endpoint:

DELETE http://localhost:8080/api/v1/books/:id

is requested with a specific :id in the URL, where :id is a placeholder variable for an integer (for example 1), the specific book is deleted from the database and the following response is returned:

```
{
    "status_code": 200,
    "status": "success",
    "message": "The Book My First Book was deleted successfully",
    "data": []
}
```

**Show**

When the endpoint:

GET http://localhost:8080/api/v1/books/:id

is requested with a specific :id in the URL, where :id is a placeholder variable for an integer (for example 1), the following response is returned:

```
{
    "status_code": 200,
    "status": "success",
    "data": {
        "id": 1,
        "name": "My First Book",
        "isbn": "123-000321",
        "authors": [
            "John Doe"
        ],
        "number_of_pages": 350,
        "publisher": "Acme Books",
        "country": "United States",
        "release_date": "2019-08-01"
    }
}
```
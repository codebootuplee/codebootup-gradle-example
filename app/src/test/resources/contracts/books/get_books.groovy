package contracts.books

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Retrieve a list of books"
    request {
        method GET()
        url "/api/v1/books"
    }
    response {
        status 200
        body([
                [
                        id: value(regex('[a-f0-9-]{36}')),
                        title: "Book 1",
                        author: "Author 1"
                ],
                [
                        id: value(regex('[a-f0-9-]{36}')),
                        title: "Book 2",
                        author: "Author 2"
                ]
        ])
        headers {
            contentType(applicationJson())
        }
    }
}

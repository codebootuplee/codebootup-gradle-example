package com.codebootup

import com.codebootup.model.Book
import org.springframework.web.bind.annotation.RestController

@RestController
class BooksApiController(private val bookService: BookService) : LibraryAPI {
    override fun getallbooks(): List<Book> {
        return bookService.getBooks()
    }
}

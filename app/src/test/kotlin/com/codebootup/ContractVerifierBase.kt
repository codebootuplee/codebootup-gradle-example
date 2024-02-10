package com.codebootup

import com.codebootup.BookService
import com.codebootup.BooksApiController
import com.codebootup.model.Book
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.web.context.WebApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@WebMvcTest(BooksApiController::class)
abstract class ContractVerifierBase {

    @MockBean
    private lateinit var bookService: BookService

    @Autowired
    private lateinit var context: WebApplicationContext

    @BeforeEach
    fun setup() {
        RestAssuredMockMvc.webAppContextSetup(context)

        // Assuming the getBooks method returns a list of books
        Mockito.`when`(bookService.getBooks()).thenReturn(
            listOf(
                Book(id = UUID.randomUUID().toString(), title = "Book 1", author = "Author 1"),
                Book(id = UUID.randomUUID().toString(), title = "Book 2", author = "Author 2")
            )
        )
    }
}
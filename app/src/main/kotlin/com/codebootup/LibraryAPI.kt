package com.codebootup

import com.codebootup.model.Book
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@RequestMapping("/api/v1")
interface LibraryAPI {

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/books"],
        produces = ["application/json"]
    )
    fun getallbooks(): List<Book>
}

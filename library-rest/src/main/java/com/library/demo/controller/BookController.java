package com.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.entity.Book;
import com.library.demo.service.BookService;

@RestController
@RequestMapping("/bookapi")
public class BookController {
// this is git
	@Autowired
	private BookService bookService;

	public BookController() {
		// TODO Auto-generated constructor stub
	}

	// Create End Point all books "/books"
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}

	// End point "/find/{bookId}" based on Id
	@GetMapping("/find/{bookId}")
	public Book findById(@PathVariable int bookId) {
		try {
			return bookService.findById(bookId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// End Point "/delete/{bookId}"

	@GetMapping("/delete/{bookId}")
	public void deleteById(@PathVariable int bookId) {
		bookService.deleteById(bookId);
	}

	// create new book "/newBook"

	@PostMapping("/newBook")
	public Book addBook(@RequestBody Book book) {
		book.setId(0); // remove id ,if passed
		bookService.save(book);
		return book;
	}

	// create UpdatBook "/updateBook"

	@PostMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		// book.setId(0); // remove id ,if passed
		bookService.save(book);
		return book;
	}

}

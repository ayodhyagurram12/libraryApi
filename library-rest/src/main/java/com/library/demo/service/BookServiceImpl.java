package com.library.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.entity.Book;
import com.library.demo.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public BookServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int theId) throws Exception {
		// TODO Auto-generated method stub

		Book book = null;
		java.util.Optional<Book> received = bookRepository.findById(theId);
		if (received.isPresent()) {
			book = received.get();
		} else {
			throw new Exception("Book is Not Available with Given Id");
		}
		return book;
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(theId);
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}
}

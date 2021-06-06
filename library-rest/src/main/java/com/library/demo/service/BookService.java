package com.library.demo.service;

import java.util.List;

import com.library.demo.entity.Book;

public interface BookService {

	public List<Book> findAll();

	public Book findById(int theId) throws Exception;

	public void deleteById(int theId);

	public void save(Book book);

}

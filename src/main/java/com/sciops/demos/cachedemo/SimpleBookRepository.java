package com.sciops.demos.cachedemo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {
	
	@Override
	@Cacheable("books")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "(Book title)");
	}
	
	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch(InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}

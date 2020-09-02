package com.sciops.demos.cachedemo;

public interface BookRepository {
	Book getByIsbn(String isbn);
}

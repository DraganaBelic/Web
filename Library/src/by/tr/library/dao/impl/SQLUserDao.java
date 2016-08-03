package by.tr.library.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.dao.UserDao;

public class SQLUserDao implements UserDao{

	@Override
	public List<Book> getCatalog() {
		// stub
		return new ArrayList<Book>();
	}

	@Override
	public Book getBookByTitle(String title) {
		// stub
		return null;
	}

}

package cn.eurasia.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//学生类
public class Student {

	private String sid; // 学号
	private String name;// 姓名
	private Map<Book, Integer> books; // 表示学生借的所有图书

	public Student() {

	}

	public Student(String sid, String name) {
		this.sid = sid;
		this.name = name;
		books = new HashMap<Book, Integer>();
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Book, Integer> getBooks() {
		return books;
	}

	public void setBooks(Map<Book, Integer> books) {
		this.books = books;
	}
}

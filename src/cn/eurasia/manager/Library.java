package cn.eurasia.manager;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cn.eurasia.domain.Book;
import cn.eurasia.domain.Student;

public class Library {
	Scanner in = new Scanner(System.in);
	Set<Book> set = new HashSet<Book>();
	Student stu = new Student();
	Set<Student> stus = new HashSet<Student>();

	public Library() {
		// 初始化图书
		Book b1 = new Book("b0001", "西游记", "吴承恩", "北京出版社", 50);
		Book b2 = new Book("b0002", "三国", "罗贯中", "北京出版社", 80);
		Book b3 = new Book("b0003", "水浒", "施耐庵", "北京出版社", 20);
		Book b4 = new Book("b0004", "红楼梦", "曹雪芹", "北京出版社", 100);

		set.add(b1);
		set.add(b2);
		set.add(b3);
		set.add(b4);

		// 初始化学生会员
		Student s1 = new Student("s0001", "张三");
		Student s2 = new Student("s0002", "李四");
		Student s3 = new Student("s0003", "王五");
		Student s4 = new Student("s0004", "赵六");

		stus.add(s1);
		stus.add(s2);
		stus.add(s3);
		stus.add(s4);
	}

	public Set<Book> getAll() {
		return set;
	}

	// 根据图书编号查询，获得想要的图书
	public Book queryBooksById(String id) {
		for (Book b : set) {
			if (id.equals(b.getId())) // 说明找到了想要的书
			{
				return b;
			}
		}
		return null; // 没有这个编号的书
	}

	// 根据学号返回一个学生对象
	public Student queryStudentsById(String sid) {
		for (Student s : stus) {
			if (s.getSid().equals(sid)) { // 说明找到了想要的学生
				return s;
			}
		}
		return null; // 没有这个学生
	}

}

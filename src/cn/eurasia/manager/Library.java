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
		// ��ʼ��ͼ��
		Book b1 = new Book("b0001", "���μ�", "��ж�", "����������", 50);
		Book b2 = new Book("b0002", "����", "�޹���", "����������", 80);
		Book b3 = new Book("b0003", "ˮ�", "ʩ����", "����������", 20);
		Book b4 = new Book("b0004", "��¥��", "��ѩ��", "����������", 100);

		set.add(b1);
		set.add(b2);
		set.add(b3);
		set.add(b4);

		// ��ʼ��ѧ����Ա
		Student s1 = new Student("s0001", "����");
		Student s2 = new Student("s0002", "����");
		Student s3 = new Student("s0003", "����");
		Student s4 = new Student("s0004", "����");

		stus.add(s1);
		stus.add(s2);
		stus.add(s3);
		stus.add(s4);
	}

	public Set<Book> getAll() {
		return set;
	}

	// ����ͼ���Ų�ѯ�������Ҫ��ͼ��
	public Book queryBooksById(String id) {
		for (Book b : set) {
			if (id.equals(b.getId())) // ˵���ҵ�����Ҫ����
			{
				return b;
			}
		}
		return null; // û�������ŵ���
	}

	// ����ѧ�ŷ���һ��ѧ������
	public Student queryStudentsById(String sid) {
		for (Student s : stus) {
			if (s.getSid().equals(sid)) { // ˵���ҵ�����Ҫ��ѧ��
				return s;
			}
		}
		return null; // û�����ѧ��
	}

}

package cn.eurasia.manager;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cn.eurasia.domain.Book;
import cn.eurasia.domain.Student;

public class StudentManager {

	Library library = new Library();
	Scanner in = new Scanner(System.in);

	// ����������ܷ��ɹ�ȡ�������������� 1.��û���Ȿ�� 2.����У��ݲ�����������ڵ�����������
	// ע��idΪ���ͼ���ţ�num��ʾ��������
	public boolean borrowBooks(Student s, String id) {
		Scanner in = new Scanner(System.in);
		Book b = null;
		b = library.queryBooksById(id);
		// ��ʾ��������Ȿ��
		if (!(b == null)) {
			System.out.println(b);
			System.out.println("����������������");
			int num = in.nextInt();
			if (num > b.getNumber()) // ���Ľ����������ڹݲ�����
			{
				System.out.println("���Ľ����������ڹݲ�����������ʧ�ܣ�");
				return false;
			} else {
				library.getAll().remove(b); // ��ɾ��ԭ������
				b.setNumber(b.getNumber() - num); // �޸��������
				library.getAll().add(b); // �ٰ��޸ĺ��ͼ�����ϣ����浽ͼ���ͼ��������
				s.getBooks().put(b, num);// ѧ������
				System.out.println("����ɹ���");
				return true;
			}
		}
		System.out.println("ͼ�鲻���ڣ�����ʧ�ܣ�");
		return false;
	}

	// ����
	public boolean returnBooks(Student s, String id) {
		Map<Book, Integer> map = s.getBooks();
		Set<Book> set = map.keySet();// ����key
		Book tempBook = null;
		boolean flag = false;
		for (Book b : set) {
			if (id.equals(b.getId())) {
				flag = true;
				tempBook = b;
				break;
			}
		}
		if (flag) {
			System.out.println("�����뻹���������");
			int num = in.nextInt();
			if (num > s.getBooks().get(tempBook)) {
				System.out.println("���Ļ����������ڽ�������������ʧ�ܣ�");
				return false;
			} else if (num == s.getBooks().get(tempBook)) {// ����
				s.getBooks().remove(tempBook);
				Book b = library.queryBooksById(id);
				library.getAll().remove(b); // ��ɾ��ԭ������
				b.setNumber(b.getNumber() + num); // �޸��������
				library.getAll().add(b); // �ٰ��޸ĺ��ͼ�����ϣ����浽ͼ���ͼ��������
				System.out.println("����ɹ���");
				return true;
			} else {
				s.getBooks().put(tempBook, num);
				Book b = library.queryBooksById(id);
				library.getAll().remove(b); // ��ɾ��ԭ������
				b.setNumber(b.getNumber() + num); // �޸��������
				library.getAll().add(b); // �ٰ��޸ĺ��ͼ�����ϣ����浽ͼ���ͼ��������
				System.out.println("����ɹ���");
				return true;
			}
		} else {
			System.out.println("ͼ���Ŵ��󣬻���ʧ�ܣ�");
			return false;
		}
	}

	// ��ʾ���е�ͼ������
	public void queryAllBooks() {
		for (Book book : library.getAll()) {
			System.out.println(book);
		}
	}

}

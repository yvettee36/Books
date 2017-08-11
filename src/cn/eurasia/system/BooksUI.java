package cn.eurasia.system;

import java.util.Scanner;

import cn.eurasia.domain.Book;
import cn.eurasia.domain.Student;
import cn.eurasia.manager.AdminManager;
import cn.eurasia.manager.Library;
import cn.eurasia.manager.StudentManager;

public class BooksUI {
	AdminManager admin = new AdminManager();
	StudentManager student = new StudentManager();
	Library library = new Library();
	Scanner in = new Scanner(System.in);
	Student s = null;

	public static void main(String[] args) {
		BooksUI ui = new BooksUI();
		System.out.println("************�»��������************");
		ui.judge();
		ui.welcome();// ��ӭ����
	}

	public void judge() {
		System.out.println("���Ƿ�Ҫ��½��Y/N");
	}

	public void welcome() {
		// ��ӭ����
		String judge = in.next();
		if (judge.equals("Y")) {
			loginBoundary();
		} else if (judge.equals("N")) {
			userMenu();
		} else {
			userMenu();
		}
	}

	// δ��¼�û���Ȩ��
	public void userMenu() {
		System.out.println("1.���ͼ��");
		System.out.println("2.��ѯͼ��");
		System.out.println("3.����ͼ��");
		System.out.println("4.�黹ͼ��");
		System.out.println("5.�˳�ϵͳ");
		System.out.print("�����빦�ܱ�ţ�");
		int choose = in.nextInt();
		switch (choose) {
		case 1:
			student.queryAllBooks();
			userMenu();
			break;
		case 2:
			queryBooks();
			userMenu();
			break;
		case 3:
			borrowBook();
			userMenu();
			break;
		case 4:
			returnBook();
			userMenu();
			break;
		case 5:
			judge();
			welcome();
			break;
		default:
			System.out.println("�����д����������룺");
			welcome();
			break;
		}
	}

	// ����ԱȨ��
	public void adminMenu() {
		System.out.println("�����빦�ܱ�Ž�����Ӧ�Ĺ��ܣ�");
		System.out.println("���ͼ�顪����ţ�1");
		System.out.println("����鼮������ţ�2");
		System.out.println("�޸��鼮������ţ�3");
		System.out.println("ɾ���鼮������ţ�4");
		System.out.println("�˳�ϵͳ������ţ�5");
		int choose = in.nextInt();
		switch (choose) {
		case 1:
			admin.queryAllBooks();
			adminMenu();
			break;
		case 2:
			add();
			adminMenu();
			break;
		case 3:
			update();
			adminMenu();
			break;
		case 4:
			delete();
			adminMenu();
			break;
		case 5:
			welcome();
			break;
		default:
			break;
		}
	}

	// ����Ա��¼����
	public void loginBoundary() {
		System.out.print("����Ա�˺ţ�");
		String userName = in.next();
		System.out.print("�� ¼ �� �� ��");
		String passWord = in.next();
		int flag = admin.login(userName, passWord);// ��¼��֤
		switch (flag) {
		case 0:// �������
			System.out.println("����������������롣");
			loginBoundary();
			break;

		case 1:// ��֤ͨ��
			System.out.println("��¼�ɹ���");
			adminMenu();// ��¼�ɹ�����ת���˵����ܹ���
			break;
		case -1:// �˻�������
			System.out.println("������Ĺ���Ա�˺Ų����ڣ���ȷ�Ϻ������롣");
			loginBoundary();
			break;
		}
	}

	// ��ѯ�鼮
	public void queryBooks() {
		System.out.println("������ͼ���ţ�");
		Book b = null;
		String id = in.next();
		b = library.queryBooksById(id);
		if (b != null) {
			System.out.println("����ѯ��ͼ���������£�");
			System.out.println(b);
		} else {
			System.out.println("�ܱ�Ǹ������ѯ��ͼ�鲻���ڣ�");
		}
	}

	// ����
	public void borrowBook() {
		System.out.println("������ѧ�ţ�");
		String sid = in.next();
		s = library.queryStudentsById(sid);
		if (s != null) {
			System.out.println("������ͼ���ţ�");
			String id = in.next();
			student.borrowBooks(s, id);
			userMenu();
		} else {
			System.out.println("���޴���");
		}

	}

	// ����
	public void returnBook() {
		System.out.println("������ѧ�ţ�");
		String sid = in.next();
		s = library.queryStudentsById(sid);
		if (s != null) {
			System.out.println("������ͼ���ţ�");
			String id = in.next();
			student.returnBooks(s, id);
		} else {
			System.out.println("���޴���");
		}
	}

	// ����
	public void add() {
		System.out.print("������Ҫ���ӵ��鼮��ţ�");
		String id = in.next();
		System.out.print("������Ҫ���ӵ��鼮���ƣ�");
		String bookName = in.next();
		System.out.print("������" + bookName + "�����ߣ�");
		String author = in.next();
		System.out.print("������" + bookName + "�ĳ����磺");
		String press = in.next();
		System.out.print("������" + bookName + "�����������");
		int number = in.nextInt();
		Book b = new Book(id, bookName, author, press, number);
		admin.addBook(b);
	}

	// ɾ��
	public void delete() {
		System.out.println("������Ҫɾ����ͼ���ţ�");
		String id = in.next();
		admin.deleteBook(id);
		adminMenu();
	}

	// ����
	public void update() {
		Book b = null;
		System.out.println("������Ҫ�޸ĵ�ͼ���ţ�");
		String id = in.next();
		b = library.queryBooksById(id);
		if (b != null) {
			System.out.print("�������鼮���ƣ�");
			String bookName = in.next();
			System.out.print("�������鼮���ߣ�");
			String author = in.next();
			System.out.print("�������鼮�����磺");
			String press = in.next();
			System.out.print("�������鼮������");
			int number = in.nextInt();
			b.setName(bookName);
			b.setAuthor(author);
			b.setPress(press);
			b.setNumber(number);
		} else {
			System.out.println("��Ҫ�޸ĵ�ͼ�鲻���ڣ�");
			update();
		}

	}
}

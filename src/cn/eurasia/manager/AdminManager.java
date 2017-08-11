package cn.eurasia.manager;

import cn.eurasia.domain.Admin;
import cn.eurasia.domain.Book;

public class AdminManager {
	Admin admin = new Admin();
	Library library = new Library();

	// ����Ա��¼��֤
	public int login(String userName, String passWord) {
		if (userName.equals(admin.getUserName())) {
			if (passWord.equals(admin.getPassWord())) {
				return 1;// �˺ź�������֤ͨ��
			} else {
				return 0;// �������
			}
		} else {
			return -1;// �˺Ų�����
		}
	}

	// ���
	public void addBook(Book b) {
		library.getAll().add(b);
		System.out.println("��ӳɹ�������");
	}

	// ɾ��
	public void deleteBook(String id) {
		Book b = library.queryBooksById(id);
		if (b != null) {
			library.getAll().remove(b);
			System.out.println("ɾ���ɹ�������");
		} else {
			System.out.println("��Ҫɾ����ͼ�鲻���ڣ�����");
		}
	}

	// ��ʾ���е�ͼ������
	public void queryAllBooks() {
		for (Book book : library.getAll()) {
			System.out.println(book);
		}
	}
}

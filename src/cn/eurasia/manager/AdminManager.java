package cn.eurasia.manager;

import cn.eurasia.domain.Admin;
import cn.eurasia.domain.Book;

public class AdminManager {
	Admin admin = new Admin();
	Library library = new Library();

	// 管理员登录验证
	public int login(String userName, String passWord) {
		if (userName.equals(admin.getUserName())) {
			if (passWord.equals(admin.getPassWord())) {
				return 1;// 账号和密码验证通过
			} else {
				return 0;// 密码错误
			}
		} else {
			return -1;// 账号不存在
		}
	}

	// 添加
	public void addBook(Book b) {
		library.getAll().add(b);
		System.out.println("添加成功！！！");
	}

	// 删除
	public void deleteBook(String id) {
		Book b = library.queryBooksById(id);
		if (b != null) {
			library.getAll().remove(b);
			System.out.println("删除成功！！！");
		} else {
			System.out.println("您要删除的图书不存在！！！");
		}
	}

	// 显示所有的图书资料
	public void queryAllBooks() {
		for (Book book : library.getAll()) {
			System.out.println(book);
		}
	}
}

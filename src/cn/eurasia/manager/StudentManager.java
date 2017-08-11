package cn.eurasia.manager;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cn.eurasia.domain.Book;
import cn.eurasia.domain.Student;

public class StudentManager {

	Library library = new Library();
	Scanner in = new Scanner(System.in);

	// 借书分析：能否借成功取决于两个条件： 1.有没有这本书 2.如果有，馆藏数量必须大于等于你借的数量
	// 注：id为借的图书编号，num表示借书数量
	public boolean borrowBooks(Student s, String id) {
		Scanner in = new Scanner(System.in);
		Book b = null;
		b = library.queryBooksById(id);
		// 表示：如果有这本书
		if (!(b == null)) {
			System.out.println(b);
			System.out.println("请输入借书的数量：");
			int num = in.nextInt();
			if (num > b.getNumber()) // 您的借书数量大于馆藏数量
			{
				System.out.println("您的借书数量大于馆藏数量，借书失败！");
				return false;
			} else {
				library.getAll().remove(b); // 先删除原来的数
				b.setNumber(b.getNumber() - num); // 修改书的数量
				library.getAll().add(b); // 再把修改后的图书资料，保存到图书馆图书数组里
				s.getBooks().put(b, num);// 学生借书
				System.out.println("借书成功！");
				return true;
			}
		}
		System.out.println("图书不存在，借书失败！");
		return false;
	}

	// 还书
	public boolean returnBooks(Student s, String id) {
		Map<Book, Integer> map = s.getBooks();
		Set<Book> set = map.keySet();// 返回key
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
			System.out.println("请输入还书的数量：");
			int num = in.nextInt();
			if (num > s.getBooks().get(tempBook)) {
				System.out.println("您的还书数量大于借书数量，还书失败！");
				return false;
			} else if (num == s.getBooks().get(tempBook)) {// 还完
				s.getBooks().remove(tempBook);
				Book b = library.queryBooksById(id);
				library.getAll().remove(b); // 先删除原来的书
				b.setNumber(b.getNumber() + num); // 修改书的数量
				library.getAll().add(b); // 再把修改后的图书资料，保存到图书馆图书数组里
				System.out.println("还书成功！");
				return true;
			} else {
				s.getBooks().put(tempBook, num);
				Book b = library.queryBooksById(id);
				library.getAll().remove(b); // 先删除原来的书
				b.setNumber(b.getNumber() + num); // 修改书的数量
				library.getAll().add(b); // 再把修改后的图书资料，保存到图书馆图书数组里
				System.out.println("还书成功！");
				return true;
			}
		} else {
			System.out.println("图书编号错误，还书失败！");
			return false;
		}
	}

	// 显示所有的图书资料
	public void queryAllBooks() {
		for (Book book : library.getAll()) {
			System.out.println(book);
		}
	}

}

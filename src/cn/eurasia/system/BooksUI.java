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
		System.out.println("************新华文轩书城************");
		ui.judge();
		ui.welcome();// 欢迎界面
	}

	public void judge() {
		System.out.println("您是否要登陆？Y/N");
	}

	public void welcome() {
		// 欢迎界面
		String judge = in.next();
		if (judge.equals("Y")) {
			loginBoundary();
		} else if (judge.equals("N")) {
			userMenu();
		} else {
			userMenu();
		}
	}

	// 未登录用户的权限
	public void userMenu() {
		System.out.println("1.浏览图书");
		System.out.println("2.查询图书");
		System.out.println("3.借阅图书");
		System.out.println("4.归还图书");
		System.out.println("5.退出系统");
		System.out.print("请输入功能编号：");
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
			System.out.println("输入有错，请重新输入：");
			welcome();
			break;
		}
	}

	// 管理员权限
	public void adminMenu() {
		System.out.println("请输入功能编号进入相应的功能：");
		System.out.println("浏览图书——编号：1");
		System.out.println("添加书籍——编号：2");
		System.out.println("修改书籍——编号：3");
		System.out.println("删除书籍——编号：4");
		System.out.println("退出系统——编号：5");
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

	// 管理员登录界面
	public void loginBoundary() {
		System.out.print("管理员账号：");
		String userName = in.next();
		System.out.print("登 录 密 码 ：");
		String passWord = in.next();
		int flag = admin.login(userName, passWord);// 登录验证
		switch (flag) {
		case 0:// 密码错误
			System.out.println("密码错误，请重新输入。");
			loginBoundary();
			break;

		case 1:// 验证通过
			System.out.println("登录成功！");
			adminMenu();// 登录成功后跳转至菜单功能管理
			break;
		case -1:// 账户不存在
			System.out.println("您输入的管理员账号不存在，请确认后再输入。");
			loginBoundary();
			break;
		}
	}

	// 查询书籍
	public void queryBooks() {
		System.out.println("请输入图书编号：");
		Book b = null;
		String id = in.next();
		b = library.queryBooksById(id);
		if (b != null) {
			System.out.println("您查询的图书资料如下：");
			System.out.println(b);
		} else {
			System.out.println("很抱歉，您查询的图书不存在！");
		}
	}

	// 借书
	public void borrowBook() {
		System.out.println("请输入学号：");
		String sid = in.next();
		s = library.queryStudentsById(sid);
		if (s != null) {
			System.out.println("请输入图书编号：");
			String id = in.next();
			student.borrowBooks(s, id);
			userMenu();
		} else {
			System.out.println("查无此人");
		}

	}

	// 还书
	public void returnBook() {
		System.out.println("请输入学号：");
		String sid = in.next();
		s = library.queryStudentsById(sid);
		if (s != null) {
			System.out.println("请输入图书编号：");
			String id = in.next();
			student.returnBooks(s, id);
		} else {
			System.out.println("查无此人");
		}
	}

	// 增书
	public void add() {
		System.out.print("请输入要增加的书籍编号：");
		String id = in.next();
		System.out.print("请输入要增加的书籍名称：");
		String bookName = in.next();
		System.out.print("请输入" + bookName + "的作者：");
		String author = in.next();
		System.out.print("请输入" + bookName + "的出版社：");
		String press = in.next();
		System.out.print("请输入" + bookName + "的添加数量：");
		int number = in.nextInt();
		Book b = new Book(id, bookName, author, press, number);
		admin.addBook(b);
	}

	// 删书
	public void delete() {
		System.out.println("请输入要删除的图书编号：");
		String id = in.next();
		admin.deleteBook(id);
		adminMenu();
	}

	// 改书
	public void update() {
		Book b = null;
		System.out.println("请输入要修改的图书编号：");
		String id = in.next();
		b = library.queryBooksById(id);
		if (b != null) {
			System.out.print("请输入书籍名称：");
			String bookName = in.next();
			System.out.print("请输入书籍作者：");
			String author = in.next();
			System.out.print("请输入书籍出版社：");
			String press = in.next();
			System.out.print("请输入书籍数量：");
			int number = in.nextInt();
			b.setName(bookName);
			b.setAuthor(author);
			b.setPress(press);
			b.setNumber(number);
		} else {
			System.out.println("您要修改的图书不存在！");
			update();
		}

	}
}

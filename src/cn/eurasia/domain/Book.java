package cn.eurasia.domain;

//图书类
public class Book {

	private String id; // 图书的ISBN编号
	private String name;// 书名
	private String author;// 作者
	private String press;// 出版社
	private int number;// 馆藏数量

	public Book() {

	}

	public Book(String id, String name, String author, String press, int number) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.press = press;
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "图书编号:" + this.getId() + "| 书名:" + this.getName() + "| 作者:" + this.getAuthor() + "| 出版社:"
				+ this.getPress() + "| 数量:" + this.getNumber();
	}

}

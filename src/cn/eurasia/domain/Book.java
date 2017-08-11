package cn.eurasia.domain;

//ͼ����
public class Book {

	private String id; // ͼ���ISBN���
	private String name;// ����
	private String author;// ����
	private String press;// ������
	private int number;// �ݲ�����

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
		return "ͼ����:" + this.getId() + "| ����:" + this.getName() + "| ����:" + this.getAuthor() + "| ������:"
				+ this.getPress() + "| ����:" + this.getNumber();
	}

}

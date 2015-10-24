package ba.bitcamp.sql.task2;

/**
 * This class present article with specified attributes.
 * 
 * @author Niddal.Salkic
 *
 */
public class Article {

	private String code;
	private String name;
	private Double price;

	/**
	 * Declaration of constructor of article
	 * 
	 * @param code
	 *            - String value of article code
	 * @param name
	 *            - String value of article name
	 * @param price
	 *            - Double value of article price
	 */
	public Article(String code, String name, Double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	// Get methods for article
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "Code: " + code + " Name: " + name + " Price: " + price + "\n";
	}

}

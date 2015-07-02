package ba.bitcamp.object.inheritance.bookstore;

/**
 * This class present author with specified attributes
 * 
 * @author Nidal
 *
 */

public class Author {

	// Attributes for author
	private String name;
	private String mail;
	private String gender;

	/**
	 * Declaration of constructor
	 * 
	 * @param name
	 *            - name of author
	 * @param mail
	 *            - mail of author
	 * @param gender
	 *            - gender of author
	 * 
	 */
	public Author(String name, String mail, String gender) {
		this.name = name;
		this.mail = mail;
		this.gender = gender;

	}

	public Author() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Equal method
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Method toString for printing information of author to console
	 */
	public String toString() {
		return "Author name is " + name + ". \n Mail adrres " + mail
				+ ". \n Gender is " + gender + ".";
	}

}

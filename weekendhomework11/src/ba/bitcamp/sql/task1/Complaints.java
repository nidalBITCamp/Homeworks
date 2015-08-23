package ba.bitcamp.sql.task1;

/**
 * This class present the complaint with specified attributes, used for get
 * information of complaints from data base
 * 
 * @author Niddal.Salkic
 *
 */
public class Complaints {

	private Integer id;
	private String date;
	private String complaints;

	/**
	 * Constructor for complaints
	 * 
	 * @param id
	 *            - Integer value of complaints id
	 * @param date
	 *            - Date value of time from input complaints in the base
	 * @param complaints
	 *            - String of complaints
	 */
	public Complaints(Integer id, String date, String complaints) {
		super();
		this.id = id;
		this.date = date;
		this.complaints = complaints;

	}

	// Declaration of set and get methods for id, date and complaint
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}
	///////////////////////////

	

	@Override
	public String toString() {
		return "ID" + id + ", Date [" + date + "], Complaints:" + complaints
				+ ".\n";
	}

}

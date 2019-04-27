package restclient;

public class Ticket {

	private Integer id;

	private String title;
	private String description;
	private String status;
	private Integer applicationId;
	private Integer assigneeId;
	private Integer daysOpen;

	public Ticket() {
	}

	public Ticket(Integer id, String title, String description, String status, Integer applicationId,
			Integer assigneeId, Integer daysOpen) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.applicationId = applicationId;
		this.assigneeId = assigneeId;
		this.daysOpen = daysOpen;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Integer getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Integer assigneeId) {
		this.assigneeId = assigneeId;
	}

	public Integer getDaysOpen() {
		return daysOpen;
	}

	public void setDaysOpen(Integer daysOpen) {
		this.daysOpen = daysOpen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package restclient;

import java.util.List;

public class TicketSearch {
	private int daysOpenFrom;
    private int daysOpenTo;

    private List<String> statusValues;

	public TicketSearch(int daysOpenFrom, int daysOpenTo, List<String> statusValues) {
		super();
		this.daysOpenFrom = daysOpenFrom;
		this.daysOpenTo = daysOpenTo;
		this.statusValues = statusValues;
	}

	public TicketSearch() {
	}

	public int getDaysOpenFrom() {
		return daysOpenFrom;
	}

	public void setDaysOpenFrom(int daysOpenFrom) {
		this.daysOpenFrom = daysOpenFrom;
	}

	public int getDaysOpenTo() {
		return daysOpenTo;
	}

	public void setDaysOpenTo(int daysOpenTo) {
		this.daysOpenTo = daysOpenTo;
	}

	public List<String> getStatusValues() {
		return statusValues;
	}

	public void setStatusValues(List<String> statusValues) {
		this.statusValues = statusValues;
	}
    
    
    
}

import java.util.ArrayList;
import java.util.Collections;

public class TicketOffice {
	private double ticketPrice;
	private double currentEarnings;
	private ArrayList<Integer> stands;

	public TicketOffice() {
		this.ticketPrice = 15;
		this.currentEarnings = 0;
		this.stands = new ArrayList<Integer>();
		this.stands.add(1500);
	}

	public TicketOffice(double ticketPrice, int numberOfStands, int amountOfSeatsPerStand) {
		this.ticketPrice = ticketPrice > 0 ? ticketPrice : 15;
		this.currentEarnings = 0;
		this.stands = new ArrayList<Integer>();
		amountOfSeatsPerStand = amountOfSeatsPerStand > 0 ? amountOfSeatsPerStand : 1500;
		numberOfStands = numberOfStands > 0 ? numberOfStands : 1;

		stands.addAll(Collections.nCopies(numberOfStands, amountOfSeatsPerStand));
	}

	public TicketOffice(double ticketPrice, ArrayList<Integer> predefinedStands) {
		this.ticketPrice = ticketPrice > 0 ? ticketPrice : 15;
		this.currentEarnings = 0;
		this.stands = new ArrayList<Integer>();

		if (predefinedStands.isEmpty() || predefinedStands == null) {
			this.stands.add(1500);
		} else {
			stands.addAll(predefinedStands);

			for (int index = 0; index < stands.toArray().length; index++) {
				if (stands.get(index) < 0) {
					stands.set(index, 1500);
				}
			}
		}
	}

	public boolean buyTickets(int amountOfTicketsToBuy, int standIndex) {
		if (standIndex - 1 < 0 || (standIndex - 1) > (stands.toArray().length - 1)) {
			System.out.println("This Stand number does not exist, try a value between 1 and " + stands.toArray().length);
			return false;
		}

		if (amountOfTicketsToBuy <= 0) {
			System.out.println("Invalid amount of Tickets");
			return false;
		}

		for (int index = 0; index < stands.toArray().length; index++) {
			if (index == (standIndex - 1)) {
				if (stands.get(index) < amountOfTicketsToBuy) {
					System.out.println("This stand does not have enough Space");
					return false;
				}

				stands.set(index, stands.get(index) - amountOfTicketsToBuy);
				this.currentEarnings = this.ticketPrice * amountOfTicketsToBuy;
				return true;
			}
		}

		return false;
	}

	public int availableStands()
	{
		int standsWithAvailableTickets = 0;

		for (int standTickets: stands)
		{
			if (standTickets > 0)
			{
				standsWithAvailableTickets++;
			}
		}

		return standsWithAvailableTickets;
	}

	public int filledStands()
	{
		return stands.toArray().length - availableStands();
	}

	public boolean isFull()
	{
		if (filledStands() == stands.toArray().length)
		{
			return true;
		}

		return false;
	}

	public void showInfo()
	{
		System.out.println(infoAsString());
	}

	private String infoAsString()
	{
		String info = "----- TicketOffice -----" +
			"\nIndividual Ticket Price: " + this.ticketPrice +
			"\nTotal Sale Earnings: " + this.currentEarnings +
			"\nAvailable Spots:";

		for (int index = 0; index < stands.toArray().length; index++) {
			info += "\n\tStand " + (index + 1) + " - " + stands.get(index) + " Ticket(s)";
		}

		return info;
	}
}

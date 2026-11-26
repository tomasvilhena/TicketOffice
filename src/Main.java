public class Main
{
	public static void main(String args[])
	{
		InputReader inputReader = new InputReader();

		double ticketPrice = inputReader.getDecimalNumber("How much should the tickets cost? ", 1.0, 50.0);
		int numberOfStands = inputReader.getIntegerNumber("How many stands does the show have available? ", 1, 20);
		int amountOfSeatsPerStand = inputReader.getIntegerNumber("How many people can each Stand Take? ", 100, 2000);
		TicketOffice ticketOffice = new TicketOffice(ticketPrice, numberOfStands, amountOfSeatsPerStand);

		do {
			clear();
			System.out.println("---- Ticket Office Manager -----");
			System.out.println("1. Show Ticket Office info.");
			System.out.println("2. Buy an Amount of tickets.");
			System.out.println("3. Check if its full.");
			System.out.println("4. Check how many stands are filled.");
			System.out.println("5. Check how many stands still have Available seats");
			System.out.println("6. Close the program");
			int option = inputReader.getIntegerNumber("Select an option", 1, 6);

			switch (option)
			{
				case 1:
				{
					clear();
					ticketOffice.showInfo();
					inputReader.readLine("Press enter to go back... ");
					break;
				}

				case 2:
				{
					clear();
					int standIndex = inputReader.getIntegerNumber("You wanna buy tickets for what stand? ", 1, numberOfStands);
					int amountOfTickets = inputReader.getIntegerNumber("How many tickets do you want to buy for this stand? ", 1, amountOfSeatsPerStand);
					if (ticketOffice.buyTickets(amountOfTickets, standIndex))
					{
						System.out.println("You have successfully bought " + amountOfTickets + " tickets for stand " + standIndex + "!");
						inputReader.readLine("Press enter to go back... ");
						break;
					} else
					{
						System.out.println("Operation cancelled, We where unable to fulfil the request!");
						inputReader.readLine("Press enter to go back... ");
						break;
					}
				}

				case 3:
				{
					clear();
					if (ticketOffice.isFull())
					{
						System.out.println("The Show is unfortunately full!");
					} else
					{
						System.out.println("The Show still has some spots left with places to seat!");
					}

					inputReader.readLine("Press enter to go back... ");
					break;
				}

				case 4:
				{
					clear();
					System.out.println("There is (are) " +  ticketOffice.filledStands() + " stand (s) filled");
					inputReader.readLine("Press enter to go back... ");
					break;
				}


				case 5:
				{
					clear();
					System.out.println("There is (are) " + ticketOffice.availableStands() + " stand (s) with seats available");
					inputReader.readLine("Press enter to go back... ");
					break;
				}

				case 6:
				{
					clear();
					System.out.println("Goodbye!");
					System.exit(0);
				}
			}
		} while(true);
	}

	public static void clear()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}

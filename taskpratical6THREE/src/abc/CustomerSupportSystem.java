package abc;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Ticket class representing a customer support ticket
class Ticket {
    private int id;
    private String description;

    public Ticket(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Description: " + description;
    }
}

public class CustomerSupportSystem {
    // Using LinkedList as the queue to store the tickets
    private Queue<Ticket> ticketQueue;
    private int ticketCounter;

    public CustomerSupportSystem() {
        ticketQueue = new LinkedList<>();
        ticketCounter = 1;
    }

    // Method to add a new ticket to the queue
    public void addTicket(String description) {
        Ticket newTicket = new Ticket(ticketCounter++, description);
        ticketQueue.add(newTicket);
        System.out.println("Ticket added: " + newTicket);
    }

    // Method to process (remove) the next ticket in line
    public void processNextTicket() {
        Ticket nextTicket = ticketQueue.poll();
        if (nextTicket != null) {
            System.out.println("Processing ticket: " + nextTicket);
        } else {
            System.out.println("No tickets to process.");
        }
    }

    // Method to display all pending tickets
    public void displayPendingTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending Tickets:");
            for (Ticket ticket : ticketQueue) {
                System.out.println(ticket);
            }
        }
    }

    // Main method to run the ticket system
    public static void main(String[] args) {
        CustomerSupportSystem supportSystem = new CustomerSupportSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCustomer Support Ticket System:");
            System.out.println("1. Add a new ticket");
            System.out.println("2. Process the next ticket");
            System.out.println("3. Display all pending tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter ticket description: ");
                    String description = scanner.nextLine();
                    supportSystem.addTicket(description);
                    break;
                case 2:
                    supportSystem.processNextTicket();
                    break;
                case 3:
                    supportSystem.displayPendingTickets();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}



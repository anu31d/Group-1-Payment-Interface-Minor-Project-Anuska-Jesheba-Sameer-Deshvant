import java.util.Scanner;

interface PaymentMethod 
{
    void makePayment();
}

class UpiPayment implements PaymentMethod 
{
    private double amount;
    private String upiId;

    public UpiPayment(double amount, String upiId) 
    {
        this.amount = amount;
        this.upiId = upiId;
    }

    public void makePayment() 
    {
        System.out.println("UPI Payment of " + amount + " using UPI ID: " + upiId);
        System.out.println("Payment Successful!");
    }
}

class CardPayment implements PaymentMethod 
{
    private double amount;
    private String cardNumber;
    private String cardHolder;

    public CardPayment(double amount, String cardNumber, String cardHolder) 
    {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public void makePayment() 
    {
        System.out.println("Card Payment of " + amount + " using Card Number: " + cardNumber);
        System.out.println("Card Holder Name: " + cardHolder);
        System.out.println("Payment Successful!");
    }
}

class WalletPayment implements PaymentMethod 
{
    private double amount;
    private String provider;

    public WalletPayment(double amount, String provider) 
    {
        this.amount = amount;
        this.provider = provider;
    }

    public void makePayment() 
    {
        System.out.println("Wallet Payment of " + amount + " via " + provider + " Wallet");
        System.out.println("Payment Successful!");
    }
}

public class paymentInterface
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Payment Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Wallet");
        System.out.print("Choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        PaymentMethod method;

        if (choice == 1) 
        {
            System.out.print("Enter UPI ID: ");
            String upi = sc.nextLine();
            method = new UpiPayment(amount, upi);
        }
        else if (choice == 2) 
        {
            System.out.print("Enter Card Number: ");
            String cardNo = sc.nextLine();
            System.out.print("Enter Card Holder Name: ");
            String name = sc.nextLine();
            method = new CardPayment(amount, cardNo, name);
        }
        else if (choice == 3) 
        {
            System.out.print("Enter Wallet Provider: ");
            String provider = sc.nextLine();
            method = new WalletPayment(amount, provider);
        }
        else 
        {
            System.out.println("Invalid Option!");
            sc.close();
            return;
        }

        System.out.println("\n--- Processing Payment ---");
        method.makePayment();

        sc.close();
    }
}

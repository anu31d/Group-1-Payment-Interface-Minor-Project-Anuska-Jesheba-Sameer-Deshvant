import java.util.Scanner;

interface PaymentMethod 
{
    void makePayment(double paymentAmount);
}

abstract class BasePayment implements PaymentMethod 
{
    protected double paymentAmount;

    public BasePayment(double paymentAmount) 
    {
        this.paymentAmount = paymentAmount;
    }
}

class UpiPayment extends BasePayment 
{
    private String upiId;

    public UpiPayment(double paymentAmount, String upiId) 
    {
        super(paymentAmount);
        this.upiId = upiId;
    }

    public void makePayment(double paymentAmount) 
    {
        System.out.println("Processing UPI payment of " + paymentAmount + " using UPI ID: " + upiId);
        System.out.println("UPI Payment Successful");
    }
}

class CardPayment extends BasePayment 
{
    private String cardNumber;
    private String cardHolderName;

    public CardPayment(double paymentAmount, String cardNumber, String cardHolderName) 
    {
        super(paymentAmount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public void makePayment(double paymentAmount) 
    {
        System.out.println("Processing Card payment of " + paymentAmount + " using card: " + cardNumber);
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Payment Successful");
    }
}

class WalletPayment extends BasePayment 
{
    private String walletProvider;

    public WalletPayment(double paymentAmount, String walletProvider) 
    {
        super(paymentAmount);
        this.walletProvider = walletProvider;
    }

    public void makePayment(double paymentAmount) 
    {
        System.out.println("Processing Wallet payment of " + paymentAmount + " via " + walletProvider + " Wallet");
        System.out.println("Wallet Payment Successful");
    }
}

public class paymentInterface
{
    public static void main(String[] args) 
    {
        Scanner scannerInput = new Scanner(System.in);

        System.out.println("Enter Payment Amount:");
        double paymentAmount = scannerInput.nextDouble();
        scannerInput.nextLine();

        System.out.println("Select Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Wallet");

        int selectedOption = scannerInput.nextInt();
        scannerInput.nextLine();

        PaymentMethod paymentMethod;

        if (selectedOption == 1) 
        {
            System.out.println("Enter UPI ID:");
            String userUpiId = scannerInput.nextLine();
            paymentMethod = new UpiPayment(paymentAmount, userUpiId);
        } 
        else if (selectedOption == 2) 
        {
            System.out.println("Enter Card Number:");
            String userCardNumber = scannerInput.nextLine();

            System.out.println("Enter Card Holder Name:");
            String userCardHolderName = scannerInput.nextLine();

            paymentMethod = new CardPayment(paymentAmount, userCardNumber, userCardHolderName);
        } 
        else if (selectedOption == 3) 
        {
            System.out.println("Enter Wallet Provider (Paytm/PhonePe/AmazonPay):");
            String walletProvider = scannerInput.nextLine();
            paymentMethod = new WalletPayment(paymentAmount, walletProvider);
        } 
        else 
        {
            System.out.println("Invalid Option");
            return;
        }

        paymentMethod.makePayment(paymentAmount);
    }
}

interface PaymentMethod {
    void processPayment(double amount);
}

// Separate interface for authentication
interface Authenticatable {
    void authenticate();
}

// Payment methods
class CreditCardPayment implements PaymentMethod, Authenticatable {
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit card payment: $" + amount);
    }

    @Override
    public void authenticate() {
        System.out.println("Authenticating credit card...");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal payment: $" + amount);
    }
}

class GooglePayPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Google Pay payment: $" + amount);
    }
}

// DIP: Processor depends only on PaymentMethod abstraction
class PaymentProcessor {
    private final PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    void executePayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}

// Decorator for payment methods that require authentication
class AuthenticatedPaymentProcessor extends PaymentProcessor {
    private final Authenticatable authenticatable;

    public AuthenticatedPaymentProcessor(PaymentMethod paymentMethod, Authenticatable authenticatable) {
        super(paymentMethod);
        this.authenticatable = authenticatable;
    }

    @Override
    void executePayment(double amount) {
        authenticatable.authenticate();
        super.executePayment(amount);
    }
}

// Usage
public class Assigment_3  {
    public static void main(String[] args) {
        // Payment that requires authentication
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentProcessor creditCardProcessor = new AuthenticatedPaymentProcessor(creditCard, (Authenticatable) creditCard);
        creditCardProcessor.executePayment(150.00);

        // Payment that doesn't require authentication
        PaymentMethod paypal = new PayPalPayment();
        PaymentProcessor paypalProcessor = new PaymentProcessor(paypal);
        paypalProcessor.executePayment(75.00);
    }
}

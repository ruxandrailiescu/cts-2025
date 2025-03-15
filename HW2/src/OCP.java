abstract class Payment {
    double value;

    public Payment(double value) {
        this.value = value;
    }

    public abstract void process();
}

class Visa extends Payment {
    String ibanFrom, ibanTo;

    public Visa(String ibanFrom, String ibanTo, double value) {
        super(value);
        this.ibanFrom = ibanFrom;
        this.ibanTo = ibanTo;
    }

    @Override
    public void process() {
        System.out.println("Visa payment processed");
    }
}

class Mastercard extends Payment {
    String ibanFrom, ibanTo;

    public Mastercard(String ibanFrom, String ibanTo, double value) {
        super(value);
        this.ibanFrom = ibanFrom;
        this.ibanTo = ibanTo;
    }

    @Override
    public void process() {
        System.out.println("Mastercard payment processed");
    }
}

class Bitcoin extends Payment {
    String addressFrom, addressTo;
    double rate;

    public Bitcoin(String addressFrom, String addressTo, double rate, double value) {
        super(value);
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.rate = rate;
    }

    @Override
    public void process() {
        System.out.println("Bitcoin payment processed");
    }
}

class Ethereum extends Payment {
    String addressFrom, addressTo;
    double rate;

    public Ethereum(String addressFrom, String addressTo, double rate, double value) {
        super(value);
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.rate = rate;
    }

    @Override
    public void process() {
        System.out.println("Ethereum payment processed");
    }
}

class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.process();
    }
}

public class OCP {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        Payment visa = new Visa("RO12BANK123", "RO34BANK456", 100.0);
        Payment mastercard = new Mastercard("RO56BANK789", "RO78BANK101", 150.0);
        Payment bitcoin = new Bitcoin("1A2B3C", "4D5E6F", 0.000025, 200.0);
        Payment ethereum = new Ethereum("0x123", "0x456", 0.00035, 500.0);

        processor.processPayment(visa);
        processor.processPayment(mastercard);
        processor.processPayment(bitcoin);
        processor.processPayment(ethereum);
    }
}

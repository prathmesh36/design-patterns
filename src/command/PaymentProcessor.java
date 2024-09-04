package command;

import command.commands.Command;
import command.commands.EnrichmentCommand;
import command.commands.SanctionsCommand;
import command.dto.payment.INDPayment;
import command.dto.payment.Payment;
import command.dto.payment.USPayment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaymentProcessor {
    List<Command> commands = new ArrayList<>();
    Payment payment;

    public PaymentProcessor(String accountNumber, String financialInstitutionIdentifier, String amount, String countryCode) throws Exception {
        this.payment = switch (countryCode) {
            case "IND" -> new INDPayment(accountNumber, financialInstitutionIdentifier);
            case "US" -> new USPayment(accountNumber, financialInstitutionIdentifier);
            default -> throw new Exception();
        };
        this.payment.setAmount("1000.00");
        this.commands = Arrays.asList(new EnrichmentCommand(this.payment), new SanctionsCommand(this.payment));
    }

    public void process(){
        for(Command command: this.commands){
            command.execute();
        }
        System.out.println(payment);
    }
}

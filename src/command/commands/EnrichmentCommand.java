package command.commands;

import command.dto.payment.Payment;

public class EnrichmentCommand implements Command {
    private final Payment payment;

    public EnrichmentCommand(Payment payment){
        this.payment = payment;
    }

    @Override
    public void execute() {
        this.payment.setBankNameFromFinancialInstitutionIdentifier();
        System.out.println("Enrichment Command Executed");
    }
}

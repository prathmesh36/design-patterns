package command.commands;

import command.dto.payment.Payment;

public class SanctionsCommand implements Command {
    private final Payment payment;

    public SanctionsCommand(Payment payment){
        this.payment = payment;
    }

    @Override
    public void execute() {
        this.payment.setSanctioned(true);
        System.out.println("Sanctions Command Executed");
    }
}

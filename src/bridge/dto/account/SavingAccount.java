package bridge.dto.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SavingAccount extends AccountImpl{
    private Map<String, List<Double>> termDeposits = new HashMap<String, List<Double>>();

    @Override
    public Map<String, List<Double>> getTermDeposits() {
        return termDeposits;
    }

    @Override
    public void setTermDeposits(Map<String, List<Double>> termDeposits) {
        this.termDeposits = termDeposits;
    }

    @Override
    public void getReport(){
        System.out.println("--------Savings Account Details--------");
        super.getReport();
    }
}

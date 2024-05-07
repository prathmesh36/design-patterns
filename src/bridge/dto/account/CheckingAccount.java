package bridge.dto.account;

public class CheckingAccount extends AccountImpl {
    private int age;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void getReport(){
        System.out.println("--------Checking Account Details--------");
        super.getReport();
    }
}

package pjwstk.s25668Bank;

public class User {
    private String id;
    private double saldo;

    public User(String id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", saldo=" + saldo +
                '}';
    }
}

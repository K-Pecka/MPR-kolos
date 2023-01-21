package pjwstk.s25668Bank;

public class Transfer {
    private String status;
    private double saldo;
    private User user;
    private String comment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Transfer(String status, double saldo, User user, String comment) {
        this.status = status;
        this.saldo = saldo;
        this.user = user;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "status='" + status + '\'' +
                ", saldo=" + saldo +
                ", user=" + user +
                ", comment='" + comment + '\'' +
                '}';
    }
}

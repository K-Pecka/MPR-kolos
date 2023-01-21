package pjwstk.s25668Bank;

import org.springframework.stereotype.Component;

@Component
public class Bank {
    UserStorage userStorage;
    TransferStorage transferStorage;
    public Bank(UserStorage userStorage,TransferStorage transferStorage)
    {
        this.userStorage = userStorage;
        this.transferStorage = transferStorage;
    }
    public User registration(String id,double saldo)
    {
        if(saldo<0)
        {
            return null;
        }
        User client =new User(id,saldo);
        userStorage.addUser(client);
        return  client;
    }
    public Transfer transferOrder(String id,double saldo)
    {
        User find = userStorage.findAccount(id);
        if(find == null)
        {
            return new Transfer("DECLINED",0,null,"user not found");
        }
        double userSaldo = find.getSaldo() - saldo;
        if(userSaldo < 0)
        {
            return  new Transfer("DECLINED",find.getSaldo(),find,"not enough money to transfer money");
        }
        else
        {
            find.setSaldo(userSaldo);
            return new Transfer("ACCEPTED",find.getSaldo(),find,"successfully");
        }
    }
    public Transfer withdrawMoney(String id,double saldo)
    {
        User find = userStorage.findAccount(id);
        if(find == null)
        {
            return new Transfer("DECLINED",0,null,"user not found");
        }
        double userSaldo = find.getSaldo()+saldo;
        return new Transfer("ACCEPTED",userSaldo,find,"successfully");
    }
}

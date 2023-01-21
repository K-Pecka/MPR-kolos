package pjwstk.s25668Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BankIntegrationTest {
    @Mock
    private TransferStorage transferStorage;
    @Mock
    private UserStorage userStorage;
    @InjectMocks
    private Bank bank;

    @Test
    public void negativeBalanceRegistration()
    {
        assertThat(bank.registration("1",-100)).isEqualTo(null);
    }
    @Test
    public void transferFromNon_existentAccount()
    {
        Transfer transfer = new Transfer("DECLINED",0,null,"user not found");
        when(userStorage.findAccount(any())).thenReturn(null);
        assertThat(bank.transferOrder("1",100).getComment()).isEqualTo(transfer.getComment());
    }
    @Test
    public void transferFromAnAccountWithInsufficientFunds()
    {
        Transfer transfer = new Transfer("DECLINED",200,new User("1",100),"not enough money to transfer money");
        when(userStorage.findAccount(any())).thenReturn(new User("1",100));
        assertThat(bank.transferOrder("1",200).getComment()).isEqualTo(transfer.getComment());
    }
    @Test
    public void paymentToNon_existentAccount()
    {
        Transfer transfer = new Transfer("DECLINED",0,null,"user not found");
        when(userStorage.findAccount(any())).thenReturn(null);
        assertThat(bank.transferOrder("1",200).getComment()).isEqualTo(transfer.getComment());
    }
    @Test
    public void happyTestTransfer()
    {
        Transfer transfer = new Transfer("ACCEPTED",100,new User("1",100),"successfully");
        when(userStorage.findAccount(any())).thenReturn(new User("1",200));
        assertThat(bank.transferOrder("1",100).getComment()).isEqualTo(transfer.getComment());
    }
    @Test
    public void happyTestWithDrawMoney()
    {
        Transfer transfer = new Transfer("ACCEPTED",400,new User("1",400),"successfully");
        when(userStorage.findAccount(any())).thenReturn(new User("1",200));
        assertThat(bank.withdrawMoney("1",200).getComment()).isEqualTo(transfer.getComment());
    }

}

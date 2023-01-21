package pjwstk.s25668Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransferStorage {
    private List<Transfer> transfers = new ArrayList<>();

    public void addTransfer(Transfer transfer)
    {
        transfers.add(transfer);
    }
}

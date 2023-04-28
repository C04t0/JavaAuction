package be.syntra.auction.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BankAccount extends BillingDetails {
    @NotNull
    @Column
    private String accountName;

    @NotNull
    @Column
    private String bankName;

    @NotNull
    @Column
    private String IBAN;

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("You will pay " + amount + "€ for this item.");
    }

}

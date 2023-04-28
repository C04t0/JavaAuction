package be.syntra.auction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "CREDITCARD_ID")
public class CreditCard extends BillingDetails {

    @NotNull
    @Column
    private String ccNumber;

    @Temporal(TemporalType.DATE)
    @Future
    @NotNull
    @Column
    private LocalDate expirationDate;

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("An amount of " + amount + "€ will be charged to your account.");
    }
}

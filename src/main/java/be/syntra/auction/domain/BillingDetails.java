package be.syntra.auction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String accountOwner;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public abstract void pay(BigDecimal amount);

}

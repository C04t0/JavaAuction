package be.syntra.auction.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {

    @NotNull
    @Column (nullable = false)
    private String street;

    @NotNull
    @Column(nullable = false)
    private String zipcode;

    @NotNull
    @Column(nullable = false)
    private String city;
}

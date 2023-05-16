package be.syntra.auction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "username cannot be blank.")
    @NotNull (message = "username cannot be null.")
    @NonNull
    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @NotBlank (message = "password cannot be blank.")
    @NotNull (message = "password cannot be null.")
    @NonNull
    @Column
    private String password;

    @Embedded
    @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET"))
    @AttributeOverride(name = "zipcode", column = @Column(name = "HOME_ZIPCODE"))
    @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY"))
    private Address homeAddress;

    @Embedded
    @AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET"))
    @AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE"))
    @AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY"))
    private Address billingAddress;

    @Embedded
    @AttributeOverride(name = "street", column = @Column(name = "SHIPPING_STREET"))
    @AttributeOverride(name = "zipcode", column = @Column(name = "SHIPPING_ZIPCODE"))
    @AttributeOverride(name = "city", column = @Column(name = "SHIPPING_CITY"))
    private Address shippingAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BillingDetails> billingDetails = new ArrayList<>();
}

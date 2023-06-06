package be.syntra.auction.domain;

import be.syntra.auction.security.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User implements UserDetails {
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

    @OneToMany(mappedBy = "id", fetch =  FetchType.LAZY, orphanRemoval = true)
    @Column
    private List<Item> items;

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
    @Column
    private List<BillingDetails> billingDetails = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Collection<GrantedAuthority> authorities;


    //security implements

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

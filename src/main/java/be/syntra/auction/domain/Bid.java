package be.syntra.auction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BIDS")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column
    private BigDecimal amount;
    @NonNull
    @Temporal(TemporalType.DATE)
    @Past
    @Column
    private LocalDate createdOnDate;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;

}

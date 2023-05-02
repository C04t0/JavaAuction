package be.syntra.auction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @Column (nullable = false)
    @NonNull
    private BigDecimal initialPrice;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private LocalDate auctionEndDate;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Bid> bids;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

}

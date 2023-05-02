package be.syntra.auction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "IMAGES")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column (nullable = false)
    private String title;
    @NotNull
    @Column (nullable = false)
    private String filename;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;
}

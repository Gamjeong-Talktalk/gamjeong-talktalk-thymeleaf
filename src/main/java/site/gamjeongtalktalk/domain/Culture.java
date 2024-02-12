package site.gamjeongtalktalk.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "t_culture")
@NoArgsConstructor(access = PROTECTED)
public class Culture {

    @Id
    @GeneratedValue
    @Column(name = "culture_id")
    private Long id;
    private String name;
    private int price;
    private String manager;
    private String date;

    @Builder
    private Culture(
            String name,
            int price,
            String manager,
            String date
    ) {
        this.name = name;
        this.price = price;
        this.manager = manager;
        this.date = date;
    }

    public static Culture create(
            String name,
            int price,
            String manager,
            String date
    ) {
        return Culture.builder()
                .name(name)
                .price(price)
                .manager(manager)
                .date(date)
                .build();
    }
}

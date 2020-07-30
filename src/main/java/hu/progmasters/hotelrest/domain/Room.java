package hu.progmasters.hotelrest.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "size")
    @NotNull
    private RoomSize size;

    @Column(name = "is_reserved")
    private boolean isReserved = false;

    @Column(name = "number")
    @Min(0)
    @Max(10_000)
    private int number;

    @Column(name = "price")
    @Min(0)
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @NotNull
    private Hotel hotel;
}

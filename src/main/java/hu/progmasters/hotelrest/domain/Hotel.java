package hu.progmasters.hotelrest.domain;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@OneToOne
    //@JoinColumn(name = "address_id")
    //Embedded: hotel-en belül hozza létre az oszlopokat(nem külön tábla lesz)
    //csak one to one kapcsolatnál lehetséges, Address-nél Embeddable, nem Entity, id sem kell

    @Embedded
    private Address address;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "stars")
    private HotelRating stars;


    //csak 255 karakter, ezért megkell adni milyen típusként hozza létre: "TEXT"
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "hotel")
    @JoinColumn(name = "hotel_id")
    private List<Room> roomList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelRating getStars() {
        return stars;
    }

    public void setStars(HotelRating stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}

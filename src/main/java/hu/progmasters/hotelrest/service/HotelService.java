package hu.progmasters.hotelrest.service;


import hu.progmasters.hotelrest.domain.Hotel;
import hu.progmasters.hotelrest.domain.dto.HotelListItem;
import hu.progmasters.hotelrest.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public List<HotelListItem> findAll() {
        List<Hotel> all = hotelRepository.findAll();

        //egyik megoldás:
        List<HotelListItem> hotelListItems = new ArrayList<>();
        for (Hotel hotel : all) {
            HotelListItem hotelListItem = new HotelListItem(hotel);
            hotelListItems.add(hotelListItem);
        }
        return hotelListItems;

       //Strem API megoldása:  return hotelRepository.
        //                              findAll()
        //                              .stream()
        //                              .map(HotelListItem::new)
        //                              .collect(Collectors.toList());)
    }
}

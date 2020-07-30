package hu.progmasters.hotelrest.controller;

import hu.progmasters.hotelrest.domain.dto.HotelListItem;
import hu.progmasters.hotelrest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping
    public ResponseEntity<List<HotelListItem>> list() {
        List<HotelListItem> hotelListItems = hotelService.findAll();

        return new ResponseEntity<>(hotelListItems, HttpStatus.OK);
    }


}

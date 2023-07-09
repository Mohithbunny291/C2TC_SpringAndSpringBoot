package com.cg.ips.iplacementservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PlacementController {

    @Autowired
    private PlacementService service;

    @GetMapping("/placements")
    public List<Placement> list(){

        return service.listAll();                                                        //  Listing all the placements that are there
    }


    @PostMapping("/placement")
    public void addPlacement(@RequestBody Placement placement){

        service.save(placement);                                                         // 1 - Adding a placement details
    }


    @PutMapping("/placement/{id}")
    public ResponseEntity<?> updatePlacement(@RequestBody Placement placement, @PathVariable Integer id){

        try {
            Placement existPlacement = service.get(id);
            service.save(placement);
            return new ResponseEntity<>(HttpStatus.OK);                                  // 2 - updating the placement details
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/placement/{id}")
    public ResponseEntity<Placement> searchPlacement(@PathVariable Integer id){

        try {
            Placement existPlacement = service.get(id);
            return new ResponseEntity<Placement>(existPlacement, HttpStatus.OK);         // 3 - Searching the placement by ID
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("placement/{id}")
    public void cancelPlacement(@PathVariable Integer id){

    	if(service.get(id) == null) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        service.delete(id);                                                              // 4 - Deleting the placement
    }


    @DeleteMapping("placements/deleteAllP")
    public void cancelAllPlacement(){

    	//if (service.listAll() != null) {
    		service.deleteAll();
	//	}
    //    throw new ResponseStatusException(HttpStatus.NOT_FOUND);                       // 5 - Deleting all the placements
    }
}

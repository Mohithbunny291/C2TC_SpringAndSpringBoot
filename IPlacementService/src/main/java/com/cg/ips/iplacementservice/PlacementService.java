package com.cg.ips.iplacementservice;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlacementService {

    @Autowired
    private PlacementRepository repository;

    public List<Placement> listAll(){
        return repository.findAll();                       // Listing all the placements that are there......
    }


    public void save(Placement placement){
        repository.save(placement);                        // 1 and 2 - Adding or Updating a placement details......
    }


    public Placement get(Integer id){

        return repository.findById(id).get();              // 3 - Get placement by ID.....
    }


    public void delete(Integer id){

        repository.deleteById(id);                         // 4 - Deleting the placement.....
    }


    public void deleteAll(){
        repository.deleteAll();                            // 5 - Deleting all the placements.....
    }

}

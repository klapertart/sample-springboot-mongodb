package klapertart.lab.mongodb.controller;

import klapertart.lab.mongodb.model.GroceryItem;
import klapertart.lab.mongodb.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author kurakuraninja
 * @since 13/02/23
 */

@RestController
@RequestMapping("/api")
public class GroceryController {

    @Autowired
    private GroceryRepository groceryRepository;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome MongoDB API";
    }

    @PostMapping("/grocery")
    public ResponseEntity<GroceryItem> createGrocery(@RequestBody GroceryItem groceryItem){
        try{
            GroceryItem save = groceryRepository.save(groceryItem);
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.example.serviciodocentes.controller;

import com.example.serviciodocentes.entitys.LineaInv;
import com.example.serviciodocentes.entitys.UserDto;
import com.example.serviciodocentes.services.LineaInvService;

import com.example.serviciodocentes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lineas")
public class LineaController {
    @Autowired
    private LineaInvService lineaInvService;
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<LineaInv>> getAlllinea(
            @RequestHeader("Authorization") String jwt) throws Exception {
        UserDto user =userService.getUserProfile(jwt);

        List<LineaInv> lineass = lineaInvService.getAllLineas();

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LineaInv> createLineas(@RequestBody LineaInv lineaInv,
                                               @RequestHeader("Authorization") String jwt) throws Exception {

        UserDto user = userService.getUserProfile(jwt);
        System.out.println(user.toString());
        LineaInv createdlineas = lineaInvService.createLineas(lineaInv, user.getRol());
        return new ResponseEntity<>(createdlineas, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LineaInv> getTareasById(@PathVariable Long id,
                                                @RequestHeader("Authorization") String jwt) throws Exception {

        UserDto user = userService.getUserProfile(jwt);
        LineaInv lineass = lineaInvService.getLineasById(id);
        return new ResponseEntity<>(lineass, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LineaInv> updateTareas(
            @PathVariable Long id,
            @RequestBody LineaInv req,
            @RequestHeader("Authorization") String jwt) throws Exception {
        UserDto user = userService.getUserProfile(jwt);

        LineaInv lineass = lineaInvService.updateLineas(id,req,user.getId());

        return new ResponseEntity<>(lineass, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTareas(
            @PathVariable Long id) throws Exception {


        lineaInvService.deleteLineas(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.example.web4.controllers;

import com.example.web4.dtos.ShotSaveDto;
import com.example.web4.entities.Shot;
import com.example.web4.services.ShotService;
import com.example.web4.services.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shot")
public class ShotController {
    private final UserService userService;
    private final ShotService shotService;

    @PostMapping("/save")
    public void saveShot(@RequestBody @Valid ShotSaveDto shotSaveDto) {
        Shot shot = new Shot();
//        shot.setCreator(userService.findByLogin(shotSaveDto.getCreatorLogin())
//                .orElseThrow(() -> new RuntimeException("You are not authorized")));
        shot.setX(shotSaveDto.getX());
        shot.setR(shotSaveDto.getR());
        shot.setY(shotSaveDto.getY());
        shotService.saveShot(shot);
    }

    @GetMapping("/get")
    public List<Shot> getShots() {
        return shotService.getAllShots();
    }
}

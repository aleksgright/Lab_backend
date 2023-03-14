package com.example.web4.services;

import com.example.web4.daos.ShotRepository;
import com.example.web4.entities.Shot;
import com.example.web4.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

import static java.lang.Math.sqrt;

@Service
@AllArgsConstructor
public class ShotService {
    private final ShotRepository shotRepository;

    public Shot saveShot(Shot shot) {
        //проверить попадания и засечь время
        long executionTime = System.nanoTime();
        shot.setHitvalue(checkShot(shot.getX(), shot.getY(), shot.getR()));
        shot.setExecutiontime(System.nanoTime() - executionTime);
        shot.setShottime(new Date(System.currentTimeMillis()));
        if (shot.isHitvalue()) {
            shot.setColor("#FFFFFF");
        } else {
            shot.setColor("#000000");
        }
        return shotRepository.save(shot);
    }

    public List<Shot> getAllShots(){
        return shotRepository.findAll();
    }

//    public List<Shot> findAllByCreator(User user) {
//        return shotRepository.findAllByCreator(user);
//    }

    private boolean checkShot(double x, double y, double r) {
        boolean hit;
        if (x > 0) {
            if (y <= 0) {
                // Circle with radius R
                hit = (sqrt(x * x + y * y) <= r);
            } else {
                // y < -2x + r
                hit = (x<=r/2 && y <=-2*x+r);
            }
        } else {
            if (y >= 0) {
                hit = false;
            } else {
                hit = (x >= -r/2 && y>=-r);
            }
        }
        return hit;
    }
}

package com.example.hospitalspring.controller;

import com.example.hospitalspring.model.Visit;
import com.example.hospitalspring.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("visits")
public class VisitController {
    final VisitService visitService;
    @GetMapping("all")
    public List<Visit> getAllVisits(){
        return visitService.getAllVisits();
    }
    @PostMapping("save")
    public void saveVisit(@RequestBody Visit visit){
        visitService.saveVisit(visit);
    }
    @GetMapping("cnp/{cnp}")
    public List<Visit> getAllByCnp(@PathVariable String cnp){
        return visitService.getVisitsByCnp(cnp);
    }
    @GetMapping("specialty/{specialty}")
    public List<Visit> getAllBySpecialty(@PathVariable String specialty){
        return visitService.getVisitsBySpecialty(specialty);
    }

}

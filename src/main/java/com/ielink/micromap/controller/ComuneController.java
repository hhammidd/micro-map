package com.ielink.micromap.controller;

import com.ielink.micromap.dto.ComuneTo;
import com.ielink.micromap.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/comune-config")
@CrossOrigin(origins = "*")
public class ComuneController {

    @Autowired
    private ComuneService comuneService;

    @GetMapping("/{comuneID}")
    public ComuneTo getComuneById(@PathVariable(name = "comuneID") long comuneID) {
        //
        System.out.println(comuneID);

        try {
            return comuneService.getComuneById(comuneID);
        } catch (NoSuchElementException e) {
            return null;//TODO
        }

    }

    @GetMapping
    public List<ComuneTo> getComuni() {
        System.out.println("sss");
        return comuneService.getComunes();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createComune(@RequestBody ComuneTo comuneTo) {
        comuneService.createComunes(comuneTo);
        System.out.println("ss");
    }

    @DeleteMapping("/{comuneId}")
    public String deleteComune(@PathVariable(name = "comuneId") long comuneId) {
        return comuneService.deleteComuneById(comuneId);
    }


    @PutMapping("/{comuneId}")
    public ComuneTo update(@PathVariable(name = "comuneId") long comuneId,
                           @RequestBody ComuneTo comuneTo) {
        return comuneService.updateComune(comuneTo, comuneId);
    }
}

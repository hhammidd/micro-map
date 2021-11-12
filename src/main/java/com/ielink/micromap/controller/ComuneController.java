package com.ielink.micromap.controller;

import com.ielink.micromap.dto.ComuneTo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/comune-config")
@CrossOrigin(origins = "*")
public class ComuneController {


    @GetMapping("/{comuneID}")
    public ComuneTo getComuneById(@PathVariable(name = "comuneID") long comuneID) {
        //
        System.out.println(comuneID);

        return new ComuneTo(1L, "Turin" + Math.random(), "Milan", "Milan", 2);

    }

    @GetMapping
    public List<ComuneTo> getComuni() {
        System.out.println("sss");
        List<ComuneTo> h = new ArrayList<>();
        ComuneTo comuneObj = new ComuneTo();

        for (int i = 0; i < 9; i++) {
            comuneObj.setComuneId((1 + (long) i));
            comuneObj.setComuneName1("Turin" + Math.random());
            comuneObj.setComuneName2("comune name" + Math.random());
            comuneObj.setCodeComune("code " + Math.random());
            comuneObj.setCodeFather(i);

            h.add(comuneObj);
        }


        return h;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createComune(@RequestBody ComuneTo comuneTo) {
        //
        System.out.println("ss");
    }

    @DeleteMapping("/{comuneId}")
    public String deleteComune(@PathVariable(name = "employeeID") long employeeID) {
        return "deleted";
    }


    @PutMapping("/{comuneId}")
    public ComuneTo update(@PathVariable(name = "comuneId") long comuneId,
                           @RequestBody ComuneTo comuneTo) {
        ComuneTo comuneObj = new ComuneTo();
        comuneObj.setComuneId(1L);
        comuneObj.setComuneName1("ssss");
        comuneObj.setComuneName2("sssssd");
        comuneObj.setCodeComune("GH");
        comuneObj.setCodeFather(1);
        return comuneObj;
    }
}

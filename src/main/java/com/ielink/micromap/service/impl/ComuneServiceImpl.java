package com.ielink.micromap.service.impl;

import com.ielink.micromap.converter.ComuneMapper;
import com.ielink.micromap.dto.ComuneTo;
import com.ielink.micromap.model.Comune;
import com.ielink.micromap.dao.*;
import com.ielink.micromap.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComuneServiceImpl implements ComuneService {

    @Autowired
    private ComuneDao comuneDao;

    @Autowired
    private ComuneMapper comuneMapper;

    @Override
    public List<ComuneTo> getComunes() {
        List<Comune> comunes = comuneDao.findAll();
        List<ComuneTo> comuneTos = new ArrayList<>();

        for (Comune comune : comunes) {
            ComuneTo employeeTo = comuneMapper.convertToDto(comune);
            comuneTos.add(employeeTo);
        }
        return comuneTos;
    }

    @Override
    public void createComunes(ComuneTo comuneTo) {
        Comune comune = comuneMapper.convertToDomain(comuneTo);
        comuneDao.save(comune);
        //TODO Add check
    }

    @Override
    public ComuneTo getComuneById(long comuneID) {
        return comuneMapper.convertToDto(comuneDao.findById(comuneID).get());
    }

    @Override
    public String deleteComuneById(long comuneID) {
        Optional<Comune> employee = comuneDao.findById(comuneID);
        if (employee != null) {
            comuneDao.deleteById(comuneID);
            return "deleted";
        } else {
            return "not deleted";
        }
    }

    @Override
    public ComuneTo updateComune(ComuneTo comuneTo, long comuneID) {
        Comune comune = comuneMapper.convertToDomain(comuneTo);
        comune.setComuneId(comuneID);
        return comuneMapper.convertToDto(comuneDao.save(comune));
    }

}

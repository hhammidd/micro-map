package com.ielink.micromap.converter;


import com.ielink.micromap.dto.ComuneTo;
import com.ielink.micromap.model.Comune;
import org.springframework.stereotype.Component;

@Component
public class ComuneMapper {

    public ComuneTo convertToDto(Comune comune) {
        ComuneTo comuneTo = new ComuneTo();

        comuneTo.setComuneId(comune.getComuneId());
        comuneTo.setComuneName(comune.getComuneName());
        comuneTo.setComuneCode(comune.getComuneCode());
        comuneTo.setProvinceId(comune.getComuneFather());

        return comuneTo;
    }

    public Comune convertToDomain(ComuneTo comuneTo) {
        Comune comune = new Comune();
        comune.setComuneId(null);
        comune.setComuneName(comuneTo.getComuneName());
        comune.setComuneCode(comuneTo.getComuneCode());
        comune.setComuneFather(comuneTo.getProvinceId());

        return comune;
    }
}

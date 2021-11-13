package com.ielink.micromap.service;

import com.ielink.micromap.dto.ComuneTo;

import java.util.List;

public interface ComuneService {
    List<ComuneTo> getComunes();
    void createComunes(ComuneTo comuneTo);

    ComuneTo getComuneById(long comuneID);

    String deleteComuneById(long comuneID);

    ComuneTo updateComune(ComuneTo comuneTo, long comuneID);
}

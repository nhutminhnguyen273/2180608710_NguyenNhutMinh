package com.example.nguyennhutminh.service;

import com.example.nguyennhutminh.model.PhongBan;
import com.example.nguyennhutminh.repositories.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAll(){return phongBanRepository.findAll();}

    public Optional<PhongBan> getById(String id){return phongBanRepository.findById(id);}

    public void add(PhongBan phongBan){phongBanRepository.save(phongBan);}

    public void update(PhongBan phongBan){
        var existingPhongBan = phongBanRepository.findById(phongBan.getMaPhong())
                .orElseThrow(() -> new IllegalStateException("Not found"));
        existingPhongBan.setMaPhong(phongBan.getMaPhong());
        existingPhongBan.setTenPhong(phongBan.getTenPhong());

        phongBanRepository.save(existingPhongBan);
    }

    public void deleteById(String id){
        if (!phongBanRepository.existsById(id))
            throw new IllegalStateException("Not found");
        phongBanRepository.deleteById(id);
    }
}

package com.example.nguyennhutminh.service;

import com.example.nguyennhutminh.model.NhanVien;
import com.example.nguyennhutminh.repositories.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> getAllById(String id) {
        return nhanVienRepository.findById(id);
    }

    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void update(NhanVien nhanVien) {
        var existingNhanVien = nhanVienRepository.findById(nhanVien.getMaNV())
                .orElseThrow(() -> new IllegalStateException("Not found"));
        existingNhanVien.setMaNV(nhanVien.getMaNV());
        existingNhanVien.setTenNV(nhanVien.getTenNV());
        existingNhanVien.setPhai(nhanVien.getPhai());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setPhongBan(nhanVien.getPhongBan());
        existingNhanVien.setLuong(nhanVien.getLuong());

        nhanVienRepository.save(existingNhanVien);
    }

    public void deleteById(String id) {
        if (!nhanVienRepository.existsById(id))
            throw new IllegalStateException("Not found");
        nhanVienRepository.deleteById(id);
    }
}

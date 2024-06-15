package com.example.nguyennhutminh.controller;

import com.example.nguyennhutminh.model.NhanVien;
import com.example.nguyennhutminh.model.PhongBan;
import com.example.nguyennhutminh.service.NhanVienService;
import com.example.nguyennhutminh.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    private PhongBanService phongBanService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String nhanVien(Model model){
        List<NhanVien> nhanVien = nhanVienService.getAll();
        model.addAttribute("nhanVien", nhanVien);
        return "nhanVien/danh-sach-nhan-vien";
    }

    @GetMapping("/add")
    public String addNhanVien(Model model){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBanList", phongBanService.getAll());
        return "nhanVien/add-nv";
    }

    @PostMapping("/add")
    public String add(@Valid NhanVien nhanVien, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("nhanVien", new NhanVien());
            model.addAttribute("phongBanList", phongBanService.getAll());
            return "nhanVien/add-nv";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien";
    }

    @GetMapping("/update/{id}")
    public String updateNhanVienForm(@PathVariable("id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.getAllById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee id: " + id));
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBanList", phongBanService.getAll());
        return "nhanVien/update-nv";
    }

    @PostMapping("/update/{id}")
    public String updateNhanVien(@PathVariable("id") String id, @Valid NhanVien nhanVien,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongBanList", phongBanService.getAll());
            return "nhanVien/update-nv";
        }
        nhanVien.setMaNV(id); // Ensure the ID is set correctly
        nhanVienService.update(nhanVien);
        return "redirect:/nhan-vien"; // Redirect to the list page after update
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id){
        nhanVienService.deleteById(id);
        return "redirect:/nhan-vien";
    }
}

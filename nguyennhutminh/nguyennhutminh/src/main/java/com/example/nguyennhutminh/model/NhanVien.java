package com.example.nguyennhutminh.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @Column(length = 3, nullable = false)
    private String maNV;

    @Column(length = 100, nullable = false)
    private String tenNV;

    @Column(length = 3)
    private String phai;

    @Column(length = 200)
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "ma_phong")
    private PhongBan phongBan;

    private long luong;
}

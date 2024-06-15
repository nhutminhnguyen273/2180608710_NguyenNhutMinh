package com.example.nguyennhutminh.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phong_ban")
public class PhongBan {
    @Id
    @Column(length = 2, nullable = false)
    private String maPhong;

    @Column(length = 30, nullable = false)
    private String tenPhong;
}

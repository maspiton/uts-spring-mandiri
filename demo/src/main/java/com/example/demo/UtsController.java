package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UtsController {

    // Jawaban No 2: Algoritma John Travolta
    @GetMapping("/john-travolta")
    public Map<String, Object> hitungGajiJohn(@RequestParam(defaultValue = "52") int jamKerja) {
        int rateNormal = 15000;
        int rateLembur = (int) (rateNormal * 1.5);
        int pengeluaran = 600000;

        int gajiNormal = (jamKerja > 40) ? (40 * rateNormal) : (jamKerja * rateNormal);
        int gajiLembur = (jamKerja > 40) ? ((jamKerja - 40) * rateLembur) : 0;

        int totalGaji = gajiNormal + gajiLembur;
        int tabungan = totalGaji - pengeluaran;
        String status = (tabungan > 0) ? "Bisa menabung" : (tabungan == 0) ? "Tidak bisa menabung" : "Cari tambahan";

        Map<String, Object> result = new HashMap<>();
        result.put("Jam Kerja", jamKerja);
        result.put("Total Gaji", totalGaji);
        result.put("Pengeluaran", pengeluaran);
        result.put("Status", status);
        result.put("Jumlah Tabungan", Math.max(tabungan, 0));

        return result;
    }

    // Jawaban No 3: Persamaan Kuadrat
    @GetMapping("/persamaan-kuadrat")
    public Map<String, Object> hitungAkarKuadrat(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam double c) {

        Map<String, Object> result = new HashMap<>();
        result.put("Persamaan", a + "x^2 + " + b + "x + " + c + " = 0");

        if (a == 0) {
            result.put("Error", "Nilai 'a' tidak boleh 0 (bukan persamaan kuadrat).");
            return result;
        }

        double d = (b * b) - (4 * a * c); // Rumus determinan
        result.put("Determinan (D)", d);

        if (d > 0) {
            result.put("Status", "Dua akar real berbeda");
            result.put("x1", (-b + Math.sqrt(d)) / (2 * a));
            result.put("x2", (-b - Math.sqrt(d)) / (2 * a));
        } else if (d == 0) {
            result.put("Status", "Satu akar real kembar");
            result.put("x1", -b / (2 * a));
        } else {
            result.put("Status", "Akar imajiner (tidak ada akar real)");
        }

        return result;
    }
}
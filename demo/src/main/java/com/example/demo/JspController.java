package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JspController {

    // ==========================================
    // 1. FITUR KALKULATOR GAJI JOHN TRAVOLTA
    // ==========================================

    @GetMapping("/view-john")
    public String tampilkanForm() {
        return "index";
    }

    @GetMapping("/hitung-jsp")
    public String hitungGaji(
            @RequestParam(defaultValue = "0") int jamKerja,
            Model model) {

        if (jamKerja == 0) return "index";

        int rateNormal = 15000;
        int rateLembur = (int) (rateNormal * 1.5);
        int pengeluaran = 600000;

        int gajiNormal = (jamKerja > 40) ? (40 * rateNormal) : (jamKerja * rateNormal);
        int gajiLembur = (jamKerja > 40) ? ((jamKerja - 40) * rateLembur) : 0;

        int totalGaji = gajiNormal + gajiLembur;
        int tabungan = totalGaji - pengeluaran;
        String status = (tabungan > 0) ? "Bisa menabung" : (tabungan == 0) ? "Tidak bisa menabung" : "Cari tambahan";

        model.addAttribute("jamKerja", jamKerja);
        model.addAttribute("totalGaji", totalGaji);
        model.addAttribute("pengeluaran", pengeluaran);
        model.addAttribute("status", status);
        model.addAttribute("tabungan", Math.max(tabungan, 0));

        return "index";
    }

    // ==========================================
    // 2. FITUR PERSAMAAN KUADRAT
    // ==========================================

    @GetMapping("/view-kuadrat")
    public String tampilkanFormKuadrat() {
        return "kuadrat";
    }

    @GetMapping("/hitung-kuadrat")
    public String hitungKuadrat(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b,
            @RequestParam(defaultValue = "0") double c,
            Model model) {

        if (a == 0) {
            model.addAttribute("error", "Nilai 'a' tidak boleh 0 sob!");
            return "kuadrat";
        }

        double d = (b * b) - (4 * a * c);
        String jenisAkar;
        String x1 = "";
        String x2 = "";

        if (d > 0) {
            jenisAkar = "Real dan Berbeda";
            x1 = String.format("%.2f", (-b + Math.sqrt(d)) / (2 * a));
            x2 = String.format("%.2f", (-b - Math.sqrt(d)) / (2 * a));
        } else if (d == 0) {
            jenisAkar = "Real dan Kembar";
            x1 = String.format("%.2f", -b / (2 * a));
            x2 = x1;
        } else {
            jenisAkar = "Imajiner (Tidak Real)";
            x1 = "-";
            x2 = "-";
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);
        model.addAttribute("d", d);
        model.addAttribute("jenisAkar", jenisAkar);
        model.addAttribute("x1", x1);
        model.addAttribute("x2", x2);

        return "kuadrat";
    }
}
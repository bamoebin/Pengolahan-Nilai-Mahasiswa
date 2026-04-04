package com.pengolahannilaimhs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Instansiasi masing-masing modul
        ValidasiData validator = new ValidasiData();
        PerhitunganNilai penghitung = new PerhitunganNilai();
        PenentuanGrade penentuGrade = new PenentuanGrade();
        PenentuanKelulusan penentuKelulusan = new PenentuanKelulusan();

        boolean lanjut = true;

        System.out.println("=== Aplikasi Pengolahan Nilai Mahasiswa ===");

        // Program mengelola proses secara berulang (loop menu) [cite: 50]
        while (lanjut) {
            double tugas = -1, uts = -1, uas = -1;
            boolean inputValid = false;

            // Modul validasi dipanggil oleh modul input data [cite: 61]
            while (!inputValid) {
                System.out.println("\nMasukkan Nilai Mahasiswa (0-100)");
                System.out.print("Nilai Tugas: ");
                tugas = scanner.nextDouble();
                System.out.print("Nilai UTS: ");
                uts = scanner.nextDouble();
                System.out.print("Nilai UAS: ");
                uas = scanner.nextDouble();

                inputValid = validator.validasi(tugas, uts, uas);
                
                if (!inputValid) {
                    System.out.println("Input tidak valid! Pastikan rentang 0-100 dan tidak semuanya 0. Silakan coba lagi.");
                }
            }

            // Eksekusi modul lainnya
            double nilaiAkhir = penghitung.hitungNilaiAkhir(tugas, uts, uas);
            String grade = penentuGrade.tentukanGrade(nilaiAkhir);
            String status = penentuKelulusan.tentukanKelulusan(nilaiAkhir);

            System.out.println("\n--- Hasil Pengolahan ---");
            System.out.println("Nilai Akhir : " + nilaiAkhir);
            System.out.println("Grade       : " + grade);
            System.out.println("Status      : " + status);
            System.out.println("------------------------");

            System.out.print("\nIngin menginput data mahasiswa lain? (y/n): ");
            String pilihan = scanner.next();
            if (pilihan.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }
        
        System.out.println("Program selesai.");
        scanner.close();
    }
}
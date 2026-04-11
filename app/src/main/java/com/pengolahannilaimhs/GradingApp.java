package com.pengolahannilaimhs;

import java.util.Scanner;

public class GradingApp {
    private final Nilai nilai;
    private final Scanner scanner;

    public GradingApp() {
        this.nilai = new Nilai();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean lanjut = true;

        System.out.println("=== Aplikasi Pengolahan Nilai Mahasiswa ===");

        while (lanjut) {
            Mahasiswa mahasiswa = inputMahasiswa();
            double tugas;
            double uts;
            double uas;
            boolean inputValid = false;

            while (!inputValid) {
                System.out.println("\nMasukkan Nilai Mahasiswa (0-100)");
                System.out.print("Nilai Tugas: ");
                tugas = scanner.nextDouble();
                System.out.print("Nilai UTS: ");
                uts = scanner.nextDouble();
                System.out.print("Nilai UAS: ");
                uas = scanner.nextDouble();

                inputValid = nilai.validasi(tugas, uts, uas);

                if (!inputValid) {
                    System.out.println("Input tidak valid! Pastikan rentang 0-100 dan tidak semuanya 0. Silakan coba lagi.");
                } else {
                    tampilkanHasil(mahasiswa, tugas, uts, uas);
                }
            }

            System.out.print("\nIngin menginput data mahasiswa lain? (y/n): ");
            String pilihan = scanner.next();
            if (pilihan.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        System.out.println("Program selesai.");
        scanner.close();
    }

    private Mahasiswa inputMahasiswa() {
        System.out.println("\nData Mahasiswa");
        System.out.print("NIM  : ");
        String nim = scanner.next();

        return new Mahasiswa(nim, "Nama Dummy", "Jurusan Dummy", "Prodi Dummy", "Kelas Dummy");
    }

    private void tampilkanHasil(Mahasiswa mahasiswa, double tugas, double uts, double uas) {
        double nilaiAkhir = nilai.hitungNilaiAkhir(tugas, uts, uas);
        String grade = nilai.tentukanGrade(nilaiAkhir);
        String status = nilai.tentukanKelulusan(nilaiAkhir);

        System.out.println("\n------ Hasil Pengolahan ------");
        System.out.println("\n------- Data Mahasiswa -------");
        System.out.println("NIM         : " + mahasiswa.getNim());
        System.out.println("Nama        : " + mahasiswa.getNama());
        System.out.println("Kelas       : " + mahasiswa.getKelas());
        System.out.println("Prodi       : " + mahasiswa.getProgramStudi());
        System.out.println("Jurusan     : " + mahasiswa.getJurusan());
        System.out.println("\n--------- Penilaian ----------");
        System.out.println("Nilai Akhir : " + nilaiAkhir);
        System.out.println("Grade       : " + grade);
        System.out.println("Status      : " + status);
        System.out.println("------------------------------");
    }
}
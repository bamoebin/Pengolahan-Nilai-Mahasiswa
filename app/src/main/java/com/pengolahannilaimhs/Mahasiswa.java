package com.pengolahannilaimhs;

public class Mahasiswa {
    private final String nim;
    private final String nama;
    private final String jurusan;
    private final String programStudi;
    private final String kelas;

    public Mahasiswa(String nim, String nama, String jurusan, String programStudi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.programStudi = programStudi; 
        this.kelas = kelas;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getProgramStudi() {
        return programStudi;
    } 

    public String getKelas() {
        return kelas;
    }
}

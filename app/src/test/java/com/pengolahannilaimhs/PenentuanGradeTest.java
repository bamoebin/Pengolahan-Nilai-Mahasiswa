package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PenentuanGradeTest {

    private PenentuanGrade penentu;

    @BeforeEach
    public void setup() {
        penentu = new PenentuanGrade();
    }

    @Test
    public void testPath1_NilaiNegatif() {
        // (1) setup
        double nilaiAkhir = -5;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("Error", actual, "Gagal di Jalur 1 (nilai < 0)");
    }

    @Test
    public void testPath2_NilaiLebih100() {
        // (1) setup
        double nilaiAkhir = 105;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("Error", actual, "Gagal di Jalur 2 (nilai > 100)");
    }

    @Test
    public void testPath3_GradeA() {
        // (1) setup
        double nilaiAkhir = 85;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("A", actual, "Gagal di Jalur 3 (nilai >= 85)");
    }

    @Test
    public void testPath4_GradeB() {
        // (1) setup
        double nilaiAkhir = 70;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("B", actual, "Gagal di Jalur 4 (nilai >= 70)");
    }

    @Test
    public void testPath5_GradeC() {
        // (1) setup
        double nilaiAkhir = 60;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("C", actual, "Gagal di Jalur 5 (nilai >= 60)");
    }

    @Test
    public void testPath6_GradeD() {
        // (1) setup
        double nilaiAkhir = 50;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("D", actual, "Gagal di Jalur 6 (nilai >= 50)");
    }

    @Test
    public void testPath7_GradeE() {
        // (1) setup
        double nilaiAkhir = 40;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("E", actual, "Gagal di Jalur 7 (nilai < 50)");
    }
}
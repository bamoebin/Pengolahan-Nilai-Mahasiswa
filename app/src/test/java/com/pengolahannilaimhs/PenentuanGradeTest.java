package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PenentuanGradeTest {

    private Nilai penentu;

    @BeforeEach
    public void setup() {
        penentu = new Nilai();
    }

    @Test
    public void testPath1_GradeA() {
        // (1) setup
        double nilaiAkhir = 85;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("A", actual, "Gagal di Jalur 1 (nilai >= 85)");
    }

    @Test
    public void testPath2_GradeB() {
        // (1) setup
        double nilaiAkhir = 70;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("B", actual, "Gagal di Jalur 2 (nilai >= 70)");
    }

    @Test
    public void testPath3_GradeC() {
        // (1) setup
        double nilaiAkhir = 60;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("C", actual, "Gagal di Jalur 3 (nilai >= 60)");
    }

    @Test
    public void testPath4_GradeD() {
        // (1) setup
        double nilaiAkhir = 50;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("D", actual, "Gagal di Jalur 4 (nilai >= 50)");
    }

    @Test
    public void testPath5_GradeE() {
        // (1) setup
        double nilaiAkhir = 40;
        String actual;

        // (2) exercise
        actual = penentu.tentukanGrade(nilaiAkhir);

        // (3) verify
        assertEquals("E", actual, "Gagal di Jalur 5 (nilai < 50)");
    }
}
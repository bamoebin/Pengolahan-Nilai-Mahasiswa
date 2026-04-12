package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidasiDataTest {

    private Nilai validator;

    @BeforeEach
    void setup() {
        validator = new Nilai();
    }

    // --- TC01: Skenario Semua Input 0 ---
    
    @Test
    void TC01_validasi_SemuaNilaiInput0_ReturnFalse() {
        // (1) setup
        double tugas = 0, uts = 0, uas = 0;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertFalse(actual, "Harusnya false karena semua nilai 0");
    }

    // --- TC02 - TC04: Skenario Salah Satu Nilai 0 ---

    @Test
    void TC02_validasi_NilaiUas0_ReturnTrue() {
        // (1) setup
        double tugas = 50, uts = 50, uas = 0;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertTrue(actual, "Harusnya true karena hanya UAS yang 0");
    }

    @Test
    void TC03_validasi_NilaiUts0_ReturnTrue() {
        // (1) setup
        double tugas = 50, uts = 0, uas = 50;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertTrue(actual, "Harusnya true karena hanya UTS yang 0");
    }

    @Test
    void TC04_validasi_NilaiTugas0_ReturnTrue() {
        // (1) setup
        double tugas = 0, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertTrue(actual, "Harusnya true karena hanya Tugas yang 0");
    }

    // --- TC05 - TC10: Skenario Nilai Di Luar Batas Atas/Bawah ---
    
    @Test
    void TC05_validasi_TugasLebihKecilDari0_ReturnFalse() {
        // (1) setup
        double tugas = -1, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertFalse(actual, "Harusnya false karena Tugas < 0");
    }

    @Test
    void TC06_validasi_TugasLebihBesarDari100_ReturnFalse() {
        // (1) setup
        double tugas = 101, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertFalse(actual, "Harusnya false karena Tugas > 100");
    }

    @Test
    void TC07_validasi_UtsLebihKecilDari0_ReturnFalse() {
        // (1) setup
        double tugas = 50, uts = -1, uas = 50;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertFalse(actual, "Harusnya false karena UTS < 0");
    }

    @Test
    void TC08_validasi_UtsLebihBesarDari100_ReturnFalse() {
        // (1) setup
        double tugas = 50, uts = 101, uas = 50;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertFalse(actual, "Harusnya false karena UTS > 100");
    }

    @Test
    void TC09_validasi_UasLebihKecilDari0_ReturnFalse() {
        // (1) setup
        double tugas = 50, uts = 50, uas = -1;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertFalse(actual, "Harusnya false karena UAS < 0");
    }

    @Test
    void TC10_validasi_UasLebihBesarDari100_ReturnFalse() {
        // (1) setup
        double tugas = 50, uts = 50, uas = 101;
        boolean actual;

        // (2) exercise
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify
        assertFalse(actual, "Harusnya false karena UAS > 100");
    }
}
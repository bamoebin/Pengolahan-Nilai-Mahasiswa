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

    // --- GROUP 1: Uji Blok Kondisi && (Anggap Belum Input) ---
    
    @Test
    void validasi_SemuaNilaiNol_ReturnFalse() {
        // (1) setup (arrange, build)
        double tugas = 0, uts = 0, uas = 0;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal di N3: Harusnya false");
    }

    @Test
    void validasi_HanyaUasBukanNol_ReturnTrue() {
        // (1) setup (arrange, build)
        double tugas = 0, uts = 0, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue(actual, "Lolos Blok 2: Harusnya true");
    }

    @Test
    void validasi_HanyaUtsBukanNol_ReturnTrue() {
        // (1) setup (arrange, build)
        double tugas = 0, uts = 50, uas = 0;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue(actual, "Lolos Blok 2: Harusnya true");
    }

    @Test
    void validasi_SemuaNilaiValid_ReturnTrue() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue(actual, "Lolos Blok 2: Harusnya true");
    }

    // --- GROUP 2: Uji Blok Kondisi || (Di Luar Rentang) ---
    
    @Test
    void validasi_TugasKurangDariNol_ReturnFalse() {
        // (1) setup (arrange, build)
        double tugas = -1, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N5 (Tugas < 0)");
    }

    @Test
    void validasi_TugasLebihDariSeratus_ReturnFalse() {
        // (1) setup (arrange, build)
        double tugas = 101, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N6 (Tugas > 100)");
    }

    @Test
    void validasi_UtsKurangDariNol_ReturnFalse() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = -1, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N7 (UTS < 0)");
    }

    @Test
    void validasi_UtsLebihDariSeratus_ReturnFalse() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 101, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N8 (UTS > 100)");
    }

    @Test
    void validasi_UasKurangDariNol_ReturnFalse() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 50, uas = -1;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N9 (UAS < 0)");
    }

    @Test
    void validasi_UasLebihDariSeratus_ReturnFalse() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 50, uas = 101;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N10 (UAS > 100)");
    }
}
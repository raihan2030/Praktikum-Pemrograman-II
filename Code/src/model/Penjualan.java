package model;

import java.time.LocalDate;

public class Penjualan {
    private String idPenjualan;
    private int jumlah;
    private Long totalHarga;
    private LocalDate tanggal;
    private Pelanggan pelanggan;
    private AlatElektronik alatElektronik;

    public Penjualan(String idPenjualan, int jumlah, Long totalHarga, LocalDate tanggal, Pelanggan pelanggan, AlatElektronik alatElektronik) {
        this.idPenjualan = idPenjualan;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
        this.pelanggan = pelanggan;
        this.alatElektronik = alatElektronik;
    }

    public String getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(String idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public int getJumlah() {
        return jumlah < 0 ? 0 : jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Long getTotalHarga() {
        return totalHarga < 0 ? 0 : totalHarga;
    }

    public void setTotalHarga(Long totalHarga) {
        this.totalHarga = totalHarga;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public AlatElektronik getAlatElektronik() {
        return alatElektronik;
    }

    public void setAlatElektronik(AlatElektronik alatElektronik) {
        this.alatElektronik = alatElektronik;
    }
}

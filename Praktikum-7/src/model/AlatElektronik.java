package model;

public class AlatElektronik {
    private String idBarang;
    private String namaBarang;
    private String merek;
    private Long harga;

    public AlatElektronik(String idBarang, String namaBarang, String merek, Long harga) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.merek = merek;
        this.harga = harga;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public Long getHarga() {
        return harga < 0 ? 0 : harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }
}

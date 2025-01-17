package id.onestep.skripsi.Models;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    private int id;

    @SerializedName("hasil")
    private String hasil;

    @SerializedName("normalisasi")
    private int normalisasi;

    @SerializedName("tanaman")
    private String tanaman;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getHasil() {
        return hasil;
    }

    public void setNormalisasi(int normalisasi) {
        this.normalisasi = normalisasi;
    }

    public int getNormalisasi() {
        return normalisasi;
    }

    public void setTanaman(String tanaman) {
        this.tanaman = tanaman;
    }

    public String getTanaman() {
        return tanaman;
    }

    @Override
    public String toString() {
        return
                "Result{" +
                        "id = '" + id + '\'' +
                        ",hasil = '" + hasil + '\'' +
                        ",normalisasi = '" + normalisasi + '\'' +
                        ",tanaman = '" + tanaman + '\'' +
                        "}";
    }
}
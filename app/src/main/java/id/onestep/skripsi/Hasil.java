package id.onestep.skripsi;

public class Hasil {
    String tanaman, hasil;
    double presentase;

    public Hasil(String tanaman, String hasil, double presentase) {
        this.tanaman = tanaman;
        this.hasil = hasil;
        this.presentase = presentase;
    }

    public String getTanaman() {
        return tanaman;
    }

    public String getHasil() {
        return hasil;
    }

    public double getPresentase() {
        return presentase;
    }
}

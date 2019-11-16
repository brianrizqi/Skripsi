package id.onestep.skripsi.Models;

import com.google.gson.annotations.SerializedName;

public class Weathers {

	@SerializedName("kota")
	private String kota;

	@SerializedName("cuaca")
	private String cuaca;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("suhu")
	private String suhu;

	@SerializedName("error")
	private boolean error;

	@SerializedName("kelembaban")
	private String kelembaban;

	public void setKota(String kota){
		this.kota = kota;
	}

	public String getKota(){
		return kota;
	}

	public void setCuaca(String cuaca){
		this.cuaca = cuaca;
	}

	public String getCuaca(){
		return cuaca;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setSuhu(String suhu){
		this.suhu = suhu;
	}

	public String getSuhu(){
		return suhu;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setKelembaban(String kelembaban){
		this.kelembaban = kelembaban;
	}

	public String getKelembaban(){
		return kelembaban;
	}

	@Override
 	public String toString(){
		return 
			"Weathers{" +
			"kota = '" + kota + '\'' + 
			",cuaca = '" + cuaca + '\'' + 
			",waktu = '" + waktu + '\'' + 
			",suhu = '" + suhu + '\'' + 
			",error = '" + error + '\'' + 
			",kelembaban = '" + kelembaban + '\'' + 
			"}";
		}
}
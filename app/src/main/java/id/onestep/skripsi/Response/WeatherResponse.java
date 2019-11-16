package id.onestep.skripsi.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Weather.DailyForecastsItem;
import id.onestep.skripsi.Models.Weather.Headline;

public class WeatherResponse{

	@SerializedName("Headline")
	private Headline headline;

	@SerializedName("DailyForecasts")
	private List<DailyForecastsItem> dailyForecasts;

	public void setHeadline(Headline headline){
		this.headline = headline;
	}

	public Headline getHeadline(){
		return headline;
	}

	public void setDailyForecasts(List<DailyForecastsItem> dailyForecasts){
		this.dailyForecasts = dailyForecasts;
	}

	public List<DailyForecastsItem> getDailyForecasts(){
		return dailyForecasts;
	}

	@Override
 	public String toString(){
		return 
			"WeatherResponse{" + 
			"headline = '" + headline + '\'' + 
			",dailyForecasts = '" + dailyForecasts + '\'' + 
			"}";
		}
}
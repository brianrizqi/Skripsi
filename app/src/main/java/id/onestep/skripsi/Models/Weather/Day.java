package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class Day{

	@SerializedName("RainProbability")
	private int rainProbability;

	@SerializedName("Wind")
	private Wind wind;

	@SerializedName("SnowProbability")
	private int snowProbability;

	@SerializedName("Snow")
	private Snow snow;

	@SerializedName("TotalLiquid")
	private TotalLiquid totalLiquid;

	@SerializedName("ShortPhrase")
	private String shortPhrase;

	@SerializedName("Ice")
	private Ice ice;

	@SerializedName("HoursOfRain")
	private double hoursOfRain;

	@SerializedName("HoursOfIce")
	private int hoursOfIce;

	@SerializedName("Rain")
	private Rain rain;

	@SerializedName("PrecipitationProbability")
	private int precipitationProbability;

	@SerializedName("HasPrecipitation")
	private boolean hasPrecipitation;

	@SerializedName("ThunderstormProbability")
	private int thunderstormProbability;

	@SerializedName("IceProbability")
	private int iceProbability;

	@SerializedName("IconPhrase")
	private String iconPhrase;

	@SerializedName("CloudCover")
	private int cloudCover;

	@SerializedName("LongPhrase")
	private String longPhrase;

	@SerializedName("Icon")
	private int icon;

	@SerializedName("WindGust")
	private WindGust windGust;

	@SerializedName("HoursOfSnow")
	private int hoursOfSnow;

	@SerializedName("HoursOfPrecipitation")
	private double hoursOfPrecipitation;

	@SerializedName("PrecipitationIntensity")
	private String precipitationIntensity;

	@SerializedName("PrecipitationType")
	private String precipitationType;

	public void setRainProbability(int rainProbability){
		this.rainProbability = rainProbability;
	}

	public int getRainProbability(){
		return rainProbability;
	}

	public void setWind(Wind wind){
		this.wind = wind;
	}

	public Wind getWind(){
		return wind;
	}

	public void setSnowProbability(int snowProbability){
		this.snowProbability = snowProbability;
	}

	public int getSnowProbability(){
		return snowProbability;
	}

	public void setSnow(Snow snow){
		this.snow = snow;
	}

	public Snow getSnow(){
		return snow;
	}

	public void setTotalLiquid(TotalLiquid totalLiquid){
		this.totalLiquid = totalLiquid;
	}

	public TotalLiquid getTotalLiquid(){
		return totalLiquid;
	}

	public void setShortPhrase(String shortPhrase){
		this.shortPhrase = shortPhrase;
	}

	public String getShortPhrase(){
		return shortPhrase;
	}

	public void setIce(Ice ice){
		this.ice = ice;
	}

	public Ice getIce(){
		return ice;
	}

	public void setHoursOfRain(double hoursOfRain){
		this.hoursOfRain = hoursOfRain;
	}

	public double getHoursOfRain(){
		return hoursOfRain;
	}

	public void setHoursOfIce(int hoursOfIce){
		this.hoursOfIce = hoursOfIce;
	}

	public int getHoursOfIce(){
		return hoursOfIce;
	}

	public void setRain(Rain rain){
		this.rain = rain;
	}

	public Rain getRain(){
		return rain;
	}

	public void setPrecipitationProbability(int precipitationProbability){
		this.precipitationProbability = precipitationProbability;
	}

	public int getPrecipitationProbability(){
		return precipitationProbability;
	}

	public void setHasPrecipitation(boolean hasPrecipitation){
		this.hasPrecipitation = hasPrecipitation;
	}

	public boolean isHasPrecipitation(){
		return hasPrecipitation;
	}

	public void setThunderstormProbability(int thunderstormProbability){
		this.thunderstormProbability = thunderstormProbability;
	}

	public int getThunderstormProbability(){
		return thunderstormProbability;
	}

	public void setIceProbability(int iceProbability){
		this.iceProbability = iceProbability;
	}

	public int getIceProbability(){
		return iceProbability;
	}

	public void setIconPhrase(String iconPhrase){
		this.iconPhrase = iconPhrase;
	}

	public String getIconPhrase(){
		return iconPhrase;
	}

	public void setCloudCover(int cloudCover){
		this.cloudCover = cloudCover;
	}

	public int getCloudCover(){
		return cloudCover;
	}

	public void setLongPhrase(String longPhrase){
		this.longPhrase = longPhrase;
	}

	public String getLongPhrase(){
		return longPhrase;
	}

	public void setIcon(int icon){
		this.icon = icon;
	}

	public int getIcon(){
		return icon;
	}

	public void setWindGust(WindGust windGust){
		this.windGust = windGust;
	}

	public WindGust getWindGust(){
		return windGust;
	}

	public void setHoursOfSnow(int hoursOfSnow){
		this.hoursOfSnow = hoursOfSnow;
	}

	public int getHoursOfSnow(){
		return hoursOfSnow;
	}

	public void setHoursOfPrecipitation(double hoursOfPrecipitation){
		this.hoursOfPrecipitation = hoursOfPrecipitation;
	}

	public double getHoursOfPrecipitation(){
		return hoursOfPrecipitation;
	}

	public void setPrecipitationIntensity(String precipitationIntensity){
		this.precipitationIntensity = precipitationIntensity;
	}

	public String getPrecipitationIntensity(){
		return precipitationIntensity;
	}

	public void setPrecipitationType(String precipitationType){
		this.precipitationType = precipitationType;
	}

	public String getPrecipitationType(){
		return precipitationType;
	}

	@Override
 	public String toString(){
		return 
			"Day{" + 
			"rainProbability = '" + rainProbability + '\'' + 
			",wind = '" + wind + '\'' + 
			",snowProbability = '" + snowProbability + '\'' + 
			",snow = '" + snow + '\'' + 
			",totalLiquid = '" + totalLiquid + '\'' + 
			",shortPhrase = '" + shortPhrase + '\'' + 
			",ice = '" + ice + '\'' + 
			",hoursOfRain = '" + hoursOfRain + '\'' + 
			",hoursOfIce = '" + hoursOfIce + '\'' + 
			",rain = '" + rain + '\'' + 
			",precipitationProbability = '" + precipitationProbability + '\'' + 
			",hasPrecipitation = '" + hasPrecipitation + '\'' + 
			",thunderstormProbability = '" + thunderstormProbability + '\'' + 
			",iceProbability = '" + iceProbability + '\'' + 
			",iconPhrase = '" + iconPhrase + '\'' + 
			",cloudCover = '" + cloudCover + '\'' + 
			",longPhrase = '" + longPhrase + '\'' + 
			",icon = '" + icon + '\'' + 
			",windGust = '" + windGust + '\'' + 
			",hoursOfSnow = '" + hoursOfSnow + '\'' + 
			",hoursOfPrecipitation = '" + hoursOfPrecipitation + '\'' + 
			",precipitationIntensity = '" + precipitationIntensity + '\'' + 
			",precipitationType = '" + precipitationType + '\'' + 
			"}";
		}
}
package id.onestep.skripsi.Models.Lahan;

import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Lahan.Plant;

public class PlantingsItem{

	@SerializedName("plant_id")
	private int plantId;

	@SerializedName("loss")
	private Object loss;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("plant")
	private Plant plant;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("area_id")
	private int areaId;

	@SerializedName("profit")
	private Object profit;

	@SerializedName("status")
	private int status;

	public void setPlantId(int plantId){
		this.plantId = plantId;
	}

	public int getPlantId(){
		return plantId;
	}

	public void setLoss(Object loss){
		this.loss = loss;
	}

	public Object getLoss(){
		return loss;
	}

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public void setPlant(Plant plant){
		this.plant = plant;
	}

	public Plant getPlant(){
		return plant;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAreaId(int areaId){
		this.areaId = areaId;
	}

	public int getAreaId(){
		return areaId;
	}

	public void setProfit(Object profit){
		this.profit = profit;
	}

	public Object getProfit(){
		return profit;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"PlantingsItem{" + 
			"plant_id = '" + plantId + '\'' + 
			",loss = '" + loss + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",plant = '" + plant + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",area_id = '" + areaId + '\'' + 
			",profit = '" + profit + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
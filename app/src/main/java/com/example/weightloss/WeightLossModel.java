package com.example.weightloss;

class WeightLossModel
{
   private int id;
   private float weight;
   private long date;

   public WeightLossModel(int id, float weight, long date) {
      this.id = id;
      this.weight = weight;
      this.date = date;
   }

   public WeightLossModel() {

   }

   @Override
   public String toString() {
      return "WeightLossModel{" +
              "id=" + id +
              ", weight=" + weight +
              ", date=" + date +
              '}';
   }

   //Getter and Setters
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public float getWeight() {
      return weight;
   }

   public void setWeight(float weight) {
      this.weight = weight;
   }

   public long getDate() {
      return date;
   }

   public void setDate(int date) {
      this.date = date;
   }
}

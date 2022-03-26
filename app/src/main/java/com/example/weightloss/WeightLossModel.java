package com.example.weightloss;

class WeightLossModel
{
   private int id;
   private int weight;
   private int date;

   public WeightLossModel(int id, int weight, int date) {
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

   public int getWeight() {
      return weight;
   }

   public void setWeight(int weight) {
      this.weight = weight;
   }

   public int getDate() {
      return date;
   }

   public void setDate(int date) {
      this.date = date;
   }
}

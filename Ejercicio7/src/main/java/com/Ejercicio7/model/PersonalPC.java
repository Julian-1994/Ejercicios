package com.Ejercicio7.model;
import java.util.Objects;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "personalpc")
public class PersonalPC {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private Integer ramMemory;
	    private String cpu;
	    private String graphicCard;
	    private Double cpuFreq;
	    private String brand;
	    private String model;
	    private Boolean hasScreen;
	    
	    
	    		
		public PersonalPC() {
			super();
		}
		
		public PersonalPC(Integer id, Integer ramMemory, String cpu, String graphicCard, Double cpuFreq, String brand,
				String model, Boolean hasScreen) {
			super();
			this.id = id;
			this.ramMemory = ramMemory;
			this.cpu = cpu;
			this.graphicCard = graphicCard;
			this.cpuFreq = cpuFreq;
			this.brand = brand;
			this.model = model;
			this.hasScreen = hasScreen;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getRamMemory() {
			return ramMemory;
		}
		public void setRamMemory(Integer ramMemory) {
			this.ramMemory = ramMemory;
		}
		public String getCpu() {
			return cpu;
		}
		public void setCpu(String cpu) {
			this.cpu = cpu;
		}
		public String getGraphicCard() {
			return graphicCard;
		}
		public void setGraphicCard(String graphicCard) {
			this.graphicCard = graphicCard;
		}
		public Double getCpuFreq() {
			return cpuFreq;
		}
		public void setCpuFreq(Double cpuFreq) {
			this.cpuFreq = cpuFreq;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public Boolean getHasScreen() {
			return hasScreen;
		}
		public void setHasScreen(Boolean hasScreen) {
			this.hasScreen = hasScreen;
		}

		@Override
		public int hashCode() {
			return Objects.hash(brand, cpu, cpuFreq, graphicCard, hasScreen, id, model, ramMemory);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PersonalPC other = (PersonalPC) obj;
			return Objects.equals(brand, other.brand) && Objects.equals(cpu, other.cpu)
					&& Objects.equals(cpuFreq, other.cpuFreq) && Objects.equals(graphicCard, other.graphicCard)
					&& Objects.equals(hasScreen, other.hasScreen) && Objects.equals(id, other.id)
					&& Objects.equals(model, other.model) && Objects.equals(ramMemory, other.ramMemory);
		}

		@Override
		public String toString() {
			return "PersonalPC [id=" + id + ", ramMemory=" + ramMemory + ", cpu=" + cpu + ", graphicCard=" + graphicCard
					+ ", cpuFreq=" + cpuFreq + ", brand=" + brand + ", model=" + model + ", hasScreen=" + hasScreen
					+ "]";
		}
	    
	
	
}
	
	   



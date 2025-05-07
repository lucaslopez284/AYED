package prac1Ej5;

public class Valores {
	private int min;
	private int max;
	private double prom;
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public double getProm() {
		return prom;
	}
	public void setProm(double prom) {
		this.prom = prom;
	}
	@Override
	public String toString() {
		return "Promedio " + this.getProm()+ ", maximo " + this.getMax() + ", minimo " + this.getMin();
	}
	
	

}

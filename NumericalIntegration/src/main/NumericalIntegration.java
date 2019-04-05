package main;

public class NumericalIntegration {

	class Function {
		public Function() {
			
		}
		public double curve(double x) {
			return 1 + x + Math.sin(2 * x);
		}
	}

	public static void main(String[] args) {
		
		Function f = new NumericalIntegration().new Function();
		
		
		double area1 = rectangle(f, 0, 5, 10);
		
		double area2 = trapezoid(f, 0, 5, 10);
		
		System.out.println("Area calculated for curve: 1 + x + Sin(2*x)");
		System.out.println("Rectangle area: " + area1);
		System.out.println("Trapezoid area: " + area2);

	}

	public static double rectangle(Function f, double xmin, double xmax, int n) {
		double dx = (xmax - xmin) / n;
		double area = 0;
		for (double i = xmin; i < xmax - dx; i = i + dx) {
			area = area + f.curve(i);
		}
		area = area * dx;
		return area;
	}

	public static double trapezoid(Function f, double xmin, double xmax, int n) {
		double dx = (xmax - xmin) / n;
		double area = 0;
		for (double i = xmin; i < xmax - dx; i = i + dx) {
			area = area + f.curve(i);
		}
		area = area * 2 - f.curve(xmin) - f.curve(xmax);
		area = area * dx / 2;
		return area;
	}
}

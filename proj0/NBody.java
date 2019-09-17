public class NBody{
	public static double readRadius(String filename){
		In in = new In(filename);
		int planetNumber = in.readInt();
		double radius = in.readDouble();
		return radius;
	}	

	public static Body[] readBodies(String filename){
		Body[] planets = new Body[5];
		In in = new In(filename);
		int planetNumber = in.readInt();
		double radius = in.readDouble();
		for (int i = 0; i < planetNumber; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Body[] planets = readBodies(filename);
		double radius = readRadius(filename);

		String background_path = "images/starfield.jpg";
		StdDraw.setScale(-radius * 2, radius * 2);
		
		
		StdDraw.enableDoubleBuffering();
		double time = 0;
		for (time = 0; time <= T; time += dt){
			double[] xForces = new double [planets.length];
			double[] yForces = new double [planets.length];
			for (int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, background_path);
			for (int i = 0; i < planets.length; i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdDraw.show();
		StdDraw.pause(2000);

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}
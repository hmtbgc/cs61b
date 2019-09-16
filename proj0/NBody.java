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
		StdDraw.picture(0, 0, background_path);
		StdDraw.show();
		StdDraw.pause(2000);
	}
}
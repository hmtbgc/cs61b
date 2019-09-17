public class Body{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		double dx = xxPos - b.xxPos;
		double dy = yyPos - b.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Body b){
	    double G = 6.67e-11;
		return G * mass * b.mass / (calcDistance(b) * calcDistance(b));
	}

	public double calcForceExertedByX(Body b){
		return calcForceExertedBy(b) * (b.xxPos - xxPos) / calcDistance(b);
	}

	public double calcForceExertedByY(Body b){
		return calcForceExertedBy(b) * (b.yyPos - yyPos) / calcDistance(b);
	}

	public double calcNetForceExertedByX(Body[] b){
		double TotalForceExertedByX = 0.0;
		for (int i = 0; i < b.length; i++){
			if (this.equals(b[i])){
				continue;
			}
			TotalForceExertedByX += calcForceExertedByX(b[i]);
		}
		return TotalForceExertedByX;
	}

	public double calcNetForceExertedByY(Body[] b){
		double TotalForceExertedByY = 0.0;
		for (int i = 0; i < b.length; i++){
			if (this.equals(b[i])){
				continue;
			}
			TotalForceExertedByY += calcForceExertedByY(b[i]);
		}
		return TotalForceExertedByY;
	}

	public void update(double dt, double fX, double fY){
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel += dt * ax;
		yyVel += dt * ay;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;

	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}

}
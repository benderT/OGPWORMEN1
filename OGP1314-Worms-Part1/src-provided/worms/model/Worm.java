package worms.model;

public class Worm {



private double positionX;
private double positionY;
private int actionPoint;
private final double minRadius=0.25;
private static final double Density = 1062.0;
private String name;
private double radius;
private double angle;



public Worm(double Px, double Py, double radius,double angle, String name) throws IllegalArgumentException {
		this.setPositionX(Px);
		this.setPositionY(Py);
		this.setRadius(radius);
		this.setnaming(name);
		this.setActionPoints(this.getMaxPossiblePoints());
		this.setOrientation(angle);

}


public double getMinRadius() {
	return this.minRadius;
}

public void setPositionX(double X){
	this.positionX=X;
}

public double getPositionX(){
	return this.positionX;
}

public void setPositionY(double Y){
	this.positionY=Y;
}

public double getPositionY(){
	return this.positionY;
}

// total programming
public void setActionPoints(int actionPoints){   
	
	if (actionPoints <0) {
		this.actionPoint =0;}
	
	else if (actionPoints > getMaxPossiblePoints()){
		this.actionPoint = getMaxPossiblePoints();}	
		
	else { this.actionPoint = actionPoints ; }		

}	

public int getActionPoint() {
	return this.actionPoint ;	
}

public int getMaxPossiblePoints() {
	return (int) Math.round(getMass());
}

	
public double getMass(){
		return  this.getDensity()*((4.0/3.0)*Math.PI*Math.pow(this.getRadius(),3));

}

public static final double getDensity() {
	return Density;
}



public void setRadius(double givenradius){
	if (validRadius(givenradius)) {
		this.radius= givenradius;
	}
 
}


public boolean validRadius(double radius){
	if (radius>minRadius) {return true;}
	else {return false;}
}
public double getRadius() {
	return radius;
}

//defensive
public void setnaming(String GivenName) throws IllegalArgumentException {
		if (!ValidName(GivenName))
			throw new IllegalArgumentException("This isn't a valid name.");
	this.name=GivenName; 
}

public boolean ValidName(String name) {
	if(name.length() < 2)
		return false; 
			else if(!Character.isUpperCase(name.charAt(0))){
			return false;
		} else {
			return name.matches("[a-zA-Z\'\" ]");
		}
	}

public void setOrientation(double angle){
	assert ValidAngle(angle);
	this.angle=angle;
}


public boolean ValidAngle(double angle) {
	if (angle>-2.0*Math.PI && angle<2.0*Math.PI){
	return true;}
	else return false;
}

public double getOrientation() {
	
	return angle;
}


public void turn(double angle){
	assert this.ValidAngle(angle);
	assert this.ValidAngle(this.getOrientation() + angle);
}









}






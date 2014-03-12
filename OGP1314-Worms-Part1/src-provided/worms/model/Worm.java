package worms.model;

public class Worm {



private double positionX;
private double positionY;
private int actionPoint;
private final double minRadius=0.25;
private static final double Density = 1062.0;
private static final double Gravity = 9.80665;
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


public boolean TurnPossible(double angle){
	int costTurn = (int) Math.ceil(60/(angle/2*Math.PI));
	if costTurn<= this.getActionPoint()
		{return true}
	else {return false;}
	
}



public void turn(double angle){
	assert this.ValidAngle(angle);
	assert this.ValidAngle(this.getOrientation() + angle); // weglaten of niet test bij setOrientation of is het een voorwaarde om Turn uit te voeren?
	assert this.TurnPossible(angle);
	
	this.setOrientation(this.getOrientation()+ angle);
	int costTurn = (int) Math.ceil(60/(angle/2*Math.PI));
	this.setActionPoint(this.getActionPoint() - costTurn);
	
}
public boolean movePossible(int cost){
	if (cost<= this.getActionPoint()){
	return true;}
}



public void Move(int nbSteps){
	int costMove= int Math.ceil(nbSteps*((double)Math.abs(Math.cos(this.getOrientation()))+ (double) Math.abs(4*Math.sin(this.getOrientaion()))))
	if (movePossible(cost)){
		this.setActionPount(this.getActionPoint()-costMove)
		double travelled= nbSteps*this.radius;
		this.setPositionX(this.getPositionX()+travelled*Math.cos(this.getOrientation()))
		this.setPositionY(this.getPositionY()+travelled*Math.sin(this.getOrientation()))
		}
	else throw IllegalCostExeption(costMove);
}
public void Jump(){
	if(util.fuzzygreatherThanOrEqualTo(this.getOrientation(),0) && !Util.fuzzyGreatherThanOrEqualTo(this.getOrientation(),Math.PI))){
	double t=this.getJumpTime();
	double [] endPosition =this.getJumpStep();
	this.setPositionX(endPosition[0]);
	this.setPositionY(endPosition[1]);
	this.setActionPoint(0);
	}
}

public double getJumpTime(){
	double distance= Math.pow(this.getInitialVelocity();2)*Math.sin(2*this.getOrientation()/this.gravity());
	double t= distance/(this.getInitialVelocity()*Math.cos(this.getOrientation()));
	return t;
}
public double getJumpStep(){
	double velocityX=this.getInitialVelocity()*Math.cos(this.getOrientation());
	double velocityY=this.getInitialVelocity()*Math.sin(this.getOrientation());
	double positionAftherJumpX= (getPositionX() + velocityX*this.getJumpTime);
	double positionAftherJumpY= (getPositionY() + (velocityY*this.getJumpTime-0.5*(this.gravity()*Math.pow(),2));
	double endPosition[] = new double[] {positionAftherJumpX,positionAftherJumpY};
	return endPosition;	
}
public double getIntialVelocity() {
	double F= (5*this.getActionPoint())+(this.getMass()*this.gravity);
	double V0= ((F/this.getMass())*0.5);
	return V0;
		
}



}






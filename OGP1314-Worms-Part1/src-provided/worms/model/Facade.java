package worms.model;


public class Facade implements IFacade {

	@Override
	public Worm createWorm(double x, double y, double direction, double radius,
			String name) throws IllegalArgumentException{
		
		try {Worm wormpie = new Worm(x,y,direction,radius,name);
			return wormpie;}
		catch(IllegalArgumentException illegalargument) {
			throw new ModelException(illegalargument);
		}
	}

	@Override
	public boolean canMove(Worm worm, int nbSteps) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public void move(Worm worm, int nbSteps) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canTurn(Worm worm, double angle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void turn(Worm worm, double angle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jump(Worm worm) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getJumpTime(Worm worm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double[] getJumpStep(Worm worm, double t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX(Worm worm) {
		return worm.getPositionX();
	}

	@Override
	public double getY(Worm worm) {
		// TODO Auto-generated method stub
		return worm.getPositionY();
	}

	@Override
	public double getOrientation(Worm worm) {
		// TODO Auto-generated method stub
		return worm.getOrientation();
	}

	@Override
	public double getRadius(Worm worm) {
		return worm.getRadius();
	}

	@Override
	public void setRadius(Worm worm, double newRadius) {
		worm.setRadius(newRadius);

	}

	@Override
	public double getMinimalRadius(Worm worm) {
		
		return worm.getMinRadius();
	}

	@Override
	public int getActionPoints(Worm worm) {
	
		return worm.getActionPoint();
	}

	@Override
	public int getMaxActionPoints(Worm worm) {
		
		return worm.getMaxPossiblePoints();
	}

	@Override
	public String getName(Worm worm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rename(Worm worm, String newName) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getMass(Worm worm) {
		// TODO Auto-generated method stub
		return 0;
	}

}

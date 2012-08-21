package surface;

public class RectangleLocation extends Location {

	public RectangleLocation(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdjacent(Location target) {
		// TODO Auto-generated method stub
		if (this.getAxisX() == target.getAxisX()) {
			if (Math.abs(this.getAxisY() - target.getAxisY()) == 1)
				return true;
		} else if (this.getAxisY() == target.getAxisY()) {
			if (Math.abs(this.getAxisX() - target.getAxisX()) == 1)
				return true;
		}
		;

		return false;
	}

}

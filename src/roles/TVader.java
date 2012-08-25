package roles;

import java.util.ArrayList;

import base.VaderBase;

import starMap.StarMapInterface;
import surface.Location;
import surface.LocationStateFactory;
import surface.TVaderState;
import transportation.TFlier;

public class TVader implements TInhabitant {

	private TRover rover;
	private ArrayList<Location> trace = new ArrayList<Location>();
	private LocationStateFactory factory = new LocationStateFactory();

	public TVader(TRover rover) {
		this.rover = rover;
	}

	@Override
	public void moveTo(Location targetLoc) {
		if (!targetLoc.getState().showState().equalsIgnoreCase("THeroBase")) {
			if (targetLoc.getState().showState().equalsIgnoreCase("MapBase")) {
				rover.moveTo(targetLoc);
				rubMap();
			} else
				rover.moveTo(targetLoc);
			trace.add(targetLoc);
		} else
			System.out.println("Vader cannot enter a Hero Base!");

		
		rover.getCurrentLocation().setState(factory.factory(new TVaderState()));

	}

	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return rover.getGender();
	}

	@Override
	public void setStarMap(StarMapInterface starMap) {
		// TODO Auto-generated method stub
		rover.setStarMap(starMap);

	}

	@Override
	public StarMapInterface getStarMap() {
		// TODO Auto-generated method stub
		return rover.getStarMap();
	}

	@Override
	public void setInitLocation(Location loc) {
		rover.setInitLocation(loc);
	}

	@Override
	public Location getCurrentLocation() {
		// TODO Auto-generated method stub
		return rover.getCurrentLocation();
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return rover.getId();
	}

	public void flyTo(Location targetLoc) {
		rover.getCurrentLocation().reverseToLastState();
		rover.setCurrentLocation(targetLoc);
		rover.getCurrentLocation().setState(factory.factory(new TVaderState()));

	}

	public void rubMap() {
		if (!rover.getCurrentLocation().getBase().isEmpty()) {
			StarMapInterface map = rover.getCurrentLocation().getBase()
					.getStarMap();

			rover.setStarMap(map);
			rover.getCurrentLocation().getBase().setEmpty();
			flyTo(VaderBase.loc);
			rover.getCurrentLocation().getBase().setMap(map);
			rover.setStarMap(null);

			System.out.println("Haha! I got the Map!");
		} else {
			System.out.println("This base is already rubbed!");
		}

	}

	public void retrace() {
		
		ArrayList<Location> newTrace=new ArrayList<Location>();
		
		int last=trace.size()-1;
		for(int i=last;i>=1;i--){
			
			if(trace.get(i).isAdjacent(trace.get(i-1)))
				newTrace.add(trace.get(i));
			
			
			}
		
		if(trace.get(0).isAdjacent(trace.get(1)))
			newTrace.add(trace.get(0));
		
		flyTo(newTrace.get(newTrace.size()-1));
		
		for (int i = newTrace.size()-2; i >=0; i--) {
			moveTo(newTrace.get(i));
		}

		trace.clear();
	}

	@Override
	public void setCurrentLocation(Location loc) {
		// TODO Auto-generated method stub
		rover.setCurrentLocation(loc);
		loc.setState(factory.factory(new TVaderState()));
	}

}

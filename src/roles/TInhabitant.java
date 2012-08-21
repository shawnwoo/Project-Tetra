package roles;

import java.util.Date;

import starMap.StarMapInterface;
import surface.Location;

public interface TInhabitant {
 public void moveTo(Location targetLoc);
 public String getImg();
 public String getGender();
 public void setStarMap(StarMapInterface starMap);
 public StarMapInterface getStarMap();
 public void setInitLocation(Location loc);
 public Location getCurrentLocation();
 public String getId();
 
}

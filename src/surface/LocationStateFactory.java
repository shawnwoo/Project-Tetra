package surface;

import java.util.HashMap;

public class LocationStateFactory {
	private HashMap states=new HashMap();
	
	
	public LocationState factory(LocationState state){
		if(states.containsKey(state.showState())){
			return (LocationState)states.get(state.showState());
		}else {
			LocationState newState=new ConcreteState(state);
			states.put(newState.showState(), newState);
			return newState;
		}
		
	}

}

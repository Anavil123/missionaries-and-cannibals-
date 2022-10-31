import java.util.List;

public class DepthLimitedSearch {

	public State exec(State initialState) {
		int limit = 20;
		return recursiveDLS(initialState, limit);
	}

	private State recursiveDLS(State state, int limit) {
		if (state.isGoal()) {
			return state;
		} else if (limit == 0) {
			return null;
		} else {
			List<State> successors = state.generateSuccessors();
			for (State child : successors) {
				State result = recursiveDLS(child, limit - 1);
				if (null != result) {
					return result;
				}
			}
			return null;
		}
	}
}

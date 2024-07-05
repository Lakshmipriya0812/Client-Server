import java.util.List;

class MediatorMasterControl implements Mediator {
	private CircularShifter circularShifter;
	private Alphabetizer alphabetizer;

	public MediatorMasterControl() {
		this.circularShifter = new CircularShifter(this);
		this.alphabetizer = new Alphabetizer(this);
	}

	public List<String> processLines(List<String> inputLines) {
		List<String> shiftedLines = circularShifter.shiftLines(inputLines);

		List<String> sortedLines = alphabetizer.sort(shiftedLines);

		return sortedLines;
	}

	@Override
	public void shiftedLine(String line) {
	}

	@Override
	public void inputHasNextLine(String line) {
	}

	@Override
	public void inputIsFinished() {
	}
}

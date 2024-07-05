import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Alphabetizer extends Colleague {

	public Alphabetizer(Mediator mediator) {
		super(mediator);
	}

	public List<String> sort(List<String> shiftedLines) {
		notifyHasNextLine(shiftedLines);
		List<String> sortedLines = sortingLines(shiftedLines);
		notifySortedLines(sortedLines);
		notifyInputFinished();
		return sortedLines;
	}

	private void notifyHasNextLine(List<String> lines) {
		for (String line : lines) {
			mediator.inputHasNextLine(line);
		}
	}

	private List<String> sortingLines(List<String> lines) {
		TreeSet<String> sortedSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		sortedSet.addAll(lines);
		return new ArrayList<>(sortedSet);
	}

	private void notifySortedLines(List<String> sortedLines) {
		for (String sortedLine : sortedLines) {
			mediator.shiftedLine(sortedLine);
		}
	}

	private void notifyInputFinished() {
		mediator.inputIsFinished();
	}
}

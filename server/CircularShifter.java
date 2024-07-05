import java.util.ArrayList;
import java.util.List;

class CircularShifter extends Colleague {

	public CircularShifter(Mediator mediator) {
		super(mediator);
	}

	public List<String> shiftLines(List<String> lines) {
		List<String> resultList = new ArrayList<>();

		for (String userInput : lines) {
			if (userInput != null) {
				List<String> wordList = circularShiftLine(userInput);
				int size = wordList.size();
				rotateSentence(resultList, wordList, size);
			}
		}

		notifyInputFinished();
		return resultList;
	}

	private List<String> circularShiftLine(String userInput) {
		List<String> sentence = new ArrayList<>();
		String[] words = userInput.split(" ");
		for (String word : words) {
			sentence.add(word.trim());
		}
		return sentence;
	}

	private void rotateSentence(List<String> resultList, List<String> wordList, int size) {
		for (int j = 0; j < size; j++) {
			String lastWord = wordList.get(size - 1);
			for (int i = size - 1; i > 0; i--) {
				wordList.set(i, wordList.get(i - 1));
			}
			wordList.set(0, lastWord);
			String shiftedLine = String.join(" ", wordList);
			resultList.add(shiftedLine);

			mediator.shiftedLine(shiftedLine);
		}
	}

	private void notifyInputFinished() {
		mediator.inputIsFinished();
	}
}

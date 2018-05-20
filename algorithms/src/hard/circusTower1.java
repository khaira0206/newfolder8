package hard;

import java.util.ArrayList;
import java.util.Collections;

class HtWt1 implements Comparable<HtWt1> {

	int Height;
	int Weight;

	public HtWt1(int h, int w) {

		Height = h;
		Weight = w;

	}

	public int compareTo(HtWt1 second) {

		if (this.Height != second.Height) {
			return ((Integer) this.Height).compareTo(second.Height);
		} else {
			return ((Integer) this.Weight).compareTo(second.Weight);
		}

	}

	public boolean isBefore(HtWt1 second) {

		if (Height < second.Height && Weight < second.Weight) {
			return true;
		} else {
			return false;
		}
	}
}

public class circusTower1 {

	public static void main(String arrg[]) {

	}

	ArrayList<HtWt1> longestIncreasingSeq(ArrayList<HtWt1> arr) {

		Collections.sort(arr);

		ArrayList<ArrayList<HtWt1>> solutions = new ArrayList<ArrayList<HtWt1>>();
		ArrayList<HtWt1> bestSequence = null;

		for (int i = 0; i < arr.size(); i++) {
			ArrayList<HtWt1> longestAtIndex = bestSeqAtIndex(arr, solutions, i);
			solutions.add(i, longestAtIndex);
			bestSequence = max(bestSequence, longestAtIndex);
		}

		return bestSequence;
	}

	ArrayList<HtWt1> bestSeqAtIndex(ArrayList<HtWt1> arr, ArrayList<ArrayList<HtWt1>> solutions, int index) {

		HtWt1 value = arr.get(index);
		ArrayList<HtWt1> bestSequence = new ArrayList<HtWt1>();

		for (int i = 0; i < index; i++) {
			ArrayList<HtWt1> solution = solutions.get(i);
			if (canAppend(solution, value)) {
				bestSequence = max(solution, bestSequence);
			}

		}

		ArrayList<HtWt1> best = (ArrayList<HtWt1>) bestSequence.clone();
		best.add(value);
		return best;

	}

	ArrayList<HtWt1> max(ArrayList<HtWt1> seq1, ArrayList<HtWt1> seq2) {

		if (seq1 == null) {
			return seq1;
		} else if (seq2 == null) {
			return seq2;
		} else {
			return seq1.size() > seq2.size() ? seq1 : seq2;
		}
	}

	boolean canAppend(ArrayList<HtWt1> solution, HtWt1 value) {
		if (solution == null) {
			return false;
		} else if (solution.size() == 0) {
			return true;
		}
		HtWt1 last = solution.get(solution.size() - 1);
		return last.isBefore(value);
	}

}

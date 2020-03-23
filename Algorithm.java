package boxstacking;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Algorithm {

	public int solve(Box input[]) {

		Box[] boxes = new Box[input.length * 3];

		// rotate each box so that each box has three instances
		for (int i = 0; i < input.length; i++) {
			Box box = input[i];
			boxes[i * 3] = new Box(box.height, box.width, box.depth);
			boxes[i * 3 + 1] = new Box(box.width, box.height, box.depth);
			boxes[i * 3 + 2] = new Box(box.depth, box.height, box.width);
		}

		// sort boxes in descending order based on area of their base (w x d) (set in
		// Comparable)
		Arrays.sort(boxes);

		// print all possible boxes in sorted order
//		System.out.println("\nAll possible combination of boxes after rotation:");
//		System.out.println("\nh  w  d");
//		for (int i = 0; i < boxes.length; i++) {
//			System.out.println(boxes[i].height + " " + boxes[i].width + " " + boxes[i].depth);
//		}

		// initialize maxStackHeight for each box
		// maxStackHeight[i] is max Stack with i on top
		int[] maxStackHeight = new int[boxes.length];
		for (int i = 0; i < boxes.length; i++) {
			maxStackHeight[i] = boxes[i].height;
		}

		// find maxStackHeight for each i box by comparing its width & depth to previous
		// boxes
		for (int i = 0; i < boxes.length; i++) {
			int val = 0;
			// Bottom up approach starting at index 0 for each i
			for (int j = 0; j < i; j++) {
				if (boxes[i].width < boxes[j].width && boxes[i].depth < boxes[j].depth) {
					val = Math.max(val, maxStackHeight[j]);
				}
			}
			maxStackHeight[i] = val + boxes[i].height;
		}

		// iterate thru array to get max of all maxStackHeight values
		int max = 0;
		for (int i = 0; i < boxes.length; i++) {
			max = Math.max(max, maxStackHeight[i]);
		}
		System.out.println(Arrays.toString(maxStackHeight));
		return max;

// ALTERNATIVE METHOD 		
//		int [] optHeight = new int [boxes.length+1];
//		
//		//edge case: if no boxes then optHeight = 0
//		optHeight[0] = 0;
//		
//		for (int i=1; i<optHeight.length; i++) {
//			int maxHeightIndex = 0;
//			for (int j=i-1; j>=0; j--) {
//				if(boxes[j].width>boxes[i-1].width && boxes[j].depth>boxes[i-1].depth) {
//					if(optHeight[maxHeightIndex]<optHeight[j+1]) {
//						maxHeightIndex = j+1;
//					}
//				}
//			}
//			optHeight[i] = optHeight[maxHeightIndex] + boxes[i-1].height;
//		}
//		return optHeight[optHeight.length-1];
	}
}

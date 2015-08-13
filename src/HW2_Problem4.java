import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/*
 * Raymond Luu
 * TCSS 343
 * 4/16/2014
 * Homework 2 Problem 4
 */
public class HW2_Problem4 {
	
	/**
	 * Main method
	 * 
	 * @param args console input.
	 */
	public static void main(String[] args) {
		// points on a given 2d plane
		Point p1 = new Point(1,1);
		Point p2 = new Point(3,1);
		Point p3 = new Point(2,2);
		Point p4 = new Point(4,2);
		Point p5 = new Point(3,3);
		Point p6 = new Point(5,3);
		Point p7 = new Point(0,4);
		Point p8 = new Point(1,4);
		Point p9 = new Point(2,4);
		Point p10 = new Point(4,4);
		Point p11 = new Point(6,4);
		
		Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11}; // array of points
		
		int max = maxNumPoints(points);

		System.out.println("The max number of points on a single straight line is: " + max);
	}
	
	/**
	 * Method to solve problem 4 in Homework 2
	 * 
	 * @param inputs array of points.
	 * @param size size of the current array.
	 * @return max number of points in a straight line.
	 */
	public static int maxNumPoints(Point[] inputs)
	{
		int currentMax = -1;
		
		if (inputs == null)
		{
			currentMax = 0;
		}
		else if (inputs.length == 1)
		{
			currentMax = 1;
		}
		else
		{			
			currentMax = 0;
			double slope_numerator = 0.0;
			double slope_denominator = 0.0;
			double slope = 0.0;
			
			for (int i = 0; i < inputs.length - 1; i++) {
				double[] slopes = new double[inputs.length - i];
				int count = 2; // given a slope, you already know two points are in a line
				// add all the slopes from one point to every other point to a new array
				for (int j = i + 1; j < inputs.length; j++)
				{
					slope_numerator = inputs[i].getY() - inputs[j].getY();
					slope_denominator = inputs[i].getX() - inputs[j].getX();
					slope = slope_numerator/slope_denominator;
					slopes[j - i - 1] = slope;
					System.out.print(slope + " ");
				}
				System.out.println();
				// Count all the slopes that are equivalent and keep a max
				for (int k = 0; k < slopes.length - 1; k++)
				{
					for (int l = k + 1; l < slopes.length - 1; l++)
					{
						if (slopes[k] == slopes[l])
						{
							System.out.print("[" + k + "]");
							System.out.print(slopes[k]);
							System.out.print("["+ l + "]");
							System.out.println(slopes[l]);
							count++;
						}
					}
					if (count > currentMax)
					{
						currentMax = count;
					}
					System.out.print("(" + count + ")");
					System.out.println("{" + currentMax + "}");
					count = 2;
				}
			}
		}
		return currentMax;
	}

}

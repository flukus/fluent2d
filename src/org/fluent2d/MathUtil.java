package org.fluent2d;

public class MathUtil {

	public static int getPoint(float pointP, int offsetA, int extentA) {
		float divisor = pointP / 100;
		int length = offsetA - extentA;
		int pointA = (int) (length * divisor);
		int pointR = pointA + offsetA;
		return pointR;
	}

	public static int getCentreOffset(int parentX1, int parentX2, int childX1,
			int childX2) {
		int parentWidth = parentX2 - parentX1;
		int childWidth = childX2 - childX1;
		int padding = parentWidth - childWidth;
		int offset = padding / 2;
		return offset;
	}

}

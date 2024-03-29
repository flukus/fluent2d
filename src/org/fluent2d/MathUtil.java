package org.fluent2d;

public class MathUtil {

	public static int getPoint(float pointP, int offsetV, int extentV) {
		float divisor = pointP / 100;
		int length = extentV - offsetV;
		int pointA = (int) (length * divisor);
		int pointR = pointA + offsetV;
		return pointR;
	}

	public static int getCentreOffset(int parentX1, int parentX2, int childX1,
			int childX2) {
		int parentWidth = parentX2 - parentX1;
		int parentCenter = parentWidth / 2;
		int childWidth = childX2 - childX1;
		int childCenter = childWidth / 2;
		int offset = parentCenter - childCenter;
		return offset + parentX1;
	}

}

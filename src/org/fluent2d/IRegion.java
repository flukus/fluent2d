package org.fluent2d;

public interface IRegion<T extends IRegion<?>> {

	// gets the absolute value of top
	public abstract int top();

	public abstract int left();

	public abstract int bottom();

	// sets the right value in absolute pixels
	public abstract T right(int right);

}
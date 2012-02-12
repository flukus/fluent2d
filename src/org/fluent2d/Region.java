package org.fluent2d;

@SuppressWarnings("unchecked")
public class Region<T extends Region<?>> {

	private int top;
	private int left;
	private int bottom;
	private int right;
	private Region<?> parent;

	public Region(int top, int left, int bottom, int right) {
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
		parent = this;
	}

	public Region(Region<?> parentRegion) {
		this.parent = parentRegion;
		this.top = parentRegion.top();
		this.left = parentRegion.left();
		this.bottom = parentRegion.bottom();
		this.right = parentRegion.right();
	}

	protected Region() {
	}

	protected void setParent(Region<?> parent) {
		this.parent = parent;
	}

	public int top() {
		return this.top;
	}

	// sets the top as a percentage
	public T top(float f) {
		top = (int) ((parent.bottom() - parent.top()) * f) + parent.top();
		return (T) this;
	}

	// sets the top in absolute pixels
	public T top(int top) {
		this.top = top;
		return (T) this;
	}

	public int left() {
		return this.left;
	}

	public int bottom() {
		return this.bottom;
	}

	// sets the bottom in absolute pixels
	public T bottom(int bottom) {
		this.bottom = bottom;
		return (T) this;
	}

	public T bottom(float bottom) {
		bottom = (int) ((parent.bottom() - parent.top()) * bottom)
				+ parent.top();
		return (T) this;
	}

	// sets the bottom in absolute pixels relative to it's current value
	public T bottomR(int bottom) {
		this.bottom = this.bottom + bottom;
		return (T) this;
	}

	public int right() {
		return this.right;
	}

	// sets the right value in absolute pixels
	public T right(int right) {
		this.right = right;
		return (T) this;
	}

	// sets the right value in absolute pixels relative to it's current value
	public T rightR(int right) {
		this.right = this.right + right;
		return (T) this;
	}

	public T width(float f) {
		right = (int) ((parent.right() - parent.left()) / f) + parent.left();
		return (T) this;
	}

	public void height(float f) {
		// TODO Auto-generated method stub
	}

	public T centerHorizontal() {
		// TODO Auto-generated method stub
		return (T) this;
	}

}

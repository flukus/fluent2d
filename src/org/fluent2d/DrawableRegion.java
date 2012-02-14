package org.fluent2d;

import org.fluent2d.resolutions.Resolution;

@SuppressWarnings("unchecked")
public class DrawableRegion<T extends DrawableRegion<?>> extends Drawable<T>
		implements IRegion {

	private int top;
	private int left;
	private int bottom;
	private int right;
	private final IRegion parentRegion;

	public DrawableRegion(Theme theme, Resolution resolution, State state) {
		super(theme, resolution, state);
		top = resolution.paddedArea().top();
		left = resolution.paddedArea().left();
		bottom = resolution.paddedArea().bottom();
		right = resolution.paddedArea().right();
		parentRegion = resolution.paddedArea();
	}

	public IRegion parentRegion() {
		return parentRegion;
	}

	@Override public int top() {
		return this.top;
	}

	// sets the top as a percentage
	public T top(float topP) {
		top = MathUtil.getPoint(topP, parentRegion().top(), parentRegion()
				.bottom());
		return (T) this;
	}

	// sets the top in pixels relative to the parent
	public T top(int topV) {
		top = topV + parentRegion().top();
		return (T) this;
	}

	// sets the top value in absolute pixels, ignoring parent dimensions
	public T topA(int topV) {
		top = topV;
		return (T) this;
	}

	// sets the top value in absolte pixels relative to it's current value
	public T topR(int topR) {
		top = top + topR;
		return (T) this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fluent2d.IRegion#left()
	 */
	@Override public int left() {
		return this.left;
	}

	// sets the left as a percentage
	public T left(float leftP) {
		top = MathUtil.getPoint(leftP, parentRegion().left(), parentRegion()
				.right());
		return (T) this;
	}

	// sets the left in pixels relative to the parent
	public T left(int leftV) {
		left = leftV + parentRegion().left();
		return (T) this;
	}

	// sets the left value in absolute pixels, ignoring parent dimensions
	public T leftA(int leftV) {
		left = leftV;
		return (T) this;
	}

	// sets the left value in absolte pixels relative to it's current value
	public T leftR(int leftV) {
		left = leftV + left;
		return (T) this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fluent2d.IRegion#bottom()
	 */
	@Override public int bottom() {
		return this.bottom;
	}

	// sets the bottom in absolute pixels
	public T bottom(int bottom) {
		this.bottom = bottom;
		return (T) this;
	}

	public T bottom(float bottom) {
		this.bottom = MathUtil.getPoint(bottom, parentRegion().top(),
				parentRegion().bottom());
		return (T) this;
	}

	// sets the bottom in absolute pixels relative to it's current value
	public T bottomR(int bottom) {
		this.bottom = this.bottom + bottom;
		return (T) this;
	}

	public T bottomA(int bottom) {
		this.bottom = bottom;
		return (T) this;
	}

	@Override public int right() {
		return this.right;
	}

	public T right(int right) {
		this.right = right;
		return (T) this;
	}

	public T right(float rightR) {
		this.right = MathUtil.getPoint(rightR, parentRegion().left(),
				parentRegion().right());
		return (T) this;
	}

	// sets the right value in absolute pixels relative to it's current value
	public T rightR(int right) {
		this.right = this.right + right;
		return (T) this;
	}

	public T rightA(int right) {
		this.right = right;
		return (T) this;
	}

	public int width() {
		return right() - left();
	}

	public T width(float widthP) {
		right = MathUtil.getPoint(widthP, parentRegion().left(), parentRegion()
				.right())
				+ left;
		return (T) this;
	}

	public int height() {
		return bottom() - top();
	}

	public T height(float heightP) {
		right = MathUtil.getPoint(heightP, parentRegion().top(), parentRegion()
				.bottom())
				+ top;
		return (T) this;
	}

	public T centerHorizontal() {
		int width = right - left;
		int offset = MathUtil.getCentreOffset(parentRegion().left(),
				parentRegion().right(), left(), right());
		leftA(offset);
		rightA(offset + width);
		return (T) this;
	}

}

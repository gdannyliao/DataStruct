package com.danny.datastruct;

import android.graphics.RectF;

public class Cell implements Comparable<Cell>, Cloneable {

	RectF rect;

	public RectF getRect() {
		return rect;
	}

	public void setRect(RectF rect) {
		this.rect = rect;
	}

	private char text;

	public char getText() {
		return text;
	}

	public void setText(char text) {
		this.text = text;
	}

	public float width() {
		return rect == null ? 0 : rect.width();
	}

	public float height() {
		return rect == null ? 0 : rect.height();
	}

	public float getCenterX() {
		return rect == null ? 0 : rect.centerX();
	}

	public float getCenterY() {
		return rect == null ? 0 : rect.centerY();
	}

	public float getLeft() {
		return rect == null ? 0 : rect.left;
	}

	public float getRight() {
		return rect == null ? 0 : rect.right;
	}

	public float getTop() {
		return rect == null ? 0 : rect.top;
	}

	public float getBottom() {
		return rect == null ? 0 : rect.bottom;
	}

	@Override
	public int compareTo(Cell another) {
		if (rect == null || another == null)
			return 0;
		if (text > another.text)
			return 1;
		else if (text < another.text)
			return -1;
		else
			return 0;
	}

	@Override
	public int hashCode() {
		return rect == null ? super.hashCode() + text : super.hashCode() + text
				+ rect.hashCode();
	}

	@Override
	public String toString() {
		return rect == null ? String.valueOf(text) : String.valueOf(text)
				+ " " + rect.toString();
	}

	public String toTextString() {
		return String.valueOf(text);
	}

	public float[] getAngles() {
		if (rect == null)
			return null;

		float[] edges = new float[4];
		edges[0] = rect.left;
		edges[1] = rect.top;
		edges[2] = rect.right;
		edges[3] = rect.bottom;
		return edges;
	}

	private volatile boolean isDrawing = false;

	public boolean isDrawing() {
		return isDrawing;
	}

	public void setDrawing(boolean isDrawing) {
		this.isDrawing = isDrawing;
	}

	@Override
	public Cell clone() throws CloneNotSupportedException {
		Cell newObj = (Cell) super.clone();
//		RectF newRect = new RectF(newObj.rect);
//		newObj.rect = newRect;
		return newObj;
	}
}

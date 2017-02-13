package BitManipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a method that finds the intersecting rectangle of two given rectangles.
 *
 * Created by rezaamini on 2/13/17.
 */
public class IntersectingRectangles {
    // Time complexity: O(1)
    public static Rectangle intersectingRectangle(Rectangle r1, Rectangle r2) {
        if (!isIntersecting(r1, r2)) {
            return new Rectangle(0, 0, -1, -1); // No intersection
        }

        int x = Math.max(r1.x, r2.x);
        int y = Math.max(r1.y, r2.y);
        int width = Math.min(r1.x + r1.width, r2.x + r2.width) - x;
        int height = Math.min(r1.y + r1.height, r2.y + r2.height) - y;
        return new Rectangle(x, y, width, height);
    }

    public static boolean isIntersecting(Rectangle r1, Rectangle r2) {
        return (r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x)
                && (r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y);
    }

    @Test
    public void testIntersectingRectangle() {
        Rectangle r1 = new Rectangle(0, 0, 5, 10);
        Rectangle r2 = new Rectangle(1, 0, 3, 4);
        Assert.assertEquals(r2, intersectingRectangle(r1, r2));
    }
}

class Rectangle {
    int x; // Lower left point x
    int y; // lower left point y
    int width;
    int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Rectangle)) {
            return false;
        }

        Rectangle rect = (Rectangle)obj;
        return rect.x == this.x
                && rect.y == this.y
                && rect.width == this.width
                && rect.height == this.height;
    }

    @Override
    public int hashCode() {
        return 13 * x
                + 17 * y
                + 19 * width
                + 23 * height;
    }
}

package visualizer;

import gameObjects.Field;

/**
 * The interface is about drawing game field
 * It visualizes shot cells, empty sea cells and shot ship cells
 * Contains methods drawInitialField() and drawField() for drawing initial field and field after each turn
 */
public interface Visualazible {
    void drawInitialField(Field field);

    void drawField(Field field);
}

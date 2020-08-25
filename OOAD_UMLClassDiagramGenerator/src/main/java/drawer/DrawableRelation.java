package drawer;

import java.awt.Graphics;

import model.diagrams.RelationType;
import model.shapes.Relation;

public class DrawableRelation implements Drawable {
    private Relation relation;

    public DrawableRelation(Relation relation) {
        this.relation = relation;
    }

    @Override
    public void draw(Graphics g) {
        int startX = relation.getStartX(), startY = relation.getStartY();
        int endX = relation.getEndX(), endY = relation.getEndY();
        RelationType relationType = relation.getRelationType();
        g.drawString(relationType.toString(), (startX + endX) / 2, (startY + endY) / 2);
        g.drawLine(startX, startY, endX, endY);
    }
}
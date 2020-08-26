package drawer;

import java.awt.Graphics;

import model.classDetail.Relation;
import model.diagrams.RelationType;

public class RelationDrawer implements SwingDrawer {
    private Relation relation;

    public RelationDrawer(Relation relation) {
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
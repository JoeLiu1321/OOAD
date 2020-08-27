package drawer;

import canvas.Canvas;
import model.diagrams.RelationType;
import model.geometric.Relation;

public class RelationDrawer implements Drawer {
    private Relation relation;

    public RelationDrawer(Relation relation) {
        this.relation = relation;
    }

    @Override
    public void draw(Canvas canvas) {
        int startX = relation.getStartX(), startY = relation.getStartY();
        int endX = relation.getEndX(), endY = relation.getEndY();
        RelationType relationType = relation.getRelationType();
        canvas.drawString(relationType.toString(), (startX + endX) / 2, (startY + endY) / 2);
        canvas.drawLine(startX, startY, endX, endY);
    }
}
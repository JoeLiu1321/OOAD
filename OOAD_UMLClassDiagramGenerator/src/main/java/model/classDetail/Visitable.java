package model.classDetail;

import visitor.*;

public interface Visitable {
    public abstract void accept(Visitor drawer);
}
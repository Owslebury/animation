package com.example.animation.data;

import com.example.animation.toolbox.Toolmode;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ToolData {
    private static ToolData instance;
    private ObjectProperty<Toolmode> toolmodeProperty;

    private ToolData() {
        toolmodeProperty = new SimpleObjectProperty<>(Toolmode.NONE);
    }

    public void setToolmode(Toolmode toolmode) {
        toolmodeProperty.set(toolmode);
    }

    public Toolmode getToolmode() {
        return toolmodeProperty.get();
    }

    public ObjectProperty<Toolmode> toolmodeProperty() {
        return toolmodeProperty;
    }

    public static synchronized ToolData getInstance() {
        if (instance == null) {
            instance = new ToolData();
        }
        return instance;
    }
}

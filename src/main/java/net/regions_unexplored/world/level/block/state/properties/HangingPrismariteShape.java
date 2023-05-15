package net.regions_unexplored.world.level.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum HangingPrismariteShape implements StringRepresentable {
    COLUMN("column"),
    FRUSTUM("frustum"),
    TIP("tip");

    private final String name;

    private HangingPrismariteShape(String shape) {
            this.name = shape;
    }

    public String getName() {
            return this.name;
        }

    public String toString() {
            return this.name;
        }

    public String getSerializedName() {
            return this.name;
        }
}

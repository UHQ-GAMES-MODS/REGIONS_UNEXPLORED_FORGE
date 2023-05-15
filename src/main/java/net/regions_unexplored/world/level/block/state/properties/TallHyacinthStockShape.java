package net.regions_unexplored.world.level.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum TallHyacinthStockShape implements StringRepresentable {
    BASE("base"),
    BASE_FRUSTUM("base_frustum"),
    BASE_TIP("base_tip"),
    MIDDLE("middle"),
    FRUSTUM("frustum"),
    TIP("tip");

    private final String name;

    private TallHyacinthStockShape(String shape) {
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

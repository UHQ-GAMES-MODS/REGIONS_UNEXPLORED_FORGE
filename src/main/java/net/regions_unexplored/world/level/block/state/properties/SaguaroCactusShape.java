package net.regions_unexplored.world.level.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum SaguaroCactusShape implements StringRepresentable {
    NORTH_SOUTH("north_south"),
    EAST_WEST("east_west"),
    UP_DOWN("up_down"),
    NORTH_UP("north_up"),
    SOUTH_UP("south_up"),
    EAST_UP("east_up"),
    WEST_UP("west_up");

    private final String name;

    private SaguaroCactusShape(String shape) {
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

package com.burning8393.builder;

public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain terrain = builder.buildFort().buildMine().buildWall().build();

        Person p = new Person
                .PersonBuilder()
                .basicInfo(11, "zhangsan", 14)
                .score(84)
                .build();
    }
}

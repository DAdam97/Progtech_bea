package com.company;

public class Position {
    private int x;
    private int y;

    private Direction facing;

    public int getX() { return x; }
    public int getY() { return y; }

    public Direction getFacing() { return this.facing; }

    public void faceTo(Direction direction) { this.facing = direction; }

    public void faceTo(Character character){
        double angle = calcAngle(this, character.getPosition());

        if (337.5d > angle || angle <= 22.5 ) { this.facing = Direction.EAST; }

        double tempAngle = 45.0d;
        double offsetAngle = 22.5d;
        int numOfDirs = 8;

        for (int i = 1; i < numOfDirs; i++){
            if (tempAngle - offsetAngle < angle && tempAngle + offsetAngle <= angle )
                facing = Direction.valueOf(i);

            tempAngle += 45.0d;
        }
    }

    private double calcAngle(Position from, Position to){
        int vecX = to.x - from.x;
        int vecY = to.y - from.y;

        double angle = 0d;

        if (vecX >= 0 && vecY >= 0){              /* koordinata rendszer 1. negyede */
            try { angle = Math.toDegrees(Math.atan(vecY / vecX)); }
            catch (ArithmeticException e) { angle = 90d; }
        }
        else if (vecX <= 0 && vecY >= 0){         /* 2. negyede */
            angle = Math.toDegrees(Math.atan(vecY / vecX)) + 180d;
        }
        else if (vecX <= 0 && vecY <= 0){         /* 3. negyede */
            try { angle = Math.toDegrees(Math.atan(vecY / vecX)) + 180d; }
            catch (ArithmeticException e) { angle = 270d; }
        }
        else {                                  /* 4. negyede */
            angle = Math.toDegrees(Math.atan(vecY / vecX)) + 360d;
        }

        return angle;
    }

    void moveTo(Position newPosition){
        this.x = newPosition.x;
        this.y = newPosition.y;
    }

    void moveForward(Direction direction, int steps){
        this.facing = direction;
        switch (direction){
            case NORTH:
                step( 0, +steps );
                break;

            case NORTHEAST:
                step( +steps, +steps );
                break;

            case EAST:
                step( +steps, 0 );
                break;

            case SOUTHEAST:
                step( +steps, -steps );
                break;

            case SOUTH:
                step( 0, -steps );
                break;

            case SOUTHWEST:
                step( -steps, -steps );
                break;

            case WEST:
                step( -steps, 0 );
                break;

            case NORTHWEST:
                step( -steps, +steps );
                break;
        }
    }

    private  void step(int xSteps, int ySteps){
        this.x += xSteps;
        this.y += ySteps;
    }

    public Position() {
        this.facing = Direction.EAST;
        this.x = 0;
        this.y = 0;
    }

    public Position(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y, Direction faceing){
        this(x,y);
        this.facing = faceing;
    }
}
package com.hasw3ll.game.settings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.hasw3ll.game.factory.WaypointFactory;

public class EnemySettings {
    private int hp;
    private float armor;
    private float speed = 200f;

    private float x = 0;
    private float y = 0;
    private float width = 50;
    private float height = 50;

    private Texture texture;
    private Array<Vector2> wayPoints = WaypointFactory.WAYPOINTS;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Array<Vector2> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(Array<Vector2> wayPoints) {
        this.wayPoints = wayPoints;
    }
}

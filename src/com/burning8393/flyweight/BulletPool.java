package com.burning8393.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Bullet {
    private UUID id = UUID.randomUUID();
    public boolean isAlive = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}

public class BulletPool {
    List<Bullet> bullets = new ArrayList<>();

    {
        for (int i = 0; i < 5; i++) {
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (!bullet.isAlive) {
                return bullet;
            }
        }
        return new Bullet();
    }
    public static void main(String[] args) {
        BulletPool pool = new BulletPool();
        for (int i = 0; i < 10; i++) {
            Bullet bullet = pool.getBullet();
            System.out.println(bullet);
        }
    }
}

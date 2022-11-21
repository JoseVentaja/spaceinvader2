package com.politecnicomalaga.sp2.managers;

import com.politecnicomalaga.sp2.model.Bullet;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShootManager {
    private ArrayList<Bullet> listBullet=new ArrayList<Bullet>();
    private ArrayList<Bullet> listBulletDead=new ArrayList<Bullet>();
    private static ShootManager singleton;
    public static ShootManager getSingleton() {
        if (singleton == null) {
            singleton = new ShootManager();
        }
        return singleton;
    }
    public Bullet shootCreate(float positionX, float positionY){
        saveShoot(positionX, positionY);
        Bullet nuevo = listBullet.get(listBullet.size()-1);
        if(listBullet.get(0).getY()>SettingsManager.SCREEN_HEIGHT){
            deadShoot(listBullet.get(0),0);
        }
        return nuevo;
    }
    public ArrayList<Bullet> getListBullet(){
        return listBullet;
    }
    public void deadShoot(Bullet shoot, int i){
        shoot.setY(1000);
        listBulletDead.add(shoot);
        listBullet.remove(i);
    }
    public void saveShoot(float positionX, float positionY){
        if(listBulletDead.isEmpty()){
            listBullet.add(new Bullet(positionX, positionY));
            listBullet.get(listBullet.size()-1).setX(positionX);
            listBullet.get(listBullet.size()-1).setY(positionY);
        }else{
            listBullet.add(listBulletDead.get(0));
            listBulletDead.remove(0);
            listBullet.get(listBullet.size()-1).setX(positionX);
            listBullet.get(listBullet.size()-1).setY(positionY);
        }
    }
}

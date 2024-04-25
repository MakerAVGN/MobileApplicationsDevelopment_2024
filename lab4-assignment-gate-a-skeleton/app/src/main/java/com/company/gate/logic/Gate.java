package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here

    // направленя открытия ворот
    public static final int OUT = -1; // наружу
    public static final int IN = 1; // внутрь
    public static final int CLOSED = 0;  // закрыто
    // Для хранения направления открывания ворот
    private int mSwing;

    //получение текущего направления открывания ворот
    public int getSwingDirection() {
        return mSwing;
    }

    // Метод для установки направления открывания ворот
    public boolean setSwing(int mSwing) {
        // Проверка, является ли направление допустимым
        if (-1 <= mSwing && mSwing <= 1) {
            this.mSwing = mSwing;
            return true;
        } else {
            return false;
        }
    }

    // Метод для открытия ворот в заданном направлении
    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            setSwing(direction);
            return true;
        }
        return false;
    }

    // Метод для закрытия ворот
    public void close() {
        setSwing(CLOSED);
    }

    // Метод для подсчета количества прошедших через ворота улиток
    public int thru(int count) {
        return (getSwingDirection() == OUT) ? -count : (getSwingDirection() == IN) ? count : 0;
    }

    // Переопределение метода toString для возврата строкового представления направления открывания ворот
    @Override
    public String toString() {
        if (getSwingDirection() == OUT){
            return "This gate is open and swings to exit the pen only";
        }else {
            if (getSwingDirection()== IN){
                return "This gate is open and swings to enter the pen only";
            }else {
                if (getSwingDirection() == CLOSED){
                    return "This gate is closed";
                }
                else {
                    return "This gate has an invalid swing direction";
                }
            }
        }
    }

}

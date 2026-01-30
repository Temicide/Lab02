package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
    private int row;
    private int column;
    private boolean isWhite;
    private String name;
    protected int hp;
    protected int power;
    protected boolean isFlying;

    public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
        if (startColumn < 0) startColumn = 0;
        if (startColumn > 4) startColumn = 4;
        if (startRow < 0) startRow = 0;
        if (startRow > 4) startRow = 4;

        this.row = startRow;
        this.column = startColumn;
        this.isWhite = isWhite;
        this.name = name;
        this.hp = 2;
        this.power = 1;
        this.isFlying = false;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        if (column < 0) column = 0;
        if (column > 4) column = 4;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row < 0) row = 0;
        if (row > 4) row = 4;
        this.row = row;
    }

    public boolean move(int direction) {
        if (direction < 0 || direction > 3) return false;

        if (direction == 0) {
            if (this.row == 4) return false;
            row += 1;
        }
        else if (direction == 1) {
            if (this.column == 4) return false;
            column += 1;
        }
        else if (direction == 2) {
            if (this.row == 0) return false;
            row -= 1;
        }
        else {
            if (this.column == 0) return false;
            column -= 1;
        }

        return true;
    }

    public void attack(ArrayList<BaseUnit> targetPieces) {
        for (BaseUnit piece : targetPieces) {
            int targetRow = piece.getRow();
            int targetColumn = piece.getColumn();

            if (this.column == targetColumn && this.row == targetRow && !piece.isFlying()) {
                System.out.println(this.getName() + " attacks " + piece.getName());
                piece.setHp(piece.getHp() - this.power);
            }
        }
    }

    public int getPower() {
        return power;
    }

    public boolean isFlying() {
        return isFlying;
    }
}

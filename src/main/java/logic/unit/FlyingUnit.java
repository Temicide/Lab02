package logic.unit;

public class FlyingUnit extends BaseUnit{
    public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        super.hp = 2;
        super.isFlying = true; 
    }
    
    @Override
    public boolean move(int direction) {
        if (direction < 0 || direction > 3) return false;

        if (direction == 0) {
            if (super.getRow() >= 3) return false;
            super.setRow(super.getRow() + 1);
        }
        else if (direction == 1) {
            if (super.getColumn() >= 3) return false;
            super.setColumn(super.getColumn() + 1);
        }
        else if (direction == 2) {
            if (super.getRow() <= 1) return false;
            super.setRow(super.getRow() - 1);
        }
        else {
            if (super.getColumn() <= 1) return false;
            super.setColumn(super.getColumn() - 1);
        }

        return true;
    }
}

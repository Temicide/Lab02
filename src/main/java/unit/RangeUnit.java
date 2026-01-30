package unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {
    public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        super.hp = 2;
    }

    @Override
    public void attack(ArrayList<BaseUnit> targetPieces) {

        boolean isWhite = super.isWhite();
        int offTarget;

        if(isWhite) offTarget = 1;
        else offTarget = -1;

        for (BaseUnit piece : targetPieces) {
            int targetRow = piece.getRow();
            int targetColumn = piece.getColumn();

            if (super.getColumn() == targetColumn && super.getRow() + offTarget == targetRow) {
                System.out.println(this.getName() + " attacks " + piece.getName());
                piece.setHp(piece.getHp() - this.power);
            }
        }
    }
}

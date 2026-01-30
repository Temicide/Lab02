package unit;

public class MeleeUnit extends BaseUnit{
    MeleeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        super.hp = 5;
        super.power = 2;
    }
}

package lab4;

public class TypeChecker {
    private Integer type;

    public void setType(Object type) throws CustomInputMismatchException {
        if (type instanceof Integer) {
            this.type = (Integer) type;
        } else {
            throw new CustomInputMismatchException("Mismatch exception: Invalid type");
        }
    }
}

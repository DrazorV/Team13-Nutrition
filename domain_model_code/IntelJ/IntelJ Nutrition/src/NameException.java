public class NameException extends  Exception{
    @Override
    public String toString() {
        return "The name contains one or more characters which does/do not belong to the alphabet";
    }
}

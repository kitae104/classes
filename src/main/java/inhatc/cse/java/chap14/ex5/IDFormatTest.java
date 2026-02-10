package inhatc.cse.java.chap14.ex5;

public class IDFormatTest {

    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) throws IDFormatException {

        if (userID == null) {
            throw new IDFormatException("아이디는 null일 수 없습니다.");
        } else if (userID.length() < 8 || userID.length() > 20) {
            throw new IDFormatException("아이디는 8자 이상 20자 이하로 입력해야 합니다.");
        }
        this.userID = userID;
    }

    public static void main(String[] args) {

        IDFormatTest test = new IDFormatTest();
        String userID = null;

        try {
            test.setUserID(userID);
        } catch (IDFormatException e) {
            e.printStackTrace();
        }

        userID = "1234";
        try {
            test.setUserID(userID);
        } catch (IDFormatException e) {
            e.printStackTrace();
        }
    }
}

package kim.kitae.chap11.ex6;

public record StudentInfo(int id, String name) {
    public static String SCHOOL_NAME = "MY_SCHOOL";

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StudentInfo std){
            return this.id == std.id;
        } else {
            return false;
        }
    }

    public void setName(String name) {
//        this.name = name;
    }
}

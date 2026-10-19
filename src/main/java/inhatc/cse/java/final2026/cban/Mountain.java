package inhatc.cse.java.final2026.cban;

public class Mountain {
    private String name;
    private String region;
    private int height;
    private int visitors;

    public Mountain(String name, String region, int height, int visitors) {
        this.name = name;
        this.region = region;
        this.height = height;
        this.visitors = visitors;
    }

    public String getName()     { return name; }
    public String getRegion()   { return region; }
    public int    getHeight()   { return height; }
    public int    getVisitors() { return visitors; }
}

package inhatc.cse.java.mid.aban.ex3;

import inhatc.cse.java.quiz.y2026.Ex3PostManagement;

public class Post {
    private int id;
    private String title;
    private String author;
    private int views;
    private PostType type;

    public Post(int id, String title, String author, int views, PostType type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.views = views;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public PostType getType() {
        return type;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", views=" + views +
                ", type=" + type +
                '}';
    }
}

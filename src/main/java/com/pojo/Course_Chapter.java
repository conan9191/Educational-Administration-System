package com.pojo;

public class Course_Chapter {
    private Integer id;

    private String name;

    private String content;

    private String chapterFile;

    private Integer courseId;

    private Integer superiorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getChapterFile() {
        return chapterFile;
    }

    public void setChapterFile(String chapterFile) {
        this.chapterFile = chapterFile == null ? null : chapterFile.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }
}
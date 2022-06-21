package com.example.ispitni_rokovi.models;

public class Study_group  extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=400)
    String name;

    @ForeignKey(table = "faculty", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int faculty_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }
}

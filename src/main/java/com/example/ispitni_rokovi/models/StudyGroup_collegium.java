package com.example.ispitni_rokovi.models;

public class StudyGroup_collegium extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @ForeignKey(table = "collegium", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int collegium_id;

    @ForeignKey(table = "study_group", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int study_group_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCollegium_id() {
        return collegium_id;
    }

    public void setCollegium_id(int collegium_id) {
        this.collegium_id = collegium_id;
    }

    public int getStudy_group_id() {
        return study_group_id;
    }

    public void setStudy_group_id(int study_group_id) {
        this.study_group_id = study_group_id;
    }
}

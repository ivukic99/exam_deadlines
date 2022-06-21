package com.example.ispitni_rokovi.models;

public class Exam_deadline extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=50)
    String exam_date;

    @Entity(type="VARCHAR", size=50)
    String application_exam_date;

    @Entity(type="VARCHAR", size=50)
    String cancel_exam_date;

    @ForeignKey(table = "collegium", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int collegium_id;

    @ForeignKey(table = "user", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExam_date() {
        return exam_date;
    }

    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    public String getApplication_exam_date() {
        return application_exam_date;
    }

    public void setApplication_exam_date(String application_exam_date) {
        this.application_exam_date = application_exam_date;
    }

    public String getCancel_exam_date() {
        return cancel_exam_date;
    }

    public void setCancel_exam_date(String cancel_exam_date) {
        this.cancel_exam_date = cancel_exam_date;
    }

    public int getCollegium_id() {
        return collegium_id;
    }

    public void setCollegium_id(int collegium_id) {
        this.collegium_id = collegium_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

package com.easykotlin.lectures.jfp;

import java.util.Date;

public class NullPointerExceptionDemo {
    static NullPointerExceptionDemo demo = new NullPointerExceptionDemo();

    public static void main(String[] args) {
        //demo.test1();
        demo.test2();
    }

    void test1() {
        try {
            Milestone nullMilestone = null;
            check(nullMilestone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // field is null
        Milestone milestone = new Milestone();
        milestone.setName("发布上线");
        check(milestone);
    }

    void test2() {
        try {
            Milestone nullMilestone = null;
            check2(nullMilestone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // field is null
        Milestone milestone = new Milestone();
        milestone.setName("发布上线");
        check2(milestone);
    }

    Boolean check(Milestone milestone) {// state ==1 && finishTime 在当前时间之前
        boolean b = milestone.getState() == 1;
        boolean before = milestone.getFinishTime().before(new Date());
        return b && before;
    }

    Boolean check2(Milestone milestone) {// state ==1 && finishTime 在当前时间之前
        if (null == milestone) return false;
        if (milestone.getState() != null && milestone.getFinishTime() != null) {
            boolean b = milestone.getState() == 1;
            boolean before = milestone.getFinishTime().before(new Date());
            return b && before;
        }
        return false;
    }

}

class Milestone {
    private String name;
    private Date finishTime;
    private Integer state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

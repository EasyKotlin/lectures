package com.easykotlin.lectures.jfp;

import java.util.Date;
import java.util.Optional;

import static java.lang.System.out;

public class NullPointerExceptionDemo {
    static NullPointerExceptionDemo demo = new NullPointerExceptionDemo();

    public static void main(String[] args) {
        demo.test1();
        demo.test2();
    }


    void test1() {
        try {
            // object is null
            Milestone nullMilestone = null;
            Boolean flag = check1(nullMilestone);
            if (flag) {
                out.println("A检查通过");
            } else {
                out.println("A检查不通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // field is null
            Milestone milestone = new Milestone();
            milestone.setName("发布上线");
            Boolean flag = check1(milestone);
            if (flag) {
                out.println("B检查通过");
            } else {
                out.println("B检查不通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    Boolean check1(Milestone milestone) {
        return milestone.getFinishTime().before(new Date()) && milestone.getState() == 1;
    }

    void test2() {
        try {
            // object is null
            Milestone nullMilestone = null;
            Boolean flag = check2(nullMilestone);
            if (flag) {
                out.println("C检查通过");
            } else {
                out.println("C检查不通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // field is null
            Milestone milestone = new Milestone();
            milestone.setName("发布上线");
            Boolean flag = check2(milestone);
            if (flag) {
                out.println("D检查通过");
            } else {
                out.println("D检查不通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Boolean check2(Milestone milestone) {
        if (milestone == null) return false;
        if (milestone.getFinishTime() != null && milestone.getState() != null) {
            return milestone.getFinishTime().before(new Date()) && milestone.getState() == 1;
        }
        return false;
    }

//    java 8 用Optional取代 null
//    See: OptionalDemo

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

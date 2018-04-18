package com.easykotlin.lectures.jfp;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static java.lang.System.out;

public class OptionalDemo {
    static OptionalDemo demo = new OptionalDemo();

    public static void main(String[] args) {
        demo.test1();
    }

    void test1() {

        try {
            Optional<Milestone> nullMilestone = Optional.of(null);
            Boolean flag = check1(nullMilestone);

            if (flag) {
                out.println("A检查通过");
            } else {
                out.println("A检查不通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // field is null
        Optional<Milestone> milestone = Optional.of(new Milestone());
        milestone.get().setName("发布上线");
        Boolean flag = check1(milestone);
        if (flag) {
            out.println("B检查通过");
        } else {
            out.println("B检查不通过");
        }
    }

    Boolean check1(Optional<Milestone> milestone) {
        if (milestone.isPresent()) {
            Milestone m = milestone.get();
            Optional<Date> finishTime = Optional.ofNullable(m.getFinishTime());
            Boolean b1 = finishTime.orElse(getOneDayAfter(new Date())).before(new Date());
            Optional<Integer> state = Optional.ofNullable(m.getState());
            Boolean b2 = state.orElse(-1) == 1;
            return b1 && b2;
        }
        return false;
    }

    Date getOneDayAfter(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now.getTime() + 1000 * 3600 * 24);
        return calendar.getTime();
    }
}

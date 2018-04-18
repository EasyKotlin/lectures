package com.easykotlin.lectures.jfp;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class OptionalDemo {

    static OptionalDemo demo = new OptionalDemo();

    public static void main(String[] aggs) {
        demo.test1();
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


    Boolean check(Milestone milestone) {
        Optional<Milestone> milestoneOptional = Optional.ofNullable(milestone);
        if (milestoneOptional.isPresent()) {
            Optional<Date> finishTimeOptional = Optional.ofNullable(milestoneOptional.get().getFinishTime());
            Optional<Integer> stateOptional = Optional.ofNullable(milestoneOptional.get().getState());
            Boolean b1 = finishTimeOptional.orElse(getOneDayAfterNow(new Date())).before(new Date());
            Boolean b2 = stateOptional.orElse(-1) == 1;
            return b1 && b2;
        }
        return false;
    }

    private Date getOneDayAfterNow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime() + 1000 * 3600 * 24);
        return calendar.getTime();
    }

}

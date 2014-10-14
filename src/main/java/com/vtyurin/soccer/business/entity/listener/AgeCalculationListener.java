package com.vtyurin.soccer.business.entity.listener;

import com.vtyurin.soccer.business.entity.Player;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AgeCalculationListener {

    @PostLoad
    @PostUpdate
    @PostPersist
    public void calculateAge(Player player) {
        if (player.getBirthDate() == null) {
            player.setAge(null);
            return;
        }

        Calendar birth = new GregorianCalendar();
        birth.setTime(player.getBirthDate());
        Calendar now = new GregorianCalendar();
        now.setTime(new Date());
        int adjust = 0;
        if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
            adjust = -1;
        }
        player.setAge(now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust);
    }
}

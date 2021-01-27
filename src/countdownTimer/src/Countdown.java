package countdownTimer.src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Countdown {

    private LocalDateTime ldt;
    private Date convertedWishedDate;

    public Duration getDurationTime(String wishedDate){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.convertedWishedDate = sdf.parse(wishedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Duration.between(ldt.now(), convertToLocalDateTime(convertedWishedDate));
    }

    public LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

}

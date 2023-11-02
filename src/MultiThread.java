import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class MultiThread extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("\n"+ Main.currDate);
            Thread.sleep(5000);
            LocalDate currDate = MultiThread.incrementDate();
            if (Main.i % 2 == 0)
                Place.checkRentedPlacesValidity();
        } catch (InterruptedException e ) {
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static LocalDate incrementDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(String.valueOf(Main.currDate)));
        c.add(Calendar.DATE, 1);
        return LocalDate.parse(sdf.format(c.getTime()));
    }

}

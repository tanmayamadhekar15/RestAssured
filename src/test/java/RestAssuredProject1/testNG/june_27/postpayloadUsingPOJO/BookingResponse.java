package RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingResponse {

    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;
    @SerializedName("booking")
    @Expose
    private CreateBooking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public CreateBooking getBooking() {
        return booking;
    }

    public void setBooking(CreateBooking booking) {
        this.booking = booking;
    }

}

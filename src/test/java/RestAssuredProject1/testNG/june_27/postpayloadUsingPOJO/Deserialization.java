package RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO;

import com.google.gson.Gson;

public class Deserialization {
    public static void main(String[] args) {
        String responseBody="{\n" +
                "    \"bookingid\": 1042,\n" +
                "    \"booking\": {\n" +
                "        \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }\n" +
                "}";
        Gson gson=new Gson();
        BookingResponse bookingResponse= gson.fromJson(responseBody,BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        System.out.println(bookingResponse.getBooking().getDepositpaid());
        System.out.println(bookingResponse.getBooking().getTotalprice());
        System.out.println(bookingResponse.getBooking().getAdditionalneeds());
        System.out.println(bookingResponse.getBooking().getBookingdates().getCheckin());

    }
}

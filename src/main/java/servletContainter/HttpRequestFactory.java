package servletContainter;

/**
 * Created by chj on 2016/2/4.
 */
public class HttpRequestFactory {


    public static HttpRequest newGet(String url)
    {
        HttpRequest request=new HttpRequest();

        request.method="GET";

        return  request;
    }



}

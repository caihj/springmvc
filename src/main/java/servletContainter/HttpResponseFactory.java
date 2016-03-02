package servletContainter;

import java.io.PrintWriter;

/**
 * Created by chj on 2016/2/4.
 */
public class HttpResponseFactory {

    public static HttpResponse newResponse()
    {
        HttpResponse response=new HttpResponse();

        response.writer=new PrintWriter(System.out,true);

        return response;
    }
}

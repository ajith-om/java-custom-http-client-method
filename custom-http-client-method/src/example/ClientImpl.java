package example;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class ClientImpl {

	public void customhttpClientMethod() throws HttpException, IOException {
		
		//this is particularly a custom type with request body
		
		String url = "some url";
		String requestBody = "some request"; // json
		String contentType = "CONTENT_TYPE"; // application/json
		HttpClient httpClient = new HttpClient();
		HttpMethod custommethod = new CustomMethod(url);

		BufferedInputStream bis1 = new BufferedInputStream(
				new ByteArrayInputStream(requestBody.getBytes(Charset.forName("utf-8"))));

		((EntityEnclosingMethod) custommethod).setRequestEntity(new InputStreamRequestEntity(bis1, contentType));

		Integer code = httpClient.executeMethod(custommethod);
		System.out.println(code);
		String responseBody = custommethod.getResponseBodyAsString();
		System.out.println(responseBody);
		
	}
}

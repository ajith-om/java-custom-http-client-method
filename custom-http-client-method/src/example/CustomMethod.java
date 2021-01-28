package example;

import org.apache.commons.httpclient.methods.EntityEnclosingMethod;

/*
Custom method class, here custom name is SNAPSHOT
*/
public class CustomMethod extends EntityEnclosingMethod {
	public CustomMethod(String uri) {
		super(uri);
	}

	@Override
	public String getName() {
		return "SNAPSHOT";

	}
}
package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

  public class MuleComponent {
	
	  int count;
	  
	  public MuleComponent() {
	  count = 1;
  }
	
  public Map<String,String> processMap(Map<String, String> input) {
	  
	  input.put("executed by", "processMap method");
	  
	  return input;
  }

  public Map<String,String> processArray(List<String> input) {
	  
	  Map<String, String> output = new HashMap<String, String>();
	  output.put("message", input.get(0));
	  output.put("executed by", "processArray method");
	  
	  return output;
  }

  public Map<String,String> processString(String input) {
    
	  Map<String, String> output = new HashMap<String, String>();
	  output.put("message", input);
	  output.put("executed by", "processString method");
	  
	  return output;
  }

  public Map<String,String> processAll(@Payload Object input, @InboundHeaders("http.method") String myHTTPmethod) {
	  
	  Map<String, String> output = new HashMap<String, String>();
	  output.put("message", input.toString());
	  output.put("http method", myHTTPmethod);	  
	  output.put("executed by", "processAll method");
	  output.put("count", String.valueOf(count));
	  count++;
	  
	  return output;
  }

} 

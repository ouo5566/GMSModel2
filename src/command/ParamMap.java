package command;

import javax.servlet.http.HttpServletRequest;

public class ParamMap {
	public static String getValues(HttpServletRequest request, String name) {
		String[] values = request.getParameterMap().get(name);
		StringBuffer buff = new StringBuffer();
		for(String v : values) {
			buff.append(v+",");
		}
		return buff.toString().substring(0,buff.toString().length()-1);
	}
}

package enums;

public enum Term {
	WEBPATH, MAIN, UPLOAD_PATH;
	@Override
	public String toString() {
		String s = "";
		switch (this) {
			case WEBPATH: s = "WEB-INF/view/"; break;
			case MAIN: s = "main.jsp";	break;
			case UPLOAD_PATH: s = "C:\\Users\\1027\\eclipse\\jee-oxygen\\eclipse\\JeeWorkSpace\\GMS-Model2\\WebContent\\resources\\img\\upload\\";	break;
			default: s = super.toString(); break;
		}
		return s;
	}
}

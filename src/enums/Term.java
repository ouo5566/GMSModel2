package enums;

public enum Term {
	WEBPATH, MAIN,;
	@Override
	public String toString() {
		String s = "";
		switch (this) {
			case WEBPATH: s = "WEB-INF/view/"; break;
			case MAIN: s = "main.jsp";	break;
			default: s = super.toString(); break;
		}
		return s;
	}
}

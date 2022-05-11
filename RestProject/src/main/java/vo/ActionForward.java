

package vo;

public class ActionForward {
	
	private String path = null;//경로
	
	
	private boolean isRedirect = false;//isRedirect false로 두어 기본값 디스페쳐로


	public ActionForward() {}
	//포워딩 객체 생성 기본값 디스페쳐
	public ActionForward(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}

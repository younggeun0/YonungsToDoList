package controller;

public class ToDoController implements Controller {

	private String url;
	private boolean forwardFlag;
	private String flag;
	
	public ToDoController(String flag) {
		this.flag = flag;
	}
	
	@Override
	public void execute() {
		
		if ("insert".equals(flag)) {
			// �ٸ� ���� ���
			
			
		} else if ("update".equals(flag)) {
			
			
		} else if ("delete".equals(flag)) {
			
			
		}
		
	}

	@Override
	public String moveUrl() {
		return url;
	}

	@Override
	public boolean isFoward() {
		return forwardFlag;
	}
}

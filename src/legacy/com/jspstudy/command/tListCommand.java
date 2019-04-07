package legacy.com.jspstudy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import legacy.com.jspstudy.dao.tDao;
import legacy.com.jspstudy.dto.tDto;

public class tListCommand implements tCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		tDao dao = new tDao();
		ArrayList<tDto> dtos = dao.list(); 
		
		ArrayList<tDto> list = new ArrayList<tDto>();
		ArrayList<tDto> completedList = new ArrayList<tDto>();
		
		for(int i = 0; i < dtos.size(); i++) {
			
			tDto dto = new tDto();
			dto = dtos.get(i);
			
			if (dto.gettComplete() == 0) {
				list.add(dto);
			} else if (dto.gettComplete() == 1){
				completedList.add(dto);
			}
		}
		
		request.setAttribute("list", list);
		request.setAttribute("completedList", completedList);
	}

}

package Util;

import java.util.ArrayList;
import java.util.List;

import Bean.Video_imageBean;
import Bean.WorkColumnBean;
import Bean.WorksBean;
import Dao.Video_imageDao;
import Dao.WorksDao;
import Impl.Video_imageImpl;
import Impl.WorkColumnImpl;
import Impl.WorksImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*WorksImpl wd=new WorksImpl();
		wd.addnewWork("201526010308", 0);*/
		Video_imageDao vi=new Video_imageImpl();
		Video_imageBean vib=new Video_imageBean();
		vib=vi.get(4);
	}

}

package hse.jack.module;

import hse.jack.model.BaseProblem;

import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.service.EntityService;

@At("/comm")
public class CommondModule extends EntityService<BaseProblem> {
	/**
	 * 跳转到导入excel页面
	 */
	@At
	public void excelUi() {
	}

	/**
	 * excel导入数据库
	 * 
	 * @param file
	 * @return
	 */
	@At
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	public Object excelTo(@Param("filePath") TempFile file) {

		return null;
	}

}

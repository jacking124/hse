package hse.jack.module;

import hse.jack.model.ExamPaperInfo;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.service.EntityService;

/**
 * <b>试卷详细信息管理</b>
 * 
 * @author jack
 * @date 2012年12月7日13:41:25
 * @version 1.0
 */
@At("/ExamInfo")
@IocBean(fields = { "dao" })
public class ExamPaperInfoModule extends EntityService<ExamPaperInfo> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到添加
	 */
	@At
	public void addUi() {

	}

}

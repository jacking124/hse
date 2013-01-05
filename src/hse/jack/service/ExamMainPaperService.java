package hse.jack.service;

import hse.jack.model.ExamMainPaper;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdEntityService;

/**
 * <b>试卷表头业务层</b>
 * 
 * @author jack
 * @date 2012年12月6日18:17:13
 * @version 1.0
 * 
 */
@IocBean(args = { "refer:dao" })
public class ExamMainPaperService extends IdEntityService<ExamMainPaper> {

	public ExamMainPaperService() {
		super();
	}

	public ExamMainPaperService(Dao dao, Class<ExamMainPaper> entityType) {
		super(dao, entityType);
	}

	public ExamMainPaperService(Dao dao) {
		super(dao);
	}

}

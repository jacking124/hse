package hse.jack.service;

import hse.jack.model.ExamPaperInfo;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdEntityService;

/**
 * 
 * @author jack
 * 
 */
@IocBean(args = { "dao" })
public class ExamPaperInfoService extends IdEntityService<ExamPaperInfo> {

	public ExamPaperInfoService() {
		super();
	}

	public ExamPaperInfoService(Dao dao, Class<ExamPaperInfo> entityType) {
		super(dao, entityType);
	}

	public ExamPaperInfoService(Dao dao) {
		super(dao);
	}

}

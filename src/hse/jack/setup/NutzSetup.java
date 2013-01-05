package hse.jack.setup;

import hse.jack.model.Account;
import hse.jack.model.BlanksProblem;
import hse.jack.model.Department;
import hse.jack.model.EmployeeInfo;
import hse.jack.model.ExamJdProblem;
import hse.jack.model.ExamMainPaper;
import hse.jack.model.ExamPaperInfo;
import hse.jack.model.JobInfos;
import hse.jack.model.JudgeProblem;
import hse.jack.model.OptionProblem;
import hse.jack.model.TrainSubject;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

public class NutzSetup implements Setup {

	@Override
	public void destroy(NutConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(NutConfig config) {
		Dao dao = config.getIoc().get(Dao.class);
		for (Class<?> klass : Scans.me().scanPackage("hse.jack.model")) {
			if (null != klass.getAnnotation(Table.class)) {
				dao.create(Account.class, false);
				dao.create(Department.class, false);
				dao.create(JobInfos.class, false);
				dao.create(EmployeeInfo.class, false);
				dao.create(ExamJdProblem.class, false);
				dao.create(TrainSubject.class, false);
				dao.create(BlanksProblem.class, false);
				dao.create(JudgeProblem.class, false);
				dao.create(OptionProblem.class, false);
				dao.create(ExamMainPaper.class, false);
				dao.create(ExamPaperInfo.class, false);
			}
		}
	}
}

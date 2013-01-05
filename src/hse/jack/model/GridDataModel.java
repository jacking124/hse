package hse.jack.model;

import java.util.ArrayList;
import java.util.List;

public class GridDataModel<T> {
	private int total;
	private List<T> rows = new ArrayList();
	private List<Column> colmodel = new ArrayList();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<Column> getColmodel() {
		return colmodel;
	}

	public void setColmodel(List<Column> colmodel) {
		this.colmodel = colmodel;
	}
}

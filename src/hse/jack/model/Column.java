package hse.jack.model;

import java.io.Serializable;
/**
 * 
 * @author jack
 *
 */
public class Column implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String header;
	private int width;
	private String name;
	private String align;
	private String render;
	
	public Column(String header, int width, String name, String align,
			String render) {
		this.header = header;
		this.width = width;
		this.name = name;
		this.align = align;
		this.render = render;
	}

	public Column() {
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

}

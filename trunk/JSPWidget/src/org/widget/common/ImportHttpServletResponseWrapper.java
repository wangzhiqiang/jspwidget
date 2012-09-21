package org.widget.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

final public class ImportHttpServletResponseWrapper extends
		HttpServletResponseWrapper {

	protected String ILLEGAL_WRITER = " 资源被占用  ";
	private boolean isWriterUsed;
	private boolean isStreamUsed;
	private StringWriter sw = new StringWriter();
	private ByteArrayOutputStream bos = new ByteArrayOutputStream();

	public ImportHttpServletResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	private ServletOutputStream sos = new ServletOutputStream() {
		@Override
		public void write(int b) throws IOException {
			bos.write(b);
		}
	};

	@Override
	public PrintWriter getWriter() throws IOException {
		if (isStreamUsed)
			throw new IllegalStateException(ILLEGAL_WRITER);
		isWriterUsed = true;
		return new PrintWriter(sw);
	}

	@Override
	public ServletOutputStream getOutputStream() {
		if (isWriterUsed)
			throw new IllegalStateException(ILLEGAL_WRITER);
		isStreamUsed = true;
		return sos;
	}

	// 获取response里的输出流
	public String getString() {

		if (isWriterUsed) {
			return sw.toString();
		} else if (isStreamUsed) {
			try {
				String character = this.getResponse().getCharacterEncoding();
				if (null == character || character.equals(""))
					character = "ISO-8859-1";
				return bos.toString(character);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}  
		return "";
	}

}

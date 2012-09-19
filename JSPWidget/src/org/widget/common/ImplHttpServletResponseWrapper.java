package org.widget.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/** 重写HttpServletResponseWrapper 更改 include 输出 */
final public class ImplHttpServletResponseWrapper extends HttpServletResponseWrapper {

	protected String IMPORT_ILLEGAL_WRITER = " Unexpected internal error during &lt;import&gt: \\Target servlet called getWriter(), then getOutputStream()";
	/** 'True' if getWriter() was called; false otherwise. */
	private boolean isWriterUsed;

	/** 'True if getOutputStream() was called; false otherwise. */
	private boolean isStreamUsed;

	private StringWriter sw = new StringWriter();

	private ByteArrayOutputStream bos = new ByteArrayOutputStream();

	public ImplHttpServletResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	private ServletOutputStream sos = new ServletOutputStream() {
		@Override
		public void write(int b) throws IOException {
			bos.write(b);
		}
	};

	/** Returns a Writer designed to buffer the output. */
	@Override
	public PrintWriter getWriter() throws IOException {
		if (isStreamUsed)
			throw new IllegalStateException(IMPORT_ILLEGAL_WRITER);
		isWriterUsed = true;
		return new PrintWriter(sw);
	}

	/** Returns a ServletOutputStream designed to buffer the output. */
	@Override
	public ServletOutputStream getOutputStream() {
		if (isWriterUsed)
			throw new IllegalStateException(IMPORT_ILLEGAL_WRITER);
		isStreamUsed = true;
		return sos;
	}

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
				return "";
			}
		} else
			return "";
	}

}

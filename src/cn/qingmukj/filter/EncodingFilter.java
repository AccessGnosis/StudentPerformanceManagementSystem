/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: EncodingFilter.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:18:33
*/
package cn.qingmukj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 * 
 * @author gnosis
 *
 */
public class EncodingFilter implements Filter {
	private String encoding = null;

	@Override
	public void destroy() {
		// 销毁encoding的值
		encoding = null;
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 如果此时encoding的值不为空
		if (encoding != null) {
			// 使用ServletRequest设置编码格式
			arg0.setCharacterEncoding(encoding);
			// 使用ServletResponse将编码回传到页面
			arg1.setContentType("text/html;charset=" + encoding);
		}
		// 传递给下一个过滤器
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// 初始化 encoding 的值
		encoding = arg0.getInitParameter("EncodingValue");
	}

}